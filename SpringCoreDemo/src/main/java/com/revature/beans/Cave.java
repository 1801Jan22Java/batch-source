package com.revature.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cave implements InitializingBean, DisposableBean {
	
	public Cave(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Cave() {
		super();
	}
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy from DisposableBean Cave");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set from InitializingBean Cave");
	}
	
	public void defaultInit(){
		System.out.println("custom default init from Cave");
	}
	public void defaultDestroy(){
		System.out.println("custom default destroy from Cave");
	}

}
