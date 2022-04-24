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

import lombok.Data;

import cn.yusiwen.wxpay.protocol.enumeration.DetailStatus;

/**
 * 微信批次单号查询批次单API 或者 商家批次单号查询批次单API 请求参数
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class QueryBatchTransferParams {
    /**
     * 微信批次单号 或 商家批次单号
     */
    private String code;
    /**
     * 是否查询转账明细单
     */
    private Boolean needQueryDetail;
    /**
     * 请求资源起始位置
     */
    private Integer offset;
    /**
     * 最大资源条数
     */
    private Integer limit;
    /**
     * 明细状态
     */
    private DetailStatus detailStatus;

}
