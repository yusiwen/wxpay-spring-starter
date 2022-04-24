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

import lombok.Data;

import cn.yusiwen.wxpay.protocol.enumeration.StockType;

/**
 * 商家券发放规则.
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class StockSendRule {

    /**
     * 批次最大发放个数
     * <p>
     * 特殊规则：取值范围 1 ≤ maxCoupons ≤ 1000000000
     */
    private Integer maxCoupons;
    /**
     * 用户最大可领个数
     * <p>
     * 每个用户最多100张券 。
     */
    private Integer maxCouponsPerUser;
    /**
     * 单天发放上限个数
     * <p>
     * {@link StockType#DISCOUNT}或者{@link StockType#DISCOUNT}时可传入此字段控制单天发放上限
     * <p>
     * 特殊规则：取值范围 1 ≤ maxCouponsByDay ≤ 1000000000
     */
    private Integer maxCouponsByDay;
    /**
     * 是否开启自然人限制
     */
    private Boolean naturalPersonLimit;
    /**
     * 可疑账号拦截
     */
    private Boolean preventApiAbuse;
    /**
     * 是否允许转赠
     */
    private Boolean transferable;
    /**
     * 是否允许分享链接
     */
    private Boolean shareable;
}
