package org.com.cay.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
//�Ѹ�������Ϊһ�����棺��Ҫ�Ѹ�����뵽IOC������,������Ϊһ������
@Component
@Aspect
public class LoggingAspect {

	//����һ�����������������������ʽ��һ��÷����в���Ҫ����κδ���
	//ʹ��@Pointcut�����������ʽ
	@Pointcut("execution(* org.com.cay.aop.impl.*.*(..))")
	public void declareJoinPointExpression(){	}
	
	
	//�����÷�����һ��ǰ��֪ͨ:��Ŀ�귽��֮ǰ��ʼִ��
	//@Before("execution(* org.com.cay.aop.impl.*.*(..))")
	//���������������ʽ
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}
	
	//����֪ͨ����Ŀ�귽��ִ�к������Ƿ����쳣����ִ�е�֪ͨ
	//ע�⣺�ں���֪ͨ�в��ܷ���Ŀ�귽��ִ�еĽ��
	//@After("execution(* org.com.cay.aop.impl.*.*(..))")
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends" );
	}
	
	//����֪ͨ���ڷ�������ִ�н�������ִ�У������ڷ���֪ͨ�п��Է��ʵ������ķ���ֵ
	//@AfterReturning(value="execution(* org.com.cay.aop.impl.*.*(..))", returning="result")
	@AfterReturning(pointcut = "declareJoinPointExpression()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	//�쳣֪ͨ���ڷ���ִ��ʱ�����쳣��ִ�е�֪ͨ�����Է��ʵ��쳣�����ҿ���ָ���ڳ���ָ���쳣ʱ��ִ���쳣֪ͨ����
	//@AfterThrowing(value="execution(* org.com.cay.aop.impl.*.*(..))",throwing="ex")
	@AfterThrowing(pointcut = "declareJoinPointExpression()", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception: " + ex);
	}
	
	/*
	 * 	����֪ͨ��ҪЯ��ProceedingJoinPoint���͵Ĳ���������
	 * 	����֪ͨ�����ڶ�̬�����ȫ���̣�ProceedingJoinPoint���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽�����һ���֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	*/
	//@Around("execution(* org.com.cay.aop.*.*(..))")
	@Around("declareJoinPointExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result = null;
		String methodName = pjd.getSignature().getName();
		
		//ִ��Ŀ�귽��
		try {
			//ǰ��֪ͨ
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
			//����֪ͨ
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//�쳣֪ͨ
			System.out.println("The method " + methodName + " occurs exception: " + e);
		}
		//����֪ͨ
		System.out.println("The method " + methodName + " ends");
		return result;
	}
}
