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
package cn.yusiwen.wxpay.protocol.v3.model.batchtransfer;

import java.time.LocalDate;

import lombok.Data;

import cn.yusiwen.wxpay.protocol.enumeration.FundFlowAccountType;

/**
 * 商户银行来账查询API 请求参数
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class QueryIncomeRecordParams {
    /**
     * 账户类型，必填
     *
     * @see FundFlowAccountType
     */
    private FundFlowAccountType accountType;
    /**
     * 日期，必填
     */
    private LocalDate date;
    /**
     * 本次查询偏移量，选填
     * <p>
     * 表示该次请求资源的起始位置，从0开始计数。调用方选填，默认为0。offset为20，limit为100时，查询第20-119条数据
     */
    private Integer offset;
    /**
     * 本次请求最大查询条数，必填
     * <p>
     * 非0非负的整数，该次请求可返回的最大资源条数，最大支持100条。
     */
    private Integer limit;
}
