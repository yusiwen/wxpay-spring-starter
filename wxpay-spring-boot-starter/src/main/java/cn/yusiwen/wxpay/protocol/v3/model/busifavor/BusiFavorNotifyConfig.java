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

/**
 * 事件通知配置
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class BusiFavorNotifyConfig {

    /**
     * 事件通知appId
     * <p>
     * 用于回调通知时，计算返回操作用户的openId（诸如领券用户），支持小程序or公众号的APPID； 如该字段不填写，则回调通知中涉及到用户身份信息的openId与unionid都将为空。
     */
    @JsonProperty("notify_appid")
    private String notifyAppId;
}
