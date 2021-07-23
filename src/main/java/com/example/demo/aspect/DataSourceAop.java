package com.example.demo.aspect;

import com.example.demo.annotation.Master;
import com.example.demo.commons.mythread.DBContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(1)
public class DataSourceAop {
//
//    /**
//     * 没有Master注解，且是service中的select* 或 get* 方法 拦截。
//     * 从库切换
//     */
//    @Pointcut(
//            "!@annotation(com.example.demo.annotation.Master)"+
//            "&& (" +
//            "execution(* com.example.demo.service..*.select*(..))"+
//            "|| " +
//            "execution(* com.example.demo.service..*.get*(..))" +
//            ")")
//    public void readPointcut(){
//
//    }
//
//    /**
//     * 主库切换
//     */
//    @Pointcut("@annotation(com.example.demo.annotation.Master) " +
//            "|| execution(* com.example.demo.service..*.insert*(..)) " +
//            "|| execution(* com.example.demo.service..*.add*(..)) " +
//            "|| execution(* com.example.demo.service..*.update*(..)) " +
//            "|| execution(* com.example.demo.service..*.edit*(..)) " +
//            "|| execution(* com.example.demo.service..*.delete*(..)) " +
//            "|| execution(* com.example.demo.service..*.remove*(..))")
//    public void writePointcut() {
//
//    }
//
//    @Before("readPointcut()")
//    public void read(){
//        DBContextHolder.slave();
//    }
//
//    @Before("writePointcut()")
//    public void write(){
//        DBContextHolder.master();
//    }


    /**
     * execution:表达式主体
     * 第一部分  代表方法返回值类型 *表示任何类型
     * 第二部分  com.example.demo.controller 表示要监控的包名
     * 第三部分 .. 代表当前包名以及子包下的所有方法和类
     * 第四部分 * 代表类名，*代表所有的类
     * 第五部分 *(..) *代表类中的所有方法(..)代表方法里的任何参数
     */
    @Before("execution(* com.example.demo.mapper..*(..))")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        //设置数据源
        if (isSlave(methodName)) {
            DBContextHolder.slave();
        } else {
            DBContextHolder.master();
        }
    }
    private boolean isSlave(String methodName) {
        return StringUtils.startsWithAny(methodName, "select", "query", "find", "get");
    }

//    @Around("@annotation(com.example.demo.annotation.Master)")
//    public Object Around(ProceedingJoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//
//        Method method = signature.getMethod();
//
//        Master dataSource = method.getAnnotation(Master.class);
//        int dataType = dataSource.type();
//        //设置数据源
//        if (dataType == 2) {
//            DBContextHolder.slave();
//        } else {
//            DBContextHolder.master();
//        }
//        return null;
//    }
}
