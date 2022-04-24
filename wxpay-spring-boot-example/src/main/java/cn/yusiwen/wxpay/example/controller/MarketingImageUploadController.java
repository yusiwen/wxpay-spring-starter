package cn.yusiwen.wxpay.example.controller;

import cn.yusiwen.wxpay.protocol.v3.WechatApiProvider;
import cn.yusiwen.wxpay.protocol.v3.WechatResponseEntity;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 微信营销图片上传.
 */
@RestController
@RequestMapping("/marketing")
public class MarketingImageUploadController {
    /**
     * WechatApiProvider
     */
    @Autowired
    private WechatApiProvider wechatApiProvider;

    /**
     * Upload wechat response entity.
     *
     * @param file the file
     * @return the wechat response entity
     */
    @PostMapping("/upload")
    public WechatResponseEntity<ObjectNode> upload(MultipartFile file) {
        String tenantId = "mobile";
        return wechatApiProvider.favorApi(tenantId).marketingImageUpload(file);
    }

}
