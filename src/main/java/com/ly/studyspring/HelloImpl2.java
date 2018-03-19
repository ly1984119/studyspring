package com.ly.studyspring;

public class HelloImpl2 implements HelloApi {

	private String message;

	public HelloImpl2() {
		this.message = "Hello world!";
	}

	public HelloImpl2(String message) {
		this.message = message;
	}

	public void sayHello() {
		System.out.println(this.message);
	}

}
