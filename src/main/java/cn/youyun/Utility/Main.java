package cn.youyun.Utility;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {//本部分实现了所有开放接口的请求与响应
    public static void main(String[] args) {
        String domain = "http://test.api.docking.aduer.com";//接口请求域
        APIList ApiInstance = new APIList(domain);

        Scanner scanner = new Scanner(System.in);//定义键盘读取器

        //读入DockingDeviceID
        String DockingDeviceID = "1aduer";
        //System.out.println("请输入对接注册设备标识开头DockingDeviceID（回车键结束）：");
        //String DockingDeviceID = scanner.next();

        //获取DeviceID
        String UserStr ="1000000001";
        //System.out.println("请在下一行输入自定义字段UserStr（回车键结束）：");
        //String UserStr = scanner.next();
        String DeviceID = DataUtil.GetDeviceID(DockingDeviceID,UserStr);

        //读入DeviceName
        String DeviceName ="santos";
        //System.out.println("请输入设备名称DeviceName（回车键结束）：");
        //String DeviceName = scanner.next();

        //读入GUID
        String GUID = "kveb7WKHct";
        //System.out.println("请输入商家唯一标识GUID（回车键结束）：");
        //String GUID = scanner.next();

        //获取nonceStr
        String nonceStr = DataUtil.GetNoncestr();

        //获取时间戳
        String timestamp = DataUtil.GetTimestamp();

        //读入对接秘钥
        String DockingSecret = "753951";
        //System.out.println("请输入对接秘钥DockingSecret（回车键结束）：");
        //String DockingSecret = scanner.next();

        System.out.println("= = = = = = = = = = == = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = 全 = = 局 = = 变 = = 量 = = 输 = = 入 = = 结 = = 束 = = = = = = = = = = == = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");

        //设备注册
        String HasRigisterOrNot = "";


        //测试web api接口
        System.out.println("接口选项：1.设备注册；2.签到/签退；3.扫码收款；4.二维码收款；5.获取交易订单支付状态；6.获取成功订单明细；7.退款；8.卡券核销；9.聚合二维码收款；10.wap收款；11.订单关闭；12.口碑单品卡券核销；13.对账单；14.订单异步通知");
        System.out.println("请选择要的测试的接口序号（回车键结束）：");
        int UserAction = scanner.nextInt();
        switch (UserAction){
            case (1):
                //调用设备注册接口
                ApiInstance.RegisterDevice(DeviceID,DeviceName,DockingDeviceID,GUID,nonceStr,timestamp,DockingSecret);
                System.out.println("提示：请妥善备份设备注册返回的参数devicesecret，后续接口需其参与。");break;
            case (2):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                // 登录账号SiteUserID
                System.out.println("请输入收银员账号SiteUserID（回车键结束）");
                int SiteUserID = scanner.nextInt();
                //登陆密码SitePwd
                System.out.println("请输入收银员账号SitePwd（回车键结束）");
                String SitePwd = scanner.next();
                //操作类型LogID
                System.out.println("请输入操作：0-签到；具体LogID-签退（回车键结束）");
                int LogID = scanner.nextInt();
                //调用签到/签退接口
                ApiInstance.SignInOrOut(DeviceID,devicesecret,SiteUserID,SitePwd,LogID,DockingDeviceID,timestamp,nonceStr,DockingSecret);break;
            }
            case (3):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                // 登录账号SiteUserID
                System.out.println("请输入收银员账号SiteUserID（回车键结束）");
                String SiteUserID = scanner.next();
                //收款金额PayMoney
                System.out.println("请输入收款金额PayMoney（回车键结束）");
                BigDecimal PayMoney = scanner.nextBigDecimal();
                //扫描的付款码ScanpayNo（18位）
                System.out.println("请输入付款码ScanpayNo（回车键结束）");
                String ScanpayNo = scanner.next();
                //调用扫码收款接口
                ApiInstance.AcquirePay(DeviceID,devicesecret,DockingDeviceID,nonceStr,PayMoney,ScanpayNo,SiteUserID,timestamp,DockingSecret);break;
            }
            case (4):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                // 登录账号SiteUserID
                System.out.println("请输入收银员账号SiteUserID（回车键结束）");
                int SiteUserID = scanner.nextInt();
                //收款金额PayMoney
                System.out.println("请输入收款金额PayMoney（回车键结束）");
                BigDecimal PayMoney = scanner.nextBigDecimal();
                //支付类型PayType
                System.out.println("请输入支付类型PayType：1.微信支付；2.支付宝；3.百度支付（回车键结束）");
                String PayType = scanner.next();
                //第三方订单号DockingOrderID
                System.out.println("请输入第三方订单号DockingOrderID（回车键结束）");
                String DockingOrderID = scanner.next();
                //调用二维码收款接口
                ApiInstance.QrcodePay(DeviceID,devicesecret,DockingDeviceID,nonceStr,PayMoney,PayType,DockingOrderID,SiteUserID,timestamp,DockingSecret);break;
            }
            case (5):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                //交易订单号OrderID
                System.out.println("请输入交易订单号OrderID（回车键结束）");
                String OrderID = scanner.next();
                //调用获取交易订单支付状态接口
                ApiInstance.GetPayState(DockingDeviceID,DeviceID,devicesecret,OrderID,timestamp,nonceStr,DockingSecret);break;
            }
            case (6):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                //交易订单号OrderID
                System.out.println("请输入交易订单号OrderID（回车键结束）");
                String OrderID = scanner.next();
                //调用获取成功订单明细接口
                ApiInstance.GetPayInfo(DockingDeviceID,DeviceID,devicesecret,OrderID,timestamp,nonceStr,DockingSecret);break;
            }
            case (7):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                //交易订单号OrderID
                System.out.println("请输入交易订单号OrderID（回车键结束）");
                String OrderID = scanner.next();
                //退款订单号RefundOrderID
                System.out.println("请输入退款订单号RefundOrderID（回车键结束）");
                String RefundOrderID = scanner.next();
                //退款金额Remoney
                System.out.println("请输入退款金额Remoney（回车键结束）");
                BigDecimal Remoney = scanner.nextBigDecimal();
                //退款授权密码Operatepass
                System.out.println("请输入退款授权密码Operatepass（回车键结束）");
                String Operatepass = scanner.next();
                //调用退款接口
                ApiInstance.Refund(DockingDeviceID,DeviceID,devicesecret,OrderID,timestamp,nonceStr,DockingSecret,RefundOrderID,Remoney,Operatepass);break;
            }
            case (8):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                //卡券号Scanticketno
                System.out.println("请输入卡券号Scanticketno（回车键结束）");
                String Scanticketno = scanner.next();
                //核销金额Paymoney
                System.out.println("请输入核销金额Paymoney（回车键结束）");
                BigDecimal Discount = scanner.nextBigDecimal();
                //调用卡券核销接口
                ApiInstance.TicketUse(DockingDeviceID,DeviceID,devicesecret,timestamp,nonceStr,Scanticketno,Discount,DockingSecret);break;
            }
            case (9):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                // 登录账号SiteUserID
                System.out.println("请输入收银员账号SiteUserID（回车键结束）");
                int SiteUserID = scanner.nextInt();
                //收款金额PayMoney
                System.out.println("请输入收款金额PayMoney（回车键结束）");
                BigDecimal PayMoney = scanner.nextBigDecimal();
                //第三方订单号DockingOrderID
                System.out.println("请输入第三方订单号DockingOrderID（回车键结束）");
                String DockingOrderID = scanner.next();
                //调用聚合支付接口
                ApiInstance.AggregateOrder(DockingDeviceID,DeviceID,devicesecret,timestamp,nonceStr,DockingOrderID,SiteUserID,PayMoney,DockingSecret);break;
            }
            case (10):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                // 登录账号SiteUserID
                System.out.println("请输入收银员账号SiteUserID（回车键结束）");
                int SiteUserID = scanner.nextInt();
                //收款金额PayMoney
                System.out.println("请输入收款金额PayMoney（回车键结束）");
                BigDecimal PayMoney = scanner.nextBigDecimal();
                //第三方订单号DockingOrderID
                System.out.println("请输入第三方订单号DockingOrderID（回车键结束）");
                String DockingOrderID = scanner.next();
                //支付类型PayType
                System.out.println("请输入支付类型PayType：wx-微信支付；ali-支付宝（回车键结束）");
                String PayType = scanner.next();

                //调用wap支付接口
                ApiInstance.UnifiedOrder(DockingDeviceID,DeviceID,devicesecret,timestamp,nonceStr,DockingOrderID,SiteUserID,PayType,PayMoney,DockingSecret);break;
            }
            case (11):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                // 登录账号SiteUserID
                System.out.println("请输入收银员账号SiteUserID（回车键结束）");
                int SiteUserID = scanner.nextInt();
                //交易订单号OrderID
                System.out.println("请输入交易订单号OrderID（回车键结束）");
                String OrderID = scanner.next();
                //调用订单关闭接口
                ApiInstance.CloseOrder(DockingDeviceID,DeviceID,devicesecret,timestamp,nonceStr, OrderID,SiteUserID,DockingSecret);break;
            }
            case (12):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                //卡券号Scanticketno
                System.out.println("请输入卡券号Scanticketno（回车键结束）");
                String Scanticketno = scanner.next();
                //调用口碑单品卡券核销接口
                ApiInstance.UseKouBeiCard(DockingDeviceID,DeviceID,devicesecret,timestamp,nonceStr,Scanticketno,DockingSecret);break;
            }
            case (13):{
                //设备秘钥devicesecret
                System.out.println("请输入设备注册返回的参数devicesecret（回车键结束）");
                String devicesecret = scanner.next();
                //交易日期TradeDate
                System.out.println("请输入交易日期TradeDate，形如20180726（回车键结束）");
                String TradeDate = scanner.next();
                //调用对账单接口
                ApiInstance.DownloadBill(DockingDeviceID,DeviceID,devicesecret,timestamp,nonceStr,TradeDate,DockingSecret);break;
            }

            default: System.out.println("您输入接口选项不存在，请重新确认后输入");break;
        }

        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = == = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");

    }
}
