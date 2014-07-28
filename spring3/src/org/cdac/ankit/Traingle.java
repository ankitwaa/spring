package org.cdac.ankit;

import java.util.ArrayList;

import org.cdac.ankit.Shape;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Traingle implements ApplicationEventPublisherAware{
	
	private Point one;
	private Point two;
	private Point three;
	
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;
	
	@Override
	@Required
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
			this.publisher=arg0;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

    @Resource
	public void setMessageSource(MessageSource messageSource){
		this.messageSource = messageSource;
	}


	public Traingle(){
		
	}
	
	
	public Traingle(Point one,Point two,Point three){
		this.one=one;
		this.two=two;
		this.three=three;
	}

	public Point getOne() {
		return one;
	}

	@Resource(name="one")
	public void setOne(Point one) {
		this.one = one;
	}

	public Point getTwo() {
		return two;
	}

	@Resource(name="two")
	public void setTwo(Point two) {
		this.two = two;
	}

	public Point getThree() {
		return three;
	}

	@Resource(name="three")
	public void setThree(Point three) {
		this.three = three;
	}
	
	@PostConstruct
	public void initializeTraingle(){
		System.out.println("Traingle is initialised...");
		Object[] args=new Object[]{"Ankit"};
		System.out.println(messageSource.getMessage("welcome",args,"Default Message",null));
		publisher.publishEvent(new DrawingEvent(this));
	}
	
	@PreDestroy
	public void destroyTraingle(){
		System.out.println("Traingle is destroyed...");
		System.out.println(messageSource.getMessage("welcome",null,"Default Message",null));
	}
	
	
	

}
