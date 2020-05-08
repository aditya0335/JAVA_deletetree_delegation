// ASSIGNMENT 1 - PART 2


 class Delegation {
	
	public static void main(String args[]) {
		B b = new B();
		System.out.println(b.f()+b.g()-b.p(1)+b.q(2));
		
		B2 b2 = new B2();
		System.out.println(b2.f()+b2.g()-b2.p(1)+b2.q(2));
		
		D d = new D();
		System.out.println(d.f()+d.g()-d.h()+d.p(1)-d.q(2)+d.r());
		
		D2 d2 = new D2();
		System.out.println(d2.f()+d2.g()-d2.h()+d2.p(1)-d2.q(2)+d2.r());	
		
	}
}
 
 class Delegation2 {
		
	public static void main(String args[]) {
		
		E e = new E();
		System.out.println(e.f()-e.g()+e.h()-e.p(1)+e.q(2)-e.r()+e.k(100));
		
		E2 e2 = new E2();
		System.out.println(e2.f()-e2.g()+e2.h()-e2.p(1)+e2.q(2)-e2.r()+e2.k(100));

		F f = new F();
		System.out.println(f.f()+f.g()+f.h()+f.p(1)-f.q(2)-f.r()-f.j(10)+f.l(100));
		
		F2 f2 = new F2();
		System.out.println(f2.f()+f2.g()+f2.h()+f2.p(1)-f2.q(2)-f2.r()-f2.j(10)+f2.l(100));		
	}
}
 
 
abstract class A {
	int a1 = 100;
	int a2 = 200;

	public int f() {
		return a1 + p(100) + q(100);
	}

	protected abstract int p(int m);

	protected abstract int q(int m);
}

class B extends A {
	int b1 = 1000;
	int b2 = 2000;

	public int g() {
		return this.p(100) + this.q(200); 
	}

	public int p(int m) {
		return m + a1+b1;
	}

	public int q(int m) {
		return m + a2+b2;
	}
}

abstract class C extends B {
	int c1 = 10000;
	int c2 = 20000;

	public int r() {
		return f() + g() + h();
	}

	public int q(int m) {
		return m + a2 + b2 + c2;
	}

	protected abstract int h();
}

class D extends C {
	int d1 = 1000000;
	int d2 = 2000000;

	public int r() {
		return f() + g() + h();
	}

	public int p(int m) {
		return super.p(m) + d2;
	}

	public int h() {
		return a1 + b1 + c1;
	}
	
	public int j(int n) {
		return r() + super.r();
	}

}

class E extends C {
	int e1 = 1;
	int e2 = 2;

	public int q(int m) {
		return p(m) + c2;
	}

	public int h() {
		return a1 + b1 + e1;
	}
	
	public int k(int n) {
		return q(n) + super.q(n);
	}

}

class F extends D {
	int f1 = 10;
	int f2 = 20;

	public int q(int m) {
		return p(m) + c1 + d1;
	}

	public int h() {
		return c2 + f2;
	}
	
	public int l(int n) {
		return q(n) + super.q(n);
	}
}



// ===== TRANSFORMATION IN TERMS OF DELEGATION ======



// INTERFACES

interface IA {
	
	public int f();
	public int p(int m);
    public int q(int m);
}

interface IB extends IA {
	public int g();
}

interface IC extends IB {
	public int r();
	public int h();
}

interface ID extends IC {
	public int j(int n);
}

interface IE extends IC {
	public int k(int n);
}

interface IF extends ID {
	public int l(int n);
}

//CLASSES 

class A2 implements IA {
	int a1 = 100;
	int a2 = 200;
    
	public A2(IB p)
	{B_sub= p;}
	IB B_sub;
	
	@Override
	public int f() {
		return a1 + p(100) + q(100);
	}

	@Override
	public int p(int m) {
		return B_sub.p(m);
	}

	@Override
	public int q(int m) {
		return B_sub.q(m);
	}
	
}

class B2 implements IB {
	int b1 = 1000;
	int b2 = 2000;
	public B2() {
		A_super = new A2(this);
		C_sub= this;
	}
     A2 A_super;
     
     public B2(IC p)
 	{C_sub=p;
 	A_super=new A2(C_sub);
 	}
     IB C_sub;
     
     
	@Override
	public int f() {
		return A_super.f();
	}

	@Override
	public int p(int m) {
	
		return m + A_super.a1 + b1;
}
	

	@Override
	public int q(int m) {
		
		return m + A_super.a2 + b2;
	}

	@Override
	public int g() {
		
		return C_sub.p(100) + C_sub.q(200); 
		
	}
}

class C2 implements IC {
	int c1 = 10000;
	int c2 = 20000;
	
	
	B2 B_super;
	public C2(IC ID_sub)
	{DE_sub=ID_sub;
	B_super=new B2(DE_sub);}
	
	
	IC DE_sub;
     
	@Override
	public int g() {
		
		return B_super.g() ;
	}

	@Override
	public int f() {
		
		return B_super.f();
	}

	@Override
	public int p(int m) {
		
		return B_super.p(m);
	}

	@Override
	public int q(int m) {
	
		return m + B_super.A_super.a2 + B_super.b2 + c2;
	}

	@Override
	public int r() {
		
		return f() + g() +h();
	}

	@Override
	public int h() {
		return DE_sub.h();
		
	}
}

class D2 implements ID {
	int d1 = 1000000;
	int d2 = 2000000;
	
	public D2() {
		C_super = new C2(this);
		F_sub=this;}
	C2 C_super;
	public D2(IF p)
 	{F_sub=p;
 	C_super=new C2(F_sub);}
     ID F_sub;
     
	@Override
	public int r() {
		
		return f() + g() + F_sub.h();
	}

	@Override
	public int h() {
		return C_super.B_super.A_super.a1 + C_super.B_super.b1 + C_super.c1;
	}

	@Override
	public int g() {
		return C_super.g();
	}

	@Override
	public int f() {
		return C_super.f();
		
	}

	@Override
	public int p(int m) {
		return C_super.p(m) + d2;
	}

	@Override
	public int q(int m) {
		return C_super.q(m);
	}

	@Override
	public int j(int n) {
		return r() + C_super.r();
	}
}

class E2 implements IE {
	int e1 = 1;
	int e2 = 2;
	public E2() {
		C2_super = new C2(this);}
	C2 C2_super;
	@Override
	public int r() {
	
		return C2_super.r();
	}

	@Override
	public int h() {
		
		return C2_super.B_super.A_super.a1 + C2_super.B_super.b1 + e1;
	}

	@Override
	public int g () {
		return C2_super.g();
	}

	@Override
	public int f() {
		return C2_super.f();
	}

	@Override
	public int p(int m) {
		return C2_super.p(m);
	}

	@Override
	public int q(int m) {
		return C2_super.q(m);
	}

	@Override
	public int k(int n) {
		return q(n) + C2_super.q(n);
	}
}

class F2 implements IF {
	int f1 = 10;
	int f2 = 20;
	public F2() {
		D_super = new D2(this);}
	D2 D_super;
	@Override
	public int j(int n) {
		return D_super.j(n);
	}

	@Override
	public int r() {
		return D_super.r();
	}

	@Override
	public int h() {
		return D_super.C_super.c2 + f2;
	}

	@Override
	public int g() {
		return D_super.g();
	}

	@Override
	public int f() {
		return D_super.f();
	}

	@Override
	public int p(int m) {
		return D_super.p(m);
	}

	@Override
	public int q(int m) {
		return p(m) + D_super.C_super.c1 + D_super.d1;
	}

	@Override
	public int l(int n) {
		return q(n) + D_super.q(n);
	}
}

