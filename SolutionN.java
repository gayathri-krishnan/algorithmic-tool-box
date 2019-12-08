import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;

public class SolutionN {
   

    /**
     * This method should return a List of containers of size m such that their cumulative score is maxuimum
     * @param inContainers list of containers
     * @param m number of containers which have to be moved to the ship
     * @return List of containers with max cumulative score
     */
    static List<Container> findContainers(List<Container> inContainers, int m) {
    	List<Container> containers = new ArrayList<Container>();
    	Comparator<Container> byStack = 
    			(Container o1, Container o2)->{if(o1.getStackIndex()>o2.getStackIndex()) return 1 ; return -1;};
    	Comparator<Container> byTierDesc = 
    			(Container o1, Container o2)->{if(o2.getTierIndex()>o1.getTierIndex()) return 1 ; return -1;};
    	Comparator<Container> byScoreDesc = 
    	    			(Container o1, Container o2)->{if(o2.getScore()>o1.getScore()) return 1 ; return -1;};    			
    	ContainerChainedComparator chainedComparator = new ContainerChainedComparator(byTierDesc,byScoreDesc);
    	Collections.sort(inContainers, byStack);
    	Collections.sort(inContainers, chainedComparator);
    	int i =0;
    	for(Container container:inContainers) {
    		if(i<m) {
    			containers.add(container);
    			i++;
    		}    		
    	}

        return containers;
    }
    
    static class ContainerChainedComparator implements Comparator<Container> {
    	 
        private List<Comparator<Container>> listComparators;
     
        @SafeVarargs
        public ContainerChainedComparator(Comparator<Container>... comparators) {
            this.listComparators = Arrays.asList(comparators);
        }
     
        @Override
        public int compare(Container o1, Container o2) {
            for (Comparator<Container> comparator : listComparators) {
                int result = comparator.compare(o1, o2);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("c:\\OUTPUT.txt");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        } else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        
        int numOfContainersOnShip = Integer.parseInt(in.nextLine().trim());

        int inContainerDetails_rows = 0;
        int inContainerDetails_cols = 4;
        inContainerDetails_rows = Integer.parseInt(in.nextLine().trim());

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
        for (String[] containerInfo : inContainerDetails) {
            String id = containerInfo[0];
            int tierIndex = Integer.parseInt(containerInfo[2].trim());
            int stackIndex = Integer.parseInt(containerInfo[1].trim());
            int score = Integer.parseInt(containerInfo[3].trim());
            containers.add(new Container(id, tierIndex, stackIndex, score));
        }
        List<Container> res = findContainers(containers, numOfContainersOnShip);
        if(res != null){
            for (int i = 0; i < res.size(); i++) {
                bw.write(String.valueOf(res.get(i)._id));
                bw.write("\t");
                bw.write(String.valueOf(res.get(i)._tierIndex));
                bw.write("\t");
                bw.write(String.valueOf(res.get(i)._stackIndex));
                bw.write("\t");
                bw.write(String.valueOf(res.get(i)._score));
                bw.newLine();
            }
        }
        bw.close();
    }

    static class Container{
        final String _id;
        final int _tierIndex;
        final int _stackIndex;
        final int _score;

        public Container(String _id, int _tierIndex, int _stackIndex, int _score) {
            this._id = _id;
            this._tierIndex = _tierIndex;
            this._stackIndex = _stackIndex;
            this._score = _score;
        }
        
        public int getTierIndex() {
            return _tierIndex;
        }
        
        public int getStackIndex() {
            return _stackIndex;
        }
        
        public int getScore() {
            return _score;
        }
        
    }
}
