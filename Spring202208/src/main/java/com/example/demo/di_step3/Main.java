package com.example.demo.di_step3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Assembler.class);
		Sql sql = (Sql)context.getBean("getSql");
		sql.crud();
		
	}

}
