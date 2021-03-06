package com.ly.studyspring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 注解方式声明aop
 * 1.用@Aspect注解将类声明为切面(如果用@Component("")注解注释为一个bean对象，那么就要在spring配置文件中开启注解扫描，<context:component-scan base-package="com.cjh.aop2"/>
 * 否则要在spring配置文件中声明一个bean对象)
 * 2.在切面需要实现相应方法的前面加上相应的注释，也就是通知类型。
 * 3.此处有环绕通知，环绕通知方法一定要有ProceedingJoinPoint类型的参数传入，然后执行对应的proceed()方法，环绕才能实现。
 */
@Component("annotationTest")
@Aspect
public class AnnotationAOP {

    //定义切点
//    @Pointcut("execution(* *.saying(..))")
    @Pointcut("execution(* com.ly.studyspring.aop.*.*(..))")
    public void sayings() {
    }

    /**
     * 前置通知(注解中的sayings()方法，其实就是上面定义pointcut切点注解所修饰的方法名，那只是个代理对象,不需要写具体方法，
     * 相当于xml声明切面的id名，如下，相当于id="embark",用于供其他通知类型引用)
     * <aop:config>
     * <aop:aspect ref="mistrel">
     * <!-- 定义切点 -->
     * <aop:pointcut expression="execution(* *.saying(..))" id="embark"/>
     * <!-- 声明前置通知 (在切点方法被执行前调用) -->
     * <aop:before method="beforSay" pointcut-ref="embark"/>
     * <!-- 声明后置通知 (在切点方法被执行后调用) -->
     * <aop:after method="afterSay" pointcut-ref="embark"/>
     * </aop:aspect>
     * </aop:config>
     */
    @Before("sayings()")
    public void sayHello(JoinPoint joinPoint) {
        System.out.println("AOP拦截前。。。。");
//        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
//        System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
//        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
//        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));

        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());
    }

    //后置通知
    @After("sayings()")
    public void sayGoodbey() {
        System.out.println("AOP拦截后。。。。");
    }

    //环绕通知。注意要有ProceedingJoinPoint参数传入。
    @Around("sayings()")
    public Object sayAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            //前置通知
            System.out.println("目标方法执行开始...");
            //执行目标方法
            //用新的参数值执行目标方法
//            pjp.proceed(new Object[]{"newSpring"});
            Object result = pjp.proceed();//执行方法

//            Object obj = pjp.getTarget(); // 必须用target，不能是this
//            Method[] methods = obj.getClass().getMethods(); // 获取所有方法
//
//            for (Method item : methods) {
//                if (item.isAnnotationPresent(MyZhuJie.class)) {
//                    MyZhuJie lock4j = item.getAnnotation(MyZhuJie.class);
//                    String objValue = this.getZhujieObjValue(item, pjp, lock4j);
//                    System.out.println("方法" + item.getName() + "加了注解，参数值：" + objValue);
//                }
//            }

            // 获取当前目标方法
            Signature signature = pjp.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method targetMethod = methodSignature.getMethod();
            if (targetMethod.isAnnotationPresent(MyZhuJie.class)) {
                MyZhuJie lock4j = targetMethod.getAnnotation(MyZhuJie.class);
                String objValue = this.getZhujieObjValue(targetMethod, pjp, lock4j);
                System.out.println("方法" + targetMethod.getName() + "加了注解，参数值：" + objValue);
            }
            //后置通知
            System.out.println("目标方法执行结束...");
            return result;
        } catch (Throwable e) {
            //异常通知
            System.out.println("执行目标方法异常后...");
            throw new RuntimeException(e);
        }
    }

    private String getZhujieObjValue(Method method, ProceedingJoinPoint pjp, MyZhuJie lock4j) {
        Object[] objects = pjp.getArgs();
        if (objects[0] instanceof String) {
            return String.valueOf((objects[0]));
        }
        String definitionKey = lock4j.btcpso();
        ParameterNameDiscoverer NAME_DISCOVERER = new DefaultParameterNameDiscoverer();
        EvaluationContext context = new MethodBasedEvaluationContext(null, method, pjp.getArgs(), NAME_DISCOVERER);
        ExpressionParser PARSER = new SpelExpressionParser();
        Expression expression = PARSER.parseExpression(definitionKey);
        return expression.getValue(context).toString();
    }
}
