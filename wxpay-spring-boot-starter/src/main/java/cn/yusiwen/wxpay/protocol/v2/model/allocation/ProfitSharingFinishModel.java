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
import lombok.EqualsAndHashCode;

import cn.yusiwen.wxpay.protocol.v2.model.BaseModel;

/**
 * The type Profit sharing finish model.
 *
 * @author wangzecheng
 * @since 1.0.0.RELEASE
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProfitSharingFinishModel extends BaseModel {

    /**
     * 商户号.
     * <p>
     * 微信支付分配的商户号
     */
    private String mchId;

    /**
     * 公众账号ID.
     * <p>
     * 微信分配的公众账号ID
     */
    private String appId;

    /**
     * 微信订单号.
     * <p>
     * 微信支付订单号
     */
    private String transactionId;

    /**
     * 商户分账单号.
     * <p>
     * 查询分账结果，输入申请分账时的商户分账单号； 查询分账完结执行的结果，输入发起分账完结时的商户分账单号
     */
    private String outOrderNo;

    /**
     * 分账完结描述.
     * <p>
     * 分账完结的原因描述
     */
    private String description;

}
