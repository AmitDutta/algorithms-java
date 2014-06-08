import java.util.BitSet;

public class BitDivide {
	private BitSet[] bitSets = null;
	private int rows = 0;
	private int cols = 0;
	public BitDivide(int totalNumbers, int cols){
		this.cols = cols;
		rows = (int) Math.ceil(totalNumbers/cols);
		bitSets = new BitSet[rows];
		for (int i = 0; i < rows; i++){
			bitSets[i] = new BitSet(cols);
		}
	}
	public int getRowIndex(int number) { return number / cols; }
	public int getColIndex1(int number) { return number % cols;}
	public int getColIndex2(int number) { return number - (getRowIndex(number) * cols);}
	public void put(int number) throws ArrayIndexOutOfBoundsException{		
		bitSets[getRowIndex(number)].set(getColIndex1(number));
	}
	public boolean exists(int number){
		return bitSets[getRowIndex(number)].get(getColIndex1(number));
	}
	public BitSet[] getbitSets() { return bitSets; }	
}
