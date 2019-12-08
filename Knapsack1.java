package algorithms;
import java.util.*;

public class Knapsack1 {
    static int optimalWeight(int W, int[] weights) {
        //write you code here
        int result = 0;
        int n = weights.length;
        
        //two dimensional array of size n,W+1
        //we go from 0 to the number, hence the +1
       //ow = optimal weights
        int[][] ow = new int[n][W+1];
        for(int i=1;i<n;i++) {
        	for(int w=1;w<=W;w++) {
        		ow[i][w]=ow[i-1][w];
        		if(weights[i]<=w) {
        			//nw = new weight
        		    int nw = ow[i-1][w-weights[i]]+weights[i];
        		    if(ow[i][w]<nw) {
        		    	ow[i][w]  = nw;
        		    }
        		}
        	}
        }
        return ow[n-1][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n+1];
        w[0]=0;
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

