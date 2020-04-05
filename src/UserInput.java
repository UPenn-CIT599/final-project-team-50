import java.util.Scanner;

public class UserInput {

	public int numberOfPeople() {

		System.out.println("Please enter the number of people");
		Scanner people = new Scanner(System.in);
		int NumofPeople = people.nextInt();
		return NumofPeople;
	}

	public int numberOfExit() {
		System.out.println("Please entern the number of exits");
		Scanner exits = new Scanner(System.in);
		int NumofExits = exits.nextInt();
		return NumofExits;

	}

}
