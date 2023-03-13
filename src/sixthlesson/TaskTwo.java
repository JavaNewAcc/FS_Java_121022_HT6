package sixthlesson;

import java.util.Scanner;

public class TaskTwo {

	public static void main(String[] args) {
		String initString;
		String[] stringArr;
		String longestWord;

		System.out.println("Введіть речення для пошуку найдовшого слова:");
		Scanner scan = new Scanner(System.in);

		initString = scan.nextLine();

		stringArr = initString.split("[ ]");
		longestWord = stringArr[0];

		if (stringArr.length == 1) {
			System.out.println(
					"Найдовше слово: " + longestWord + ". Кількість символів в ньому: " + longestWord.length());
		} else {
			for (int i = 1; i < stringArr.length; i++) {
				if (stringArr[i].length() > longestWord.length()) {
					longestWord = stringArr[i];
				}
			}
			System.out.println(
					"Найдовше слово: " + longestWord + ". Кількість символів в ньому: " + longestWord.length());
		}
	}
}