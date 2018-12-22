import java.util.Random;
import java.util.Scanner;

public class Change {
	private static final int TEN = 10;
	private static final int FIVE = 5;
	private static final int ONE = 1;
	private static final int[] coinList = { TEN, FIVE, ONE };

	private static int getChange(int m) {
		if (m == 0) {
			return m;
		}
		if (m == 1) {
			return 1;
		}
		if (m == TEN | m == FIVE | m == ONE) {
			return 1;
		}
		int total = 0;
		for (int i = 0; i < coinList.length; i++) {
			int quotient = 0;
			int remainder = 0;
			if (m >= coinList[i]) {
				quotient = m / coinList[i];
				remainder = m % coinList[i];
				m = remainder;
				total += quotient;
			}
		}
		return total;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(getChange(m));
		//Stress testing code
		/*while (true) {
			int n = new Random().nextInt(10000);
			System.out.println(n);
			System.out.println(getChange(n));
			m = scanner.nextInt();
		}*/

	}
}
