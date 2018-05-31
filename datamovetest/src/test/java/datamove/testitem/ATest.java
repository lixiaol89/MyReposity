package datamove.testitem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ATest {

	public static void main(String[] args) {
		new B();
		A a1 = new A();
		a1.setA("a");
		a1.setB(1);
		a1.setC("c");
		A a2 = new A();
		a2.setA("a");
		a2.setB(1);
		a2.setC("cc");
		A a3 = new A();
		a3.setA("bc");
		a3.setB(1);
		a3.setC("cc");
		A a4 = new A();
		a4.setA("a");
		a4.setB(1);
		a4.setC("cc");
		A a5 = new A();
		a5.setA("b");
		a5.setB(3);
		a5.setC("cc");
		List<A> aa = new ArrayList<>();
		aa.add(a1);
		aa.add(a2);
		aa.add(a3);
		List<A> ab = new ArrayList<>();
		ab.add(a1);
		ab.add(a2);
		ab.add(a3);
		List<A> ba = new ArrayList<>();
		ba.add(a4);
		ba.add(a5);
		List<A> bb = new ArrayList<>();
		bb.add(a4);
		bb.add(a5);
		for(A a:aa){
			System.out.println(a.getA());
		}
		System.out.println("===");
		for(A a:ba){
			System.out.println(a.getA());
		}
		System.out.println("===");
		aa.removeAll(ba);
		for(A a:aa){
			System.out.println(a.getA());
		}
		System.out.println("===");
		ba.removeAll(ab);
		for(A a:ba){
			System.out.println(a.getA());
		}
		
		Map<A,String> map = new HashMap<>();
		map.put(a1, a1.getA());
		map.put(a2, a2.getA());
		map.put(a3, a3.getA());
		map.put(a4, a4.getA());
		map.put(a5, a5.getA());
		Set<Entry<A, String>> en = map.entrySet();
		for(Entry<A, String> e : en){
			A d = e.getKey();
			String v = e.getValue();
			System.out.println(d.getA()+"=-="+v);
		}
	}
}
