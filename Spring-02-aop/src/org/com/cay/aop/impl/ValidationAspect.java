package org.com.cay.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value=1)//切面优先级，数字越小，优先级越高
@Component
@Aspect
public class ValidationAspect {

	//@Before("execution(* org.com.cay.aop.impl.*.*(..))")
	//引用外部的切入点表达式，如果在同一包下，则直接使用类名.切面函数，否则为加入包名.类名.切面函数
	@Before("LoggingAspect.declareJoinPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("--> validate: " + Arrays.asList(joinPoint.getArgs()));
	}
}
