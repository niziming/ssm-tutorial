package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextValueFilter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {
    ArrayList persions = new ArrayList();

    @Before
    public void setUp() throws Exception {
        persions.add(new Student(17, "ziming"));
        persions.add(new Student(18, "xueqing"));
    }

    @Test
    public void jsonTest() {
        String s = JSON.toJSONString(persions);
        System.out.println(s);
        JSONArray objects = new JSONArray();
        for (int i = 0; i < 5; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("age", 10);
            jsonObject.put("name", "ziming");
            objects.add(jsonObject);
        }
        String s1 = objects.toJSONString();
        System.out.println(s1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("age", 12);
        jsonObject.put("name", "ziming");
        String jsonString = JSON.toJSONString(jsonObject);
        System.out.println("jsonString" + jsonString);
        Object parse = JSON.parseObject(jsonString, Student.class);
        System.out.println(parse);
        System.out.println(parse.getClass().getName());
        Object parse1 = JSON.parse(jsonString);
        System.out.println(parse1);

    }

    @Test
    public void contextValueFilterTest () {
        ContextValueFilter contextValueFilter = new ContextValueFilter() {
            @Override
            public Object process(BeanContext beanContext, Object o, String s, Object o1) {
                System.out.println(beanContext);
                System.out.println(o);
                System.out.println(s);
                System.out.println(o1);
                return null;
            }
        };
        String jsonString = JSON.toJSONString(persions, contextValueFilter);
        System.out.println(persions);
    }
}