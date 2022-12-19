package com.example.demo.aop_step3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		AopDao dao = (AopDao)context.getBean("getAopDao");
		
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		
		AroundTest at = (AroundTest)context.getBean("getAroundTest");
		at.crud();//jp.proceed(); 에 의해 좌측 코드가 실행됨.
		
		StudentDao std = (StudentDao)context.getBean("getStudentDao");
		std.select();
		std.insert();
		std.update();
		std.delete();
		
	}

}
