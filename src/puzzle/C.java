package puzzle;

import java.util.ArrayList;
import java.util.List;

public class C extends B {
	
	public static void test(MyCollection<A> obj) {
	}
	
	public static void test1(MyCollection<? extends A> obj) {
		// covariance
	}
	
	public static void test2(MyCollection<C> obj) {
		
	}
	
	public static void test3(MyCollection<? super C> obj) {
		//contravariance
	}
	
	public static void main(String[] s) {
		test(new MyCollection<A>(new A()));
		// test(new MyCollection<B>(new B())); // won't compile B extends A, but that
		//does not mean MyCollection<B> extends Mycollection <A>
		
		test1(new MyCollection<B>(new B())); // works dues to covariance
		
		//test2(new MyCollection<B>(new B())); // won't compile C extends 
		test3(new MyCollection<A>(new A()));
		test3(new MyCollection<B>(new B()));
	}
}
