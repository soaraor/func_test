package cn.youyun.Utility;

import org.apache.commons.io.IOUtils;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URL;

public class Post4Pay {
    /**
     * 发送Http post请求
     * @param xmlInfo 请求参数字符串
     * @param requestURL 请求地址
     * @return 返回信息
     */
    public static String HttpPost(String xmlInfo, String requestURL) {
        System.out.println("请求参数:" + xmlInfo);
        byte[] xmlData = xmlInfo.getBytes();
        InputStream inputStream = null;
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            URL url = new URL(requestURL);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestProperty("content-Type", "application/x-www-form-urlencoded");
            urlConnection.setRequestProperty("charset", "utf-8");
            urlConnection.setRequestProperty("Content-length", String.valueOf(xmlData.length));
            System.out.println("请求参数长度：" + String.valueOf(xmlData.length));
            DataOutputStream printout = new DataOutputStream(urlConnection.getOutputStream());
            printout.write(xmlData);
            printout.flush();
            printout.close();

            inputStream = urlConnection.getInputStream();
            byte[] byteIS = IOUtils.toByteArray(inputStream);
            String ResponseString = new String(byteIS, "UTF-8");
            if ((ResponseString == null) || ("".equals(ResponseString.trim()))) {
                System.out.println("= = = = =返回结果为空= = = = =");
            }
            else System.out.println("响应参数："+ ResponseString);
            return ResponseString;
        } catch (Exception e) {
            e.printStackTrace();
            return "【接口请求抛出错误】";
        } finally {
            try {
                inputStream.close();
            }catch (Exception e1) {
                e1.printStackTrace();
            }
            /**
            try {
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
             */
        }
    }
}
