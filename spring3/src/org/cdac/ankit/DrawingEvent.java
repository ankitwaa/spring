package org.cdac.ankit;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

public class DrawingEvent extends ApplicationEvent {
		
	public DrawingEvent(Object ref) {
		super(ref);
	}
	
	public String toString(){
		return "Drawing Event";
	}
	
}
