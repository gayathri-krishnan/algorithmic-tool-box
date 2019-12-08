import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
	if(s.length() == 0 && t.length() == 0) {
		return 0;
	}
	int n = s.length();
	int m = t.length();
	char[] A = s.toUpperCase().toCharArray();
	char[] B = t.toUpperCase().toCharArray();
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
			if(A[i-1]==B[j-1]) {
				int match = D[i-1][j-1];
				min = Math.min(min, match);				
			}else {
				int mismatch = D[i-1][j-1]+1;
				min = Math.min(min, mismatch);				
			}
			D[i][j] = min;
		}
	}
    return D[n][m];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
