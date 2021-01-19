package ziming.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ziming.domain.Account;

import java.util.Date;
import java.util.Map;

/**
 * @RequestMapping 这个注释的作用
 * 类上：请求 URL 的第一级访问目录。
 * 方法上：请求 URL 的第二级访问目录。
 * value：用于指定请求的 URL。它和 path 属性的作用是一样的。
 * method：用于指定请求的方式。
 * params：用于指定限制请求参数的条件。它支持简单的表达式。要求请求参数的 key 和 value 必须和
 * 配置的一模一样。
 * params = {"accountName"}，表示请求参数必须有 accountName
 * params = {"moeny!100"}，表示请求参数中 money 不能是 100。
 * 以上四个属性只要出现 2 个或以上时，他们的关系是与的关系。
 */
//@RestController
@Controller
@RequestMapping
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello () {
        System.out.println("hello string mvc");
        return "success";
    }
    /**
     * 查询账户
     * @return
     */
    @RequestMapping("/findAccount")
    public String findAccount(Integer accountId,String accountName) {
        System.out.println("查询了账户。。。"+accountId+","+accountName);
        return "success";
    }
    @RequestMapping(value = "/account/saveAccount", method = RequestMethod.POST)
    public String saveAccount(Account account) {
        System.out.println("保存了账户。。。。"+account);
        return "success";
    }
    @RequestMapping("/deleteAccount")
    public String deleteAccount(Date date) {
        System.out.println("删除了账户。。。。"+date);
        return "success";
    }
    /**
     * 删除账户
     * @return
     */
    @RequestMapping(value="/removeAccount",params= {"accountName","money>100"})
    public String removeAccount() {
        System.out.println("删除了账户");
        return "success";
    }
    @RequestMapping("/account/find")
    public String accountFind () {
        System.out.println("查询用户");
        return "success";
    }
    @RequestMapping("/test")
    public String test () {
        System.out.println("hello string mvc");
        return "success";
    }
    /**
     * 保存账户
     * @return
     */
    @RequestMapping(value="/saveAccount",method= RequestMethod.POST)
    public String saveAccount() {
        System.out.println("保存了账户");
        return "success";
    }
    @RequestMapping (value = "/testReqMapping", params = {"username=user"}, headers = {"Accept"})
    public String testReqMapping(){
        System.out.println("测试reqmapping注解...");
        return "success";
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:3000/users", String.class);
        String body = forEntity.getBody();
        Object jsonObject = JSONObject.parse(body);
        String s = JSON.toJSONString(jsonObject);
        JSONArray jsonObject1 = JSON.parseArray(s);
        //JSONArray objects = JSON.parseArray(body);
        //Object[] objects1 = objects.stream().toArray();
        System.out.println(jsonObject1);
    }
}
