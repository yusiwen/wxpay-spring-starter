<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <title>微信Native支付测试</title>
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
    <script type="text/javascript">
        var interval;//计时器

        //生成微信支付二维码
        function wxPayTest(orderNo) {
            $.ajax({
                url: '${ctx}/wxpay/nativePay',
                type: 'post',
                cache: false,
                data: {
                    "orderId": orderNo
                },
                dataType: 'json',
                success: function (result) {
                    console.log(result.code_url)
                    //生成二维码
                    $("#code").qrcode({
                        render: "canvas", //table方式
                        width: 240, //宽度
                        height: 240, //高度
                        text: result.code_url //任意内容
                    });

                    clearInterval(interval);
                    interval = setInterval(function () {
                        seletOrderState(orderNo);
                    }, 2000);
                }, error: function () {
                    alert("请求服务器超时");
                }
            });
        }

        //查询订单状态
        function seletOrderState(orderNo) {
            $.ajax({
                url: '${ctx}/wxpay/queryTransaction',
                type: 'post',
                cache: false,
                data: {
                    "orderId": orderNo
                },
                dataType: 'json',
                success: function (result) {
                    if (result.trade_state === 'SUCCESS') {
                        clearInterval(interval);
                        //alert("支付成功，跳转成功页面");
                        window.location = "${ctx}/success.jsp"
                    } else {
                        console.log(result.trade_state);
                    }
                }, error: function () {
                    console.log("请求服务器超时");
                }
            });
        }

        $(document).on('click', '#payBtn', function () {
            var orderId = $('#orderNo').val();
            console.log(orderId);
            wxPayTest(orderId);
        });

        $(document).on('click', '#queryBtn', function () {
            var orderId = $('#orderNo').val();
            console.log(orderId);
            seletOrderState(orderId);
        });
    </script>
</head>
<body>
<button id="payBtn">微信支付测试</button>
<input type="text" id="orderNo"/>
<span>温馨提示:支付完成后，稍等片刻</span>
<button id="queryBtn">查询订单接口测试</button>

<div align="center" style="margin-top: 100px;">
    <div id="code" style="width: 240px;height: 240px;margin: 0px auto;"></div>
</div>

</body>
</html>
