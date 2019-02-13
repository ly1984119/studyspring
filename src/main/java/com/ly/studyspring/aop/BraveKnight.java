package com.ly.studyspring.aop;

import org.springframework.stereotype.Component;

/**
 * Created by liuyu7 on 2019/1/28.
 */
@Component("knight")
public class BraveKnight {

    @MyZhuJie(value = false, btcpso = "#paramObj.id")
    public void saying(ParamObj paramObj) {
        System.out.println("我是骑士..（切点方法）" + paramObj.getName());
    }

    @MyZhuJie(value = false, btcpso = "#paramObj.id")
    public void saying2(ParamObj paramObj) {
        System.out.println("我是骑士..（切点方法）" + paramObj.getName());
    }

    @MyZhuJie(value = false)
    public void saying3(String str){
        System.out.println( "我是骑士..（切点方法）" + str);
    }
}
