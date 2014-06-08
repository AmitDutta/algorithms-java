public class KeyBoard {
 /* a, b, c, d, e, 
	f, g, h, i, j, 
	k, l, m, n, o 
	p, q, r, s, t 
	u, v, w, x, y 
	z*/
	private static boolean canMoveBetweenColumns(int cur_col, int dest_col, int cur_row){
		return (cur_row == 5 && cur_col == 0)  || cur_col == dest_col ? false : true;
	}
	private static boolean canMoveBetweenRows(int cur, int dest){
		boolean val = true;
		int distance = Math.abs(cur - dest);
		if (cur > 0 && distance >= 6) val = false;
		if (cur == dest) val = false;
		return val;
	}
	public static void printSequence(String str){
		int cur_row = 0;
		int cur_col = 0;
		String direction = "";
		for (int i = 0; i < str.length(); i++){
			int  dest_row = (str.charAt(i) - 97) / 5;
			int dest_col = (str.charAt(i) - 97) % 5;
			while (cur_row != dest_row || cur_col != dest_col){
				// first try row wise movement
				if (canMoveBetweenColumns(cur_col, dest_col, cur_row)){
					direction = cur_col > dest_col ? "Left" : "Right";					
					for (int j = 1; j <= Math.abs(cur_col - dest_col); j++){
						System.out.println(direction);
					}
					cur_col = dest_col;
				}
				if (canMoveBetweenRows(cur_row, dest_row)){
					direction = cur_row > dest_row ? "Up" : "Down";
					for (int j = 1; j <= Math.abs(cur_row - dest_row); j++){
						System.out.println(direction);
					}
					cur_row = dest_row;
				}
			}
			if (cur_row == dest_row && cur_col == dest_col){
				System.out.println("OK");
			}
		}		
	}
	public static void main(String[] args){
		printSequence("xyw");
	}
}
