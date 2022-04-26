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
package cn.yusiwen.wxpay.protocol.v3.model.discountcard;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import cn.yusiwen.wxpay.protocol.enumeration.ContractStatus;
import cn.yusiwen.wxpay.protocol.enumeration.CountType;
import cn.yusiwen.wxpay.protocol.enumeration.UnfinishedReason;

/**
 * 微信支付先享卡用户守约状态变化通知解密
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class DiscountCardAgreementEndConsumeData {
    /**
     * 应用appId需要绑定微信商户平台
     */
    @JsonProperty("appid")
    private String appId;
    /**
     * 先享卡ID，唯一标识一个先享卡
     */
    private String cardId;
    /**
     * 先享卡模板ID，唯一定义此资源的标识。创建模板后可获得
     */
    private String cardTemplateId;
    /**
     * 创建先享卡的时间
     */
    private String createTime;
    /**
     * 商户号
     */
    @JsonProperty("mchid")
    private String mchId;
    /**
     * 用户先享卡目标列表
     */
    private List<Objective> objectives;
    /**
     * 用户标识，用户在{@code appId}下的唯一标识
     */
    @JsonProperty("openid")
    private String openId;
    /**
     * 商户领卡号，商户在请求领卡预受理接口时传入的领卡请求号，同一个商户号下必须唯一，要求32个字符内，只能是数字、大小写字母_-|*
     */
    private String outCardCode;
    /**
     * 用户先享卡优惠列表
     */
    private List<Reward> rewards;
    /**
     * 先享卡的守约状态
     */
    private ContractStatus state;
    /**
     * 先享卡约定时间期限
     */
    private TimeRange timeRange;
    /**
     * 享受优惠总金额，单位为 “分”
     */
    private Long totalAmount;
    /**
     * 未完成约定原因
     */
    private UnfinishedReason unfinishedReason;

    /**
     * 目标列表属性
     *
     * @author yusiwen
     * @since 1.0.0.RELEASE
     */
    @Data
    public static class Objective {

        /**
         * 目标数量
         * <p>
         * 履约目标需要完成的数量，必须大于0。
         */
        private Long count;
        /**
         * 目标描述
         */
        private String description;
        /**
         * 目标名称
         */
        private String name;
        /**
         * 用户先享卡目标完成纪录
         */
        private List<ObjectiveCompletionRecord> objectiveCompletionRecords;
        /**
         * 目标id
         */
        private String objectiveId;
        /**
         * 目标单位
         * <p>
         * 示例值：次
         */
        private String unit;

    }

    /**
     * 先享卡约定时间期限
     *
     * @author yusiwen
     * @since 1.0.0.RELEASE
     */
    @Data
    public static class TimeRange {
        /**
         * 开始时间
         */
        private String beginTime;
        /**
         * 结束时间
         */
        private String endTime;
    }

    /**
     * 优惠列表属性
     *
     * @author yusiwen
     * @since 1.0.0.RELEASE
     */
    @Data
    public static class Reward {

        /**
         * 优惠金额
         * <p>
         * 1、优惠金额，此项优惠对应的优惠总金额，单位：分，必须大于0。 2、此项优惠已享累计金额≤创建模板时配置的此项奖励的奖励金额，
         * 例如：优惠为【满10元减3元优惠券4张】时，用户一次消费使用了2张优惠券，优惠金额为本次优惠总金额6元，优惠数量为本次使用优惠的优惠券数量2张
         */
        private Long amount;
        /**
         * 优惠数量
         */
        private Long count;
        /**
         * 优惠数量类型
         */
        private CountType countType;
        /**
         * 优惠描述
         */
        private String description;
        /**
         * 优惠名称
         */
        private String name;
        /**
         * 优惠ID
         */
        private String rewardId;
        /**
         * 优惠单位，例如 “个”
         */
        private String unit;
        /**
         * 优惠使用记录列表
         */
        private List<RewardUsageRecord> rewardUsageRecords;

    }

}
