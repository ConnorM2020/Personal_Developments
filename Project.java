import java.util.Scanner;

public class Project {
	// check for invalid statements rather first
	public static boolean valid(String in) {
		// check first letter is capital
		char cOne = in.charAt(0);
		System.out.println("First: " + cOne);

		if (!Character.isUpperCase(cOne) && cOne != '"') // valid check for quotes
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
// found source from:
// https://www.geeksforgeeks.org/extract-all-integers-from-a-given-string/?ref=rp
// will gather all ints from a string and store into string array
		char[] chrArrayStr = in.toCharArray();
		char[] numbers = extractInts(chrArrayStr);
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length - 1; j++) {
				// numbers presented less than 12 will be invalid
				System.out.println(numbers[i]);
				if (numbers[i] == 1) {
					if (numbers[j] <= 2) {
						return false;
					} else
						return true;
				} else if (numbers[i] >= 2 && numbers[i] <= 9)
					return false;
			}
		}

		// count for number of periods and even quotes
		if (periodCount >= 2 || quoteCount % 2 != 0)
			return false;

		// final check at end
		if (last == '.' || last == '!' || last == '?')
			return true;
		else
			return false;
	}

	public static char[] extractInts(char[] str) {
		if (str.length > 0) {
			char[] ints = new char[str.length];

			for (int i = 0; i < str.length; i++) {
				if (str[i] - '0' >= 0 && str[i] - '0' <= 12) {
					ints[i] += str[i];
				}
			}
			return ints;
		}
		System.out.println("Empty array of numbers");

		return null;
	}

	public static void main(String[] args) {
		// Take a Scanner string input to validate a string
		String input = "";
		System.out.println("Please enter a sentence.");
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		System.out.println("Sentence: " + input);
		boolean checkValidation = valid(input);
		if (!checkValidation)
			System.out.println("Invalid sentence");
		else
			System.out.println("Valid Sentence.");

	}
// 
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

	// failed attempt
	// int[] intStr = new int [spltIn.length]; // same length
	// intStr[i] = Integer.parseInt(spltIn[i]);
//	for (int i = 0; i < spltIn.length; i++) {
//		for (int j = i + 1; j < spltIn.length - 1; j++) {
//			System.out.println(spltIn[i] + " ");
//			// store each string number as an integer
//			if (spltIn[i].charAt(i) >= '1' && spltIn[i].charAt(i) <= '9') {
//				return false;
//			}
//			if (spltIn[j].charAt(j) >= 3)
//				continue;
//			else
//				return false;
//		}
//	}
}
