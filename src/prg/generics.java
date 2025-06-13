package prg;

public class generics<T> {
	
	T a,b;
	
	generics(T a, T b){
		this.a = a;
		this.b = b;
	}
	
	public void disp() {
		
		System.out.println(this.a);
		
	}
	
	
}
