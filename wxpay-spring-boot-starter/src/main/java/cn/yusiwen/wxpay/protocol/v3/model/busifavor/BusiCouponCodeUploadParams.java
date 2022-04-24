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

import java.util.Set;

import lombok.Data;

/**
 * 商家券上传预存code API请求参数
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class BusiCouponCodeUploadParams {

    /**
     * 批次号
     */
    private String stockId;
    /**
     * 券code列表
     * <p>
     * 特殊规则：单个券code长度为【1，32】，条目个数限制为【1，200】。
     */
    private Set<String> couponCodeList;
    /**
     * 请求业务单据号
     */
    private String uploadRequestNo;
}
