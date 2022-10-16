package week1.day2;

public class OnePlus {
	
	/*
	 * 10R - 2022
	 * 9R - 2020
	 * 7T - 2018
	 * 5 - 2016
	 * 4 - 2015
	 * 
	 */
	
	public static void getModelNames(int year) {
		
		/*
		if(year < 2016) {
			System.out.println("Model is 4");
		} else if(year < 2018) {
			System.out.println("Model is 5");
		} else if(year < 2020) {
			System.out.println("Model is 7T");
		} else if(year < 2022) {
			System.out.println("Model is 9R");
		} else {
		} */
		
		// int or String
		switch (year) {
		case 2022:
			System.out.println("Model is 9R");
			break;
		case 2020:
			System.out.println("Model is 7T");
			break;
		case 2018:
			System.out.println("Model is 5");
			break;
		case 2016:
			System.out.println("Model is 4");
			break;
		default:
			break;
		}
		
		
	}
	
	public static void main(String[] args) {
		getModelNames(2022);
	}

}
