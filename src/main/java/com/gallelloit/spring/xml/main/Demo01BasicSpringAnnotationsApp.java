package com.gallelloit.spring.xml.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gallelloit.spring.business.CricketCoach;

/**
 * Simple Spring application that creates a context from a XML file (applicationContext.xml),
 * which sets the scanning configuration at com.gallelloit.spring package. Spring will search in that package and all subpackages
 * for classes defined with @Component annotation.
 * 
 * This app gets the bean cricketCoach, which implements the interface Coach. This coach implementation uses internally
 * the implementation RandomFortuneService of interface FortuneService using @Autowired and @Qualifier annotations
 * in the fortuneService property.
 * 
 * The values of the plain private properties in CricketCoach implementation are fetch from sports.properties
 * This configuration is specified also in the applicationContext.xml:
 * 
 *  - First tell Spring a placeholder property: '<context:property-placeholder location="classpath:sport.properties"/>'
 *  - Then, in the bean itself, i.e., in the class definition, a @Value annotation is used on each property:
 * 
 *  ```
 * 		@Value(value="${foo.email}")
 *		private String emailAddress;
 *	
 *		@Value(value="${foo.team}")
 *		private String team;
 *	```
 * 
 * This Coach implementation uses internally the implementation RandomFortuneService of interface FortuneService
 * 
 * @author pgallello
 *
 */
public class Demo01BasicSpringAnnotationsApp {

	public static void main(String[] args) {
		
		// Load the Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

 		// Retrieve baseball coach object
		
		/*
		 * Java basics: if no implementation specific methods where used in this main program, it wouldn't be
		 * necessary to define the object with the implementation name. The next commented line shows how could
		 * be done:
		 * 
		 * Coach theCricketCoach = context.getBean("cricketCoach", Coach.class);
		 * 
		 */
		
		/*
		 * As long as implementation specific methods are used (getEmailAddress() and getTeam()), the object need to be created with the
		 * implementation name.
		 */
		CricketCoach theCricketCoach = context.getBean("cricketCoach", CricketCoach.class);
		
		// Call methods on the bean
		System.out.println(">> Main. Daily workout: " + theCricketCoach.getDailyWorkout());
		System.out.println(">> Main. Daily fortune: " + theCricketCoach.getDailyFortune());
		
		System.out.println(">> Main. Coach email address: " + theCricketCoach.getEmailAddress());
		System.out.println(">> Main. Coach team:" + theCricketCoach.getTeam());

		
		// Close the context
		context.close();
		
	}

}