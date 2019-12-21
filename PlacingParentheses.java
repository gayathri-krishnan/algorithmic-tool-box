package algorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//figure this out 1+0+3*5+7-3*6*4-0-7+8-4*4*1*6 
//correct answer - 149040
public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
      List<Integer> d = getNumbers(exp);
      int n = d.size();
      List<String> o = getOperators(exp);
      //create min and max two dimensional array
      long[][] m = new long[n][n];
      long[][] M = new long[n][n];
      for(int i =1;i<n;i++) {
        m[i][i] = d.get(i);
        M[i][i] = d.get(i);
      }   
      for(int s=1;s<n;s++) {
        for(int i=1;i<n-s;i++) {
          int j= i+s;
          long[] minMax= minAndMax(i,j,m,M,o);          
          m[i][j] = minMax[0];
          M[i][j] = minMax[1];
        }
      }
      return M[1][n-1];
    }

    private static long[] minAndMax(int i , int j, long[][] m,long[][] M, List<String> o) {
      long[] minMax = new long[2];
      long min = Long.MAX_VALUE;
      long max = Long.MIN_VALUE;
      for(int k=i;k<j;k++) {
        long a = eval(M[i][k],M[k+1][j],o.get(k));
        long b = eval(M[i][k],m[k+1][j],o.get(k));
        long c = eval(m[i][k],M[k+1][j],o.get(k));
        long d = eval(m[i][k],m[k+1][j],o.get(k));
        max = max(max,a,b,c,d);
        min = min(min,a,b,c,d);
      }
      minMax[0] = min;
      minMax[1] = max;
      return minMax;
    }
    
   private static long max(long ...a) {
      long max = Long.MIN_VALUE;    

      if ( a != null) {
        for (int i = 0; i < a.length; i++) {
          max = Math.max(max, a[i]);
        }
      }

      return max;
    }
   
   private static long min(long ...a) {
     long min = Long.MAX_VALUE;    

     if ( a != null) {
       for (int i = 0; i < a.length; i++) {
         min = Math.min(min, a[i]);
       }
     }

     return min;
   }
   
    
    private static long eval(long a, long b, String op) {
        if ("+".equals(op)) {
            return a + b;
        } else if ("-".equals(op)) {
            return a - b;
        } else if ("*".equals(op)) {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }
    
    private static List<Integer> getNumbers(String exp) {
    	Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(exp);
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(0);
        while(m.find()) {
        	numbers.add(Integer.parseInt(m.group()));
        }
        return numbers;
    }
    
    private static List<String> getOperators(String exp) {
    	Pattern p = Pattern.compile("[+*/-]");
        Matcher m = p.matcher(exp);
        List<String> operators = new ArrayList<String>();
        operators.add("");
        while(m.find()) {
        	operators.add(m.group());
        }
        return operators;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));        
        //System.out.println(max(7,1,0,-3,2,5));
    }
}

