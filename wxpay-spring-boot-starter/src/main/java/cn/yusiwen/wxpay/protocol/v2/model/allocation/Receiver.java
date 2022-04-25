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
package cn.yusiwen.wxpay.protocol.v2.model.allocation;

import lombok.Data;

/**
 * The type Receiver.
 *
 * @author wangzecheng
 * @since 1.0.0.RELEASE
 */
@Data
public class Receiver {

    /**
     * 分账接收方类型.
     * <p>
     * MERCHANT_ID：商户号（mch_id或者sub_mch_id） PERSONAL_OPENID：个人openId
     */
    private Type type;

    /**
     * 分账接收方帐号.
     * <p>
     * 类型是MERCHANT_ID时，是商户号（mch_id或者sub_mch_id） 类型是PERSONAL_OPENID时，是个人openId
     */
    private String account;

    /**
     * 分账金额.
     * <p>
     * 单位为分，只能为整数，不能超过原订单支付金额及最大分账比例金额
     */
    private Integer amount;

    /**
     * 分账描述.
     * <p>
     * 分账的原因描述，分账账单中需要体现
     */
    private String description;

    /**
     * 分账个人接收方姓名.
     * <p>
     * 可选项，在接收方类型为个人的时可选填，若有值，会检查与 name 是否实名匹配，不匹配会拒绝分账请求. 1、分账接收方类型是PERSONAL_OPENID时，是个人姓名（选传，传则校验）
     */
    private String name;

}
