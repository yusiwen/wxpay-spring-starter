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

import java.util.List;

import lombok.Data;

/**
 * 固定时间段可用
 * <p>
 * 允许指定券在特殊时间段生效。当设置固定时间段可用时不可设置领取后N天有效
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class FixAvailableTime {

    /**
     * 可用星期数
     *
     * 允许指定每周固定星期数生效，0代表周日生效，1代表周一生效，以此类推；不填则代表在可用时间内周一至周日都生效。
     */
    private List<Long> availableWeekDay;
    /**
     * 允许指定特殊生效星期数中的具体生效的时间段。
     *
     * 当天开始时间，单位：秒。
     */
    private Long beginTime;
    /**
     * 允许指定特殊生效星期数中的具体生效的时间段。
     *
     * 当天结束时间，单位：秒，默认为23点59分59秒。
     */
    private Long endTime;

}
