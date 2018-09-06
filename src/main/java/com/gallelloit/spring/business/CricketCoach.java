package com.gallelloit.spring.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gallelloit.spring.service.FortuneService;

/**
 * Class with two plain properties (emailAddress and team) and a reference to FortuneService
 * The implementation for FortuneService is defined in applicationContext.xml as the
 * randomFortuneService
 * 
 * Display messages are shown for debug purposes to see when each method is executed by
 * Spring Framework at bean creation time. 
 * 
 * @author pgallello
 *
 */
@Component
public class CricketCoach implements Coach {
	
	@Value(value="${foo.email}")
	private String emailAddress;
	
	@Value(value="${foo.team}")
	private String team;
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getTeam() {
		return team;
	}

	public CricketCoach() {
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice cricket for 1 hour.";
	}

	// Spring will generate the service that will bring up the fortune status
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">> Cricket coach: inside setFortuneService(FortuneService fortuneService) (Autowired)");

		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return "Cricket fortune: " + fortuneService.getFortune();
	}

}