package sixthlesson;

import java.util.Arrays;
import java.util.Scanner;

public class AddTaskTwo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Введіть данні для пошуку повторів:");
		String text = scan.nextLine();
		String tempText;
		String word = "";
		String tempWord = "";

		boolean repeat = false;

		for (int i = 0; i < text.length() / 2; i++) {
			word = text.substring(0, i + 1);
			tempWord = text.substring(i + 1, word.length() * 2);
			tempText = text.substring(0, text.length());
			if (word.equals(tempWord)) {
				String[] textArr = new String[text.length() / word.length()];
				for (int j = 0; j < textArr.length; j++) {
					textArr[j] = tempText.substring(0, word.length());
					tempText = tempText.substring(word.length());
				}
				for (int k = 0; k < textArr.length; k++) {
					if (textArr[0].equals(textArr[k])) {
						repeat = true;
					} else {
						repeat = false;
						break;
					}
				}
				if (repeat) {
					break;
				} else {
					continue;
				}
			}
			if (!repeat) {
				word = "без повторів";
			}
		}
		System.out.println("Вовочка написав слово: " + word);
	}
}