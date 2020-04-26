import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author feihan The class takes user input and randomly generates exits
 *         locations on the floor plan
 * 
 */

public class Exit {

	private ArrayList<int[]> ExitLocations;

	// constructor
	public Exit() {

	
		this.ExitLocations = new ArrayList<int[]>();

	}

	/**
	 * randomly generate locations for given number of exits and returns locations
	 * 
	 * @param numExit;
	 * @param FloorSize;
	 * 
	 */

	public void locationGenerator(int numExit, int FloorSize) {

		// first randomly shuffle all possible outcomes between 1~4k-4
		List<Integer> randomList = new ArrayList<>();
		for (int i = 1; i <= (4 * FloorSize - 4); i++) {
			randomList.add(i);
		}
		Collections.shuffle(randomList);

		// then take the first numExits for exits' location consideration
		// numbering based on clockwise. The upper left being (1,1)
		boolean[] visited = new boolean[randomList.size()];
		for (int i = 0; i < numExit; i++) {
			int index = i;
			int temp = randomList.get(index);
			while ((temp - 1) % (FloorSize - 1) == 0 || visited[temp - 1]) {
				index++;
				if (index >= randomList.size()) {
					index = 0;
				}
				temp = randomList.get(index);
			}
			visited[temp - 1] = true;

			if (temp <= (FloorSize)) {

				int[] arr = { 0, temp - 1 };
				ExitLocations.add(i, arr);

			} else if (temp <= 2 * FloorSize - 1) {

				int[] arr = { temp - FloorSize, FloorSize - 1 };
				ExitLocations.add(i, arr);

			} else if (temp <= 3 * FloorSize - 2) {

				int[] arr = { FloorSize - 1, 3 * FloorSize - temp - 2 };
				ExitLocations.add(i, arr);

			} else {

				int[] arr = { 4 * FloorSize - temp - 3, 0 };
				ExitLocations.add(i, arr);
			}
		}
	}

	// return location for exits
	public ArrayList<int[]> getExitLocations() {
		return ExitLocations;
	}

}
