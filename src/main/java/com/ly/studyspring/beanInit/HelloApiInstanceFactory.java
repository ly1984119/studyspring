package com.ly.studyspring.beanInit;

public class HelloApiInstanceFactory {
    public HelloApi newInstance(String message){
        return new HelloImpl2(message);
    }

}
