package cn.youyun.Utility;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sun.security.provider.MD5;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class json_test {
    public static String jsonobject(int count) {//JSONObject输出格式
        JSONObject params = new JSONObject(new LinkedHashMap<String, Object>());
        Map ReOject = new LinkedHashMap();
        ReOject.put("firsr", "c1");
        ReOject.put("second", "c2");
        ReOject.put("third", "c3");
        ReOject.put("forth", "c4");
        ReOject.put("fifth", "c5");

        try {//检验得知：所谓的引号是人为加的，不是系统加的，JSON格式只是在key:value之间加了一个“:”
            params.put("①test_count", count);
            params.put("②play_number", "7");
            params.put("③serving_club", "Juventuz");
            params.put("④country", "Portual");
            params.put("⑤age", "33");
            params.put("⑥height", "185cm");
            params.put("⑦weigth", "84kg");
            params.put("⑧aim", "champion");
            params.put("ReObject",ReOject);
            String JsonInstance = params.toString();//JSON数据string化
            return JsonInstance;
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONArray jsonarray(int count) {//JSONArray输出格式
        JSONArray array = new JSONArray();
        int temp = count;
        int num = count*0 +7;
        StringBuilder appendtest = new StringBuilder();//这里使用string构造器才能append，直接string不可以
        appendtest.append("⑧aim:");
        array.add("①test_count:"+temp);
        array.add("②play_number:"+num);
        array.add("③serving_club:"+"Juventuz");
        array.add("④country:"+"Portual");
        array.add("⑤age:"+ 33);
        array.add("⑥height:"+"185cm");
        array.add("⑦weigth:"+"84kg");
        array.add(appendtest.append("champion"));
        return array;
    }
    public static Object[] MultiType(boolean judge){
        Object[] object = new Object[6];
        object [0] = 19951029;
        object [1] = new String[] { "liangsi", "xuesui" };//元素是一个数组，所以只返回数组第一个元素的地址
        object [2] = new Date();
        object [3] = judge;
        return object;
    }

    public static JSONObject map4put(){
        JSONObject jsonob = new JSONObject(new LinkedHashMap<String, Object>());
        Map map = new LinkedHashMap();
        map.put(1,"啊");
        map.put(2,"哦");
        map.put(3,"呃");
        map.put(4,"咦");
        map.put(5,"唔");
        jsonob.put("map",map);
        return jsonob;
    }

    public static void main(String[] args) {
        System.out.println("JSONObject序列："+"\r");
        System.out.println("====="+jsonobject(1));
        System.out.println("JSONArray序列："+"\r");
        System.out.println("====="+jsonarray(1));
        System.out.println("MultiType内容：");
        //System.out.println(String.format("%s",MultiType(true)));

        for(int n=0;n<MultiType(true).length;n++){
            System.out.println(String.valueOf(MultiType(true)[n]));
        }


        System.out.println("\r"+"Object内容："+"\r");
        /**
         * Object类输出测试样例
         * */
        boolean a = true;
        Object[] object = new Object[4];
        object [0] = 1110;
        object [1] = "liangsi";
        object [2] = new Date();
        object [3] = a;

        for(int i=0;i<object.length;++i){
            System.out.print(object[i]+"\t");
        }

        System.out.println("map4put内容：");
        System.out.println(map4put());

        System.out.println("签名功能测试：");
        System.out.println(Sign.GetSign("Aaaa123","测试","Aaaa","abc","PNDSSK","1480414431","aduer"));

    }
}
