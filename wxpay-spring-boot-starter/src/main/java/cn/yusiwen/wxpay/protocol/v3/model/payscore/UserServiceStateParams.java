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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 查询用户授权状态参数.
 * <p>
 * {@code appId} 从对应租户的配置中自动注入。
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
@Data
public class UserServiceStateParams {
    /**
     * 微信支付分 服务ID , 需要微信侧运营操作绑定到商户。
     */
    private String serviceId;
    /**
     * 微信用户在商户对应appId下的唯一标识。
     */
    @JsonProperty("openid")
    private String openId;

}
