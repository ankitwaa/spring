package org.cdac.ankit;

import org.cdac.ankit.springhibernate.dao.UserHinbernateDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class SpringExample{
	
	
	public static void main(String[] args) throws Exception
	{
		//BeanFactory factory=new XmlBeanFactory(new FileSystemResource("beans.xml"));
		
		AbstractApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		applicationContext.registerShutdownHook();
		/*Shape s=(Shape)applicationContext.getBean("traingle");
		s.draw();
		s.setHeight(60);
		
		Shape s2=(Shape)applicationContext.getBean("shape");
		s2.draw();*/
		
		Traingle tr=(Traingle)applicationContext.getBean("traingle");
		System.out.println(tr.getOne().getX());
		
		String message=applicationContext.getMessage("welcome", null, "Missing", null);
		System.out.println(" Message " + message);
		
		UserHinbernateDao dao=(UserHinbernateDao)applicationContext.getBean("userHinbernateDao",UserHinbernateDao.class);

	}

}
