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
package cn.yusiwen.wxpay.protocol.v3.model.busifavor;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 核销用户券请求参数
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class BusiFavorUseParams {
    /**
     * 券code
     */
    private String couponCode;
    /**
     * 批次号
     */
    private String stockId;
    /**
     * 公众账号ID
     */
    @JsonProperty("appid")
    private String appId;
    /**
     * 请求核销时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "GMT+8")
    private OffsetDateTime useTime;
    /**
     * 核销请求单据号,商户侧保证唯一
     */
    private String useRequestNo;
    /**
     * 用户标识，用户的唯一标识，做安全校验使用
     */
    @JsonProperty("openid")
    private String openId;

}
