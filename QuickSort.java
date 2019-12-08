import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class QuickSort
{
	public static void swap (int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	public static int Partition(int[] a, int low, int high)
	{
		int pivot = a[low];
		int i = low - 1;
		int j = high + 1;

		while (true) {
			do {
				i++;
			} while (a[i] < pivot);

			do {
				j--;
			} while (a[j] > pivot);

			if (i >= j)
				return j;

			swap(a, i, j);
		}
	}

	// Quicksort routine
	public static void quickSort(int[] a, int low, int high)
	{
		// base condition
		if (low >= high) {
			return;
		}

		// rearrange the elements across pivot
		int pivot = Partition(a, low, high);

		// recurse on sub-array containing elements less than the pivot
		quickSort(a, low, pivot);

		// recurse on sub-array containing elements more than the pivot
		quickSort(a, pivot + 1, high);
	}


	public static void main(String[] args)
	{
		FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

		quickSort(a, 0, a.length - 1);

		// print the sorted array
		for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
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