package cn.youyun.Utility;

import java.util.Calendar;
import java.util.Scanner;

public class DataUtil {
    /**
     * 由DockingDeviceID得到DeviceID
     * @param DockingDeviceID
     * @return DeviceID
     */
    public static String GetDeviceID(String DockingDeviceID){
        String DeviceID = "";
        DeviceID+=DockingDeviceID;//null拼接DockingDeviceID
        System.out.println("请在下一行输入自定义字段（回车键结束）：");
        Scanner scanner = new Scanner(System.in);
        DeviceID+=(scanner.next());//读入用户字段并连接到DockingDeviceID尾部
        return DeviceID;
    }

    public static String GetTimestamp(){
        String timestamp = "";
        Calendar calendar = Calendar.getInstance();
        timestamp = String.valueOf(calendar.getTimeInMillis() / 1000);// 返回UTC时间（精确到秒）
        return timestamp;
    }






    /**
     * 对输入的参数做出反应，返回MD5处理的签名字符串
     * @param DeviceID 设备标识
     * @param DeviceName 设备名称
     * @param DockingDeviceID 对接注册设备标识开头
     * @param GUID 商家唯一标识
     * @param nouceStr 随机字符串
     * @param timeStamp 时间戳
     * @param DockingSecret 设备密钥
     * @return
     */
    public static String GetSign(String DeviceID,String DeviceName,String DockingDeviceID,String GUID,String nouceStr,String timeStamp,String DockingSecret){
        //最终用以保存签名结果的字符串
        String Sign = "";
        String stringA = "DeviceID="+DeviceID+"&DeviceName="+DeviceName+"&DockingDeviceID="+DockingDeviceID+"&GUID="+GUID+"&nonceStr="+nouceStr+"&timeStamp="+timeStamp;
        //拼接字符
        String StringSignTemp = stringA +"&"+ DockingSecret;
        //字符内容全部转为小写
        StringSignTemp = StringSignTemp.toLowerCase();
        //md5加密
        Sign =MD5.MD5(StringSignTemp);
        return Sign;
    }
}
