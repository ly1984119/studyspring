package com.ly.studyspring;

import com.ly.studyspring.aop.BraveKnight;
import com.ly.studyspring.aop.BraveKnight2;
import com.ly.studyspring.aop.ParamObj;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuyu7 on 2019/1/28.
 */
public class TestAOP {

    private ApplicationContext context;

    @Before
    public void initialData() {
        // 1、读取配置文件实例化一个IoC容器
        this.context = new ClassPathXmlApplicationContext("studyspring/aop.xml");
    }

    @Test
    public void testSayHello() {
        BraveKnight br = (BraveKnight) context.getBean("knight");
        ParamObj paramObj = new ParamObj("123456","haduka");
//        br.saying2(paramObj);
        br.saying3("test2222");

//        BraveKnight2 br2 = (BraveKnight2) context.getBean("knight2");
//        paramObj.setId("654321");
//        paramObj.setName("jkiuyh");
//        br2.saying(paramObj);
    }
}
