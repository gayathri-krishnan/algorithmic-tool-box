import java.io.*;
import java.util.*;

public class FirstRepeatedWord {

    static String repeatedWord(String[] ar) {
    	Set<String> unique = new HashSet<>();
        

        for (int i = 0; i < ar.length; i++) {
            if (ar[i].trim().length()>0 && !unique.add(ar[i])) {                
                return ar[i];
            }
        }

        return "";

    }
/**
 * 5 1 5 8 12 13 
 * 5 8 1 23 1 11 
 * @param args
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s= s.replaceAll("\\.", " ");
        s= s.replaceAll(",", " ");
        s=         s.replaceAll("\t", " ");
        s=         s.replaceAll(":", " ");
        s=         s.replaceAll(";", " ");
        s=         s.replaceAll("-", " ");
        String[] ar = s.split(" ");
        System.out.println(repeatedWord(ar));
        
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
