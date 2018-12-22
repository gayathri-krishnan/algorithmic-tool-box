import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
    	if(capacity==0) {
    		return 0;
    	}
        double value = 0;
        int number = values.length;
        //write your code here
        Map<Double, Integer> map = new TreeMap<Double, Integer>(Collections.reverseOrder());
        
        for(int i=0;i<number;i++) {
        	if(values[i]>0 && weights[i]>0)
        		map.put((double)values[i]/weights[i],i);
        }
     // Iterate over them
        for (Entry<Double, Integer> entry : map.entrySet()) {
            //System.out.println(entry.getKey() + " => " + entry.getValue());
            int index = entry.getValue();
            double vByW = entry.getKey();
            
            if(weights[index]>=capacity) {
            	
            	value = value + capacity*vByW;
            	break;
            }else {
            	capacity = capacity - weights[index];
            	value = value + values[index];
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();       
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
