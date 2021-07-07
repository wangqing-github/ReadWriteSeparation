package com.example.demo.aspect;

import com.example.demo.commons.mythread.DBContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
//            "!@annotation(com.sql.readwrite.annotation.Master)"+
//            "&& (" +
//            "execution(* com.sql.readwrite.service..*.select*(..))"+
//            "|| " +
//            "execution(* com.sql.readwrite.service..*.get*(..))" +
//            ")")
//    public void readPointcut(){
//
//    }
//
//    /**
//     * 主库切换
//     */
//    @Pointcut("@annotation(com.sql.readwrite.annotation.Master) " +
//            "|| execution(* com.sql.readwrite.service..*.insert*(..)) " +
//            "|| execution(* com.sql.readwrite.service..*.add*(..)) " +
//            "|| execution(* com.sql.readwrite.service..*.update*(..)) " +
//            "|| execution(* com.sql.readwrite.service..*.edit*(..)) " +
//            "|| execution(* com.sql.readwrite.service..*.delete*(..)) " +
//            "|| execution(* com.sql.readwrite.service..*.remove*(..))")
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
    @Before("execution(* com.sql.readwrite.mapper..*(..))")
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
}
