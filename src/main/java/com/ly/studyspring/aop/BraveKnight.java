package com.ly.studyspring.aop;

import org.springframework.stereotype.Component;

/**
 * Created by liuyu7 on 2019/1/28.
 */
@Component("knight")
public class BraveKnight {

    @MyZhuJie
    public void saying(String value) {
        System.out.println("我是骑士..（切点方法）" + value);
    }
}
