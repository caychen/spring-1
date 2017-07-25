package org.com.cay.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value=1)//�������ȼ�������ԽС�����ȼ�Խ��
@Component
@Aspect
public class ValidationAspect {

	//@Before("execution(* org.com.cay.aop.impl.*.*(..))")
	//�����ⲿ���������ʽ�������ͬһ���£���ֱ��ʹ������.���溯��������Ϊ�������.����.���溯��
	@Before("LoggingAspect.declareJoinPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("--> validate: " + Arrays.asList(joinPoint.getArgs()));
	}
}
