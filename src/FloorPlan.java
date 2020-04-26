import java.util.ArrayList;
import java.util.Random;

public class FloorPlan {

	/*
	 * in the ArrayList floorPlan void = 0 wall = 1 exit = 2 people = 3
	 */

	public int maxExit = 8;

	// size = 3n+1 (n >= 10)
	private int size;
	private int[][] floorPlan;
	private Exit exit;

	public FloorPlan(int k, Exit exits) {
		this.size = k;
		this.exit = exits;
		this.floorPlan = new int[size][size];

		// core
		// r = 1/3 * size
		for (int c = size / 3; c <= 2 * (size / 3); c++) {
			floorPlan[size / 3][c] = 1;
		}

		// r = 2/3 * size
		for (int c = size / 3; c <= 2 * (size / 3); c++) {
			floorPlan[2 * (size / 3)][c] = 1;
		}

		// c = 1/3 * size
		for (int r = size / 3; r <= 2 * (size / 3); r++) {
			if (r == size / 2) {
				continue;
			}
			floorPlan[r][size / 3] = 1;
		}

		// c = 2/3 * size
		for (int r = size / 3; r <= 2 * (size / 3); r++) {
			if (r == size / 2) {
				continue;
			}
			floorPlan[r][2 * (size / 3)] = 1;
		}

		// perimeter
		for (int c = 0; c < size; c++) {
			for (int r = 0; r < size; r++) {
				if ((r == 0) || (r == size - 1) || (c == 0) || (c == size - 1)) {
					floorPlan[r][c] = 1;
				}
			}
		}

		// Save the exit in from Exit class in to floorPlan ArrayList
		ArrayList<int[]> exitLocations = exit.getExitLocations();
		for (int[] point : exitLocations) {
			int r = point[0];
			int c = point[1];
			floorPlan[r][c] = 2;
		}

	}

	public int getSize() {
		return size;
	}

	public int[][] getfloorPlan() {
		return floorPlan;
	}

	public Exit getExit() {
		return exit;
	}

	public void setExit(Exit exit) {
		this.exit = exit;
	}

	// make sure the rows and columns are inbound and valid
	public boolean inbound(int r, int c) {
		return (r >= 0) && (r < size) && (c >= 0) && (c < size);
	}

	// check if any people left on the floor
	public boolean hasPeopleOnFloor() {
		boolean hasPeople = false;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (floorPlan[r][c] == 3)
					hasPeople = true;
			}
		}
		return hasPeople;
	}

	// to get the maxpeople according to size
	public int getMaxPeople() {
		int maxNumPeople = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (floorPlan[i][j] == 0) {
					maxNumPeople++;
				}
			}
		}
		return maxNumPeople;

	}

	// to distrbute people on the floorplan's void space randomly
	public boolean locatePeople(int numPeople) {
		int max = getMaxPeople();
		if (numPeople > max)
			return false;
		int total = size * size;
		Random random = new Random();
		while (numPeople > 0) {
			int next = random.nextInt(total);
			int r = next / size;
			int c = next % size;
			if (floorPlan[r][c] == 0) {
				floorPlan[r][c] = 3;
				numPeople--;
			}
		}
		return true;
	}
}
