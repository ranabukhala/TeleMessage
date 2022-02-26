package com.TeleMessage.util;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.TeleMessage.model.PhoneNumber;

public class PhoneNumberValidation {
	
	private static Date date = new Date() ;
    private static long timeMilli = date.getTime();
    
    /* PhoneValidation used to validate given phone numbers 
     * the function go over all the numbers and check it's validation .
     * 
     * @Param numbers store the given phone numbers from the Post method - request body 
     * @Param phoneNumbers store all the details after checking the validation such 
     * type , current status and status info
     * 
     */
    public static Object PhoneValidation (List<String> numbers) {
    	
    	List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
    	
    	for (int i = 0 ; i < numbers.size() ; i++ ) {
    		
    		String phone = numbers.get(i).replaceAll("[^a-zA-Z0-9]", "");
    		PhoneNumber number = new PhoneNumber();
    		number.setMdn(String.valueOf(phone));
    		number.setTransactionId(String.valueOf(phone+ "+" + timeMilli));
    		number.setRequestReceivedDate(new Date());
    	
    		try {
    			
    			Long.parseLong(phone);
    			
    			if(phone.startsWith("1")) {
    				phone = phone.substring(1, phone.length());
    				if(phone.length() == 10) {
    					number.setType("Full");
    					number.setCurrentStatus(2);
    					number.setStatusInfo("Success Mobile is a full US number");
    				}
    				if(phone.length() > 10 || phone.length() < 10) {
    					number.setType("NotFull");
    					number.setCurrentStatus(4);
    					number.setStatusInfo("Mobile is not a full number");
    				}
    			}
    			else if (phone.length() == 10) {
    				number.setType("NoCountryCode");
    				number.setCurrentStatus(4);
					number.setStatusInfo("Mobile does not have a country code");
    			}
    			else if (phone.length() >= 11 || phone.length() < 10){
    				number.setType("NotFull");
					number.setCurrentStatus(4);
					number.setStatusInfo("Mobile is not a full number");
    			}
    			else {
    				if (numbers.get(i).contains("+")){
        				number.setType("NotUS");
    					number.setCurrentStatus(4);
    					number.setStatusInfo("Mobile is not US number");
    				}
    			}
    		}
    		
    		catch (Exception e){
    			number.setType("Invalid");
				number.setCurrentStatus(-1);
				number.setStatusInfo("Invalid Phone Number");
    		}
    		phoneNumbers.add(number);
    	}
    	return phoneNumbers;
    }
}
