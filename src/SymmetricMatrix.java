public class SymmetricMatrix {	
	private int[] store;
	private int n;
	public SymmetricMatrix(int[][] original){
		this. n = original.length;		
		store = new int[(n*(n+1))/2];
		save(original);
	}
	private void save(int[][] original){
		int step = 1;
		int flag = 0;
		int index = 0;
		for (int i = 0; i < original.length; i++){
			for (int j = 0; j <= i; j++){
				index = ((i * n) + j) - flag;
				store[index] = original[i][j];
			}
			flag += n - step;
			step++;
		}
	}	
	public int[] getOneDimensionalArray(){
		int len = (n*(n+1))/2;
		int[] ret = new int[len];
		System.arraycopy(store, 0, ret, 0, len);
		return ret;
	}
	public void add(){
		int len = (n*(n+1))/2;
		int[] output = new int[len];
		for (int i= 0; i < len; i++)output[i] = store[i] + store[i];
		int[][] result = new int[n][n];
		int step = 1;
		int flag = 0;
		int index = 0;
		for(int i = 0; i < n; i++){
			for (int j = 0; j <= i; j++){
				index = ((i * n) + j) - flag;
				result[i][j] = result[j][i] = output[index];
			}
			flag += n - step;
			step++;
		}
		
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		int[][] array = {{1,2,3,4},
				{2,5,9,8},
				{3,9,6,2},
				{4,8,2,7}};
		SymmetricMatrix mat = new SymmetricMatrix(array);
		int[] output = mat.getOneDimensionalArray();
		/*for (int i = 0; i < output.length; i++){
			System.out.print(output[i] + " ");
		}*/
		mat.add();
		System.out.println();
		
		int[][] array2 = {{1,2,3},
				{2,4,8},
				{3,8,5}};
		mat = new SymmetricMatrix(array2);
		output = mat.getOneDimensionalArray();
		mat.add();
		/*for (int i = 0; i < output.length; i++){
			System.out.print(output[i] + " ");
		}*/
	}
}
