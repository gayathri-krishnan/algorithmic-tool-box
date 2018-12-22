import java.util.Scanner;

public class Fibonacci {
	
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;
    return calc_fib(n - 1) + calc_fib(n - 2);    
  }
  
	private static long calc_fib_fast(int n) {
		if (n <= 1) {
			return n;
		}
		long[] numArr = new long[n + 1];
		numArr[0] = 0;
		numArr[1] = 1;
		for (int i = 2; i <= n; i++) {
			numArr[i] = numArr[i - 1] + numArr[i - 2];
		}
		return numArr[n];
	}

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    //System.out.println(calc_fib(n));
    System.out.println(calc_fib_fast(n));
  }
}
