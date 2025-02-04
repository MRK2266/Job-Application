package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceValidation {

	
	private static final Logger LOGGER=LoggerFactory.getLogger(PerformanceValidation.class);
	
	 @Around("execution(* com.example.demo.server.jobServer.*(..)) && args(postId)")
	public Object methodValidation(ProceedingJoinPoint jp,int postId) throws Throwable {
		if(postId<0) {
			LOGGER.info("id is negative updating");
			postId=-postId;
			LOGGER.info("updated value "+postId);
			
		}
		Object obj=jp.proceed(new Object[] {postId});
		return obj;
		
	}
}
