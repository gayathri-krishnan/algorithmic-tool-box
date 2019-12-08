import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import Solution.Container;

public class Solution {

    /*
     * Complete the function below.
     */
    static List<Container> createSchedule(List<Container> inContainers) {
    	
    	Object[] containerArr =  inContainers.toArray();
    	
		Container temp = null;
    	for(int i=containerArr.length-1;i>=0;i--) {
    		Container current = (Container) containerArr[i];
    		Container prev = (Container) containerArr[i-1];
    		if(current.isStackedDirectlyAboveInYard(prev)) {
    			//perfect
    			if(prev.isStackedDirectlyAboveOnShip(current) ){
    				//nothing to do
    			}else {
    				temp = ((Container)containerArr[i]);
    				containerArr[i] = (Container)containerArr[i-1];
    				containerArr[i-1] = temp;    				
    			}
    			
    		}
    	}
    	return inContainers;

    }

public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("c:\\out2.txt");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        } else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int inContainerDetails_rows = 0;
        int inContainerDetails_cols = 0;
        inContainerDetails_rows = Integer.parseInt(in.nextLine().trim());
        inContainerDetails_cols = Integer.parseInt(in.nextLine().trim());

        String[][] inContainerDetails = new String[inContainerDetails_rows][inContainerDetails_cols];
        for (int inContainerDetails_i = 0; inContainerDetails_i < inContainerDetails_rows; inContainerDetails_i++) {
            for (int inContainerDetails_j = 0; inContainerDetails_j < inContainerDetails_cols; inContainerDetails_j++) {
                inContainerDetails[inContainerDetails_i][inContainerDetails_j] = in.next();
            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        List<Container> containers = new ArrayList<>();
        for(String[] containerInfo : inContainerDetails){
            containers.add(new Container(containerInfo[0],containerInfo[1], containerInfo[2]));
        }
        List<Container> res = createSchedule(containers);
        for (int i = 0; i < res.size(); i++) {
            bw.write(String.valueOf(res.get(i)._id));
            bw.write("\t");
            bw.write(String.valueOf(res.get(i)._startPosition));
            bw.write("\t");
            bw.write(String.valueOf(res.get(i)._endPosition));
            bw.newLine();
        }

        bw.close();
    }

   static class Container {
        private String _id;
        private String _startPosition;
        private String _endPosition;

        Container(String inId, String inStartPosition, String inEndPosition) {
            _id = inId;
            _startPosition = inStartPosition;
            _endPosition = inEndPosition;
        }
        
        public char getStack() {
        	return _startPosition.charAt(0);
        }

        /**
         * checks if the inContainer is in the same stack as current container
         */
        private boolean inSameStackInYard(Container inContainer) {
            return _startPosition.charAt(0) == inContainer._startPosition.charAt(0);
        }

        /**
         * returns true if inContainer is above current container, false otherwise
         */
        public boolean isStackedDirectlyAboveInYard(Container inContainer) {
            if(!inSameStackInYard(inContainer)){
                return false;
            }
            int pos1 = Integer.valueOf(_startPosition.charAt(1));
            int pos2 = Integer.valueOf(inContainer._startPosition.charAt(1));
            return pos1-pos2 == 1 ? true : false;
        }

        private boolean inSameStackOnShip(Container inContainer){
            return _endPosition.charAt(0) == inContainer._endPosition.charAt(0);
        }

        /**
         * returns true if the inContainer has to be stacked directly above
         * the current container on the ship. return false otherwise
         */
        public boolean isStackedDirectlyAboveOnShip(Container inContainer){
            if(!inSameStackOnShip(inContainer)){
                return false;
            }
            int pos1 = Integer.valueOf(_endPosition.charAt(1));
            int pos2 = Integer.valueOf(inContainer._endPosition.charAt(1));
            return pos1 - pos2 == 1 ? true : false;
        }

        /**
         * returns the container id
         */
        public String getContainerId(){
            return _id;
        }
    }
}