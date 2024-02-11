package com.example.demotest;

public class Main {



	public static void main(String[] args) {
		System.out.println("Start...");
		//var parent = new Parent();
		var child = new Child();
	}
}

class Parent {
	static {
		System.out.println("static parent");
	}

	{
		System.out.println("Hello Parent");
	}
}

class Child {
	static {
		System.out.println("static child");
	}

	{
		System.out.println("Hello Child");
	}
}