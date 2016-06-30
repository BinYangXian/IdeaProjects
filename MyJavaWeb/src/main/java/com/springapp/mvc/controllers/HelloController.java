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

@Controller //��������һ��controller
@RequestMapping("/") /*����controller�����ڵ�url��ַ*/
//���ʸ�ʽ��http://localhost��8080�����Ǹ�·����
public class HelloController {
    //1��ģ�壬������ʹ��spring mvc��
	@RequestMapping(method = RequestMethod.GET) //����get����ʽ
	public String printWelcome(ModelMap model) {  //ֻҪ���Ƿ�����վ�ĸ�Ŀ¼���÷�����ִ��
		model.addAttribute("message", "Hello world!");//ʹ��message�ܱ�jsp�ļ����ʣ��÷����¸���������ȫ��
        model.put("content","This is my first spring mvc app");//�Զ����ֵ�Ե���ӣ����ϸ��������ơ�
		return "hello"; //����ҳ��jsp�ļ�����prefix��suffix��mvc-dispatcher-servlet�����ã����û�У�����Ҫȫ���ƣ�
        //"/WEB-INF/pages/hello.jsp"��
	}

    //2�������·��������
    @RequestMapping(value = "/page/{name}/{age}",method = RequestMethod.GET) //������·���ﴫ����name��age
    // Ȼ������ʾ������
    //���ʸ�ʽ����http://localhost:8080/page/С��/1
    public String getName(ModelMap map, @PathVariable("name") String name, @PathVariable("age") int age){

        map.addAttribute("name",name);
        map.addAttribute("age",age);
        return "name";
    }
}