package hr.fer.oop.hiding_overriding;

class A {
	static void stat() { 
		System.out.println("A.m"); 
	}
	void virt() 	{ 
		stat(); 
		A.stat(); 
	}
}
class B extends A {
	static void stat() { 
		System.out.println("B.m"); 
	}
	void virt() { 
		stat(); 
		A.stat(); 
		B.stat(); 
	}
}

public class Main {

	public static void main(String[] args) {
		A aa = new A();	
		System.out.println("calling aa.stat():");
		aa.stat();
		System.out.println("calling aa.virt():");
		aa.virt();
		B bb = new B();
		System.out.println("calling bb.stat():");
		bb.stat();
		System.out.println("calling bb.virt():");
		bb.virt();
		A ab = new B();
		System.out.println("calling ab.stat():");
		ab.stat();
		System.out.println("calling ab.virt():");
		ab.virt();

	}

}


