package com.ly.studyspring.beanInit;

public class HelloApiStaticFactory {
	
	// 工厂方法
	public static HelloApi newInstance(String message){
		return new HelloImpl2(message);
	}

}
