import java.io.*;
import java.util.*;

public class CountingValley {

    static int countingValley(int n, String s) {
    	
               
        int v = 0;     // # of valleys
        int lvl = 0;   // current level
        for(char c : s.toCharArray()){
            if(c == 'U') ++lvl;
            if(c == 'D') --lvl;
            
            // if we just came UP to sea level
            if(lvl == 0 && c == 'U')
                ++v;
        }

        return v;

    }
/**
 * 5 1 5 8 12 13 
 * 5 8 1 23 1 11 
 * @param args
 */
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(countingValley(n, s));
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
