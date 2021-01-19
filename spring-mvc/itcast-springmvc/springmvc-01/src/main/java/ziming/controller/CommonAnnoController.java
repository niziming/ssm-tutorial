package ziming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class CommonAnnoController {
    //1RequestParam
    //作用：把请求中指定名称的参数给控制器中的形参赋值。
    //属性：value：请求参数中的名称。required：请求参数中是否必须提供此参数。默认值：true。表示必须提供，如果不提供将报错。
    @RequestMapping("/useRequestParam")
    public String useRequestParam(@RequestParam("name")String username,
                                  @RequestParam(value="age",required=false)Integer age){
        System.out.println(username+","+age);
        return "success";
    }
    //2RequestBody
    // 作用：用于获取请求体内容。直接使用得到是 key=value&key=value...结构的数据。get 请求方式不适用。
    // 属性：required：是否必须有请求体。默认值是:true。当取值为 true 时,get 请求方式会报错。如果取值
    // 为 false，get 请求得到是 null。
    /**
     * RequestBody 注解
     * @param body
     * @return
     */
    @RequestMapping("/useRequestBody")
    public String useRequestBody(@RequestBody(required=false) String body){
        System.out.println(body);
        return "success";
    }
    //4.3PathVaribale
    //作用：用于绑定 url 中的占位符。例如：请求 url 中 /delete/{id}，这个{id}就是 url 占位符。
    //url 支持占位符是 spring3.0 之后加入的。是 springmvc 支持 rest 风格 URL 的一个重要标志。
    //属性：value：用于指定 url 中占位符名称。required：是否必须提供占位符。
    /**
     * @return
     */
    @RequestMapping("/usePathVariable/{id}")
    public String usePathVariable(@PathVariable("id") Integer id){
        System.out.println(id);
        return "success";
    }
}
