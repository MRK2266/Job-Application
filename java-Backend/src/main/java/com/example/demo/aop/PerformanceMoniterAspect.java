package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMoniterAspect {
	private static final Logger LOGGER=LoggerFactory.getLogger(PerformanceMoniterAspect.class);
	
	 @Around("execution(* com.example.demo.server.jobServer.*(..))")
	public Object MoniterMethod(ProceedingJoinPoint jp) throws Throwable {
		long start=System.currentTimeMillis();
		
		Object obj= jp.proceed();
		long end=System.currentTimeMillis();		

	   LOGGER.info("method executed in "+(end-start)+" ms");
	
	   return obj;
	}
}
