import java.awt.Point;
import java.util.ArrayList;

public class simulation {
	private floorPlan f;
	private int[][] distances;
	private int[][] exitIndexes;
	
	public simulation(floorPlan f) {
		this.f = f;
		exitIndexes = new int[f.getSize()][f.getSize()];
		distances = new int[f.getSize()][f.getSize()];
	}
	
	/*Return a list of Point objects representing the shortest path 
	 * from the location (r,c) to its closest exit.
	*/
	public ArrayList<Point> pathFrom(int r, int c) {
		ArrayList<Point> list = new ArrayList<Point>();
		
		// do what need to do	
		
		return list;
	}
}
