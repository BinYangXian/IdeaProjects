package com.jikexueyuan.javaweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fangc on 2016/5/7.
 */
@Controller
public class MainController {
@RequestMapping(value = "main.form",method = RequestMethod.GET)
    public String mainPage(ModelMap map, HttpServletRequest request, HttpServletResponse response){
    //可添加传统的servlet的HttpServletRequest等,只是这项目里在没有添加tomcat的支持类库时，没有代码提示，
    // 但是仍然能正常编译；当然也可以open model setting 手动添加tomcat 的lib。

    map.addAttribute("title","我的网站");

    try {
        response.sendRedirect("http://baidu.com");//在response提交之后无法创建session，所在main.jsp
        //中取消自动创建。
    } catch (IOException e) {
        e.printStackTrace();
    }

    return "main";
    }
}
