package ziming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
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
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello () {
        System.out.println("hello string mvc");
        return "success";
    }
    @RequestMapping (value = "/testReqMapping", params = {"username=user"}, headers = {"Accept"})
    public String testReqMapping(){
        System.out.println("测试reqmapping注解..");
        return "success";
    }
}
