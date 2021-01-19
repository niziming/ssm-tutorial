package ziming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import ziming.domain.User;

@Controller
@RequestMapping
public class RestfulController {
    //什么是 rest：
    //REST（英文：Representational State Transfer，简称 REST）描述了一个架构样式的网络系统，
    //比如 web 应用程序。它首次出现在 2000 年 Roy Fielding 的博士论文中，他是 HTTP 规范的主要编写者之
    //一。在目前主流的三种 Web 服务交互方案中，REST 相比于 SOAP（Simple Object Access protocol，简单
    //对象访问协议）以及 XML-RPC 更加简单明了，无论是对 URL 的处理还是对 Payload 的编码，REST 都倾向于用更
    //加简单轻量的方法设计和实现。值得注意的是 REST 并没有一个明确的标准，而更像是一种设计的风格。
    //它本身并没有什么实用性，其核心价值在于如何设计出符合 REST 风格的网络接口。
    //restful 的优点
    //它结构清晰、符合标准、易于理解、扩展方便，所以正得到越来越多网站的采用。
    //restful 的特性：
    //资源（Resources）：网络上的一个实体，或者说是网络上的一个具体信息。
    //它可以是一段文本、一张图片、一首歌曲、一种服务，总之就是一个具体的存在。可以用一个 URI（统一
    //资源定位符）指向它，每种资源对应一个特定的 URI 。要
    //获取这个资源，访问它的 URI 就可以，因此 URI 即为每一个资源的独一无二的识别符。
    //表现层（Representation）：把资源具体呈现出来的形式，叫做它的表现层 （Representation）。
    //比如，文本可以用 txt 格式表现，也可以用 HTML 格式、XML 格式、JSON 格式表现，甚至可以采用二
    //进制格式。
    //状态转化（State Transfer）：每 发出一个请求，就代表了客户端和服务器的一次交互过程。
    //HTTP 协议，是一个无状态协议，即所有的状态都保存在服务器端。因此，如果客户端想要操作服务器，
    //必须通过某种手段，让服务器端发生“状态转化”（State Transfer）。而这种转化是建立在表现层之上的，所以
    //就是 “表现层状态转化”。具体说，就是 HTTP 协议里面，四个表示操作方式的动词：GET 、POST 、PUT、
    //DELETE。它们分别对应四种基本操作：GET 用来获取资源，POST 用来新建资源，PUT 用来更新资源，DELETE 用来
    //删除资源。
    //    restful 的示例：
    //            /account/1 HTTP GET ： 得到 id = 1 的 account
    ///account/1 HTTP DELETE： 删除 id = 1 的 account
    ///account/1 HTTP PUT： 更新 id = 1 的 account
    ///account HTTP POST： 新增 account
    //基于 HiddentHttpMethodFilter 的示例
    //由于浏览器 form 表单只支持 GET 与 POST 请求，而 DELETE、PUT 等 method 并不支持，Spring3.0 添
    //加了一个过滤器，可以将浏览器请求改为指定的请求方式，发送给我们的控制器方法，使得支持 GET、POST、PUT
    //与 DELETE 请求。
    //4.4RequestHeader
    @RequestMapping("/useRequestHeader")
    public String useRequestHeader(@RequestHeader(value="Accept-Language", required=false)String requestHeader){
        System.out.println(requestHeader);
        return "success";
    }
    //4.5CookieValue
    //作用： 用于把指定 cookie 名称的值传入控制器方法参数。
    //属性：
    //value：指定 cookie 的名称。
    //required：是否必须有此 cookie。
    @RequestMapping("/useCookieValue")
    public String useCookieValue(@CookieValue(value="JSESSIONID",required=false)
                                         String cookieValue){
        System.out.println(cookieValue);
        return "success";
    }
    //6ModelAttribute
    //作用：该注解是 SpringMVC4.3 版本以后新加入的。它可以用于修饰方法和参数。
    //出现在方法上，表示当前方法会在控制器的方法执行之前，先执行。它可以修饰没有返回值的方法，也可
    //以修饰有具体返回值的方法。
    //出现在参数上，获取指定的数据给参数赋值。
    //属性：value：用于获取数据的 key。key 可以是 POJO 的属性名称，也可以是 map 结构的 key。
    //应用场景：
    //当表单提交数据不是完整的实体类数据时，保证没有提交数据的字段使用数据库对象原来的数据。
    //例如：
    //我们在编辑一个用户时，用户有一个创建信息字段，该字段的值是不允许被修改的。在提交表单数
    //据是肯定没有此字段的内容，一旦更新会把该字段内容置为 null，此时就可以使用此注解解决问题。
    /**
     * 被 ModelAttribute 修饰的方法
     * @param user
     */
    @ModelAttribute
    public void showModel(User user) {
        System.out.println("执行了 showModel 方法"+user.getUname());
    }

}
