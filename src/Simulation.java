import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Simulation {

//	public static void main(String[] args) {
//		
//	}
	int floorSize;

	public Simulation(UserInput input) {
		floorSize = input.getFloorSize();
	}

	private HashMap<Exit, Integer> runSimulation() {
		HashMap<Exit, Integer> simulationRes = new HashMap<Exit, Integer>();
		for (int i = 0; i < 50; i++) {
			Planner Plan = new Planner();
			int[][] Floor = Plan.getFloor().getfloorPlan();
			ArrayList<Person> People = Plan.getPeople();
			Exit exitLocation = Plan.getExits();	
			int timer = 0;
			while (Plan.getFloor().hasPeopleOnFloor()) {
				for (Person p : People) {
					// index of current location
					int iCur = p.getCurrentLocation()[0]; // row
					int jCur = p.getCurrentLocation()[1]; // column
					int iNext = iCur;
					int jNext = jCur;

					int[][] distanceGrid = Plan.getDistanceWithWall(Plan.getClosetExit(p));

					if (p.getDistanceToExit() == 1) {
						People.remove(new Person(p.getCurrentLocation()));
						Floor[iCur][jCur] = 0;
					}

					else {
						if (iCur > 0) {

							int distanceIfGoUp = distanceGrid[iCur - 1][jCur];
							if (distanceIfGoUp == p.getDistanceToExit() - 1 && Floor[iCur - 1][jCur] == 0) {
								iNext = iCur - 1;
							}
						}

						if (iCur < Plan.getFloor().getSize() - 1) {
							int distanceIfGoDown = distanceGrid[iCur + 1][jCur];
							if (distanceIfGoDown == p.getDistanceToExit() - 1 && Floor[iCur + 1][jCur] == 0) {
								iNext = iCur + 1;
							}
						}

						if (jCur > 0) {
							int distanceIfGoLeft = distanceGrid[iCur][jCur - 1];
							if (distanceIfGoLeft == p.getDistanceToExit() - 1 && Floor[iCur][jCur - 1] == 0) {
								jNext = jCur - 1;
							}
						}

						if (jCur < Plan.getFloor().getSize() - 1) {
							int distanceIfGoRight = distanceGrid[iCur][jCur + 1];
							if (distanceIfGoRight == p.getDistanceToExit() - 1 && Floor[iCur][jCur + 1] == 0) {
								jNext = jCur + 1;
							}
						}
						Floor[iCur][jCur] = 0;
						Floor[iNext][jNext] = 3;

						iCur = iNext;
						jCur = jNext;
						p.setCurrentLocation(iCur, jCur);
						p.setDistanceToExit(distanceGrid[iCur][jCur]);

					}

				}
				timer++;

				/*
				 * for (int i = 0; i < Floor.length; ++i) { for (int j = 0; j < Floor[i].length;
				 * ++j) { if (Floor[i][j] == 0) { System.out.print(" "); } else {
				 * System.out.print(Floor[i][j]); } } System.out.println(); } }
				 * System.out.println("The escape takes " + timer + " mins");
				 */

			}
			simulationRes.put(exitLocation, timer);
		}
		return simulationRes;
	}

	private Exit bestExitLocation(HashMap<Exit, Integer> simulations) {
		Exit bestSolution=null;
		simulations = runSimulation();

		int shortestTime = Collections.min(simulations.values());
		for (Entry<Exit, Integer> entry : simulations.entrySet()) {
			if (entry.getValue() == shortestTime) {
				bestSolution = entry.getKey();
			}
		}
		return bestSolution;
	}
	
	public FloorPlan optimalFloorPlan() {
		FloorPlan optimalFloorPlan = new FloorPlan(floorSize,bestExitLocation(runSimulation()));
		return optimalFloorPlan;
	}
}
