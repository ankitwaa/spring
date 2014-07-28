package org.cdac.ankit;

import java.io.BufferedReader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Shape implements ApplicationContextAware,InitializingBean{
	

	private String name;
	private int height;
	private Rectangle rectangle;
	
	private ApplicationContext context;
	
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public Shape(){
		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Shape parameter has been initialized...");
		
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}
	
	@Resource(name="rectangle")
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public Shape(Rectangle rectangle){
		this.rectangle=rectangle;
	}
	
	public Shape(String name){
		this.name=name;
	}
	
	public Shape(int height){
		this.height=height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.context=arg0;
		
	}
	
	public void draw(){
		System.out.println("Shape Rectange" + rectangle.getLength() + " ," + rectangle.getWidth() + " Height: " + height);
	}
	
	@PostConstruct
	public void initializeShape(){
		System.out.println("Shape is initialised..");
	}

	@PreDestroy
	public void destroyShape(){
		System.out.println("Shape is about to destroyed");
	}
}
