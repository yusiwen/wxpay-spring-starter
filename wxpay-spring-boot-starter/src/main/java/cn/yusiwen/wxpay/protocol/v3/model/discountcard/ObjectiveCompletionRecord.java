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

import lombok.Data;

import cn.yusiwen.wxpay.protocol.enumeration.StrategyType;

/**
 * 微信先享卡目标完成纪录
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class ObjectiveCompletionRecord {

    /**
     * 目标完成数量
     */
    private Long completionCount;
    /**
     * 目标完成时间
     */
    private String completionTime;
    /**
     * 目标完成类型
     */
    private StrategyType completionType;
    /**
     * 目标完成描述
     */
    private String description;
    /**
     * 目标完成流水号
     */
    private String objectiveCompletionSerialNo;
    /**
     * 目标id
     */
    private String objectiveId;
    /**
     * 备注说明
     */
    private String remark;

}
