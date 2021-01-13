package fastjson;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class Used {
    public static void main(String[] args) {
        HashMap parse = (HashMap<String, String>) JSON.parse("{'key': 'value'}");
        String ziming = JSON.toJSONString(new Student(16, "ziming"));
        System.out.println();
        System.out.println(parse);
        System.out.println(ziming);
    }
}
