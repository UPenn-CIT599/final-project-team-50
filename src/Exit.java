import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author feihan2020
 * The class takes user input and randomly generates
 * exits locations on the floor plan
 * 
 */

public class Exit {
	 //int numExit;//user input
	 //int FloorSize;//defined in simulation class
	 ArrayList<int[]> ExitLocations;
	 
	 //constructor
	 public Exit() {
		 
		// this.numExit=numExit;
		 //this.FloorSize=FloorSize; 
		 this.ExitLocations=new ArrayList<int[]>();
		 
	 }
	 
	 
	 /**
	  * randomly generate locations for given number of exits
	  * and returns locations 
	  * @param numExit;
	  * @param FloorSize;
	  * 
	  */
	 
	 void locationGenerator(int numExit, int FloorSize) {
		 
		 //first randomly shuffle all possible outcomes between 1~4k-4
		 List<Integer> randomList = new ArrayList<>();
		 for (int i = 1; i <= (4*FloorSize-4); i++) {
			 randomList.add(i);
		 }
		 Collections.shuffle(randomList);

		 //then take the first numExits for exits' location consideration
		for(int i=1;i<=numExit;i++) {
			int temp=randomList.get(i);
			
			
			
			if(temp<=(FloorSize-1)) {
				
				int[] arr= {FloorSize,temp};
				ExitLocations.add(i,arr);
				
			}else if(temp<=(2*FloorSize-2)) {
				
				int[] arr= {2*FloorSize-temp,FloorSize};
				
				ExitLocations.add(i,arr);

			}else if(temp<=(3*FloorSize-3)) {
				
				int[] arr= {1,3*FloorSize-temp-1};
				ExitLocations.add(i,arr);
				
			}else {
				
				int[] arr= {1,temp-FloorSize*2};
				ExitLocations.add(i,arr);
			}
		
		
		}
		 
		 
		 

	 }
	 
	 //return location for exits
	 public ArrayList<int[]> getExits() {
	        return this.ExitLocations;
	    }
		 
	

}
