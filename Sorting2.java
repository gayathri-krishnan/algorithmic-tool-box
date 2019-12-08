//code to implement Dijkstra 3-way partitioning

public class Sorting2 {

	private int[] original={0,7,8,1,8,9,3,8,8,8,0,7,8,1,8,9,3,8,8,8};
	private int length;
	private int lt;
	private int gt;

	public Sorting2(int len) {
		length = len;
		// original = new int[length];

		

	}

	public void swap(int a, int b) { // here indexes are passed
		int temp = original[a];
		original[a] = original[b];
		original[b] = temp;
	}

	public int random(int start, int end) {
		return (start + (int) (Math.random() * (end - start + 1)));
	}

	public void partition(int pivot, int start, int end) {
		swap(pivot, start); // swapping pivot and starting element in that subarray

		int pivot_value = original[start];
		lt = start;
		gt = end;

		int i = start;
		while (i <= gt) {

			if (original[i] < pivot_value) {
				swap(lt, i);
				lt++;
				i++;
			}

			if (original[i] > pivot_value) {
				swap(gt, i);
				gt--;
			}
			if (original[i] == pivot_value)
				i++;
		}
	}

	public void Sort(int start, int end) {
		if (start < end) {

			int pivot = random(start, end); // choose the index for pivot randomly
			partition(pivot, start, end); // about index the array is partitioned

			Sort(start, lt - 1);
			Sort(gt + 1, end);

		}
	}

	public void Sort() {
		Sort(0, length - 1);
	}

	public void disp() {
		for (int i = 0; i < length; ++i) {
			System.out.print(original[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Sorting2 qs = new Sorting2(20);
		qs.disp();

		qs.Sort();
		qs.disp();

	}

}