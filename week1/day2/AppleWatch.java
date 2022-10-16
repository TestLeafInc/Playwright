package week1.day2;

public class AppleWatch {
	
	
	// static - variable !!
	public static String brandName = "apple";
	
	// features -> show time, get heart rate, send sms --> method
	// property -> color, size  --> variable 
	
	// variable signature 
	// access_modifier data_type variable_name = value
	protected String color = "Black";
	char size = 'M';
	
	/* Access Modifiers */
	// if not mentioned -> default !!
	// default -> only accessed by the package
	// public --> everyone can access 
	// private --> only the class can access
	// protected -> same package + inherited classes (extends)
	
	/* Data Types */
	
	/* Primitive Data Type */
	// short (age) 
	// int   (kilometers)
	// long  (phone number)
	// boolean (did it happen?)
	// char (initial)
	// float (1.28f)
	// double (3.3333333)
	
	/* Non Primitive Data Type */
	// String
	// Arrays, List, Set, Map
	
	
	// method signature 
	// access_modifier data_type method_name(argument)
	
	
	public String getTime() {
		return "10:00 AM";
	}
	
	// return -> keyword return the value
	
	
	protected short getHeartBeat() {
		return 70;
	}
	
	
	// constructor 
	// method name = class name
	// it does not have return type !
	// when constructor invoked when you create object
	public AppleWatch() { // zero argument -> default constructor.
		//System.out.println("Booting apple watch");
		this("5 Series");
	}
	
	// Constructors are used to perform a launching activity when you create object
	
	public AppleWatch(String which) { // one argument -> overloaded constructor.
		System.out.println("Booting apple watch "+which);
	}
	
	
	public static int getBatteryCharge() {
		return 74;
	}
	
	public static boolean isCharged() {
		return false;
	}
	
	
	
	
	
	
	
	
	
	

}
