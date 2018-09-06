package com.gallelloit.spring.xml.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gallelloit.spring.business.FootballCoach;

/**
 * Simple Spring application that creates a context from a XML file (applicationContext.xml),
 * which sets the scanning configuration at com.gallelloit.spring package. Spring will search in that package and all subpackages
 * for classes defined with @Component annotation.
 * 
 * This app gets the bean cricketCoach, which implements the interface Coach.
 * 
 * This coach implementation uses internally the implementation RandomFortuneService of interface FortuneService
 * 
 * @author pgallello
 *
 */

/**
 * Simple Spring application that creates a context from a XML file (applicationContext.xml),
 * which sets the scanning configuration at com.gallelloit.spring package. Spring will search in that package
 * and all subpackages for classes defined with @Component annotation.
 * 
 * It gets the bean footballCoach, which implements the interface Coach
 * This Coach implementation uses internally the implementation HappyFortuneService of interface FortuneService
 * as a result of the use of @Component and @Qualifier annotations in the constructor.
 * 
 * The resolved issue of this example is testing the two most used bean scopes from Spring: Singleton and Prototype
 * 
 * In the FootballCoach object, two alternative versions of the bean definition are specified through the
 * @Scope annotation, which must be specified with the scope strategy. The original proposed solution
 * has both alternative lines, one of which must be commented.
 * 
 * - On one side, Singleton (`@Scope(value="singleton")`), the default stratey, will make Spring to create and
 * return one instance of the bean no matter how many times the bean is retrieved. You can see in the example how
 * the memory location for the two retrieved objects is the same.
 * 
 * - Whereas when Prototype strategy is defined (`@Scope(value="prototype")`), any time a new bean is requested to the container, a different
 * instance is created and retrieved. This test can be performed commenting the singleton line and uncommenting
 * the prototype one.
 * 
 * @author pgallello
 *
 */
public class Demo03BeanScopeAnnotationsApp {

	public static void main(String[] args) {
		
		// Load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from Spring container
		FootballCoach oneCoach = context.getBean("footballCoach", FootballCoach.class);
		FootballCoach otherCoach = context.getBean("footballCoach", FootballCoach.class);
		
		// Check if they are the same beans
		boolean result = (oneCoach == otherCoach);
		
		// Print out the results
		System.out.println("\nPointing to the same object? " + result);

		System.out.println("\nMemory location for theCoach: " + oneCoach);
		System.out.println("\nMemory location for alphaCoach: " + otherCoach);
		
		// Set properties in the first object
		oneCoach.setEmailAddress("some-email@gmail.com");
		oneCoach.setTeam("Some team");
		
		// Get the properties from the second object
		System.out.println(">> Main. Second coach email: " + otherCoach.getEmailAddress());
		System.out.println(">> Main. Second coach team: " + otherCoach.getTeam());
		
		// Close context
		context.close();
		
	}

}