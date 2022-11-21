import java.util.Scanner;

public class Project {
	// check for invalid statements rather first
	public static boolean valid(String in) {
		// check first letter is capital
		char cOne = in.charAt(0);
		System.out.println("First: " + cOne);
		if (!Character.isUpperCase(cOne))
			return false;
		// store last character
		char last = (in.charAt(in.length() - 1)); // last character at last position
		System.out.println("Last: " + last);
		int periodCount = 0;
		int quoteCount = 0;

		// check number of periods + quotes
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == '.')
				periodCount++;

			if (in.charAt(i) == '"')
				quoteCount++;
		}
		// make sure if either one is invalid, then all invalid

		// Check for numbers spelt below

		// found source from:
		// https://www.geeksforgeeks.org/extract-all-integers-from-a-given-string/?ref=rp
		// will gather all ints from a string and store into string array
		String[] spltIn = in.split("[^0-9]+");
		// will extract all integers from string as array form
		//int intSplit = Integer.parseInt(spltIn[0]);
	//	System.out.println(intSplit);
//		if (Integer.parseInt(spltIn[1] != null)) {
//		int intSplitTwo = Integer.parseInt(spltIn[1]);
////		
//		if (intSplit == 1)
//			if (intSplitTwo >= 3)
//				return true;
//			else
//				return false;
//
////			if (intSplit <= 12)
//				return false;
//			else continue;

		// final period count check towards end
		if (periodCount >= 2 || quoteCount % 2 != 0)
			return false;

		else if (periodCount == 1)
			return true;
		return true;

	}

	public static void main(String[] args) {
		// Take a Scanner string input to validate a string
		String input = "";
		System.out.println("Please enter a sentence.");
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		System.out.println("Name: " + input);

		boolean checkValidation = valid(input);

		if (!checkValidation)
			System.out.println("Invalid sentence");
		else
			System.out.println("Valid Sentence.");

	}

//	for (int i = 0; i < in.length(); i++) {
//	// if same, then invalid
//	// make sure to compare all values in array set
//	for (int j = 0; j < numbers.length; j++) {
//		if (numbers[j] == in.charAt(i)) {
//			System.out.println("Found: " + in.charAt(i));
//			return false;
//		}
//	}
//}
}
