package week1.day2;

public class Looping {
	
	public static void run() {
		
		for (int i = 11;i > 0 ; i--) {
			System.out.println("walk the ring "+i);
		}
		
	}
	
	public static void walk() {
		
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday"};
		
		for (String eachDay : days) {
			System.out.println(eachDay);
		}
		
		for (int i = 0; i < days.length; i++) {
			System.out.println(days[i]);
		}
		
	}
	
	public static void eat() {
		int dosa = 1;
		boolean hunger = true;
		while(hunger) {
			System.out.println("eat");
			dosa++;
			if(dosa > 4) {
				hunger = false;
			}
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		eat();
	}

}
