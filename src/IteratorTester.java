
public class IteratorTester {
	private int[] array;
	public IteratorTester(int[] items){
		array = new int[items.length];
		for (int i = 0; i < items.length; i++) array[i] = items[i];
	}
	public IteratorWithPeek<Integer> getIterator() { return new SampleIterator(); }
	private class SampleIterator implements IteratorWithPeek<Integer>{
		private int i = 0;
		private int j = 0;
		@Override
		public boolean hasNext() {			
			return i != array.length;
		}

		@Override
		public Integer next() {
			return array[i++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Integer peek() {
			return array[i];
		}
	}
	public static void main(String[] args){
		IteratorTester tester = new IteratorTester(new int[]{1,2,3,4,5,6});
		IteratorWithPeek<Integer> it = tester.getIterator();
		while(it.hasNext()){
			System.out.println(it.peek());
			System.out.println(it.peek());
			System.out.println(it.next());
		}
	}
}
