import java.util.HashMap;
import java.util.Map;

public class TaxiCab {
	private Map<Long, Tuple> map = new HashMap<Long, Tuple>();
	private class Tuple{
		private int item1;
		private int item2;
		public Tuple(int item1, int item2){
			this.item1 = item1;
			this.item2 = item2;
		}		
		public boolean equals(Object that){
			if (that == null) return false;
			Tuple other = (Tuple) that;
			return (item1 == other.item1 && item2 == other.item2) ||
					(item1 == other.item2 && item2 == other.item1);
		}
	}
	public long getCube(int i) { return i * i * i; }	
	public void calculate(int N){
		for (int i = 1; i <= N - 1; i++){
			for (int j = i; j <= N; j++){				
				long val1 = getCube(i) + getCube(j);				
				Tuple pair = new Tuple(i, j);
				if (!map.containsKey(val1)){
					map.put(val1, pair);
				}else{					
					if(!pair.equals(map.get(val1))){
						System.out.println(val1 + " " + i + " " + j + " " + map.get(val1).item1 + " " + map.get(val1).item2);
					}					
				}
			}
		}
	}
	public static void main(String[] args){	
		new TaxiCab().calculate(1000);
	}
}
