package com.springapp.mvc;

/**
 * Created by fangc on 2016/5/5.
 */
public class User {//这里就用此类，如果取值对象是数据库也类似

    private String name="jkxy";
    private int age=20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//操，下述两个方法是必须的，否则访问出现错误，
// adduser.jsp文件中的modelAttribute="user"会自动调用该类中的getAge与getName方法取得各值。
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
