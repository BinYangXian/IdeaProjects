package com.jikexueyuan.basicSyntax.main;

public class Main {

	public static void main(String[] args) {
//1+3+5+...+99=?
		int sum=0;
		for (int j = 1; j <= 99; j+=2) {
			sum+=j;
		}
		System.out.println(sum);
		
//1!+2!+...+10!=?
		long result=0;
		long f=1;
		for (int i = 1; i <= 10; i++) {
			f=f*i;
			result+=f;
		}
		System.out.println(result);
	}

}
