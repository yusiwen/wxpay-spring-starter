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
package cn.yusiwen.wxpay.protocol.v3.model.payscore;

import lombok.Data;

/**
 * 服务位置信息
 * <p>
 * 如果传入，用户侧则显示此参数。
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class Location {

    /**
     * 服务开始地点，选填。
     * <p>
     * 开始使用服务的地点，不超过50个字符，超出报错处理。 【建议】 1、用户下单时【未确定】服务结束地点，不填写。 2、服务在同一地点开始和结束，不填写。 3、用户下单时【已确定】服务结束地点，填写。
     */
    private String startLocation;
    /**
     * 预计服务结束地点，有开始地点时为必填。
     *
     * 1、结束使用服务的地点，不超过50个字符，超出报错处理 。 2、填写了服务开始地点，才能填写服务结束地点。
     */
    private String endLocation;
}
