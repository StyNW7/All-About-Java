package utility;

import java.util.Scanner;

public class Printing {
	
	Scanner scan = new Scanner(System.in);
	
	public void dashSpacing() {
		System.out.println("----------------------");
	}
	
	public void clickSpace() {
		System.out.println("Press enter to continue...\n");
		scan.nextLine();
	}

}
