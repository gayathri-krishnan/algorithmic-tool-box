package algorithms;
import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int[] ow = new int[W+1];
        for(int i=1;i<=W;i++) {
        	ow[i] = ow[i-1];
        	int gap = i-ow[i-1];
        	for(int j=0;j<w.length;j++) {
        		if(w[j]<=gap) {
        			ow[i] = ow[i] + w[j];
        		}
        	}
        	
        }
        
        return ow[W];
    }

    private static int[] reverse(int[] in) {
    	int n = in.length;
    	int[] out = new int[n];
    	int j=0;
    	for(int i = n-1 ;i>=0;i--) {
    		out[j]=in[i];
    		j++;
    	}
    	return out;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

