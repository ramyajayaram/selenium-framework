package Utility;
import org.apache.commons.lang3.RandomStringUtils;

public class StringUtility {
	
	public static String Email() {
		 String Email = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
		 return Email.concat("@gmail.com");

	}

}