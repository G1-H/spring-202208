package com.example.demo.aop_step2;

public class Logout {
	AopDao dao;
	public void run(AopDao dao, String job) {
		this.dao = dao;
		System.out.println("log....AopDao.....1");
		
		switch(job) {
		case "select":
			this.dao.select();
			break;
		
		case "update":
			this.dao.update();
			break;
			
		case "insert":
			this.dao.insert();
			break;
			
		case "delete":
			this.dao.delete();
			break;
			
		}
		
		System.out.println("log....AopDao.....2");
	}
}
