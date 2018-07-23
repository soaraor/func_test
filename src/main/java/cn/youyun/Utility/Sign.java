package cn.youyun.Utility;

public class Sign {
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
        String Sign = "";//最终用以保存签名结果的字符串
        String stringA = "DeviceID="+DeviceID+"&DeviceName="+DeviceName+"&DockingDeviceID="+DockingDeviceID+"&GUID="+GUID+"&nonceStr="+nouceStr+"&timeStamp="+timeStamp;
        String StringSignTemp = stringA +"&"+ DockingSecret;//拼接字符
        StringSignTemp = StringSignTemp.toLowerCase();//全部转为小写
        Sign =MD5.MD5(StringSignTemp);
        return Sign;
    }
}
