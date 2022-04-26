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

package cn.yusiwen.wxpay.protocol.v3.model.profitsharing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import cn.yusiwen.wxpay.protocol.enumeration.ReceiverType;

/**
 * 服务商-删除分账接收方API-请求参数
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class PartnerDelReceiversParams {
    /**
     * 子商户号，选填
     */
    @JsonProperty("sub_mchid")
    private String subMchId;
    /**
     * 应用ID，自动注入
     */
    @JsonProperty("appid")
    private String appId;
    /**
     * 子商户应用ID，选填
     * <p>
     * 分账接收方类型包含{@code PERSONAL_SUB_OPENID}时必填
     */
    @JsonProperty("sub_appid")
    private String subAppId;
    /**
     * 分账接收方类型，必填
     */
    private ReceiverType type;
    /**
     * 分账接收方帐号，必填
     */
    private String account;
}
