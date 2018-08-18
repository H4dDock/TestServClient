package MainServ;

/**
 * 
 * @author H4dDock
 *
 */

public class SomeWeirdShit {
	/**
	 * 
	 * @param firstString
	 * @param secondString
	 * @return true, if first string has second string inside itself.
	 */
	protected static boolean ConcatThis(String firstString, String secondString) {
		String partString = "";

		if (secondString.length() > firstString.length())
			throw new IllegalArgumentException("Second argument length > first argument lentgh");

		for (int i = 0; i <= firstString.length() - secondString.length(); i++) {
			partString = firstString.substring(i, i + secondString.length());
			if (partString.equals(secondString))
				return true;
		}

		return false;
	}
}
