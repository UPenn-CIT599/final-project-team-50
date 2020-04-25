import java.util.Scanner;

public class UserInput {
	private int numberOfPeople;
	private int numberOfExits;
	private int floorSize;

	public UserInput() {
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public int getNumberOfExits() {
		return numberOfExits;
	}

	public int getFloorSize() {
		return floorSize;
	}

	public void setNumberOfPeople() {
		System.out.println("Please enter the number of people");
		Scanner people = new Scanner(System.in);
		int numOfPeople = people.nextInt();
		this.numberOfPeople = numOfPeople;
	}

	public void setNumberOfExit() {
		System.out.println("Please enter the number of exits");
		Scanner exits = new Scanner(System.in);
		int numOfExits = exits.nextInt();
		this.numberOfExits = numOfExits;

	}

	public void setFloorSize() {
		System.out.println("Please enter the size of floor");
		Scanner size = new Scanner(System.in);
		int floorSize = size.nextInt();
		this.floorSize = floorSize;
	}

}
