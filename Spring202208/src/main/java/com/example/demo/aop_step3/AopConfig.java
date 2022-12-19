package com.example.demo.aop_step3;


import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.tomcat.jni.Time;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@Aspect
public class AopConfig {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");

	@Bean
	public AopDao getAopDao() {
		return new AopDao(); 
	}  
	
	@Bean
	public AroundTest getAroundTest() {
		return new AroundTest(); 
	}
	@Bean
	public StudentDao getStudentDao() {
		return new StudentDao();
	}
	
	@Before("execution(* com.example.demo.aop_step3.AopDao.*(..))")
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("log......");
		//실행될 메서드명
		System.out.println(jp.getSignature().getName());
	}
	
	@Around("execution(* com.example.demo.aop_step3.AroundTest.*(..))")
	public void aroundAdvice(ProceedingJoinPoint jp) {
		System.out.println("비지니스 로직을 처리하기 전에.......");
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("비지니스 로직을 처리한 후에 ...");
	}
	
	@Before("execution(* com.example.demo.aop_step3.StudentDao.select(..))")
	public void beforeStudent(JoinPoint jp) {
		Date d = Calendar.getInstance().getTime();
		String now = sdf.format(d);
		
		String log = now + ">>>" + jp.getSignature().getName();
		writeLog(log);
		
	}
	@Around("execution(* com.example.demo.aop_step3.StudentDao.insert(..))"
			+ " || execution(* com.example.demo.aop_step3.StudentDao.update(..))"
			+ " || execution(* com.example.demo.aop_step3.StudentDao.delete(..))")
		
	public void aroundStudent(ProceedingJoinPoint jp) {
		Date d = Calendar.getInstance().getTime();
		String now = sdf.format(d);
		
		String log = now + ">>>" + jp.getSignature().getName();
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log += ">>>around Aop End";
		writeLog(log);
	}
	
	public void writeLog(String log) {
		FileWriter fw ;
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf2.format(new Date());
		String logFileName = today + ".log";
		
		try {
			fw = new FileWriter(logFileName, true);
			fw.write(log);
			fw.write("\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
