package org.cdac.ankit;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListenerClass implements ApplicationListener<ApplicationEvent>{
	public void onApplicationEvent(ApplicationEvent arg0) {
			System.out.println("Application Event Occur" + arg0);
	}
}
