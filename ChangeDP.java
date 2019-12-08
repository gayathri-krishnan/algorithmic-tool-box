import java.util.Random;
import java.util.Scanner;

public class ChangeDP {
	private static final int ONE = 1;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int[] coin = { ONE, THREE, FOUR };

	private static int getChange(int money) {
		int[] minCoins = new int[money + 1];
		minCoins[0] = 0;
		int numOfCoins;
		for (int m = 1; m <= money; m++) {
			for (int i = 0; i < coin.length; i++) {
				if (money >= coin[i]) {
					int index = m - coin[i];
					if (index >= 0) {
						numOfCoins = minCoins[index] + 1;
						if (minCoins[m] == 0 || numOfCoins < minCoins[m]) {
							minCoins[m] = numOfCoins;
						}
					}

				}
			}
		}

		return minCoins[money];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int money = scanner.nextInt();
		System.out.println(getChange(money));
		// Stress testing code

//		while (true) {
//			int n = new Random().nextInt(10000);
//			System.out.println(n);
//			System.out.println(getChange(n));
//			//money = scanner.nextInt();
//		}

	}
}
