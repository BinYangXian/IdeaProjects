package com.springapp.mvc.controllers;

import com.springapp.mvc.User;
import com.springapp.mvc.db.DbConnection;
import com.springapp.mvc.db.entities.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by fangc on 2016/5/6.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String listUsers(ModelMap map){
        Session session= DbConnection.getSession();//获取到session
       //查询所有的用户：
        List<UsersEntity> list = session.createCriteria(UsersEntity.class).addOrder(Order.desc("id")).list();//根
        // 据id列进行反序排列，此处的"id"是UserEntity中的long id（该"id"可以为命名为别名）；
        // 而UserEntity中long id是对应于数据库中的id。

        map.addAttribute("users",list);//通过map与jsp文件连接
        session.close();
        return "users";
    }

    //4、使用SpringMVC提供的表单标签生成HTML
    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
    //访问格式例：http://localhost:8080/adduser
    public String addUser(ModelMap map){ //如果仅是提交表单的页面，无需其余参数与下述方法，因为下述方法是填充表单的初始值之法
        User u=new User();
        u.setName("jikexueyuan");

        map.addAttribute("user",u);//参数与add_user中的modelAttribute对应（相同），将u中数据传递给jsp作为表单初始值。

        return "add_user";
    }

    //3、使用SpringMVC接收和处理URL参数(！同时该方法也是表单提交参数的 接受和处理方式；两种方式得到的jsp渲染结果一样)：
    @RequestMapping(value = "/result",method = RequestMethod.GET)
    //接受URL参数访问格式例：http://localhost:8080/result？name=小明&age=20
    //表单提交访问格式：http://localhost:8080/adduser
     /*参数1.与模板文件沟通的参数，使得我们在这里配置的属性在模板文件里能直接访问到。参数2/3 接受路径参数*/
    public String result(ModelMap map,@RequestParam String name,@RequestParam int age
            ,HttpServletRequest request,HttpServletResponse response){//该法可接收用户的数据,也可通过response做出回应
        map.addAttribute("name",name);
        map.addAttribute("age",age);
//保存数据到服务器的sql数据库，而不仅仅在 map 中：
        Session session = DbConnection.getSession();
        Transaction transaction = session.beginTransaction();

        UsersEntity ue=new UsersEntity();
        ue.setName(name);
        ue.setAge((byte)age);//因为在数据库中我们设置的age的类型为tinyInt也就是byte（byte类型取值范围0-255）
        session.save(ue);//保存

        transaction.commit();//提交到数据库

        session.close();
    /*  此法不太好，所以改在jsp中进行跳转，意味着，在jsp中也可以访问到response。
      try {
            response.sendRedirect("users");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return "result";
    }
}
