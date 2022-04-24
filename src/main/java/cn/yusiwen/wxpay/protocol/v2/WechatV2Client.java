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

package cn.yusiwen.wxpay.protocol.v2;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.http.HttpMethod;

import cn.yusiwen.wxpay.WechatPayProperties;
import cn.yusiwen.wxpay.protocol.v2.model.BaseModel;
import cn.yusiwen.wxpay.protocol.v3.WechatMetaBean;

/**
 * 微信支付V2 客户端
 * <p>
 * V3接口不完善的临时性解决方案
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
public class WechatV2Client {
    /**
     * WechatMetaBean
     */
    private final WechatMetaBean wechatMetaBean;

    public WechatV2Client(WechatMetaBean wechatMetaBean) {
        this.wechatMetaBean = wechatMetaBean;
    }

    public <M extends BaseModel> JsonNode wechatPayRequest(M model, HttpMethod method, String url) {
        WechatPayProperties.V3 v3 = wechatMetaBean.getV3();
        return model.appSecret(v3.getAppSecret()).request(v3.getMchId(), method, url);
    }

    public WechatMetaBean getWechatMetaBean() {
        return wechatMetaBean;
    }
}
