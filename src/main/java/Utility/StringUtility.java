package Utility;
import org.apache.commons.lang3.RandomStringUtils;

public class  StringUtility {
	
	public static String Email() {
		 String Email = RandomStringUtils.randomAlphanumeric(17).toLowerCase();
		 return Email.concat("@gmail.com");

	}
	
	
	public static String Password() {
		 String Password = RandomStringUtils.randomAlphanumeric(15).toUpperCase();
		 return Password;

	}
	public static String  PhoneNumber()
	{
		long number=Math.round(Math.random()*1000000);
		String numberAsString = Long.toString(number);
		return numberAsString;
		
	}
	

}
