package prg;

public class EnumClass {
	
	public enum light{
		
		RED(10),GREEN(20),YELLOW(30);
		
		private int time;
		
		light(int time){
			this.time = time;
		}
		
		int getTime(){
			return this.time;
		}

		
	}
	
	public static void main(String[] args) {
		
		light l = light.YELLOW;
		System.out.println(l.getTime());
		
	}
	
}
