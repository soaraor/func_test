package cn.youyun.Utility;

import java.math.BigDecimal;

public class APIList {//本部分是所有开放web api的具体实现逻辑
    private String ApiDomain = "";
    public APIList(String domain){ ApiDomain = domain; }//不允许直接修改类内接口域名，构造方法实例APIList(string domain)来间接为其赋值，保证其安全性

    /**
     * RegisterDevice：1.设备注册
     * @param DeviceID 设备标识
     * @param DeviceName 设备名称
     * @param DockingDeviceID 对接注册设备标识开头
     * @param GUID 商家唯一标识
     * @param nonceStr 随机字符串
     * @param timestamp 时间戳
     * @return success,Msg,ReObj
     */
    public String RegisterDevice(String DeviceID, String DeviceName, String DockingDeviceID, String GUID, String nonceStr, String timestamp,String DockingSecret){
        //设备注册请求地址
        String postfix = "/api/RegisterDevice/";
        String RequestURL = ApiDomain + postfix;
        try {
            //设备注册签名逻辑
            String stringA ="DeviceID="+DeviceID+"&DeviceName="+DeviceName+"&DockingDeviceID="+DockingDeviceID+"&GUID="+GUID+"&nonceStr="+nonceStr+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr = "deviceid="+DeviceID+"&devicename="+DeviceName+"&DockingDeviceID="+DockingDeviceID+"&guid="+GUID+"&nonceStr="+nonceStr+"&timestamp="+timestamp+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);//发送请求并将相应结果存进resultStr字符串
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * SignInOrOut：2.签到/签退
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param SiteUserID 收银员账号
     * @param SitePwd 收银员密码
     * @param LogID 签到ID
     * @param DockingDeviceID 对接注册设备标识开头
     * @param timestamp 时间戳
     * @param nonceStr 随机字符串
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String SignInOrOut(String DeviceID,String devicesecret,int SiteUserID,String SitePwd,int LogID,String DockingDeviceID,String timestamp,String nonceStr,String DockingSecret){
        //签到/签退请求地址
        String postfix = "/api/SignInOrOut/";
        String RequestURL = ApiDomain + postfix;
        try {
            //签到/签退签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&LogID="+LogID+"&nonceStr="+nonceStr+"&SitePwd="+SitePwd+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&siteUserID="+SiteUserID+"&LogID="+LogID+"&SitePwd="+SitePwd+"&DockingDeviceID="+DockingDeviceID+"&timestamp="+timestamp+"&nonceStr="+nonceStr+"&sign="+sign;;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * AcquirePay：3.扫买家码收款
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param nonceStr 随机字符串
     * @param PayMoney 收款金额
     * @param ScanpayNo 付款码
     * @param SiteUserID 收银员账号
     * @param timestamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String AcquirePay(String DeviceID, String devicesecret, String DockingDeviceID, String nonceStr, BigDecimal PayMoney, String ScanpayNo, String SiteUserID, String timestamp, String DockingSecret){
        //扫码收款请求地址
        String postfix = "/api/AcquirePay/";
        String RequestURL = ApiDomain + postfix;
        try {
            //扫码收款签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&PayMoney="+PayMoney+"&ScanpayNo="+ScanpayNo+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&paymoney="+PayMoney+"&scanpayno="+ScanpayNo+"&siteUserID="+SiteUserID+"&timestamp="+timestamp+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * QrcodePay：4.出示二维码收款
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param nonceStr 随机字符串
     * @param Paymoney 付款金额
     * @param PayType 支付类型
     * @param DockingOrderID 第三方订单号
     * @param SiteUserID 收银员账号
     * @param timestamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String QrcodePay(String DeviceID, String devicesecret, String DockingDeviceID, String nonceStr, BigDecimal Paymoney,String PayType, String DockingOrderID, int SiteUserID, String timestamp, String DockingSecret){
        //二维码收款请求地址
        String postfix = "/api/QrcodePay/";
        String RequestURL = ApiDomain + postfix;
        try {
            //二维码收款签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&DockingOrderID="+DockingOrderID+"&nonceStr="+nonceStr+"&Paymoney="+Paymoney+"&PayType="+PayType+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&paymoney="+Paymoney+"&PayType="+PayType+"&DockingOrderID="+DockingOrderID+"&siteUserID="+SiteUserID+"&timestamp="+timestamp+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * GetPayState：5.获取交易订单支付状态
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param OrderID 交易订单号
     * @param timestamp 时间戳
     * @param nonceStr 随机字符串
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String GetPayState(String DockingDeviceID,String DeviceID,String devicesecret,String OrderID,String timestamp,String nonceStr,String DockingSecret){
        //获取交易订单支付状态请求地址
        String postfix = "/api/GetPayState/";
        String RequestURL = ApiDomain + postfix;
        try {
            //获取交易订单支付状态签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&OrderID="+OrderID+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&OrderID="+OrderID+"&timestamp="+timestamp+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * GetPayInfo：6.获取成功订单明细
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param OrderID 交易订单号
     * @param timestamp 时间戳
     * @param nonceStr 随机字符串
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String GetPayInfo(String DockingDeviceID,String DeviceID,String devicesecret,String OrderID,String timestamp,String nonceStr,String DockingSecret){
        //获取成功订单明细请求地址
        String postfix = "/api/GetPayInfo/";
        String RequestURL = ApiDomain + postfix;
        try {
            //获取成功订单明细签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&OrderID="+OrderID+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&OrderID="+OrderID+"&timestamp="+timestamp+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * Refund：7.退款
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param OrderID 交易订单号
     * @param timestamp 时间戳
     * @param nonceStr 随机字符串
     * @param DockingSecret 对接秘钥
     * @param RefundOrderID 退款订单号
     * @param Remoney 退款金额
     * @param Operatepass 退款授权密码
     * @return success,Msg,ReObj
     */
    public String Refund(String DockingDeviceID,String DeviceID,String devicesecret,String OrderID,String timestamp,String nonceStr,String DockingSecret,String RefundOrderID, BigDecimal Remoney, String Operatepass){
        //退款签名请求地址
        String postfix = "/api/Refund/";
        String RequestURL = ApiDomain + postfix;
        try {
            //退款签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&Operatepass="+Operatepass+"&OrderID="+OrderID+"&RefundOrderID="+RefundOrderID+"&Remoney="+Remoney+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&OrderID="+OrderID+"&timestamp="+timestamp+"&RefundOrderID="+RefundOrderID+"&Remoney="+Remoney+"&Operatepass="+Operatepass+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * TicketUse：8.卡券核销
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param timestamp 时间戳
     * @param nonceStr 随机字符串
     * @param Scanticketno 卡券号
     * @param Discount 核销金额
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String TicketUse(String DockingDeviceID,String DeviceID,String devicesecret,String timestamp,String nonceStr,String Scanticketno, BigDecimal Discount,String DockingSecret){
        //卡券核销请求地址
        String postfix = "/api/TicketUse/";
        String RequestURL = ApiDomain + postfix;
        try {
            //卡券核销签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&Paymoney="+Discount+"&Scanticketno="+Scanticketno+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&timestamp="+timestamp+"&Scanticketno="+Scanticketno+"&Paymoney="+Discount+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * AggregateOrder：9.聚合二维码收款
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param timestamp 时间戳
     * @param nonceStr 随机字符串
     * @param DockingOrderID 第三方订单号
     * @param SiteUserID 收银员账号
     * @param Paymoney 收款金额
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String AggregateOrder(String DockingDeviceID,String DeviceID,String devicesecret,String timestamp,String nonceStr,String DockingOrderID,int SiteUserID, BigDecimal Paymoney,String DockingSecret){
        //聚合支付请求地址
        String postfix = "/api/AggregateOrder/";
        String RequestURL = ApiDomain + postfix;
        try {
            //聚合支付签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&DockingOrderID="+DockingOrderID+"&nonceStr="+nonceStr+"&Paymoney="+Paymoney+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&timestamp="+timestamp+"&DockingOrderID="+DockingOrderID+"&SiteUserID="+SiteUserID+"&Paymoney="+Paymoney+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * UnifiedOrder：10.wap收款
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param timestamp 时间戳
     * @param nonceStr 随机字符串
     * @param DockingOrderID 交易订单号
     * @param SiteUserID 收银员账号
     * @param Paytype 支付类型
     * @param Paymoney 支付金额
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String UnifiedOrder(String DockingDeviceID,String DeviceID,String devicesecret,String timestamp,String nonceStr,String DockingOrderID,int SiteUserID, String Paytype, BigDecimal Paymoney,String DockingSecret){
        //wap收款请求地址
        String postfix = "/api/UnifiedOrder/";
        String RequestURL = ApiDomain + postfix;
        try {
            //wap收款签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&DockingOrderID="+DockingOrderID+"&nonceStr="+nonceStr+"&Paymoney="+Paymoney+"&Paytype="+Paytype+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&DockingOrderID="+DockingOrderID+"&nonceStr="+nonceStr+"&Paymoney="+Paymoney+"&Paytype="+Paytype+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * CloseOrder：11.订单关闭
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param timestamp 时间戳
     * @param nonceStr 随机字符串
     * @param OrderID 交易订单号
     * @param SiteUserID 收银员账号
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String CloseOrder(String DockingDeviceID,String DeviceID,String devicesecret,String timestamp,String nonceStr,String OrderID, int SiteUserID,String DockingSecret){
        //订单关闭请求地址
        String postfix = "/api/CloseOrder/";
        String RequestURL = ApiDomain + postfix;
        try {
            //订单关闭签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&OrderID="+OrderID+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&timestamp="+timestamp+"&OrderID="+OrderID+"&SiteUserID="+SiteUserID+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * UseKouBeiCard：12.口碑单品卡券核销
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param timestamp 时间戳
     * @param nonceStr 随机字符串
     * @param Scanticketno 卡券号
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String UseKouBeiCard(String DockingDeviceID,String DeviceID,String devicesecret,String timestamp,String nonceStr,String Scanticketno,String DockingSecret){
        //口碑单品卡券核销请求地址
        String postfix = "/api/UseKouBeiCard/";
        String RequestURL = ApiDomain + postfix;
        try {
            //口碑单品卡券核销签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&Scanticketno="+Scanticketno+"&timestamp="+timestamp;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&timestamp="+timestamp+"&Scanticketno="+Scanticketno+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * DownloadBill：13.对账单
     * @param DockingDeviceID
     * @param DeviceID
     * @param devicesecret
     * @param timestamp
     * @param nonceStr
     * @param TradeDate
     * @param DockingSecret
     * @return success,Msg,ReObj
     */
    public String DownloadBill(String DockingDeviceID,String DeviceID,String devicesecret,String timestamp,String nonceStr,String TradeDate,String DockingSecret){
        //请求地址
        String postfix = "/api/DownloadBill/";
        String RequestURL = ApiDomain + postfix;
        try {
            //卡券核销签名逻辑
            String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&timestamp="+timestamp+"&TradeDate="+TradeDate;//ascii序
            String sign = DataUtil.GetSign(stringA,DockingSecret);
            //请求响应
            String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&timestamp="+timestamp+"&TradeDate="+TradeDate+"&sign="+sign;
            String result = Post4Pay.HttpPost(RequestStr,RequestURL);
            return result;
        }catch (Exception e){
            return null;
        }
    }

}
