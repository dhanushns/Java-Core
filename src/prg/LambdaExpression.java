package prg;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

interface sample{
	
	String name = "Java";
	
	static void infMethod() {
		System.out.println("static");
	}
	
	default void defMethod() {
		changeName();
		System.out.println("Default Method");
	}
	

	private void changeName() {
		System.out.println("Private method");
	}
	

	void display();
	
	int fun();
	
}

@FunctionalInterface
interface funInterface{
	
	default void m1() {
		System.out.println("m1");
	}
	
	default void m2() {
		System.out.println("m2");
	}
	
	static void s1() {
		System.out.println("s1");
	}
	
	abstract void display();
	
}

class A{
	
	String name = "Java";
	
	void getName() {
		System.out.println("Hello, " + this.name);
	}
	
}

public class LambdaExpression {

	public static void main(String[] args) {
		
		A obj = new A() {
			@Override
			public void getName() {
				System.out.println(this.name);
			}
		};
		
		obj.getName();
		
		sample s = new sample() {
			@Override
			public void display() {
				System.out.println("Display");
			}
			@Override
			public int fun() {
				return 0;
			}
		};
		
		s.display();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(20);
		list.add(10);
		
		list.forEach(n -> System.out.println(n));
		
		funInterface fun = ()->{
			A a = new A();
			a.getName();
		};
		
		fun.display();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				 System.out.println("Thread");
			}
		}).start();
		
		Runnable r = ()->System.out.println("Runnable Thread");
		new Thread(r).start();
		
		Consumer<List<Integer>> display = data -> data.forEach(n -> System.out.println(n));
		Consumer<List<Integer>> modify = data -> data.forEach(n -> {
			data.set(1, 50);
		});
		
		System.out.println("\n\nFunctionalInterface");
		//display.accept(list);
		modify.andThen(display).accept(list);
		
		Predicate<Integer> lessThen10 = i-> i<10;
		Predicate<Integer> moreThen10 = i-> i>10;
		
		list.forEach(n -> {
			if(lessThen10.or(moreThen10).test(n)) System.out.println("Predicate : " + n);
		});
		
		Function<List<Integer>, Integer> fun_ = li -> li.get(0);
		fun_ = fun_.andThen(a -> a*10);
		fun_ = fun_.compose(a -> list.reversed());
		System.out.println("Function : " + fun_.apply(list));
		
		list.stream().map(a-> a>15 ? a : 0).forEach(System.out::println);
		
		
	}
	


}
