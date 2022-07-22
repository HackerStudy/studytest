// This file is auto-generated, don't edit it. Thanks.
package com.hackerstudy.studytest.voice;

import com.alibaba.fastjson.JSON;
import com.aliyun.dyvmsapi20170525.models.SingleCallByTtsRequest;
import com.aliyun.dyvmsapi20170525.models.SingleCallByTtsResponse;
import com.aliyun.teaopenapi.models.Config;

public class Sample {

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dyvmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dyvmsapi.aliyuncs.com";
        return new com.aliyun.dyvmsapi20170525.Client(config);
    }

    public static void main(String[] args_) throws Exception {
        java.util.List<String> args = java.util.Arrays.asList(args_);
        com.aliyun.dyvmsapi20170525.Client client = Sample.createClient("LTAI5tMJzyYRRkbzCkWLdpm9", "UkVHavueWiZVgCD3SwnFz9tBH9tTor");
        SingleCallByTtsRequest singleCallByTtsRequest = new SingleCallByTtsRequest();
        singleCallByTtsRequest.setCalledNumber("15673331257");
        singleCallByTtsRequest.setTtsCode("TTS_228851020");
        // 复制代码运行请自行打印 API 的返回值
        SingleCallByTtsResponse singleCallByTtsResponse = client.singleCallByTts(singleCallByTtsRequest);
        System.out.println(JSON.toJSONString(singleCallByTtsResponse.getBody()));
    }
}