package prg;

public class genericClass {
	
	public static void main(String[] args) {
		
		generics<String> str = new generics<String>("Java", "Python");
		str.disp();
		
		generics<Integer> int_data = new generics<Integer>(10,12);
		int_data.disp();
		
		
	}
	
}
