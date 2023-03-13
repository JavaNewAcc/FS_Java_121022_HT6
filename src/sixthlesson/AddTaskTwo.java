package sixthlesson;

import java.util.Scanner;

public class AddTaskTwo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Введіть данні для пошуку повторів:");
		String text = scan.nextLine();
		char[] charArr = text.toCharArray();
		int repeatLength = 0;

		for (int i = 1; i < charArr.length; i++) {
			if (charArr[0] == charArr[i]) {
				repeatLength = i;
				break;
			}
		}
		System.out.println("Вовочка написав слово: " + text.substring(0, repeatLength));
	}
}