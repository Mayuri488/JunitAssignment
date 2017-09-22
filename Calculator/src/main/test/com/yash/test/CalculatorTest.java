package com.yash.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yash.Calculator;
import com.yash.NegativeNotAllowedException;
import com.yash.NotValidString;

public class CalculatorTest {

	Calculator cal=new Calculator();
	
	/*
	 * for an empty string it will return 0)
	 */
	@Test
	public void addFormEmptyString() {
		assertEquals(0,cal.add(""));
	}

	/*
	 * for an one number  
	 */
	@Test
	public void addForSingleumber(){
		assertEquals(5,cal.add("5"));
	}
	
	/*
	 * for an one number and lots of commas
	 */
	
	@Test
	public void addForSingleumberwithlotsOfcommas(){
		assertEquals(5,cal.add(",,,5,,,,,,,,"));
	}
	
	/*
	 * for an two numbers  
	 */
	@Test
	public void addForValidString(){
		assertEquals(3,cal.add("1,2"));
	}
	
	

	/*
	 * for an unknown amount of numbers
	 */
	@Test
	public void addUnknownAmoutOfNumbers(){
		assertEquals(179,cal.add("1,2,5,8,4,6,7,56,45,45"));
	}
	

	
	/*
	 * for 1\n2,3
	 */
	@Test
	public void addForSlashN(){
		assertEquals(12,cal.add("6,1\n2,3"));
	}
	
	/*
	 * for 1\n2,3
	 */
	@Test(expected=NotValidString.class)
	public void addForSlashNWithcomma(){
		cal.add("6,1,\n2,3");
	}
	
	/*
	 * support for diffrent delimeters
	 */
	@Test
	public void addDifferentDelimeters1(){
		assertEquals(25,cal.add("1,5,4;7;8"));
	}
	//
	
	@Test
	public void addDifferentDelimeters2(){
		assertEquals(7,cal.add(",,,,,,,,,,,,,,,,2;;;;;5;;;;"));
	}
	
	/*
	 * for an negative values 
	 */
	@Test(expected=NegativeNotAllowedException.class)
	public void addForValidNegativeNumbers(){
		cal.add("-1,-2");
	}
	
	
	/*
	 * 
	 * Value greater than 1000 is ignored
	 */
	@Test
	public void addIgnoreValueGreaterThanThousond(){
		assertEquals(5,cal.add("1000,5"));
	}
	
	/*
	 * 
	 *  delimeter length can be any
	 */
	@Test
	public void addDelimeterLength(){
		assertEquals(6,cal.add("//[***]\n,1**;;*2***3"));
	}
	
	
	@Test
	public void addDelimeterLength1(){
		assertEquals(5,cal.add("//\n&+*1;4"));
	}
}
