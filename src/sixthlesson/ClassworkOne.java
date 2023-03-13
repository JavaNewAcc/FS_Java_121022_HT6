package sixthlesson;

import java.util.Scanner;

public class ClassworkOne {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String login;
		Boolean result = true;

		System.out.println("Введіть логін:");
		login = scan.nextLine();
		String loginTemp = login.toLowerCase();
		char[] charArr = login.toCharArray();

		if (loginTemp.length() < 6) {
			result = false;
		} else if (!(loginTemp.charAt(0) >= 'a' && loginTemp.charAt(0) <= 'z')) {
			result = false;
		} else {
			charArr = loginTemp.toCharArray();
			for (int i = 0; i < charArr.length; i++) {
				char s = charArr[i];
				if (!((s >= 'a' && s <= 'z') || (s >= '0' && s <= '9') || s == '_')) {
					result = false;
					break;
				}
			}
		}
		if (result) {
			System.out.println(login + " correct");
		} else {
			System.out.println(login + " incorrect");
		}
	}
}