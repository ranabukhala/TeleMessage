package com.TeleMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import com.TeleMessage.model.PhoneNumber;
import com.TeleMessage.util.PhoneNumberValidation;

@SpringBootTest
class TeleMessageApplicationTests {

	private static List<String> numbers = new ArrayList<String>();
	private static List<PhoneNumber> phones = new ArrayList<PhoneNumber>();
	
	@BeforeTestMethod
	private void init() {
		
		numbers.add("15417543012"); 	// FullUS
		numbers.add("+919251113333"); 	// NotUS 
		numbers.add("9251114444"); 		// NO CC
		numbers.add("115555"); 			// NotFull
		PhoneNumber phone1 = new PhoneNumber();
		phone1.setType("Full");
		phone1.setStatusInfo("Success Mobile is a full US number");
		PhoneNumber phone2 = new PhoneNumber();
		phone2.setType("NotUS");
		phone2.setStatusInfo("Mobile is not US number");
		PhoneNumber phone3 = new PhoneNumber();
		phone3.setType("NoCountryCode");
		phone3.setStatusInfo("Mobile does not have a country code");
		PhoneNumber phone4 = new PhoneNumber();
		phone4.setType("NotFull");
		phone4.setStatusInfo("Mobile is not a full number");
		phones.add(phone1);
		phones.add(phone2);
		phones.add(phone3);
		phones.add(phone4);
		
	}

	@SuppressWarnings("unchecked")
	@Test
	public void validateMobileNumber() throws Exception {
		
		boolean result = false;
		List<PhoneNumber> mobileResponse = (List<PhoneNumber>) PhoneNumberValidation.PhoneValidation(numbers);
		for (int i = 0; i < mobileResponse.size(); i++) {
			if ((phones.get(i).getType().equals(mobileResponse.get(i).getType())) &&
					(phones.get(i).getStatusInfo().equals(mobileResponse.get(i).getStatusInfo()))){
				result = true;
			}
			assertEquals(true, result);
		}
	}
	
	
}
