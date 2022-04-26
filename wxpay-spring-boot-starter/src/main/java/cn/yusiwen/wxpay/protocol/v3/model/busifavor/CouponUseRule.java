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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import cn.yusiwen.wxpay.protocol.enumeration.BusiFavorUseMethod;
import cn.yusiwen.wxpay.protocol.enumeration.StockType;

/**
 * 商家券核销规则
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class CouponUseRule {

    /**
     * 核销方式
     */
    private BusiFavorUseMethod useMethod;
    /**
     * 换购券使用规则
     *
     * @see StockType#EXCHANGE
     */
    private ExchangeCoupon exchangeCoupon;
    /**
     * 券可核销时间
     */
    private CouponAvailableTime couponAvailableTime;
    /**
     * 核销小程序appId
     *
     * @see BusiFavorUseMethod#MINI_PROGRAMS
     */
    @JsonProperty("mini_programs_appid")
    private String miniProgramsAppId;
    /**
     * 核销小程序path
     *
     * @see #miniProgramsAppId
     */
    private String miniProgramsPath;
    /**
     * 固定面额满减券使用规则
     *
     * @see StockType#NORMAL
     */
    private FixedNormalCoupon fixedNormalCoupon;
    /**
     * 折扣券使用规则
     *
     * @see StockType#DISCOUNT
     */
    private DiscountCoupon discountCoupon;

}
