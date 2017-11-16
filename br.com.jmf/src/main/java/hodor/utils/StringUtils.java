package hodor.utils;

public class StringUtils {

	public static boolean isNotBlank(String possibleCommand) {
		return !isBlank(possibleCommand); 
	}
	
	public static boolean isBlank(String str) {
		return str == null || str.trim().equals("");
	}
}
