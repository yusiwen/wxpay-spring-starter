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
package cn.yusiwen.wxpay.protocol.v3.model.payscore;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 授权、解除授权服务回调解密.
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class PayScoreUserPermissionConsumeData {

    /**
     * 是否是解除授权，此参数并非微信返回参数
     *
     * 是：true，不是：false
     *
     * 用来判断是授权还是解除授权
     */
    private boolean closed;
    /**
     * The AppId.
     */
    @JsonProperty("appid")
    private String appId;
    /**
     * The MchId.
     */
    @JsonProperty("mchid")
    private String mchId;
    /**
     * The OpenId.
     */
    @JsonProperty("openid")
    private String openId;
    /**
     * The Openorclose time.
     */
    private String openOrCloseTime;
    /**
     * 只在 微信支付分授权回调中返回
     */
    private String outRequestNo;
    /**
     * The Service id.
     */
    private String serviceId;
    /**
     * The User service status.
     */
    private String userServiceStatus;

}
