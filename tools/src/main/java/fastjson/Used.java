package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Used {
    public static void main(String[] args) {
        HashMap parse = (HashMap<String, String>) JSON.parse("{'key': 'value'}");
        String ziming = JSON.toJSONString(new Student(16, "ziming"));
        System.out.println();
        System.out.println(parse);
        System.out.println(ziming);

        JSONObject jsonObject = JSON.parseObject("{'key': {'keychild': {'child': 'hello'}}}");
        Map<String, Object> innerMap = jsonObject.getInnerMap();
        System.out.println(innerMap);


        //JSONObject keychild = jsonObject
        //        .getJSONObject("key")
        //        .getJSONObject("keychild");
        //keychild.put("child", "world");
        //System.out.println(keychild);
        //System.out.println(jsonObject);


        //System.out.println(jsonObject);
        //JSONObject key = (JSONObject)jsonObject.get("key");
        //System.out.println(key);
        //key.put("keychild", "change");
        //System.out.println(key);
        //System.out.println(jsonObject);

        //jsonObject.put("key", "change");
        //System.out.println(jsonObject);

        //Map<String, Object> innerMap = jsonObject.getInnerMap();
        //Object o = innerMap.get("keychild");
        //System.out.println(jsonObject);
        //System.out.println(innerMap);
        //System.out.println(o);
    }
}
