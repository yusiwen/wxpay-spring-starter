package cn.yusiwen.wxpay.example.controller;

import cn.yusiwen.wxpay.protocol.enumeration.TradeBillType;
import cn.yusiwen.wxpay.protocol.v3.WechatApiProvider;
import cn.yusiwen.wxpay.protocol.v3.WechatDirectPayApi;
import cn.yusiwen.wxpay.protocol.v3.model.Amount;
import cn.yusiwen.wxpay.protocol.v3.model.FundFlowBillParams;
import cn.yusiwen.wxpay.protocol.v3.model.PayParams;
import cn.yusiwen.wxpay.protocol.v3.model.Payer;
import cn.yusiwen.wxpay.protocol.v3.model.TradeBillParams;
import cn.yusiwen.wxpay.protocol.v3.model.TransactionQueryParams;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

/**
 * 支付接口开发样例，以Native支付为例.
 */
@RestController
@RequestMapping("/wxpay")
public class PayController {

    /**
     * Tenant ID
     */
    public static final String TENANT_ID = "mobile";

    /**
     * WechatApiProvider
     */
    @Autowired
    private WechatApiProvider wechatApiProvider;

    /**
     * 总流程建议为:
     * <p>
     * 生成商品订单 - 生成对应的支付订单 - 支付操作 - 支付结果回调更新 - 结束
     * <p>
     * 此处建议在商品订单生成之后调用
     *
     * @param orderId 商品订单id
     * @return the object node
     */
    @PostMapping("/nativePay")
    public ObjectNode nativePay(@RequestParam String orderId) {

        //TODO
        // 查询该orderId下是否生成了支付订单
        // 如果没有
        // 新增支付订单存入数据库 并标明支付状态为【待支付】
        // 根据新生成的支付订单信息向微信支付发起支付 并根据返回结果进行处理
        // 如果有状态为待支付
        // 根据待支付订单信息向微信支付发起支付 并根据返回结果进行处理
        // 如果有状态为待支付之外的状态
        // 根据产品的业务设计自行实现
        // 支付状态更新逻辑在【回调接口 /wxpay/callbacks/transaction】中处理  需要幂等处理

        // 开发时需要指定使用的商户租户配置 这里为 mobile 请参考 application.yml
        PayParams payParams = new PayParams();
        payParams.setDescription("wxpay-spring-boot-starter-example");
        // 商户侧唯一订单号 建议为商户侧支付订单号 订单表主键 或者唯一标识字段
        payParams.setOutTradeNo(orderId);
        // 需要定义回调通知
        payParams.setNotifyUrl("/wxpay/callbacks/transaction");
        Amount amount = new Amount();
        amount.setTotal(1);
        payParams.setAmount(amount);
        // 此类支付  Payer 必传  且openId需要同appId有绑定关系 具体去看文档
        Payer payer = new Payer();
        payer.setOpenId("ooadI5kQYrrCqpgbisvC8bEw_oUc");
        payParams.setPayer(payer);

        return wechatApiProvider.directPayApi(TENANT_ID)
                .nativePay(payParams)
                .getBody();
    }

    /**
     * 根据商户订单号查询支付状态
     *
     * @param orderId 支付订单号
     * @return 应答报文体
     */
    @PostMapping("/queryTransaction")
    public ObjectNode queryTransaction(@RequestParam String orderId) {

        TransactionQueryParams params = new TransactionQueryParams();
        params.setTransactionIdOrOutTradeNo(orderId);
        return wechatApiProvider.directPayApi(TENANT_ID).queryTransactionByOutTradeNo(params).getBody();
    }

    /**
     * 下载对账单 如果要解析内容的话自行实现
     *
     * @return the response entity
     */
    @GetMapping("/tradebill")
    public ResponseEntity<Resource> download() {
        WechatDirectPayApi wechatDirectPayApi = wechatApiProvider.directPayApi(TENANT_ID);

        TradeBillParams tradeBillParams = new TradeBillParams();
        tradeBillParams.setBillDate(LocalDate.of(2021, Month.MAY, 20));
        tradeBillParams.setBillType(TradeBillType.ALL);
        return wechatDirectPayApi.downloadTradeBill(tradeBillParams);
    }

    /**
     * 下载申请资金账单  如果要解析内容的话自行实现
     *
     * @return the response entity
     */
    @GetMapping("/fundflowbill")
    public ResponseEntity<Resource> fundFlowBill() {
        WechatDirectPayApi wechatDirectPayApi = wechatApiProvider.directPayApi(TENANT_ID);

        FundFlowBillParams fundFlowBillParams = new FundFlowBillParams();
        fundFlowBillParams.setBillDate(LocalDate.of(2021, Month.MAY, 20));

        return wechatDirectPayApi.downloadFundFlowBill(fundFlowBillParams);
    }
}
