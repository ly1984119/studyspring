package com.ly.studyspring.aop;

public class HelloWorldServiceImpl implements IHelloWorldService {

    @Override
    public void sayHello() {
        System.out.println("============Hello World!");
    }
}
