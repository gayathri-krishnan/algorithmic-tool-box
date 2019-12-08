import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a) {
        int currentCounter = 0;
        Integer currentElement = null;
        for(int i=0;i<a.length;i++) {
        	if(currentCounter==0) {
        		currentElement = a[i];
        		currentCounter = 1;
        	}else {
        		if(currentElement!=null && a[i]==currentElement.intValue()) {
        			currentCounter = currentCounter+1;
        		}else {        			
        			currentCounter = currentCounter-1;
        			if(currentCounter==0) {
        				currentElement = null;
        			}
        		}
        	}
        }
        if(currentElement!=null && currentCounter>=1) {
        	int finalCounter = 0;
        	//second pass to check majority
        	for(int i=0;i<a.length;i++) {
        		if(a[i]==currentElement.intValue()) {
        			finalCounter = finalCounter+1;
        		}
        	}
        	if(finalCounter>a.length/2) {
        		return 1;
        	}
        }
        return 0;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        System.out.println(getMajorityElement(a));
        
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

