# 微信支付spring-boot启动项目

## 使用

在项目pom.xml中添加如下依赖

```xml
<dependency>
    <groupId>cn.yusiwen</groupId>
    <artifactId>wxpay-spring-boot-starter</artifactId>
    <version>1.0.0.RELEASE</version>
</dependency>
```

## 配置

在项目的配置文件中增加如下配置向

```yaml
# 微信支付，以下参数均为虚构
wechat:
  pay:
    v3:
      # 租户id
      mobile:
        # 应用appId 必填
        app-id: wx554b6b******54312
        # v2 api 密钥  1.0.5版本以后如果用到V2的接口时必填，单纯V3不需要
        app-secret: app*******secret
        # api v3 密钥 必填
        app-v3-secret: 0e4efac*************5303ec
        # 微信支付商户号 必填
        mch-id: 112312349
        # 商户服务器域名 用于回调  回调路径为 domain + notifyUrl  需要放开回调接口的安全策略 必填
        # 本地测试时可以用ngrok做内网穿透，具体可见ngrok文档：https://dashboard.ngrok.com/get-started/setup
        domain: https://a94e-104-245-14-202.jp.ngrok.io
        # 商户 api 证书路径 必填  填写classpath路径 位于 maven项目的resources文件下
        cert-path: wechat/apiclient_cert.p12
```

具体请见`wxpay-spring-boot-example`项目

## 感谢

- [Wechat-Group/WxJava](https://github.com/Wechat-Group/WxJava)
- [NotFound403/payment-spring-boot](https://github.com/NotFound403/payment-spring-boot)
- [zhong-zhuang/we-chat-pay-native](https://gitee.com/zhong-zhuang/we-chat-pay-native)