import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author feihan
 * The class takes user input and randomly generates
 * exits locations on the floor plan
 * 
 */

public class Exit {
	 //int numExit;//user input
	 //int FloorSize;//defined in simulation class
	 private ArrayList<int[]> ExitLocations;
	 
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
	 
	public void locationGenerator(int numExit, int FloorSize) {
		 
		 //first randomly shuffle all possible outcomes between 1~4k-4
		 List<Integer> randomList = new ArrayList<>();
		 for (int i = 1; i <= (4*FloorSize-4); i++) {
			 randomList.add(i);
		 }
		 Collections.shuffle(randomList);

		 //then take the first numExits for exits' location consideration
		 //numbering based on clockwise. The upper left being (1,1) 
		for(int i=1;i<=numExit;i++) {
			int temp=randomList.get(i);
					
			
			if(temp<=(FloorSize-1)) {
				
				int[] arr= {1,temp};
				ExitLocations.add(i,arr);
				
			}else if(temp<=(2*FloorSize-2)) {
				
				int[] arr= {temp-FloorSize+1,FloorSize};
				
				ExitLocations.add(i,arr);

			}else if(temp<=(3*FloorSize-3)) {
				
				int[] arr= {FloorSize,3*FloorSize-temp-1};
				ExitLocations.add(i,arr);
				
			}else {
				
				int[] arr= {4*FloorSize-temp-2,1};
				ExitLocations.add(i,arr);
			}
		
		
		}
		 
		 
		 

	 }
	
	//return location for exits
	 public ArrayList<int[]> getExitLocations() {
		return ExitLocations;
	}
	

}
