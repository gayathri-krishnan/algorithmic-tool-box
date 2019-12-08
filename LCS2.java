import java.util.*;

public class LCS2 {
	 private static List<String> aList = new ArrayList<String>();
	 private static List<String> bList = new ArrayList<String>();

    private static int lcs2(int[] a, int[] b) {
    	if(a.length == 0 && b.length == 0) {
    		return 0;
    	}
    	int n = a.length;
    	int m = b.length;
    	
    	int[][]D = new int[n+1][m+1];
    	for(int i=0;i<=n;i++) {
    		D[i][0] = i;
    	}
    	for(int j=0;j<=m;j++) {
    		D[0][j] = j;
    	}
    	for(int j=1;j<=m;j++) {
    		for(int i=1;i<=n;i++) {
    			int insertion = D[i][j-1]+1;
    			int deletion = D[i-1][j]+1;	
    			int min = Math.min(insertion, deletion);
    			if(a[i-1]==b[j-1]) {
    				int match = D[i-1][j-1];
    				min = Math.min(min, match);				
    			}else {
    				int mismatch = D[i-1][j-1]+1;
    				min = Math.min(min, mismatch);				
    			}
    			D[i][j] = min;
    		}
    	}   
    	for(int i=0,j=0;i<=n && j<=m;i++,j++) {
    		
    			outputAlignment(i, j, D, a, b);
    		
    	}
    	return D[n][m];
    }
    public static void outputAlignment(int i, int j, int[][] D, int[] a,int[] b) {
    	if(i==0 && j==0){
    		return;
    	}
    	if(i>0 && D[i][j]==D[i-1][j]+1) {
    		outputAlignment(i-1, j, D, a, b);
    		aList.add(String.valueOf(a[i-1]));
    		bList.add("-");
    	}else if(j>0 && D[i][j]==D[i][j-1]+1){
    		outputAlignment(i, j-1, D, a, b);
    		aList.add("-");
    		bList.add(String.valueOf(b[j-1]));
    	}else {
    		outputAlignment(i-1, j-1, D, a, b);
    		aList.add(String.valueOf(a[i-1]));
    		bList.add(String.valueOf(b[j-1]));
    	}
    }
    	
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

