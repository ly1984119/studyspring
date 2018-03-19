package com.ly.studyspring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloApi {

	private ApplicationContext context;

	@Before
	public void initialData() {
		// 1、读取配置文件实例化一个IoC容器
		this.context = new ClassPathXmlApplicationContext("studyspring/helloworld.xml");
	}

	@Test
	public void testSayHello() {
		// 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
		HelloApi helloApi = this.context.getBean("hello", HelloApi.class);
		// 3、执行业务逻辑
		helloApi.sayHello();

		HelloImpl2 helloImpl2 = this.context.getBean("hello2", HelloImpl2.class);
		helloImpl2.sayHello();
		
		HelloApi helloApi3 = this.context.getBean("hello3", HelloApi.class);
		helloApi3.sayHello();

        HelloApi helloApi4 = this.context.getBean("hello4", HelloApi.class);
        helloApi4.sayHello();

        HelloApi helloApi5 = this.context.getBean("hello5", HelloApi.class);
        helloApi5.sayHello();
	}
}
