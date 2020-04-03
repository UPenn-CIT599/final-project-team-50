import java.awt.Point;
import java.util.ArrayList;

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
	public int[][] getDistanceWithWall(exit e){
		int [][] distanceWithWall = new int [f.getSize()][f.getSize()];
		
		//implement the method;
		
		return distanceWithWall;
	}
	/**
	 * @param location of a person
	 * This method will take the location of one person and generate an integer
	 * represent the shortest distance to a closest exit 
	 */
	public int getShortestDistance(int r, int c) {
		ArrayList<Integer> distancesToExit = new ArrayList<Integer>();

		for (exit e : exits) {
			distancesToExit.add(getDistanceWithWall(e)[r][c]);
		}
		
		distancesToExit.sort(null);
		return distancesToExit.get(0);
	}
	
	
	
	
}
