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



class Result3 {

    /*
     * Complete the 'zeros' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int zeros(int n) {
    	// Write your code here
    	int val = n;
    	double prod = 1;
    	while(val>0) {
    		prod = prod * val ;
    		val--;
    	}
    	val = n;
    	while(val>0) {
    		Double q = prod/Math.pow(10,val);
    		if (q - Math.floor(q) == 0){
    			return val;
    		}
    		val--;
    	}
    	return 0;
    }

}
final String fileName = System.getenv("OUTPUT_PATH");

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test3"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result3.zeros(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
