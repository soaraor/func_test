package cn.youyun.Utility;

import java.math.BigDecimal;

public class APIList {
    private String ApiDomain = "";
    private final static String CHARSET_UTF8 = "utf8";
    public APIList(String domain){ ApiDomain = domain; }//不允许直接修改类内接口地址，构造方法实例APIList(string domain)来间接为其赋值，保证其安全性

    /**
     * RegisterDevice：1.设备注册
     * @param DeviceID 设备标识
     * @param DeviceName 设备名称
     * @param DockingDeviceID 对接注册设备标识开头
     * @param GUID 商家唯一标识
     * @param nonceStr 随机字符串
     * @param timestamp 时间戳
     * @return
     */
    public String RegisterDevice(String DeviceID, String DeviceName, String DockingDeviceID, String GUID, String nonceStr, String timestamp,String DockingSecret){
        //请求地址
        String postfix = "/api/RegisterDevice/";
        String RequestURL = ApiDomain + postfix;
        //设备注册签名逻辑
        String stringA ="DeviceID="+DeviceID+"&DeviceName="+DeviceName+"&DockingDeviceID="+DockingDeviceID+"&GUID="+GUID+"&nonceStr="+nonceStr+"&timestamp="+timestamp;//ascii序
        String sign = DataUtil.GetSign(stringA,DockingSecret);
         //请求响应
        String RequestStr = "deviceid="+DeviceID+"&devicename="+DeviceName+"&DockingDeviceID="+DockingDeviceID+"&guid="+GUID+"&nonceStr="+nonceStr+"&timestamp="+timestamp+"&sign="+sign;
        String result = Post4Pay.HttpPost(RequestStr,RequestURL);//发送请求并将相应结果存进resultStr字符串
        return result;
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
     * @return
     */
    public String SignInOrOut(String DeviceID,String devicesecret,int SiteUserID,String SitePwd,int LogID,String DockingDeviceID,String timestamp,String nonceStr,String DockingSecret){
        //请求地址
        String postfix = "/api/SignInOrOut/";
        String RequestURL = ApiDomain + postfix;
        //签到/签退签名逻辑
        String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&LogID="+LogID+"&nonceStr="+nonceStr+"&SitePwd="+SitePwd+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp;//ascii序
        String sign = DataUtil.GetSign(stringA,DockingSecret);
        //请求响应
        String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&siteUserID="+SiteUserID+"&LogID="+LogID+"&SitePwd="+SitePwd+"&DockingDeviceID="+DockingDeviceID+"&timestamp="+timestamp+"&nonceStr="+nonceStr+"&sign="+sign;;
        String result = Post4Pay.HttpPost(RequestStr,RequestURL);
        return result;
    }

    /**
     * AcquirePay：3.扫码收款
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param nonceStr 随机字符串
     * @param PayMoney 收款金额
     * @param ScanpayNo 付款码
     * @param SiteUserID 收银员账号
     * @param timestamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return
     */
    public String AcquirePay(String DeviceID, String devicesecret, String DockingDeviceID, String nonceStr, BigDecimal PayMoney, String ScanpayNo, String SiteUserID, String timestamp, String DockingSecret){
        //请求地址
        String postfix = "/api/AcquirePay/";
        String RequestURL = ApiDomain + postfix;
        //扫码收款签名逻辑
        String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&PayMoney="+PayMoney+"&ScanpayNo="+ScanpayNo+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp;//ascii序
        String sign = DataUtil.GetSign(stringA,DockingSecret);
        //请求响应
        String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&paymoney="+PayMoney+"&scanpayno="+ScanpayNo+"&siteUserID="+SiteUserID+"&timestamp="+timestamp+"&sign="+sign;
        String result = Post4Pay.HttpPost(RequestStr,RequestURL);
        return result;
    }

    /**
     * QrcodePay：4.二维码收款
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
     * @return
     */
    public String QrcodePay(String DeviceID, String devicesecret, String DockingDeviceID, String nonceStr, BigDecimal Paymoney,String PayType, String DockingOrderID, int SiteUserID, String timestamp, String DockingSecret){
        //请求地址
        String postfix = "/api/QrcodePay/";
        String RequestURL = ApiDomain + postfix;
        //二维码收款签名逻辑
        String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&DockingOrderID="+DockingOrderID+"&nonceStr="+nonceStr+"&Paymoney="+Paymoney+"&PayType="+PayType+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp;//ascii序
        String sign = DataUtil.GetSign(stringA,DockingSecret);
        //请求响应
        String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&paymoney="+Paymoney+"&PayType="+PayType+"&DockingOrderID="+DockingOrderID+"&siteUserID="+SiteUserID+"&timestamp="+timestamp+"&sign="+sign;
        String result = Post4Pay.HttpPost(RequestStr,RequestURL);
        return result;
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
     * @return
     */
    public String GetPayState(String DockingDeviceID,String DeviceID,String devicesecret,String OrderID,String timestamp,String nonceStr,String DockingSecret){
        //请求地址
        String postfix = "/api/GetPayState/";
        String RequestURL = ApiDomain + postfix;
        //获取交易订单支付状态签名逻辑
        String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&OrderID="+OrderID+"&timestamp="+timestamp;//ascii序
        String sign = DataUtil.GetSign(stringA,DockingSecret);
        //请求响应
        String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&OrderID="+OrderID+"&timestamp="+timestamp+"&sign="+sign;
        String result = Post4Pay.HttpPost(RequestStr,RequestURL);
        return result;
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
     * @return
     */
    public String GetPayInfo(String DockingDeviceID,String DeviceID,String devicesecret,String OrderID,String timestamp,String nonceStr,String DockingSecret){
        //请求地址
        String postfix = "/api/GetPayInfo/";
        String RequestURL = ApiDomain + postfix;
        //获取成功订单明细签名逻辑
        String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&OrderID="+OrderID+"&timestamp="+timestamp;//ascii序
        String sign = DataUtil.GetSign(stringA,DockingSecret);
        //请求响应
        String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&OrderID="+OrderID+"&timestamp="+timestamp+"&sign="+sign;
        String result = Post4Pay.HttpPost(RequestStr,RequestURL);
        return result;
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
     * @return
     */
    public String Refund(String DockingDeviceID,String DeviceID,String devicesecret,String OrderID,String timestamp,String nonceStr,String DockingSecret,String RefundOrderID, BigDecimal Remoney, String Operatepass){
        //请求地址
        String postfix = "/api/Refund/";
        String RequestURL = ApiDomain + postfix;
        //获取退款签名逻辑
        String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&Operatepass="+Operatepass+"&OrderID="+OrderID+"&RefundOrderID="+RefundOrderID+"&Remoney="+Remoney+"&timestamp="+timestamp;//ascii序
        String sign = DataUtil.GetSign(stringA,DockingSecret);
        //请求响应
        String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&OrderID="+OrderID+"&timestamp="+timestamp+"&RefundOrderID="+RefundOrderID+"&Remoney="+Remoney+"&Operatepass="+Operatepass+"&sign="+sign;
        String result = Post4Pay.HttpPost(RequestStr,RequestURL);
        return result;
    }



    // 8.卡券核销；9.聚合二维码收款；10.wap收款；11.订单关闭；12.口碑单品卡券核销；13.对账单
}
