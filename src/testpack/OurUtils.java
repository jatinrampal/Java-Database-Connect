package testpack;

public class OurUtils {
	public static String getHtmlHeader(String title) {
		return "<html><head><title>"+title+"</title></head><body><center>";
	}
	public static String getHtmlFooter() {
		return "</center></body></html>";
	}
	public static boolean validateTextInput(String input) {
		boolean isValid = true; 
		if(input == null || input.trim().equals("")) isValid = false;
		return isValid;
	}
}
