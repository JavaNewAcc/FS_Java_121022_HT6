package sixthlesson;

public class TaskThree {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			String formatter = "%." + (i + 2) + "f";
			System.out.println(String.format(formatter, Math.PI));
		}
	}
}