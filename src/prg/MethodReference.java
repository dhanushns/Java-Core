package prg;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

class method_sample{
	
	public static void display(int n) {
		
		System.out.println("static ref : " + n);
		
	}
	
	public void display_num(int n) {
		System.out.println("non-static object ref : " + n);
	}
	
	
	public static void name_display(String name) {
		
		System.out.println("Arbitary Object : " + name);
		
	}
	
	private String name;
	
	method_sample(){
		this.name = "Default";
	}
	
	method_sample(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person {"
				+ "name : " + this.name
				+ "}";
	}

	
	
}

public class MethodReference {
	
	
	public static void main(String[] args) {
		
		int[] numbers = {1,2,3,45,35,};
		
		String[] names = {
				"java",
				"python",
				"sql",
				"angular"
		};
		
		//static reference
		Arrays.stream(numbers).forEach(method_sample::display);
		
		//method reference of object
		method_sample ms = new method_sample();
		Arrays.stream(numbers).forEach(ms::display_num);
		
		//Reference to an Instance Method of an Arbitrary Object of a Particular Type
		Arrays.stream(names).map(String::toUpperCase).forEach(method_sample::name_display);
		
		Supplier<method_sample> p = method_sample::new;
		
		Supplier<String> getCode = () -> "My CODE";
		
		method_sample mp = p.get();
		System.out.println(mp);
		
		Function<String, method_sample> fun = method_sample::new;
		method_sample ms2 = fun.apply("Dhanush");
		System.out.println(ms2);
		System.out.println(getCode.get());
		
	}
	
}
