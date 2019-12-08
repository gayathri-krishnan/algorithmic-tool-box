import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Snippet {

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
        char[] ar = s.toCharArray();
        int oneCount = 0;
        int zeroCount = 0;
        List<String> magicalList = new ArrayList<String>();
        String magical = "";
        for(int i=0;i<ar.length;i++) {
        	if(ar[i]=='1') {
        		oneCount++;
        	}else {
        		zeroCount++;
        	}
        	
        	if(oneCount==zeroCount) {
        		//check prefix
        		if(charCount(magical,"1")>charCount(magical,"0") && charCount(magical,"0")>0) {
        			//indeed magical
        			magicalList.add(magical + ar[i]);
        			oneCount = 0;
        			zeroCount = 0;
        			magical = "";
        		}
        	}
        	magical = magical + ar[i];
        	if(magical.length()>0) {
        		magical = s;
        		magicalList = new ArrayList<String>();
        		magicalList.add(magical);
        	}
        }
        
        //find permutation and combination
        Map<Integer ,String > decMap = new TreeMap<Integer,String>(Collections.reverseOrder());
        for(String binary:magicalList) {
        	int num = Integer.parseInt(binary,2);
        	decMap.put(num, binary);
        }
        String biggestMagicalNumber = "";
        //Biggest Magical number
        for(Entry<Integer, String> magicNumber:decMap.entrySet()) {
        	biggestMagicalNumber = biggestMagicalNumber + magicNumber.getValue();
        }
        System.out.println(biggestMagicalNumber);
    }
    
    private static int charCount(String in, String count){
        String replace = "1".equals(count)?"0":"1";
        in = in.replace(replace,"");
        return in.length();
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
