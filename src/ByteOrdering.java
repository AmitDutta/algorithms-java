import org.junit.*;

import static org.junit.Assert.*;

public class ByteOrdering {
	public int getMsb(byte b){
		return (((byte) 1) & (b >> 7));
	}
	public int getIndexRegular(byte[] a){
		int index = 0;
		while (index <= a.length - 2){
			if (index == a.length - 2 && getMsb(a[index]) == 1){
				break;
			}
			if (getMsb(a[index]) == 1) index += 2;
			else index++;
		}
		return index;
	}
	public int getIndexFromReverse(byte[] a){
		if (a.length == 1) return 0;
		int index = a.length - 2;
		int end = a.length -1;
		boolean haszero = false;
		while (index >= 0){
			if (getMsb(a[index]) == 0) {
				haszero = true;
				break;
			}
			index--;
		}
		if (!haszero){
			return a.length - 2; /*From right to left, all bytes start with 1; except possibly the last. Also, if it starts with 1, it has length at least two.*/
		}
		if (index < 0) return 0; 
		int diff = end - index + 1;
		if ((diff & 1) == 0) index = a.length -1;
		else index = a.length - 2;
		return index;
	}
	@Test
	public void isMsbOneTest(){
		assertEquals(1, getMsb((byte)255));
		assertEquals(1, getMsb((byte)128));
		assertEquals(1, getMsb((byte)129));
		assertEquals(1, getMsb((byte)193));
		assertEquals(0, getMsb((byte)4));
		assertEquals(0, getMsb((byte)0));
		assertEquals(0, getMsb((byte)100));
	}
	@Test
	public void getIndexRegularTest(){		
		assertEquals(0, getIndexRegular(new byte[] {(byte) 255, (byte) 255}));
		assertEquals(2, getIndexRegular(new byte[] {(byte) 255, (byte) 255, (byte) 255, (byte) 255}));
		assertEquals(2, getIndexRegular(new byte[] {(byte) 0, (byte) 0, (byte) 255, (byte) 255}));
		assertEquals(0, getIndexRegular(new byte[] {(byte) 0}));
		assertEquals(1, getIndexRegular(new byte[] {(byte) 0, (byte) 0}));
		assertEquals(5, getIndexRegular(new byte[] {(byte) 255, (byte) 0, (byte) 255, (byte) 0,  (byte) 0, (byte) 255, (byte) 0}));
	}
	@Test
	public void getIndexFromReverse(){
		assertEquals(2, getIndexFromReverse(new byte[] {(byte) 255, (byte) 0, (byte) 255, (byte) 0}));
		assertEquals(0, getIndexFromReverse(new byte[] {(byte) 255, (byte) 255}));
		assertEquals(2, getIndexFromReverse(new byte[] {(byte) 255, (byte) 255, (byte) 255, (byte) 255}));
		assertEquals(2, getIndexFromReverse(new byte[] {(byte) 0, (byte) 0, (byte) 255, (byte) 255}));
		assertEquals(0, getIndexFromReverse(new byte[] {(byte) 0}));
		assertEquals(1, getIndexFromReverse(new byte[] {(byte) 0, (byte) 0}));
		assertEquals(5, getIndexFromReverse(new byte[] {(byte) 255, (byte) 0, (byte) 255, (byte) 0,  (byte) 0, (byte) 255, (byte) 0}));
		assertEquals(6, getIndexFromReverse(new byte[] {(byte) 255, (byte) 0, (byte) 255, (byte) 255,  (byte) 255, (byte) 255, (byte) 0}));
		assertEquals(5, getIndexFromReverse(new byte[] {(byte) 0, (byte) 0, (byte) 0, (byte) 255,  (byte) 255, (byte) 255, (byte) 255}));
	}
}
