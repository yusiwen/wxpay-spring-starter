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
import cn.yusiwen.wxpay.protocol.v2.model.GroupRedpackModel;
import cn.yusiwen.wxpay.protocol.v2.model.RedpackInfoModel;
import cn.yusiwen.wxpay.protocol.v2.model.RedpackModel;

/**
 * 现金红包
 *
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */
public class WechatPayRedpackApi {
    /**
     * WechatV2Client
     */
    private final WechatV2Client wechatV2Client;

    /**
     * Instantiates a new Wechat pay redpack api.
     *
     * @param wechatV2Client
     *            the wechat v 2 client
     */
    public WechatPayRedpackApi(WechatV2Client wechatV2Client) {
        this.wechatV2Client = wechatV2Client;
    }

    /**
     * 发放随机红包
     *
     * @param redpackModel
     *            the redpack model
     * @return the json node
     */
    public JsonNode sendRedpack(RedpackModel redpackModel) {

        WechatPayProperties.V3 v3 = wechatV2Client.getWechatMetaBean().getV3();
        redpackModel.setAppId(v3.getAppId());
        redpackModel.setMchId(v3.getMchId());
        return wechatV2Client.wechatPayRequest(redpackModel, HttpMethod.POST,
                "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack");
    }

    /**
     * 发放裂变红包
     *
     * @param groupRedpackModel
     *            the group redpack model
     * @return the json node
     */
    public JsonNode sendRedpack(GroupRedpackModel groupRedpackModel) {
        WechatPayProperties.V3 v3 = wechatV2Client.getWechatMetaBean().getV3();
        groupRedpackModel.setAppId(v3.getAppId());
        groupRedpackModel.setMchId(v3.getMchId());
        return wechatV2Client.wechatPayRequest(groupRedpackModel, HttpMethod.POST,
                "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack");
    }

    /**
     * 查询红包信息
     *
     * @param redpackInfoModel
     *            the redpack info model
     * @return the json node
     */
    public JsonNode redpackInfo(RedpackInfoModel redpackInfoModel) {
        WechatPayProperties.V3 v3 = wechatV2Client.getWechatMetaBean().getV3();
        redpackInfoModel.setAppId(v3.getAppId());
        redpackInfoModel.setMchId(v3.getMchId());
        return wechatV2Client.wechatPayRequest(redpackInfoModel, HttpMethod.POST,
                "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo");
    }
}
