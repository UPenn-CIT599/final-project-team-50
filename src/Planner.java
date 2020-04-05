
import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yao16
 * Assumption: 1. the person closer to an exit will move first
 * 			   2. the move speed of each person are same
 */
public class Planner {
	private FloorPlan floor;
	private UserInput userDefine;
	
	public Planner(FloorPlan f) {
		floor = f;
	}
	
	/**using BREADTH-FIRST SEARCH
	 * @param location of exit
	 * This method will take the location of one exit and generate a 2D array
	 * to store the distance between this exit to all the available location (not a wall) on a floor map. 
	 */
	public int[][] getDistanceWithWall(int r, int c) {
		int[][] distanceWithWall = new int[floor.getSize()][floor.getSize()];
		Point point = new Point(r,c);		
		Queue<Integer[]> queue = new LinkedList<>();
		
		
		
		
		
		
		return distanceWithWall;
	}
	/**
	 * @param A person
	 * This method will take all people on the floor and return a HashMap outline closest exit each person should go
	 */
	public HashMap<Person, Exit> closestExit(Person[] people) {
			
		HashMap<Person, Exit> personToExit = new HashMap<Person, Exit>(); 
		
		//implement the method build person-exit pair
		
		return personToExit;
	}
	/**
	 * @param A person
	 * This method will take one person and return the distance between this person and the exit he/she is going
	 */
	public int distanceToExit (Person p){  
		int distance=0;
		
		//implement the method
		
		return distance;
	}
	
	/**
	 * @param everyone on the floor
	 * This method will take everyone on the floor and sorted them by their distance to the target exit.
	 */
	public Person[] movePriority(Person[] allPeople) {
		Person[] sortedPeople = new Person[userDefine.numberOfPeople()];
		
		//implement the method
		
		return sortedPeople;
	}
}
	
