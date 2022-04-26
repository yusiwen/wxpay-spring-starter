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
package cn.yusiwen.wxpay.protocol.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type User coupons query params.
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class UserCouponsQueryParams {
    /**
     * 用户公众号服务号标识
     */
    @JsonProperty("openid")
    private String openId;
    /**
     * 公众服务号ID
     */
    @JsonProperty("appid")
    private String appId;
    /**
     * 批次号
     */
    private String stockId;
    /**
     * 券状态 null 不生效
     */
    private Status status;
    /**
     * 创建批次的商户号
     */
    @JsonProperty("creator_mchid")
    private String creatorMchId;
    /**
     * 批次发放商户号
     */
    @JsonProperty("sender_mchid")
    private String senderMchId;
    /**
     * 可用商户号
     */
    @JsonProperty("available_mchid")
    private String availableMchId;
    /**
     * 分页页码
     */
    private Integer offset = 0;
    /**
     * 分页大小
     */
    private Integer limit = 20;

    /**
     * The enum Status.
     *
     * @author yusiwen
     * @since 1.0.0.RELEASE
     */
    public enum Status {
        /**
         * Sended status.
         */
        SENDED,
        /**
         * Used status.
         */
        USED
    }

}
