package cn.youyun.Utility;

import java.util.Calendar;
import java.util.Scanner;
import java.util.UUID;

public class DataUtil {
    /**
     * 由DockingDeviceID, UserStr得到DeviceID
     * @param DockingDeviceID
     * @param UserStr
     * @return DeviceID
     */
    public static String GetDeviceID(String DockingDeviceID,String UserStr){
        String DeviceID = "";
        DeviceID = DockingDeviceID + UserStr;//null拼接DockingDeviceID+用户字
        return DeviceID;
    }

    /**
     * 获取UTC时间戳
     * @return timestamp
     */
    public static String GetTimestamp(){
        String timestamp = "";
        Calendar calendar = Calendar.getInstance();
        timestamp = String.valueOf(calendar.getTimeInMillis() / 1000);// 返回UTC时间（精确到秒）
        return timestamp;
    }

    /**
     * 生成32位随机字符串
     * @return nonceStr
     */
    public static String GetNoncestr(){
        String nonceStr = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return nonceStr;
    }





    public static String GetSign(String stringA, String DockingSecret){
        String Sign = "";
        //拼接字符
        String StringSignTemp = stringA +"&"+ DockingSecret;
        StringSignTemp = StringSignTemp.toLowerCase();
        //md5加密
        Sign =MD5.MD5(StringSignTemp);
        return Sign;
    }
}
