package cn.mldn.test;
interface Fruit{
	public void eat();
}
class Apple implements Fruit{
	@Override
	public void eat() {
		System.out.println("** ³ÔÆ»¹û£¡");
	}
}
class Orange implements Fruit{
	@Override
	public void eat() {
		System.out.println("** ³ÔéÙ×Ó£¡");
	}
}
class Factory{
	public static Fruit getInstance(String className){
		Fruit f=null;
			try {
				f=(Fruit) Class.forName(className).newInstance();
		} catch (Exception e){
			}
		return f;
	}
}
public class TestFactory {
	public static void main(String[] args) {
		Fruit f=Factory.getInstance("cn.mldn.test.Orange");
		f.eat();
	}
}
