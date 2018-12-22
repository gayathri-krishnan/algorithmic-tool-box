import java.util.Scanner;

public class GCD {
	private static int gcd_naive(long a, long b) {
		int current_gcd = 1;
		for (int d = 2; d <= a && d <= b; ++d) {
			if (a % d == 0 && b % d == 0) {
				if (d > current_gcd) {
					current_gcd = d;
				}
			}
		}

		return current_gcd;
	}

	private static long gcd_efficient(long a, long b) {
		if(a==b) {
			return a;
		}
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}
		if(a==1||b==1) {
			return 1;
		}
		long bigger_num = a > b ? a : b;
		long smaller_num = a > b ? b : a;
		long rem = bigger_num % smaller_num;
		long a1 = smaller_num;
		long b1 = rem;

		while (rem > 0) {

			rem = a1 % b1;

			a1 = b1;
			b1= rem==0?b1:rem;

		}

		return b1;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		//System.out.println(gcd_naive(a, b));
		System.out.println(gcd_efficient(a, b));
	}
}
