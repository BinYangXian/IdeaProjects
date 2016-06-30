package com.springapp.mvc.controllers;

import com.springapp.mvc.User;
import com.sun.prism.impl.paint.PaintUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller //申明这是一个controller
@RequestMapping("/") /*配置controller的所在的url地址*/
//访问格式：http://localhost：8080（就是根路径）
public class HelloController {
    //1、模板，创建和使用spring mvc：
	@RequestMapping(method = RequestMethod.GET) //配置get请求方式
	public String printWelcome(ModelMap model) {  //只要我们访问网站的根目录，该方法就执行
		model.addAttribute("message", "Hello world!");//使得message能被jsp文件访问；该法较下个方法更安全。
        model.put("content","This is my first spring mvc app");//自定义键值对的添加，与上个方法类似。
		return "hello"; //返回页面jsp文件名，prefix与suffix在mvc-dispatcher-servlet中配置，如果没有，则需要全名称：
        //"/WEB-INF/pages/hello.jsp"。
	}

    //2、神奇的路径参数：
    @RequestMapping(value = "/page/{name}/{age}",method = RequestMethod.GET) //从请求路径里传进来name与age
    // 然后再显示出来。
    //访问格式例：http://localhost:8080/page/小明/1
    public String getName(ModelMap map, @PathVariable("name") String name, @PathVariable("age") int age){

        map.addAttribute("name",name);
        map.addAttribute("age",age);
        return "name";
    }
}