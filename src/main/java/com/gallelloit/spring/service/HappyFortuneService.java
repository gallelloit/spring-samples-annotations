package com.gallelloit.spring.service;

import org.springframework.stereotype.Component;

/**
 * Plain service simulation with just the implemented method getFortune returning
 * a fixed happy message.
 * @author pgallello
 *
 */
@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		 return "Today is your lucky day!";
	}
	
}