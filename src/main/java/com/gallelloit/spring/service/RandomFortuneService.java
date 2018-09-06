package com.gallelloit.spring.service;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * Defines an array with fortunes
 * In the implemented method getFortune from FortuneService interface,
 * it returns a random message from the array 
 * @author pgallello
 *
 */
@Component
public class RandomFortuneService implements FortuneService {

	private String[] myArray = {"Today is your lucky day!", "Not very good work expected. But let's try.", "You'll have a bad day today! Keep trying..."};
	Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		
		int randomNumber = myRandom.nextInt(myArray.length);
		
		return myArray[randomNumber];
	}

}