import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Simulation {

	public static void main(String[] args) {
		Simulation simulation = new Simulation(9);
		Planner planner = new Planner(9, 3, 5);
		HashMap<Exit, Integer> simulationResults = simulation.runSimulation(planner);
		int shortestTime = Collections.min(simulationResults.values());
		
		FloorPlan floorPlan = simulation.getOptimalFloor(simulation.optimalExitLocation(simulationResults));

		int[][] Floor = floorPlan.getfloorPlan();
		
		System.out.println("The optimal exit locate is below: ");
		 for (int i = 0; i < Floor.length; ++i) { 
			 for (int j = 0; j < Floor[i].length; ++j) { 
				 if (Floor[i][j] == 0) { System.out.print(" "); } 
				 else {
					 System.out.print(Floor[i][j]); 
				 } 
			 } 
			 System.out.println(); 
		 }		
		 System.out.println("The time for everyone to escape is "+ shortestTime + " mins");
	}
	
	int floorSize;
	public Simulation(int s) {
		floorSize = s;
	}

	public HashMap<Exit, Integer> runSimulation(Planner initialPlan) {

		HashMap<Exit, Integer> simulationRes = new HashMap<Exit, Integer>();

		for (int i = 0; i < 30; i++) {
			int exitAmount = initialPlan.getExits().getExitLocations().size();		
			int peopleAmount = initialPlan.getPeople().size();	
			
			Planner plans = new Planner(floorSize, exitAmount, peopleAmount);
			
			ArrayList<Person> People = plans.getPeople();
			Exit exitLocation = plans.getExits();
	
			FloorPlan floorPlan = plans.getFloor();	
			int[][] Floor = floorPlan.getfloorPlan();
			
//			System.out.println("The initial floor is below: ");
//			for (int r = 0; r < Floor.length; ++r) {
//				for (int j = 0; j < Floor[i].length; ++j) {
//					if (Floor[r][j] == 0) {
//						System.out.print(" ");
//					} else {
//						System.out.print(Floor[r][j]);
//					}
//				}
//				System.out.println();
//			}

			int timer = 0;
			while (floorPlan.hasPeopleOnFloor()) {
				for (Person p : People) {
					// index of current location
					int iCur = p.getCurrentLocation()[0]; // row
					int jCur = p.getCurrentLocation()[1]; // column
					int iNext = iCur;
					int jNext = jCur;

					int[][] distanceGrid = plans.getDistanceWithWall(plans.getClosetExit(p));

					if (p.getDistanceToExit() == 1) {
						
						People.remove(new Person(p.getCurrentLocation()));
						floorPlan.getfloorPlan()[iCur][jCur] = 0;
					}

					else {
						if (iCur > 0) {

							int distanceIfGoUp = distanceGrid[iCur - 1][jCur];
							if (distanceIfGoUp == p.getDistanceToExit() - 1 && Floor[iCur - 1][jCur] == 0) {
								iNext = iCur - 1;
							}
						}

						if (iCur < plans.getFloor().getSize() - 1) {
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

						if (jCur < plans.getFloor().getSize() - 1) {
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
				
				
			}
			simulationRes.put(exitLocation, timer);
			

		}
		return simulationRes;
	}

	public Exit optimalExitLocation(HashMap<Exit, Integer> results) {
		Exit bestSolution = null;
		int shortestTime = Collections.min(results.values());
		for (Entry<Exit, Integer> entry : results.entrySet()) {
			if (entry.getValue() == shortestTime) {
				bestSolution = entry.getKey();
			}
		}
		return bestSolution;
	}
	
	
	public FloorPlan getOptimalFloor (Exit e) {
		FloorPlan optimalFloorPlan = new FloorPlan(floorSize, e);
		return optimalFloorPlan;
	}
	
}
