import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
    	int n = a.length;
    	if(n==1)
    		return a[0]*b[0];
    	List<Long> aList = new ArrayList<Long>();
    	List<Long> bList = new ArrayList<Long>();
        long result = 0;
        for (int i = 0; i < n; i++) {
        	aList.add(new Long(a[i]));
        	bList.add(new Long(b[i]));            
        }
        aList.sort(Collections.reverseOrder());
        bList.sort(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
        	result += aList.get(i)*bList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
      //Stress testing code
      		/*while(true) {
      			int n = new Random().nextInt(10) + 2;
      			
      			int[] a = new int[n];
      			int[] b = new int[n];
      			for(int i=0;i<n;i++) {
      				a[i] = new Random().nextInt(10000);
      				b[i] = new Random().nextInt(10000);
      				System.out.println("a["+i+"]"+a[i]);
      				System.out.println("b["+i+"]"+b[i]);
      			}      			
      			System.out.println(maxDotProduct(a, b));
      			Scanner scanner = new Scanner(System.in);
      	        int x = scanner.nextInt();
      		}*/
    }
}

