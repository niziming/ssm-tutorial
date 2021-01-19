package resttemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class used {
    public static void main(String[] args) {
        //RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:3000/users", String.class);
        //String body = forEntity.getBody();
        //Object jsonObject = JSONObject.parse(body);
        //String s = JSON.toJSONString(jsonObject);
        //JSONArray jsonObject1 = JSON.parseArray(s);
        ////JSONArray objects = JSON.parseArray(body);
        ////Object[] objects1 = objects.stream().toArray();
        //System.out.println(jsonObject1);
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        String user = "{'firstname':'ziming','lastname':'111','status':'231'}";

        JSONObject jsonObject = JSON.parseObject(user);
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObject.toString(), headers);
        //Map<String, Object> innerMap = jsonObject.getInnerMap();

        System.out.println(jsonObject);

        ResponseEntity<String> re = restTemplate.postForEntity(
                "http://localhost:3000/users",
                formEntity,
                String.class);
        System.out.println(re);

        //ResponseEntity<String> forEntity = restTemplate
        //        .getForEntity("http://localhost:3000/users", String.class);
        //String body = forEntity.getBody();
        //System.out.println(body);
    }
}
