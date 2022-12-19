package com.example.demo.di_step3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.member.GuestMember;
import com.example.demo.member.Member;
import com.example.demo.member.RegisterMember;

@Configuration
public class Assembler {
	
	@Bean
	public Sql getSql() {
		return new Oracle();
	}
	
	@Bean
	public Member getMember() {
		return new GuestMember();
	}
	
}
