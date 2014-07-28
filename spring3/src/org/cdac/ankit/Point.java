package org.cdac.ankit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;


@Component
public class Point {
	private int x;
	private int y;
	
	public Point(){
		
	}
	
	public Point(int x,int y){
		
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	@PostConstruct
	public void initialize(){
		System.out.println("Point Initialized...");
	}
	
	

}
