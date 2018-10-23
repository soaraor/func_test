package cn.youyun.Utility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.*;

public class APIList {//本部分是所有开放web api的具体实现逻辑
    private String ApiDomain = "";
    public APIList(String domain){ ApiDomain = domain; }//不允许直接修改类内接口域名，构造方法实例APIList(string domain)来间接为其赋值，保证其安全性

    /**
     * RegisterDevice：设备注册
     * @param DeviceID 设备标识
     * @param DeviceName 设备名称
     * @param DockingDeviceID 对接注册设备标识开头
     * @param GUID 商家唯一标识
     * @param NonceStr 随机字符串
     * @param TimeStamp 时间戳
     * @return success,Msg,ReObj
     */
    public String RegisterDevice(String DeviceID, String DeviceName, String DockingDeviceID, String GUID, String NonceStr, String TimeStamp,String DockingSecret){
        //设备注册请求地址
        String postfix = "/api/RegisterDevice/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "RegisterDevice";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceName);
        ParamList.add(DockingDeviceID);
        ParamList.add(GUID);
        ParamList.add(NonceStr);
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * SignInOrOut：2.签到/签退
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param LogID 签到ID
     * @param NonceStr 随机字符串
     * @param SitePwd 收银员密码
     * @param SiteUserID 收银员账号
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String SignInOrOut(String DeviceID,String DeviceSecret,String DockingDeviceID,int LogID,String NonceStr,String SitePwd, int SiteUserID,String TimeStamp,String DockingSecret){
        //签到/签退请求地址
        String postfix = "/api/SignInOrOut/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "SignInOrOut";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(String.valueOf(LogID));
        ParamList.add(NonceStr);
        ParamList.add(SitePwd);
        ParamList.add(String.valueOf(SiteUserID));
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * AcquirePay：3.扫买家码收款
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param NonceStr 随机字符串
     * @param PayMoney 收款金额
     * @param ScanPayNo 付款码
     * @param SiteUserID 收银员账号
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String AcquirePay(String DeviceID, String DeviceSecret, String DockingDeviceID, String NonceStr, BigDecimal PayMoney, String ScanPayNo, int SiteUserID, String TimeStamp, String DockingSecret){
        //扫码收款请求地址
        String postfix = "/api/AcquirePay/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "AcquirePay";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(NonceStr);
        ParamList.add(String.valueOf(PayMoney));
        ParamList.add(ScanPayNo);
        ParamList.add(String.valueOf(SiteUserID));
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * QrcodePay：4.出示二维码收款
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DockingOrderID 第三方订单号
     * @param NonceStr 随机字符串
     * @param PayMoney 付款金额
     * @param PayType 支付类型
     * @param SiteUserID 收银员账号
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String QrcodePay(String DeviceID, String DeviceSecret, String DockingDeviceID, String DockingOrderID, String NonceStr, BigDecimal PayMoney,String PayType, int SiteUserID, String TimeStamp, String DockingSecret){
        //二维码收款请求地址
        String postfix = "/api/QrcodePay/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "QrcodePay";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(DockingOrderID);
        ParamList.add(NonceStr);
        ParamList.add(String.valueOf(PayMoney));
        ParamList.add(PayType);
        ParamList.add(String.valueOf(SiteUserID));
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * GetPayState：5.获取交易订单支付状态
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param NonceStr 随机字符串
     * @param OrderID 交易订单号
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String GetPayState(String DeviceID,String DeviceSecret,String DockingDeviceID,String NonceStr,String OrderID,String TimeStamp,String DockingSecret){
        //获取交易订单支付状态请求地址
        String postfix = "/api/GetPayState/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "GetPayState";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(NonceStr);
        ParamList.add(OrderID);
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * GetPayInfo：6.获取成功订单明细
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param NonceStr 随机字符串
     * @param OrderID 交易订单号
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String GetPayInfo(String DeviceID,String DeviceSecret,String DockingDeviceID,String NonceStr,String OrderID,String TimeStamp,String DockingSecret){
        //获取成功订单明细请求地址
        String postfix = "/api/GetPayInfo/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "GetPayInfo";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(NonceStr);
        ParamList.add(OrderID);
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * Refund：7.退款
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param NonceStr 随机字符串
     * @param OperatePass 退款授权密码
     * @param OrderID 交易订单号
     * @param RefundOrderID 退款订单号
     * @param Remoney 退款金额
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String Refund(String DeviceID,String DeviceSecret,String DockingDeviceID,String NonceStr,String OperatePass, String OrderID, String RefundOrderID, BigDecimal Remoney,String TimeStamp,String DockingSecret){
        //退款签名请求地址
        String postfix = "/api/Refund/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "Refund";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(NonceStr);
        ParamList.add(OperatePass);
        ParamList.add(OrderID);
        ParamList.add(RefundOrderID);
        ParamList.add(String.valueOf(Remoney));
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * TicketUse：8.卡券核销
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param NonceStr 随机字符串
     * @param PayMoney 核销金额
     * @param ScanTicketno 卡券号
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String TicketUse(String DeviceID,String DeviceSecret,String DockingDeviceID,String NonceStr,BigDecimal PayMoney,String ScanTicketno, String TimeStamp,String DockingSecret){
        //卡券核销请求地址
        String postfix = "/api/TicketUse/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "TicketUse";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(NonceStr);
        ParamList.add(String.valueOf(PayMoney));
        ParamList.add(ScanTicketno);
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * AggregateOrder：9.聚合二维码收款
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DockingOrderID 第三方订单号
     * @param NonceStr 随机字符串
     * @param PayMoney 收款金额
     * @param SiteUserID 收银员账号
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String AggregateOrder(String DeviceID,String DeviceSecret,String DockingDeviceID,String DockingOrderID,String NonceStr,BigDecimal PayMoney,int SiteUserID,String TimeStamp, String DockingSecret){
        //聚合支付请求地址
        String postfix = "/api/AggregateOrder/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "AggregateOrder";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(DockingOrderID);
        ParamList.add(NonceStr);
        ParamList.add(String.valueOf(PayMoney));
        ParamList.add(String.valueOf(SiteUserID));
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * UnifiedOrder：10.wap收款
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DockingOrderID 交易订单号
     * @param NonceStr 随机字符串
     * @param PayMoney 支付金额
     * @param PayType 支付类型
     * @param SiteUserID 收银员账号
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String UnifiedOrder(String DeviceID,String DeviceSecret,String DockingDeviceID,String DockingOrderID,String NonceStr,BigDecimal PayMoney,String PayType, int SiteUserID, String TimeStamp,String DockingSecret){
        //wap收款请求地址
        String postfix = "/api/UnifiedOrder/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "UnifiedOrder";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(DockingOrderID);
        ParamList.add(NonceStr);
        ParamList.add(String.valueOf(PayMoney));
        ParamList.add(PayType);
        ParamList.add(String.valueOf(SiteUserID));
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * CloseOrder：11.订单关闭
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param NonceStr 随机字符串
     * @param OrderID 交易订单号
     * @param SiteUserID 收银员账号
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String CloseOrder(String DeviceID,String DeviceSecret,String DockingDeviceID,String NonceStr,String OrderID, int SiteUserID,String TimeStamp,String DockingSecret){
        //订单关闭请求地址
        String postfix = "/api/CloseOrder/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "CloseOrder";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(NonceStr);
        ParamList.add(OrderID);
        ParamList.add(String.valueOf(SiteUserID));
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * UseKouBeiCard：12.口碑单品卡券核销
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param NonceStr 随机字符串
     * @param ScanTicketno 卡券号
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String UseKouBeiCard(String DeviceID,String DeviceSecret,String DockingDeviceID,String NonceStr,String ScanTicketno,String TimeStamp,String DockingSecret){
        //口碑单品卡券核销请求地址
        String postfix = "/api/UseKouBeiCard/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "UseKouBeiCard";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(NonceStr);
        ParamList.add(ScanTicketno);
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * DownloadBill：13.对账单
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param NonceStr 随机字符串
     * @param TimeStamp 时间戳
     * @param TradeDate 交易状态
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String DownloadBill(String DeviceID,String DeviceSecret,String DockingDeviceID,String NonceStr,String TimeStamp,String TradeDate,String DockingSecret){
        //请求地址
        String postfix = "/api/DownloadBill/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "DownloadBill";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(NonceStr);
        ParamList.add(TimeStamp);
        ParamList.add(TradeDate);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * AsynchronInform：14.订单异步通知
     * @param NonceStr 随机字符串
     * @param OrderID 交易订单号
     * @param OrderMoney 订单金额
     * @param OrderState 订单状态
     * @param PayTime 支付时间
     * @param PayType 支付类型
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success
     */
    public String AsynchronInform(String NonceStr,String OrderID,BigDecimal OrderMoney,String OrderState,String PayTime,String PayType,String TimeStamp,String DockingSecret){
        //请求地址
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入合作商请求地址：");
        String RequestURL = scanner.next();
        String operarion = "AsynchronInform";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(NonceStr);
        ParamList.add(OrderID);
        ParamList.add(String.valueOf(OrderMoney));
        ParamList.add(OrderState);
        ParamList.add(PayTime);
        ParamList.add(PayType);
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * AppletPay：15.小程序支付
     * @param AppID 小程序AppID
     * @param DeviceID 设备标识
     * @param DeviceSecret 设备秘钥
     * @param DockingDeviceID 对接注册设备标识开头
     * @param DockingOrderID 交易订单号
     * @param NonceStr 随机字符串
     * @param OpenID 消费者信息
     * @param PayMoney 支付金额
     * @param SiteUserID 收银员账号
     * @param TimeStamp 时间戳
     * @param DockingSecret 对接秘钥
     * @return success,Msg,ReObj
     */
    public String AppletPay(String AppID,String DeviceID,String DeviceSecret,String DockingDeviceID,String DockingOrderID,String NonceStr,String OpenID,BigDecimal PayMoney, int SiteUserID, String TimeStamp,String DockingSecret){
        //小程序支付请求地址
        String postfix = "/api/AppletPay/";
        String RequestURL = ApiDomain + postfix;
        String operarion = "AppletPay";

        LinkedList<String> ParamList = new LinkedList<>();
        ParamList.add(AppID);
        ParamList.add(DeviceID);
        ParamList.add(DeviceSecret);
        ParamList.add(DockingDeviceID);
        ParamList.add(DockingOrderID);
        ParamList.add(NonceStr);
        ParamList.add(OpenID);
        ParamList.add(String.valueOf(PayMoney));
        ParamList.add(String.valueOf(SiteUserID));
        ParamList.add(TimeStamp);

        try {
            return ResponseResult(ParamList,operarion,DockingSecret,RequestURL);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 调用接口且接收响应（公共部分）
     * @param ParamList 参数值顺序表
     * @param operarion 接口名
     * @param DockingSecret 对接秘钥
     * @param RequestURL 接口请求地址
     * @return 响应结果
     */
    public static String ResponseResult(LinkedList ParamList, String operarion, String DockingSecret, String RequestURL){
        //签名逻辑
        String stringA = stringA(ParamList,operarion);//字母序
        String sign = DataUtil.GetSign(stringA,DockingSecret);
        //请求响应
        String RequestStr =stringA +"&sign="+sign;
        String result = null;
        try {
            result = HttpProxy.HttpPost(RequestStr,RequestURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
    *以下stringA、GetkeyvalueTreemap、GetkeyList、GetvalueList四个方法，共同实现了“读取参数名-》排ASCII序-》拼接saringA”了
    * */

    /*拼接stringA*/
    public static String stringA(LinkedList<String> ParamList, String operarion){
        String stringA="";
        TreeMap<String,String> resultMap = GetkeyvalueTreemap(ParamList, operarion);

        Iterator<String> iterator =  resultMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = resultMap.get(key);
            stringA+=(key+"="+value);
            stringA+="&";
        }
        stringA = stringA.substring(0,stringA.length()-1);                     //去掉最后一个&
        return stringA;
    }

    /*获取键列（原始功能是获取方法所有参数名）*/
    public static LinkedList<String> GetkeyList(String operarion){
        Class<APIList> clazz = APIList.class;
        LinkedList<String> paramsName = new LinkedList<>();                  //用于存放参数名的顺序表
        try {
            //得到方法实体
            Method method = null;
            switch (operarion){
                case ("RegisterDevice"): method = clazz.getMethod("RegisterDevice", String.class, String.class, String.class, String.class, String.class, String.class, String.class);break;
                case ("SignInOrOut"): method = clazz.getMethod("SignInOrOut", String.class, String.class, String.class, int.class, String.class, String.class, int.class, String.class, String.class);break;
                case ("AcquirePay"): method = clazz.getMethod("AcquirePay", String.class, String.class, String.class, String.class, BigDecimal.class, String.class, int.class, String.class, String.class);break;
                case ("QrcodePay"): method = clazz.getMethod("QrcodePay", String.class, String.class, String.class, String.class, String.class, BigDecimal.class, String.class, int.class, String.class, String.class);break;
                case ("GetPayState"): method = clazz.getMethod("GetPayState", String.class, String.class, String.class, String.class, String.class, String.class, String.class);break;
                case ("GetPayInfo"): method = clazz.getMethod("GetPayInfo", String.class, String.class, String.class, String.class, String.class, String.class, String.class);break;
                case ("Refund"): method = clazz.getMethod("Refund", String.class, String.class, String.class, String.class, String.class, String.class, String.class, BigDecimal.class, String.class, String.class);break;
                case ("TicketUse"): method = clazz.getMethod("TicketUse", String.class, String.class, String.class, String.class, BigDecimal.class, String.class, String.class, String.class);break;
                case ("AggregateOrder"): method = clazz.getMethod("AggregateOrder", String.class, String.class, String.class, String.class, String.class, BigDecimal.class, int.class, String.class, String.class);break;
                case ("UnifiedOrder"): method = clazz.getMethod("UnifiedOrder", String.class, String.class, String.class, String.class, String.class, BigDecimal.class, String.class, int.class, String.class, String.class);break;
                case ("CloseOrder"): method = clazz.getMethod("CloseOrder", String.class, String.class, String.class, String.class, String.class, int.class, String.class, String.class);break;
                case ("UseKouBeiCard"): method = clazz.getMethod("UseKouBeiCard", String.class, String.class, String.class, String.class, String.class, String.class, String.class);break;
                case ("DownloadBill"): method = clazz.getMethod("DownloadBill", String.class, String.class, String.class, String.class, String.class, String.class, String.class);break;
                case ("AsynchronInform"): method = clazz.getMethod("AsynchronInform", String.class, String.class, BigDecimal.class, String.class, String.class, String.class, String.class, String.class);break;
                case ("AppletPay"): method = clazz.getMethod("AppletPay", String.class, String.class, String.class, String.class, String.class, String.class, String.class, BigDecimal.class, int.class, String.class, String.class);break;
                default: System.out.println("operation错误");break;
            }

            //得到该方法参数信息数组（参数名、参数数据类型）
            Parameter[] ParamsArray = method.getParameters();
            //遍历参数数组，依次输出参数名和参数类型
            Arrays.stream(ParamsArray).forEach(ParamElement->{
                paramsName.add(ParamElement.getName());                                          //参数名有序依次add进顺序表
            });
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        paramsName.removeLast();                                                                 //移除最后一个参数名DockingSecret
        return paramsName;
    }

    /*获取值列（这个参数数量各异，无法统一，选择在每个接口具体测试方法内实现）*/
    public static LinkedList<String> GetvalueList(LinkedList<String> ParamList){
        LinkedList<String> value = new LinkedList<>(ParamList);                                  //一开始写LinkedList<String> value = null直接报错，真是个憨憨
        return value;
    }

    /*获取键值map*/
    public static TreeMap<String, String> GetkeyvalueTreemap(LinkedList<String> ParamList, String operarion){    //AKA GetkeyvalueTreemap
        TreeMap<String, String> KeyValueTreemap= new TreeMap<>();                                               //treemap是红黑树，自带ascii排序功能                                                                                   //最终的“参数名-参数值”map
        LinkedList<String> keylist = GetkeyList(operarion);                                                                                                                    //name→email→count
        LinkedList<String> valuelist = GetvalueList(ParamList);                                                 //liangsi→soaraor@163.com→19961110
        for (int i = 0; i < keylist.size(); i++) {
            KeyValueTreemap.put(keylist.get(i),valuelist.get(i));
        }
        return KeyValueTreemap;
    }


}
