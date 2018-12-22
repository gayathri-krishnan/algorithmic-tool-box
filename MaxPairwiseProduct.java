
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
	static long getMaxPairwiseProduct(long[] numbers) {
		long max_product = 0;
		int n = numbers.length;

		for (int first = 0; first < n; ++first) {
			for (int second = first + 1; second < n; ++second) {
				long interimProd = numbers[first] * numbers[second];
				if (interimProd > max_product) {
					max_product = interimProd;
				}
			}
		}

		return max_product;
	}

	static long getMaxPairwiseProductFast(long[] numbers) {
		
		int n = numbers.length;
		int max_index1 = -1;
		int max_index2 = -1;
		for (int first = 0; first < n; ++first) {
			if(max_index1==-1 || numbers[first]> numbers[max_index1]) {
				max_index1 = first;
			}
		}
		for (int second = 0; second < n; ++second) {
			if((second!=max_index1 )&& ( max_index2==-1 || numbers[second]> numbers[max_index2])) {
				max_index2 = second;
			}
		}
		return numbers[max_index1]*numbers[max_index2];
	}
	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);		
		int n = scanner.nextInt();
		long[] numbers = new long[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		//Stress testing code
		/*while(true) {
			int n = new Random().nextInt(10) + 2;
			
			long[] numbers = new long[n];
			for(int i=0;i<n;i++) {
				numbers[i] = new Random().nextInt(10000);
			}
			long rs1 = getMaxPairwiseProduct(numbers);
			long rs2 = getMaxPairwiseProductFast(numbers);
			if(rs1!=rs2) {
				System.out.println("Failure");
				break;
			}else {
				System.out.println("OK");
			}
		}*/
			
		
		//System.out.println(getMaxPairwiseProduct(numbers));
		System.out.println(getMaxPairwiseProductFast(numbers));
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}