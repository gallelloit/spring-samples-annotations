package com.gallelloit.spring.xml.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gallelloit.spring.business.Coach;
import com.gallelloit.spring.business.TrackCoach;

/**
 * Simple Spring application that creates a context from a XML file (applicationContext.xml),
 * which sets the scanning configuration at com.gallelloit.spring package. Spring will search in that package and all subpackages
 * for classes defined with @Component annotation.
 * 
 * This app gets the bean trackCoach, which implements the interface Coach. This coach implementation uses internally the implementation RandomFortuneService of interface FortuneService using
 * @Autowired and @Qualifier annotations in the constructor.
 * 
 * This demo application tests the lifecycle of Spring beans. TrackCoach object defines two methods with the annotations
 * @Postconstruct and @Predestroy. Some messages are displayed to see when each method is executed.
 * 
 * @author pgallello
 *
 */
public class Demo02LifeCycleAnnotationsApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from Spring container
		Coach theCoach = context.getBean("trackCoach", TrackCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// Close context
		context.close();
	}

}
