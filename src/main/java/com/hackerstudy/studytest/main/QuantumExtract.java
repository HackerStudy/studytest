package com.hackerstudy.studytest.main;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hackerstudy.studytest.util.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Class: QuantumExtract
 * @Description: 量子抽取测试
 * @Author: Hacker
 * @Date: 2021-08-19 17:41
 * @Version: 1.0
 */
@Slf4j
public class QuantumExtract {

    public static void main(String[] args) {
        // 量子抽取接口MD5签名key
        String signKey = "eb83ac6c-7862-4812-b5a1-789377266415";
        // 申请抽取序列号URL
        String seqUrl = "http://10.3.1.102:8999/v2/QtecRandomApi/applyExtractSeq";
        Map<String, Object> map = new HashMap<>();
        map.put("extracter","抽取账号1");
        map.put("useBlockchain", false);
        HashMap<String, String> heardMap = new HashMap<>();
        heardMap.put("sign", DigestUtils.md5DigestAsHex((signKey + JSON.toJSONString(map)).getBytes(StandardCharsets.UTF_8)));
        log.warn("申请抽取序列号入参：{},{}" ,heardMap,JSON.toJSONString(map));
        String seqResultJson = HttpClientUtils.postJSON(seqUrl, heardMap,JSON.toJSONString(map));
        log.warn("申请抽取序列号返回值：" + seqResultJson);
        JSONObject seqJsonObject = JSON.parseObject(seqResultJson);
        if(!seqJsonObject.getBoolean("success")){
            log.error("量子抽取-获取抽取序列号失败：{}",seqJsonObject.getString("message"));
        }
    }
}
