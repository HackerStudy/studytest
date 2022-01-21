package com.hackerstudy.studytest.util;

import cn.hutool.core.codec.Base64;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
//import javax.servlet.http.HttpSession;

/**
 * <p>
 * RSA公钥/私钥/签名工具包
 * <p>
 * 字符串格式的密钥在未在特殊说明情况下都为BASE64编码格式<br/>
 * 由于非对称加密速度极其缓慢，一般文件不使用它来加密而是使用对称加密，<br/>
 * 非对称加密算法可以用来对对称加密的密钥加密，这样保证密钥的安全也就保证了数据的安全
 * </p>
 * 
 */
@Slf4j
public class RSAUtils {

	/**
	 * 加密算法RSA
	 */
	public static final String KEY_ALGORITHM = "RSA";

	/**
	 * 签名算法
	 */
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	/**
	 * 获取公钥的key
	 */
	private static final String PUBLIC_KEY = "LocatorPublicKey";

	/**
	 * 获取私钥的key
	 */
	private static final String PRIVATE_KEY = "LocatorPrivateKey";

	/**
	 * RSA最大加密明文大小
	 */
	private static final int MAX_ENCRYPT_BLOCK = 117;

	/**
	 * RSA最大解密密文大小
	 */
	private static final int MAX_DECRYPT_BLOCK = 128;

	public static void main(String[] args) throws Exception {

		//测试签名和验签
		Map<String, Object> keyMap = getKeyPair();
		System.out.println("公钥" + getPublicKey(keyMap));
		System.out.println("私钥" + getPrivateKey(keyMap));

		Map<String,String> map = new HashMap<>();
		map.put("aa", "123");
		map.put("bb", "456");
		
		String str = createSign(map);
		System.out.println(str);
		String sign = sign(str.getBytes(), getPrivateKey(keyMap)); // 签名
		System.out.println(sign);
		boolean b = verify("aa=123&bb=456&".getBytes(), getPublicKey(keyMap), sign); // 验签
		System.out.println(b);

		//测试rsa加密  公钥加密，私钥解密
		String publicKey = getPublicKey(keyMap);
		String privateKey = getPrivateKey(keyMap);
		String source = "zl123456";
		log.info("加密前：{}",source);
		String encryptSource = encryptByPublicKey(source,publicKey);
		log.info("加密后：{}",encryptSource);
		String decryptSource = decryptByPrivateKey(encryptSource,privateKey);
		log.info("解密后：{}",decryptSource);
	}

	///**
	// * @description: 生成密钥（session中存在的话就直接从session中拿取，不存在的话就生成）
	// * @auther: Hacker
	// * @date: 2021-7-28 11:26
	// * @param session request的session对象
	// * @return: {@link KeyPair}
	// * @throws
	// */
	//public static KeyPair getKeyPair(HttpSession session) throws Exception {
	//	//用于处理 在负载均衡时，两个session共享的keypair不一样的问题.把keypair放到session里，通过session共享达到目的
	//	KeyPair keyPair= (KeyPair)session.getAttribute("sessionKeyPair");
	//	if(null==keyPair){
	//		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
	//		keyPairGen.initialize(1024);
	//		keyPair = keyPairGen.generateKeyPair();
	//		session.setAttribute("sessionKeyPair", keyPair);
	//	}
	//	return keyPair;
	//}

	/**
	 * <p>
	 * 生成密钥对(公钥和私钥)
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> getKeyPair() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}

	
	public static String createSign(Map<String, String> paramsMap) {
		// 先排序
		List<String> keys = new ArrayList<String>(paramsMap.keySet());
		Collections.sort(keys);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < keys.size(); i++) {
			String k = keys.get(i);
			String v = paramsMap.get(k);
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		return sb.toString();
	}
	

	/**
	 * <p>
	 * 用私钥对信息生成数字签名
	 * </p>
	 * 
	 * @param data
	 *            已加密数据
	 * @param privateKey
	 *            私钥(BASE64编码)
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String sign(byte[] data, String privateKey) throws Exception {
		byte[] keyBytes = Base64.decode(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateK);
		signature.update(data);
		return Base64.encode((signature.sign()));
	}

	/**
	 * <p>
	 * 校验数字签名
	 * </p>
	 * 
	 * @param data
	 *            已加密数据
	 * @param publicKey
	 *            公钥(BASE64编码)
	 * @param sign
	 *            数字签名
	 * 
	 * @return
	 * @throws Exception
	 * 
	 */
	public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
		byte[] keyBytes = Base64.decode(publicKey);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey publicK = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicK);
		signature.update(data);
		return signature.verify(Base64.decode(sign));
	}

	/**
	 * RSA公钥加密
	 *
	 * @param str       加密字符串
	 * @param publicKey 公钥
	 * @return 密文
	 * @throws Exception 加密过程中的异常信息
	 */
	public static String encryptByPublicKey(String str, String publicKey) throws Exception {
		byte[] data = str.getBytes(StandardCharsets.UTF_8);
		byte[] keyBytes = Base64.decode(publicKey.getBytes(StandardCharsets.UTF_8));
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return Base64.encode(encryptedData);
	}

	/**
	 * @description: 私钥加密
	 * @auther: Hacker
	 * @date: 2021-5-21 14:08
	 * @param dataStr 明文
	 * @param privateKey 私钥
	 * @return: {@link String}
	 * @throws
	 */
	public static String encryptByPrivateKey(String dataStr, String privateKey) throws Exception {
		byte[] data = dataStr.getBytes(StandardCharsets.UTF_8);
		byte[] keyBytes = Base64.decode(privateKey.getBytes(StandardCharsets.UTF_8));
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return Base64.encode(encryptedData);
	}

	/**
	 * RSA私钥解密
	 *
	 * @param str        密文
	 * @param privateKey 私钥
	 * @return 明文
	 * @throws Exception 解密过程中的异常信息
	 */
	public static String decryptByPrivateKey(String str, String privateKey) throws Exception {
		byte[] inputByte = Base64.decode(str.getBytes(StandardCharsets.UTF_8));

		//base64编码的私钥
		byte[] decoded = Base64.decode(privateKey.getBytes(StandardCharsets.UTF_8));
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(decoded);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateK);
		int inputLen = inputByte.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(inputByte, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(inputByte, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return new String(decryptedData,StandardCharsets.UTF_8);
	}


	/**
	 * @description: 公钥解密
	 * @auther: Hacker
	 * @date: 2021-5-21 13:57
	 * @param encryptedStr 密文
	 * @param publicKey 公钥
	 * @return: {@link String} - 明文
	 * @throws
	 */
	public static String decryptByPublicKey(String encryptedStr, String publicKey) throws Exception {
		byte[] encryptedData = Base64.decode(encryptedStr.getBytes(StandardCharsets.UTF_8));
		byte[] keyBytes = Base64.decode(publicKey.getBytes(StandardCharsets.UTF_8));
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return new String(decryptedData,StandardCharsets.UTF_8);
	}

	/**
	 * <p>
	 * 获取私钥
	 * </p>
	 * 
	 * @param keyMap
	 *            密钥对
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return Base64.encode(key.getEncoded());
	}

	/**
	 * @description: 获取私钥
	 * @auther: Hacker
	 * @date: 2021-7-28 11:31
	 * @param keyPair 密钥对象
	 * @return: {@link String}
	 * @throws
	 */
	public static String getPrivateKey(KeyPair keyPair) throws Exception {
		Key key = keyPair.getPrivate();
		return Base64.encode(key.getEncoded());
	}

	/**
	 * <p>
	 * 获取公钥
	 * </p>
	 * 
	 * @param keyMap
	 *            密钥对
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return Base64.encode(key.getEncoded());
	}

	/**
	 * @description: 获取公钥
	 * @auther: Hacker
	 * @date: 2021-7-28 11:32
	 * @param keyPair 密钥对象
	 * @return: {@link String}
	 * @throws
	 */
	public static String getPublicKey(KeyPair keyPair) throws Exception {
		Key key = keyPair.getPublic();
		return Base64.encode(key.getEncoded());
	}

}