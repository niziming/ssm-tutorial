package spring12_anno_aop.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
@Component("logger")
@Aspect // 标识是一个切面类
public class Logger {
    @Pointcut("execution(* spring12_anno_aop.service.impl.*.*(..))")
    public void log() {}

    /**
     * 前置通知
     */
    // @Before("log()")
    public void beforPrintLog(){
        System.out.println("Logger类中的pringLog方法开始记录日志了。。。");
    }

    @Around("log()")
    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            //得到方法执行所需的参数
            Object[] args = pjp.getArgs();
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置");
            //明确调用业务层方法（切入点方法）
            rtValue = pjp.proceed(args);
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。后置");
            return rtValue;
        }catch (Throwable t){
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。最终");
        }
    }
}
