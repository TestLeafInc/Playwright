package week1.day2;

public class HelloWorld {
	
	{
		System.out.println("Hello block");
	}
	
	static {
		System.out.println("Hello static block");
	}
	
	public HelloWorld() {
		System.out.println("Hello constructor");
	}
	
	// main method 
	public static void main(String[] args) {
		
		System.out.println("Hello main");
	}

}
