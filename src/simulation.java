import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yao16
 * Assumption: 1. the person closer to an exit will move first
 * 			   2. the move speed of each person are same
 */
public class simulation {
	private floorPlan f;
	private person[] people;
	private exit[] exits;
	
	public simulation(floorPlan f) {
		this.f = f;
	}
	
	/**using BREADTH-FIRST SEARCH
	 * @param location of exit
	 * This method will take the location of one exit and generate a 2D array
	 * to store the distance between this exit to all the available location (not a wall) on a floor map. 
	 */
	public int[][] getDistanceWithWall(exit e) {
		int[][] distanceWithWall = new int[f.getSize()][f.getSize()];

		//implement the method;
		
		return distanceWithWall;
	}
	/**
	 * @param A person
	 * This method will take one person and return the closest exit he/she should go
	 */
	public exit closestExit(person p) {
		exit closestExit = new exit();	
		HashMap<exit, Integer> map = new HashMap<exit,Integer>(); //to store at the position this person standing, the pair of exit-distance.

		//implement the method find the exit with the shortest distance
		
		return closestExit;
	}
	/**
	 * @param A person
	 * This method will take one person and return the distance between this person and the exit he/she is going
	 */
	public person[] movePriority(person[] people) { 
		person[] sortedPeople = new person[this.people.length];
		
		//implement the method
		
		return sortedPeople;
	}
	
}
