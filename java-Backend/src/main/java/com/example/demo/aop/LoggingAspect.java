package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
	
	
	                      //return type  class-name.method-name(args)
         @Before("execution(* com.example.demo.server.jobServer.*(..))")
	   public void LoggMethod(JoinPoint jp) {
		   LOGGER.info("method calling "+jp.getSignature().getName());
	   }
         @After("execution(* com.example.demo.server.jobServer.*(..))")
  	   public void LoggMethodExecute(JoinPoint jp) {
  		   LOGGER.info("method Executed "+jp.getSignature().getName());
  	   }
         @AfterThrowing("execution(* com.example.demo.server.jobServer.*(..))")
  	   public void LoggMethodException(JoinPoint jp) {
  		   LOGGER.info("method has some issue with it"+ jp.getSignature().getName());
  	   }
         @AfterReturning("execution(* com.example.demo.server.jobServer.*(..))")
  	   public void LoggMethodSuccess(JoinPoint jp) {
  		   LOGGER.info("method executed Successfully "+jp.getSignature().getName() );
  	   }
}
