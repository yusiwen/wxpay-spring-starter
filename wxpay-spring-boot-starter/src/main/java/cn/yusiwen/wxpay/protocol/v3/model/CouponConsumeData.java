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

import cn.yusiwen.wxpay.protocol.enumeration.CouponStatus;

/**
 * 微信代金券核销通知参数
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class CouponConsumeData {

    /**
     * 可用开始时间 YYYY-MM-DDTHH:mm:ss.sss+TIMEZONE
     */
    private String availableBeginTime;
    /**
     * 可用结束时间 YYYY-MM-DDTHH:mm:ss.sss+TIMEZONE
     */
    private String availableEndTime;
    /**
     * 实扣代金券信息
     */
    private ConsumeInformation consumeInformation;
    /**
     * 代金券id
     */
    private String couponId;
    /**
     * 代金券名称
     */
    private String couponName;
    /**
     * 代金券类型
     */
    private CouponType couponType;
    /**
     * 领券时间
     */
    private String createTime;
    /**
     * 代金券描述
     */
    private String description;
    /**
     * 减至优惠特定信息
     */
    private DiscountTo discountTo;
    /**
     * 是否无资金流
     */
    private Boolean noCash;
    /**
     * 普通满减券信息
     */
    private NormalCouponInformation normalCouponInformation;
    /**
     * 是否单品优惠
     */
    private Boolean singleItem;
    /**
     * 单品优惠特定信息
     */
    private SingleitemDiscountOff singleitemDiscountOff;
    /**
     * 代金券状态
     *
     * @see CouponStatus
     */
    private CouponStatus status;
    /**
     * 创建批次的商户号
     */
    @JsonProperty("stock_creator_mchid")
    private String stockCreatorMchId;
    /**
     * 批次号
     */
    private String stockId;

    /**
     * 券类型
     *
     * @since 1.0.0.RELEASE
     */
    public enum CouponType {
        /**
         * 满减券
         */
        NORMAL,
        /**
         * 减至券
         */
        CUT_TO
    }
}
