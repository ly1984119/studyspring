package com.ly.studyspring;

public class HelloApiInstanceFactory {
    public HelloApi newInstance(String message){
        return new HelloImpl2(message);
    }

}
