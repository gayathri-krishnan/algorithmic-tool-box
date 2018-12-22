import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    
	private static long getFibonacciLastDigitFast(int n) {
		if (n <= 1) {
			return n;
		}
		int[] numArr = new int[n+1];
		numArr[0] = 0;
		numArr[1] = 1;
		for (int i = 2; i <= n; i++) {
			numArr[i] = (numArr[i - 1] + numArr[i - 2])%10;
		}
		return numArr[n];
	}
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        //System.out.println(getFibonacciLastDigitNaive(n));
        System.out.println(getFibonacciLastDigitFast(n));
    }
}

