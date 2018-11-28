package cn.enhance;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Enh {

    @Pointcut("execution(public String name(..))")
    public void poincut(){};

    @Before("poincut()")
    public void be(JoinPoint jp){
        System.out.println("前置执行 调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法" + Arrays.toString(jp.getArgs()));
    }

    @AfterReturning(value = "poincut()",returning = "result")
    public void afre(JoinPoint jp,Object result){
        System.out.println("后置执行 调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法" + Arrays.toString(jp.getArgs()) + "返回" + result);
    }

    @Around("poincut()")
    public void ar(ProceedingJoinPoint pjp){
        System.out.println("环绕开始");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕结束");
    }

    @After("poincut()")
    public void af(JoinPoint jp){
        System.out.println("最终执行 调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法" + Arrays.toString(jp.getArgs()));
    }

    @AfterThrowing(value = "poincut()",throwing = "e")
    public void ex(JoinPoint jp,Exception e){
        System.out.println("异常执行" + e);
    }
}
