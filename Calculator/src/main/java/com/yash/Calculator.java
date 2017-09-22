package com.yash;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public  int add(String numbers) {
		int sum=0;
		
		if(numbers.isEmpty())
			return 0;
		
		exceptionForStringNotValid(numbers);
		
	    Matcher matcher = getMatcherForSpecialChar(numbers);
		
		String specialCharRemovedString=matcher.replaceAll(",");
		
		
		
		String[] values = specialCharRemovedString.split(",");
			
			for(int i=0;i<values.length;i++){
				try{
					System.out.println(values[i]); 
					int val=Integer.parseInt(values[i]);
					if(val<0){
						throw new NegativeNotAllowedException("Negative number is not allowed");
					}
					if(val<1000)
					{
						sum=sum+val;	
						System.out.println(sum);
					}
					
				}catch(NumberFormatException n){
					continue;
				}
				}
			return sum;
		
	}

	

	private void exceptionForStringNotValid(String numbers) {
		if(numbers.contains(",\n"))
		{
			throw new NotValidString("String is not Valid");
		}
	}

	private Matcher getMatcherForSpecialChar(String numbers) {
		Pattern replace = Pattern.compile("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~\n*]");
	     Matcher matcher = replace.matcher(numbers);
		return matcher;
	}

}
