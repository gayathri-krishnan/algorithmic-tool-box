import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ProxyServer {

   
/**
 * 5 1 5 8 12 13 
 * 5 8 1 23 1 11 
 * @param args
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String,Boolean> sites = new HashMap<>();       
        List<String> inputList = new ArrayList<String>();
        String s= scanner.nextLine();
        inputList.add(s);
        n--;
        while(n>0 && s!=null && s.length()>0 ) {
        	s= scanner.nextLine();
        	inputList.add(s);
        	n--;
        }
        
        for(String site: inputList) {        	
        	if(site.startsWith("+")) {
        		site = site.replace("+", "").trim();
        		if(site.length()>=2) {
        			sites.put(site.substring(0, 2),true);
        		}
        		
        	}else if(site.startsWith("-") ) {
        		site = site.replace("+", "").trim();
        		if(site.length()>=2) {
        			String prefix = site.substring(0, 2);
        			if(sites.get(prefix)==null || !sites.get(prefix))
        			sites.put(site.substring(0, 2),false);
        		}
        	}  
        }
        
        if(sites==null || sites.size()==0) {
        	System.out.println(-1);
        	
        	System.exit(0);
        }
        
        Map<String,Boolean> blockedSites = sites.entrySet() 
        .stream() 
        .filter(map -> !map.getValue()).collect(Collectors.toMap(map->map.getKey(),map->map.getValue()));
        
        if(blockedSites==null || blockedSites.size()==0) {
        	System.out.println(-1);
        	
        	System.exit(0);
        }
        System.out.println(blockedSites.size());
        for(String site: blockedSites.keySet()) {
        	System.out.println(site);
        }
        
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
