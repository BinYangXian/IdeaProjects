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
        Session session= DbConnection.getSession();//��ȡ��session
       //��ѯ���е��û���
        List<UsersEntity> list = session.createCriteria(UsersEntity.class).addOrder(Order.desc("id")).list();//��
        // ��id�н��з������У��˴���"id"��UserEntity�е�long id����"id"����Ϊ����Ϊ��������
        // ��UserEntity��long id�Ƕ�Ӧ�����ݿ��е�id��

        map.addAttribute("users",list);//ͨ��map��jsp�ļ�����
        session.close();
        return "users";
    }

    //4��ʹ��SpringMVC�ṩ�ı���ǩ����HTML
    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
    //���ʸ�ʽ����http://localhost:8080/adduser
    public String addUser(ModelMap map){ //��������ύ����ҳ�棬�������������������������Ϊ���������������ĳ�ʼֵ֮��
        User u=new User();
        u.setName("jikexueyuan");

        map.addAttribute("user",u);//������add_user�е�modelAttribute��Ӧ����ͬ������u�����ݴ��ݸ�jsp��Ϊ����ʼֵ��

        return "add_user";
    }

    //3��ʹ��SpringMVC���պʹ���URL����(��ͬʱ�÷���Ҳ�Ǳ��ύ������ ���ܺʹ���ʽ�����ַ�ʽ�õ���jsp��Ⱦ���һ��)��
    @RequestMapping(value = "/result",method = RequestMethod.GET)
    //����URL�������ʸ�ʽ����http://localhost:8080/result��name=С��&age=20
    //���ύ���ʸ�ʽ��http://localhost:8080/adduser
     /*����1.��ģ���ļ���ͨ�Ĳ�����ʹ���������������õ�������ģ���ļ�����ֱ�ӷ��ʵ�������2/3 ����·������*/
    public String result(ModelMap map,@RequestParam String name,@RequestParam int age
            ,HttpServletRequest request,HttpServletResponse response){//�÷��ɽ����û�������,Ҳ��ͨ��response������Ӧ
        map.addAttribute("name",name);
        map.addAttribute("age",age);
//�������ݵ���������sql���ݿ⣬���������� map �У�
        Session session = DbConnection.getSession();
        Transaction transaction = session.beginTransaction();

        UsersEntity ue=new UsersEntity();
        ue.setName(name);
        ue.setAge((byte)age);//��Ϊ�����ݿ����������õ�age������ΪtinyIntҲ����byte��byte����ȡֵ��Χ0-255��
        session.save(ue);//����

        transaction.commit();//�ύ�����ݿ�

        session.close();
    /*  �˷���̫�ã����Ը���jsp�н�����ת����ζ�ţ���jsp��Ҳ���Է��ʵ�response��
      try {
            response.sendRedirect("users");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return "result";
    }
}
