import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class WineTasting {
	private Map<Integer, Person> preferance;
	private BitTest bt;
	private int total;
	private class Person{
		byte items;
		int item1, item2, item3;
		int id;
		public Person(int id){
			this.id = id;
			items = 0;
			item1 = item2 = item3 = 0;
		}
	}
	public WineTasting(String path){		
		preferance = new HashMap<Integer, Person>();		
		bt = new BitTest();
		total = 0;
		BufferedReader br = null;		
		try{
			String line;
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			while((line = br.readLine()) != null){
				String[] parts = line.split("	");
				Integer pid = Integer.parseInt(parts[0].substring(6));
				int wid = Integer.parseInt(parts[1].substring(4));
				if (!preferance.containsKey(pid)){					
					Person person = new Person(pid);
					preferance.put(pid, person);
				}
				Person person = preferance.get(pid);				
				if (person.items < 3 && !bt.exists(wid)){
					if (person.item1 == 0) person.item1 = wid;
					else if (person.item2 == 0) person.item2 = wid;
					else person.item3 = wid;
					person.items++;
					total++;
					bt.add(wid);
				}
			}						
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if (br != null) br.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}		
	}
	public void printOutput(){
		for (Integer key : preferance.keySet()){
			Person person = preferance.get(key);
			for (int i = 1; i <= person.items; i++){
				int wine = i == 1 ? person.item1 : i == 2 ? person.item2 : person.item3;
				System.out.println("person" + key + "\t" + "wine" + wine);
			}
		}			
	}
	public int getTotalItemsSold(){ return total; }
	public static void main(String[] args){
		//String filePath = "/home/amit/Workspace/java-workspace/algortihms/person_wine_3.txt";
		long start = System.currentTimeMillis();
		WineTasting solver = new WineTasting(args[0]);
		System.out.println(System.currentTimeMillis() - start);
		System.out.println(solver.getTotalItemsSold());
		solver.printOutput();		
	}
}
