/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package cn.yusiwen.wxpay;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The type Wechat pay properties.
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
@ConfigurationProperties("wechat.pay")
public class WechatPayProperties {
    /**
     * wechat pay V3 properties
     */
    private Map<String, V3> v3 = new HashMap<>();

    /**
     * wechat pay v3 properties.
     *
     * @author yusiwen
     * @since 1.0.0.RELEASE
     */
    @Data
    public static class V3 {
        /**
         * app id for wechat pay is required
         */
        @JsonProperty("appid")
        private String appId;
        /**
         * app secret for wechat pay is required
         */
        private String appSecret;
        /**
         * app V3 secret is required by wechat pay V3
         */
        private String appV3Secret;
        /**
         * mchId for wechat pay is required
         */
        @JsonProperty("mchid")
        private String mchId;
        /**
         * partnerKey for wechat pay is optional
         */
        private String partnerKey;
        /**
         * wechat pay certificate Path
         */
        private String certPath;
        /**
         * your pay server domain
         */
        private String domain;
    }
}
