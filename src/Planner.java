
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

/**
 * @author yao16 Assumption: 1. the person closer to an exit will move first 2.
 *         the move speed of each person are same
 */
public class Planner {
	private FloorPlan floor;
	private Exit exits;
	private ArrayList<Person> people;
	private int numberOfPeople;

	public Planner(int floorSize, int exitAmount, int peopleAmount) {

		exits = new Exit();
		exits.locationGenerator(exitAmount, floorSize); // only locate exit on the floor once
		floor = new FloorPlan(floorSize, exits);
		numberOfPeople = peopleAmount;
		people = buildPeopleArray();
	}

	// getters of instance variables
	public FloorPlan getFloor() {
		return floor;
	}

	public Exit getExits() {
		return exits;
	}

	// method to store all the people on the floor in an ArrayList
	private ArrayList<Person> buildPeopleArray() {
		ArrayList<Person> unsortedPeople = new ArrayList<>();
		boolean locatePeopleSuccess = floor.locatePeople(numberOfPeople); // only locate people on the floor once by
																			// calling locatePeople method

		if (locatePeopleSuccess) {
			int s = floor.getSize();
			for (int r = 0; r < s; r++) {
				for (int c = 0; c < s; c++) {
					if (floor.getfloorPlan()[r][c] == 3) {
						int[] initialLocation = { r, c };
						Person p = new Person(initialLocation); // create one person
						unsortedPeople.add(p);
					}
				}
			}
		}
		else {
			System.out.println("The number of people exceeds maximum");
			System.out.println("You can accommodate at maximum "+ floor.getMaxPeople()+ " people on your floor");
		}

		for (Person p : unsortedPeople) {
			int i = p.getInitialLocation()[0];
			int j = p.getInitialLocation()[1];
			int[] closetExit = getClosetExit(p);
			int[][] distanceMap = getDistanceWithWall(closetExit);
			p.setDistanceToExit(distanceMap[i][j]);
		}

		Collections.sort(unsortedPeople); // set the priority that person with the shorter distance has the priority
											// over person with longer distance

		return unsortedPeople;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	/**
	 * using BREADTH-FIRST SEARCH
	 * 
	 * @param location of exit This method will take the location of one exit and
	 *                 generate a 2D array to store the distance between this exit
	 *                 to all the available location (not a wall) on a floor map.
	 */
	public int[][] getDistanceWithWall(int[] oneExit) {
		int h = floor.getSize();
		if (h == 0)
			return null;
		int l = floor.getSize();
		boolean[][] visited = new boolean[h][l];
		visited[oneExit[0]][oneExit[1]] = true;
		int[][] distanceWithWall = new int[h][l];
		ArrayList<int[]> layer = new ArrayList<>();
		layer.add(oneExit);
		ArrayList<int[]> nextLayer = new ArrayList<>();

		int distance = 0;
		while (!layer.isEmpty()) {
			for (int i = 0; i < layer.size(); ++i) {
				int[] curVertex = layer.get(i);
				int row = curVertex[0];
				int col = curVertex[1];

				if (floor.getfloorPlan()[row][col] == 1) {
					distanceWithWall[row][col] = -1; // if there is a wall on that point, then the distance return -1.
					continue;
				} else {
					distanceWithWall[row][col] = distance;
				}

				int[] delta_row = { -1, 1, 0, 0 };
				int[] delta_col = { 0, 0, -1, 1 };

				for (int k = 0; k < 4; ++k) {
					int new_row = delta_row[k] + row;
					int new_col = delta_col[k] + col;
					if (new_row >= 0 && new_row < l && new_col >= 0 && new_col < l && !visited[new_row][new_col]) {
						int[] temp = { new_row, new_col };
						nextLayer.add(temp);
						visited[new_row][new_col] = true;
					}
				}
			}
			layer.clear();
			for (int[] item : nextLayer) {
				int[] temp = { item[0], item[1] };
				layer.add(temp);
			}
			nextLayer.clear();
			distance++;
		}
		return distanceWithWall;
	}

	// helper method to find which exit is the closet one for one person
	public int[] getClosetExit(Person p) {
		int r = p.getInitialLocation()[0];
		int c = p.getInitialLocation()[1];

		HashMap<int[], Integer> distanceToEachExit = new HashMap<int[], Integer>();

		for (int[] oneExit : exits.getExitLocations()) {
			int[][] distanceMapForExit = getDistanceWithWall(oneExit);
			distanceToEachExit.put(oneExit, distanceMapForExit[r][c]);
		}

		int shortestDistance = Collections.min(distanceToEachExit.values());
		int[] closetExit = new int[2];
		for (Entry<int[], Integer> entry : distanceToEachExit.entrySet()) {
			if (entry.getValue() == shortestDistance) {
				closetExit = entry.getKey();
			}
		}
		return closetExit;
	}

	/**
	 * @param A person This method will take all people on the floor and return a
	 *          HashMap outline closest exit each person should go
	 */
	public HashMap<Person, int[]> closestExit() {
		HashMap<Person, int[]> personToExit = new HashMap<Person, int[]>();

		for (Person p : people) {
			int[] closetExit = getClosetExit(p);
			personToExit.put(p, closetExit);
		}
		return personToExit;
	}

}
