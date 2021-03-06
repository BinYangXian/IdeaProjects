package cn.mldn.demo;

import java.lang.reflect.Field;

public class TestDemo {
	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("cn.mldn.po.Book");
		Object obj = cls.newInstance(); // 必须给出实例化对象
		Field titleField = cls.getDeclaredField("title");
		titleField.setAccessible(true);//封装取消了
		titleField.set(obj, "Java开发");// 等价于：Book类对象.title="Java开发";
		System.out.println(titleField.get(obj));// 等价于：Book类对象.title
	}
}