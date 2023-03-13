package sixthlesson;

import java.util.Scanner;

public class TaskOne {

	public static void main(String[] args) {
		String initString;
		int counter = 0;
		Scanner scan = new Scanner(System.in);
		char[] charArr;

		System.out.println("Введіть строку для пошуку символу 'b':");
		initString = scan.nextLine();
		charArr = initString.toCharArray();

		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == 'b') {
				counter++;
			}
		}
		System.out.println("Символ 'b' зустрічається наступну кількість разів: " + counter);
	}
}