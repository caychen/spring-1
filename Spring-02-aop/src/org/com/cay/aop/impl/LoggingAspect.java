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
//把该类声明为一个切面：需要把该类放入到IOC容器中,再声明为一个切面
@Component
@Aspect
public class LoggingAspect {

	//定义一个方法，用于声明切入点表达式，一般该方法中不需要添加任何代码
	//使用@Pointcut声明切入点表达式
	@Pointcut("execution(* org.com.cay.aop.impl.*.*(..))")
	public void declareJoinPointExpression(){	}
	
	
	//声明该方法是一个前置通知:在目标方法之前开始执行
	//@Before("execution(* org.com.cay.aop.impl.*.*(..))")
	//引用上面的切面表达式
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}
	
	//后置通知：在目标方法执行后（无论是否发生异常）再执行的通知
	//注意：在后置通知中不能访问目标方法执行的结果
	//@After("execution(* org.com.cay.aop.impl.*.*(..))")
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends" );
	}
	
	//返回通知：在方法正常执行结束后再执行，而且在返回通知中可以访问到方法的返回值
	//@AfterReturning(value="execution(* org.com.cay.aop.impl.*.*(..))", returning="result")
	@AfterReturning(pointcut = "declareJoinPointExpression()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	//异常通知：在方法执行时出现异常后执行的通知，可以访问到异常对象，且可以指定在出现指定异常时再执行异常通知代码
	//@AfterThrowing(value="execution(* org.com.cay.aop.impl.*.*(..))",throwing="ex")
	@AfterThrowing(pointcut = "declareJoinPointExpression()", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception: " + ex);
	}
	
	/*
	 * 	环绕通知需要携带ProceedingJoinPoint类型的参数，其中
	 * 	环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法，且环绕通知必须有返回值，返回值即为目标方法的返回值
	*/
	//@Around("execution(* org.com.cay.aop.*.*(..))")
	@Around("declareJoinPointExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result = null;
		String methodName = pjd.getSignature().getName();
		
		//执行目标方法
		try {
			//前置通知
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
			//后置通知
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//异常通知
			System.out.println("The method " + methodName + " occurs exception: " + e);
		}
		//返回通知
		System.out.println("The method " + methodName + " ends");
		return result;
	}
}
