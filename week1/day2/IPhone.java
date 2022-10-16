package week1.day2;

public class IPhone {
	
	public boolean isCharged = true;
	private String faceId = "Babu";
	
	public void makeCall(String name) {
		System.out.println("Called "+name);
	}
	
	boolean unlock(int code) {
		System.out.println("unlocked using "+code);
		return true;
	}
	
	protected String getPhoneColor(String model) {
		return "white";
	}

}
