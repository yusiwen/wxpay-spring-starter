package cn.yusiwen.wxpay.example.controller;

import cn.yusiwen.wxpay.protocol.v3.WechatApiProvider;
import cn.yusiwen.wxpay.protocol.v3.WechatMarketingFavorApi;
import cn.yusiwen.wxpay.protocol.v3.WechatPayCallback;
import cn.yusiwen.wxpay.protocol.v3.model.ResponseSignVerifyParams;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 务必保证回调接口的幂等性
 * <p>
 * 微信回调控制器，当支付成功、代金券核销成功后，微信支付服务器会通过回调进行通知商户侧。
 * 商户侧可以根据微信的回调通知进行支付的后续处理，例如支付状态的变更等等。
 * 需要注意的是回调接口需要白名单放行。
 * <p>
 * 开发者只需要编写对结果的{@link java.util.function.Consumer}即可。
 * <p>
 * 请注意：返回的格格式必须是{@link WechatPayCallback} 给出的格式，不能被包装和更改，切记！
 * @author yusiwen
 * @since 1.0.0.RELEASE
 */

@Slf4j
@RestController
@RequestMapping("/wxpay/callbacks")
public class CallbackController {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CallbackController.class);

    /**
     * Tenant ID
     */
    private static final String TENANT_ID = "mobile";
    /**
     * WechatApiProvider
     */
    @Autowired
    private WechatApiProvider wechatApiProvider;


    /**
     * 代金券核销通知.
     * <p>
     * 需要手动调用{@link WechatMarketingFavorApi#setMarketingFavorCallback(String)} 设置，一次性操作!
     *
     * @param wechatpaySerial    the wechatpay serial
     * @param wechatpaySignature the wechatpay signature
     * @param wechatpayTimestamp the wechatpay timestamp
     * @param wechatpayNonce     the wechatpay nonce
     * @param request            the request
     * @return the map
     */
    @SneakyThrows
    @PostMapping("/coupon")
    public Map<String, ?> couponCallback(
            @RequestHeader("Wechatpay-Serial") String wechatpaySerial,
            @RequestHeader("Wechatpay-Signature") String wechatpaySignature,
            @RequestHeader("Wechatpay-Timestamp") String wechatpayTimestamp,
            @RequestHeader("Wechatpay-Nonce") String wechatpayNonce,
            HttpServletRequest request) {
        String body = request.getReader().lines().collect(Collectors.joining());
        // 对请求头进行验签 以确保是微信服务器的调用
        ResponseSignVerifyParams params = new ResponseSignVerifyParams();
        params.setWechatpaySerial(wechatpaySerial);
        params.setWechatpaySignature(wechatpaySignature);
        params.setWechatpayTimestamp(wechatpayTimestamp);
        params.setWechatpayNonce(wechatpayNonce);
        params.setBody(body);
        return wechatApiProvider.callback(TENANT_ID).couponCallback(params, data -> {
            //TODO 对回调解析的结果进行消费  需要保证消费的幂等性 微信有可能多次调用此接口
            LOGGER.info(data.toString());
        });
    }

    /**
     * 微信支付成功回调.
     * <p>
     * 无需开发者判断，只有扣款成功微信才会回调此接口
     *
     * @param wechatpaySerial    the wechatpay serial
     * @param wechatpaySignature the wechatpay signature
     * @param wechatpayTimestamp the wechatpay timestamp
     * @param wechatpayNonce     the wechatpay nonce
     * @param request            the request
     * @return the map
     */
    @SneakyThrows
    @PostMapping("/transaction")
    public Map<String, ?> transactionCallback(
            @RequestHeader("Wechatpay-Serial") String wechatpaySerial,
            @RequestHeader("Wechatpay-Signature") String wechatpaySignature,
            @RequestHeader("Wechatpay-Timestamp") String wechatpayTimestamp,
            @RequestHeader("Wechatpay-Nonce") String wechatpayNonce,
            HttpServletRequest request) {
        String body = request.getReader().lines().collect(Collectors.joining());
        // 对请求头进行验签 以确保是微信服务器的调用
        ResponseSignVerifyParams params = new ResponseSignVerifyParams();
        params.setWechatpaySerial(wechatpaySerial);
        params.setWechatpaySignature(wechatpaySignature);
        params.setWechatpayTimestamp(wechatpayTimestamp);
        params.setWechatpayNonce(wechatpayNonce);
        params.setBody(body);
        return wechatApiProvider.callback(TENANT_ID).transactionCallback(params, data -> {
            //TODO 对回调解析的结果进行消费  需要保证消费的幂等性 微信有可能多次调用此接口
            LOGGER.info(data.toString());
        });
    }

    /**
     * 微信合单支付成功回调.
     * <p>
     * 无需开发者判断，只有扣款成功微信才会回调此接口
     *
     * @param wechatpaySerial    the wechatpay serial
     * @param wechatpaySignature the wechatpay signature
     * @param wechatpayTimestamp the wechatpay timestamp
     * @param wechatpayNonce     the wechatpay nonce
     * @param request            the request
     * @return the map
     */
    @SneakyThrows
    @PostMapping("/combine_transaction")
    public Map<String, ?> combineTransactionCallback(
            @RequestHeader("Wechatpay-Serial") String wechatpaySerial,
            @RequestHeader("Wechatpay-Signature") String wechatpaySignature,
            @RequestHeader("Wechatpay-Timestamp") String wechatpayTimestamp,
            @RequestHeader("Wechatpay-Nonce") String wechatpayNonce,
            HttpServletRequest request) {
        String body = request.getReader().lines().collect(Collectors.joining());
        // 对请求头进行验签 以确保是微信服务器的调用
        ResponseSignVerifyParams params = new ResponseSignVerifyParams();
        params.setWechatpaySerial(wechatpaySerial);
        params.setWechatpaySignature(wechatpaySignature);
        params.setWechatpayTimestamp(wechatpayTimestamp);
        params.setWechatpayNonce(wechatpayNonce);
        params.setBody(body);
        return wechatApiProvider.callback(TENANT_ID).combineTransactionCallback(params, data -> {
            //TODO 对回调解析的结果进行消费  需要保证消费的幂等性 微信有可能多次调用此接口
        });
    }
}
