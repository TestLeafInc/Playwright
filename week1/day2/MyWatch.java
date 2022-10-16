package week1.day2;

import static week1.day2.AppleWatch.*;

public class MyWatch {
	
	
	public static void main(String[] args) {
		
		// Call the AppleWatch -> Create Object
		// Syntax: ClassName Obj = new ClassName();
		AppleWatch myWatch = new AppleWatch();
		
		// call method. objectName.methodName();
		short heartBeat = myWatch.getHeartBeat(); // ctrl +2 followed by l
		System.out.println(heartBeat); // syso + ctrl + space
		
		// Call static variable
		// Syntax : ClassName.variable
		String brandName = AppleWatch.brandName;
		System.out.println(brandName);
		
		// Syntax: ClassName.methodName
		int batteryCharge = getBatteryCharge();
		System.out.println(batteryCharge);
		
		boolean charged = isCharged();
		
		// You can call static method from the class or interface
		Android.playMusic();
		
	}

}
