import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'mergeArrays' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
    // Write your code here;
    	Object[] a1 =  a.toArray();
    	Object[] b1 = b.toArray();
    	List<Integer> mergedList = new ArrayList<Integer>();
    	int i = 0 ,j = 0;
    	while (i<a1.length && j<b1.length) {
    		//compare first elements
    		if((Integer)a1[i]==(Integer)b1[j]) {
    			
    				mergedList.add((Integer)a1[i]);
        			mergedList.add((Integer)b1[j]);
        			i++;
        			j++;
    			
    			
    		}else if((Integer)a1[i]<(Integer)b1[j]) {
    			
    				mergedList.add((Integer)a1[i]);
        			i++;
    			
    			
    		}else {
    			
    				mergedList.add((Integer)b1[j]);
        			j++;
    			
    			
    		}
    	}
    	while(j<b1.length) {
    		mergedList.add((Integer)b1[j]);
    		j++;
    	}
    	while(i<a1.length) {
    		mergedList.add((Integer)a1[i]);
    		i++;
    	}
        return mergedList;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test2"));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> b = IntStream.range(0, bCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.mergeArrays(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
