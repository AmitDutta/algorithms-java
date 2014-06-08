public class BitTest {
	private byte[] array;
	private int row = Integer.MAX_VALUE;
	private int col = 8;
	public BitTest(){
		array = new byte[row/8];
	}
	public void add(int number){
		array[number/col] |= (1 << (number%col)); 
	}
	public boolean exists(int number){
		byte val = (byte) (array[number/col] & (1 << (number%col)));
		return val == 0 ? false : true;
	}
}
