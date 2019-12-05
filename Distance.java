package algorithms;

import java.util.*;

public class Distance {
  public static int editDistance(String s, String t) {	
	//add an empty string to the start for both string
	  s = " "+s;
	  t = " "+t;      
	//build d[][]
	  int n = s.length();
	  int m = t.length();
	int[][] D = new int[n][m];
	//first row is same as i
	for(int i=0;i<n;i++) {
		D[i][0] = i;
	}	
	for(int j=0;j<m;j++) {
		D[0][j] = j;
	}
	for(int j=1;j<m;j++) {
		for(int i=1;i<n;i++) {
			int ins = D[i][j-1]+1;
			int del = D[i-1][j]+1;
			int match = D[i-1][j-1];
			int misMatch = D[i-1][j-1] + 1;
			if(s.charAt(i)==t.charAt(j)) {
				D[i][j] = Math.min(Math.min(ins, del),match);
			}else {
				D[i][j] = Math.min(Math.min(ins, del),misMatch);
			}			
		}
	}
	
	
	 return D[n-1][m-1];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(editDistance(s, t));
    scan.close();
  }

}
