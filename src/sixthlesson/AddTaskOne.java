package sixthlesson;

import java.util.Scanner;

public class AddTaskOne {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean error = true;
		int dollars = 0;
		int cents = 0;
		boolean centsExist = false;
		boolean thousands = false;
		String amountWords = "You have: ";

		System.out.println("How much money do you have?");
		String amount = scan.nextLine();
		char[] charArr = amount.toCharArray();

		String[] amountArr = amount.split("[.,]");

		for (int i = 0; i < charArr.length; i++) {
			if (!(charArr[i] >= '0' && charArr[i] <= '9' || charArr[i] == '.' || charArr[i] == ',')) {
				System.out.println("Please enter only numbers, ',' and '.' characters");
				error = true;
				return;
			} else {
				error = false;
			}
		}
		if (amountArr.length > 2) {
			System.out.println("You have entered wrong amount");
			error = true;
			return;
		} else if (amountArr.length == 2 && amountArr[1].length() > 2) {
			System.out.println("Please check quantity of cents.");
			error = true;
			return;
		} else {
			error = false;
		}

		int[] dollarsArr = new int[0];
		int[] centsArr = new int[0];

		if (amountArr[0].length() > 0) {
			dollarsArr = new int[amountArr[0].length()];
			dollars = Integer.valueOf(amountArr[0]);
			for (int i = amountArr[0].length() - 1; i >= 0; i--) {
				dollarsArr[i] = dollars % 10;
				dollars = dollars / 10;
			}
		}
		if (amountArr.length > 1) {
			centsArr = new int[2];
			cents = Integer.valueOf(amountArr[1]);
			for (int i = amountArr[1].length() - 1; i >= 0; i--) {
				centsArr[i] = cents % 10;
				if (centsArr[i] > 0) {
					centsExist = true;
				}
				cents = cents / 10;
			}
		}

		String[] numbers = { "zero ", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ",
				"ten ", "eleven ", "twelve ", "thirteen ", "forteen ", "fifteen ", "sixteen ", "seventeen ",
				"eighteen ", "nineteen " };
		String[] tens = { " ", " ", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ",
				"ninety " };
		String[] keyWords = { "dollar(s) ", "cent(s) ", "hundred ", "thousand ", "million ", "and ", "only" };

		if (!error) {
			if (dollarsArr.length > 0) {
				for (int i = 0; i < dollarsArr.length; i++) {
					if (dollarsArr.length - i == 7 && dollarsArr[i] > 0) {
						amountWords += numbers[dollarsArr[i]];
						amountWords += keyWords[4];
					} else if (dollarsArr.length - i == 6 && dollarsArr[i] > 0) {
						amountWords += numbers[dollarsArr[i]];
						amountWords += keyWords[2];
						thousands = true;
					} else if (dollarsArr.length - i == 5 && dollarsArr[i] == 1) {
						amountWords += numbers[dollarsArr[i + 1] + 10];
						i++;
						thousands = true;
					} else if (dollarsArr.length - i == 5 && dollarsArr[i] > 1) {
						amountWords += tens[dollarsArr[i]];
						thousands = true;
					} else if (dollarsArr.length - i == 4 && dollarsArr[i] > 0) {
						amountWords += numbers[dollarsArr[i]];
						thousands = true;
					} else if (thousands) {
						amountWords += keyWords[3];
						i--;
						thousands = false;
					} else if (dollarsArr.length - i == 3 && dollarsArr[i] > 0) {
						amountWords += numbers[dollarsArr[i]];
						amountWords += keyWords[2];
					} else if (dollarsArr.length - i == 2 && dollarsArr[i] == 1) {
						amountWords += numbers[dollarsArr[i + 1] + 10];
						i++;
					} else if (dollarsArr.length - i == 2 && dollarsArr[i] > 1) {
						amountWords += tens[dollarsArr[i]];
					} else if (dollarsArr.length - i == 1 && dollarsArr[i] > 0) {
						amountWords += numbers[dollarsArr[i]];
					}
				}
				if (amountWords.length() > 10) {
					amountWords += keyWords[0];
					if (centsExist) {
						amountWords += keyWords[5];
					} else {
						amountWords += keyWords[6];
					}
				}

				for (int j = 0; j < centsArr.length; j++) {
					if (centsArr.length - j == 2 && centsArr[j] == 1) {
						amountWords += numbers[centsArr[j + 1] + 10];
						j++;
					} else if (centsArr.length - j == 2 && centsArr[j] > 1) {
						amountWords += tens[centsArr[j]];
					} else if (centsArr.length - j == 1 && centsArr[j] > 0) {
						amountWords += numbers[centsArr[j]];
					}
				}
				if (centsExist) {
					amountWords += keyWords[1];
				}
			}
			System.out.println(amountWords);
		}
	}
}