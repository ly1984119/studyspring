package com.ly.studyspring.aop;

import org.springframework.stereotype.Component;

/**
 * Created by liuyu7 on 2019/1/28.
 */
@Component("knight2")
public class BraveKnight2 {

    @MyZhuJie(value = false, btcpso = "#paramObj.id")
    public void saying(ParamObj paramObj) {
        System.out.println("我是骑士..（切点方法）" + paramObj.getName());
    }

}
