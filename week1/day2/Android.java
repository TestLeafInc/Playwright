package week1.day2;

// interface cannot have constructor !

public interface Android {
	
	public void startPhone();
	
	/* Java 1.8 -> default and static */
	
	default void shutDown() {
		System.out.println("Shutting down by default");
	}
	
	static void playMusic() {
		
	}

}
