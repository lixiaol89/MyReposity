package datamove.testitem;

public class A {
	
	private static B b1 = new B();
	static{
		System.out.println("A : " + b1);
	}
	
	private String a;
	
	public final String ac = "qq";
	
	private int b;
	
	private String c;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

//	@Override
//	public boolean equals(Object obj) {
//		A o = (A) obj;
//		return this.a.equals(o.getA())&&this.b==o.getB();
//	}
//	
//	@Override
//	public int hashCode() {
//		int result = 17;
//		result = 31*result +this.a.hashCode();
//		result = 31*result + this.b;
//		return result;
//	}
}


class B extends A{
	
	private static B b1 = new B();
	
	static{
		System.out.println("B : " + b1);
	}
}
