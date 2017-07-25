package org.com.cay.aop.impl.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class ValidationAspect {

	public void validateArgs(JoinPoint joinPoint){
		System.out.println("--> validate: " + Arrays.asList(joinPoint.getArgs()));
	}
}
