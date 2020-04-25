/**
 * @author feihan The class tracks location,speed, direction of a person
 */

public class Person implements Comparable<Person> {

	private int[] initialLocation = new int[2];// two numbers to track ppl's initial location (row and column axis)
	private int[] currentLocation = new int[2];
	private Integer distanceToExit;

	public void setDistanceToExit(Integer distanceToExit) {
		this.distanceToExit = distanceToExit;
	}

	public int[] getInitialLocation() {
		return this.initialLocation;
	}

	public Integer getDistanceToExit() {
		return distanceToExit;
	}

	public int compareTo(Person p) {
		return this.getDistanceToExit().compareTo(p.getDistanceToExit());
	}

	public int[] getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(int r, int c) {
		this.currentLocation[0] = r;
		this.currentLocation[1] = c;
	}

	// constructor
	Person(int[] initialLocation) {

		this.initialLocation = initialLocation;
		this.currentLocation = initialLocation;
		this.distanceToExit = 0;

	}

}
	
	
