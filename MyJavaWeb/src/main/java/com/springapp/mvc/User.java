package com.springapp.mvc;

/**
 * Created by fangc on 2016/5/5.
 */
public class User {//������ô��࣬���ȡֵ���������ݿ�Ҳ����

    private String name="jkxy";
    private int age=20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//�٣��������������Ǳ���ģ�������ʳ��ִ���
// adduser.jsp�ļ��е�modelAttribute="user"���Զ����ø����е�getAge��getName����ȡ�ø�ֵ��
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
