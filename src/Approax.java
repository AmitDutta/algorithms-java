import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class Approax {
    public static void main(String args[] ) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	Map<Integer, Set<Integer>> centers = new HashMap<Integer, Set<Integer>>();
    	Map<Integer, Boolean> items = new HashMap<Integer, Boolean>();
    	int n = sc.nextInt();
    	int p = 1;
    	while (p <= n){
    		int num = sc.nextInt();
    		int q = 1;
    		Set<Integer> itemsList = new HashSet<Integer>();
    		while (q <= num){
    			int item = sc.nextInt();
    			itemsList.add(item);
    			items.put(item, true);
    			q++;
    		}
    		centers.put(p, itemsList);
    		p++;
    	}
    	sc.close();
    	for (Integer data : items.keySet()){
    		for (Integer datacenter: centers.keySet()){
    			Set<Integer> itms = centers.get(datacenter);
    			if (!itms.contains(data)){
    				for (Integer datacenter2: centers.keySet()){
    					if (!datacenter2.equals(datacenter) && centers.get(datacenter2).contains(data)){
    						System.out.println(data + " " + datacenter2 + " " + datacenter);
    						itms.add(data);
    						break;
    					}
    				}
    			}
    		}
    	}
    	System.out.println("done");
    }
}