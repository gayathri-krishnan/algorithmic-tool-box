import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * 
 * @author WEL
2
4 5
UPDATE 2 2 2 4
QUERY 1 1 1 3 3 3
UPDATE 1 1 1 23
QUERY 2 2 2 4 4 4
QUERY 1 1 1 3 3 3
2 4
UPDATE 2 2 2 1
QUERY 1 1 1 1 1 1
QUERY 1 1 1 2 2 2 
QUERY 2 2 2 2 2 2

 */

public class Solution_1 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	Solution_1 a = new Solution_1();
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        List<TestCase> testCaseList = new ArrayList<TestCase>();
        for(int i=0;i<testCases;i++) {
        	Solution_1.TestCase testCase = a.new TestCase();
        	String secondLine = in.nextLine();
            String[] secondLineElems = secondLine.split("\\s");
            int cubeSize = Integer.parseInt(secondLineElems[0]);
            int commandSize = Integer.parseInt(secondLineElems[1]);
            testCase.setCubeSize(cubeSize);
            testCase.setCommandSize(commandSize);
            
            List<String> commands = new ArrayList<String>();
            for(int j=0;j<commandSize;j++) {
            	commands.add(in.nextLine());            	
            }
            testCase.setCommands(commands);   
            //Create a map having non zero elements
            Map<Solution_1.Location,Integer> nonZeroElements = new HashMap<Solution_1.Location,Integer>();
            for(String command: commands) {
            	String[] commandElems = command.split("\\s");
            	//UPDATE 2 2 2 4            	
            	if("UPDATE".equalsIgnoreCase(commandElems[0])) {
            		if(commandElems.length!=5) {            			
            			throw new Exception("Insufficient Input");
            		}
            			
            		int x = Integer.parseInt(commandElems[1]);
            		int y = Integer.parseInt(commandElems[2]);
            		int z = Integer.parseInt(commandElems[3]);
            		
            		Solution_1.Location loc = a.new Location(x,y,z);            		
            		nonZeroElements.put(loc, Integer.parseInt(commandElems[4]));
            		//System.out.println(commandElems[4]);
            	}
            	//QUERY 1 1 1 2 2 2 4
            	if("QUERY".equalsIgnoreCase(commandElems[0])) {
            		if(commandElems.length!=7) { 
            			
            			throw new Exception("Insufficient Input");
            		}
            		int x1 = Integer.parseInt(commandElems[1]);
            		int y1 = Integer.parseInt(commandElems[2]);
            		int z1 = Integer.parseInt(commandElems[3]);
            		
            		int x2 = Integer.parseInt(commandElems[4]);
            		int y2 = Integer.parseInt(commandElems[5]);
            		int z2 = Integer.parseInt(commandElems[6]);            		
            		List<Integer> vals = new ArrayList<Integer>();
            		nonZeroElements.forEach((k, v) -> {
            			if(k.getX()>=x1 && k.getY()>=y1 && k.getZ()>=z1 &&
            					k.getX()<=x2 && k.getY()<=y2 && k.getZ()<=z2) {
            				 vals.add(v);
            			}
            		});
            		int sum = 0;
            		for(Integer v: vals) {
            			sum += v.intValue();
            		}
            		System.out.println(sum);
            	}
            }
            
            
            testCaseList.add(testCase);
        }        
    }
    
    class TestCase{
    	private int commandSize;
    	public int getCommandSize() {
			return commandSize;
		}
		public void setCommandSize(int commandSize) {
			this.commandSize = commandSize;
		}
		private int cubeSize;
    	public int getCubeSize() {
			return cubeSize;
		}
		public void setCubeSize(int cubeSize) {
			this.cubeSize = cubeSize;
		}
		public List<String> getCommands() {
			return commands;
		}
		public void setCommands(List<String> commands) {
			this.commands = commands;
		}
		List<String> commands;
    }
    
    class Location{
    	private int x;
    	public int getX() {
			return x;
		}
		public Location(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getZ() {
			return z;
		}
		public void setZ(int z) {
			this.z = z;
		}
		private int y;
    	private int z;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			result = prime * result + z;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Location other = (Location) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			if (z != other.z)
				return false;
			return true;
		}
		private Solution_1 getOuterType() {
			return Solution_1.this;
		}
    	
    }
}