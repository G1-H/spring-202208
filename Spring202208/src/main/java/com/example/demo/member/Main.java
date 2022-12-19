package com.example.demo.member;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.di_step3.Assembler;

public class Main {
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Assembler.class);
		Member m = (Member)context.getBean("getMember");
		m.crud();
	}

}
