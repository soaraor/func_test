package cn.youyun.Utility;

import java.math.BigDecimal;

public class APIList {
    private String ApiDomain = "";
    private final static String CHARSET_UTF8 = "utf8";
    public APIList(String domain){ ApiDomain = domain; }//不允许直接修改类内接口地址，构造方法实例APIList(string domain)来间接为其赋值，保证其安全性

    /**
     * RegisterDevice：设备注册
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
        String stringA ="DeviceID="+DeviceID+"&DeviceName="+DeviceName+"&DockingDeviceID="+DockingDeviceID+"&GUID="+GUID+"&nonceStr="+nonceStr+"&timestamp="+timestamp;
        String sign = DataUtil.GetSign(stringA,DockingSecret);
         //请求响应
        String RequestStr = "deviceid="+DeviceID+"&devicename="+DeviceName+"&DockingDeviceID="+DockingDeviceID+"&guid="+GUID+"&nonceStr="+nonceStr+"&timestamp="+timestamp+"&sign="+sign;
        String result = Post4Pay.HttpPost(RequestStr,RequestURL);//发送请求并将相应结果存进resultStr字符串
        return result;
    }

    /**
     * SignInOrOut：签到/签退
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param SiteUserID 收银员ID
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
        String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&LogID="+LogID+"&nonceStr="+nonceStr+"&SitePwd="+SitePwd+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp;
        String sign = DataUtil.GetSign(stringA,DockingSecret);
        //请求响应
        String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&siteUserID="+SiteUserID+"&LogID="+LogID+"&SitePwd="+SitePwd+"&DockingDeviceID="+DockingDeviceID+"&timestamp="+timestamp+"&nonceStr="+nonceStr+"&sign="+sign;;
        String result = Post4Pay.HttpPost(RequestStr,RequestURL);
        return result;
    }

    /**
     * AcquirePay：扫码收款
     * @param DeviceID 设备标识
     * @param devicesecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param nonceStr 随机字符串
     * @param PayMoney 收款金额
     * @param ScanpayNo 付款码
     * @param SiteUserID 收银员ID
     * @param timestamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return
     */
    public String AcquirePay(String DeviceID, String devicesecret, String DockingDeviceID, String nonceStr, BigDecimal PayMoney, String ScanpayNo, int SiteUserID, String timestamp, String DockingSecret){
        //请求地址
        String postfix = "/api/AcquirePay/";
        String RequestURL = ApiDomain + postfix;
        //扫码收款签名逻辑
        String stringA ="DeviceID="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&PayMoney="+PayMoney+"&ScanpayNo="+ScanpayNo+"&SiteUserID="+SiteUserID+"&timestamp="+timestamp;
        String sign = DataUtil.GetSign(stringA,DockingSecret);
        //请求响应
        String RequestStr ="deviceid="+DeviceID+"&devicesecret="+devicesecret+"&DockingDeviceID="+DockingDeviceID+"&nonceStr="+nonceStr+"&paymoney="+PayMoney+"&scanpayno="+ScanpayNo+"&siteUserID="+SiteUserID+"&timestamp="+timestamp+"&sign="+sign;
        String result = Post4Pay.HttpPost(RequestStr,RequestURL);
        return result;
    }
}
