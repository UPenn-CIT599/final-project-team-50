/**
 * @author feihan
 * The class tracks location,speed, direction of a person
 */

public class Person implements Comparable<Person> {

	 //int ID;
	 //double speed;
	 //String Direction;	
	 //int totalDistance;
	 //double totalTime;
	 
	 private int[] initialLocation=new int[2];//two numbers to track ppl's location (row and column axis)
	 private int[] currentLocation=new int[2];
	 private Integer distanceToExit;
	 
	 public void setDistanceToExit(Integer distanceToExit) {
		this.distanceToExit = distanceToExit;
	}

	public int[] getInitialLocation() {
		return this.initialLocation;
	}

	public Integer getDistanceToExit() {
		return distanceToExit;
	}
	
	
	public int compareTo(Person p) {
		return this.getDistanceToExit().compareTo(p.getDistanceToExit());
	}
	
	public int[] getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(int r, int c) {
		this.currentLocation[0] = r;
		this.currentLocation[1] = c;
	}

	 
	//constructor
	 Person(int[] initialLocation) {
		 //this.ID=ID;
		 //this.speed=speed;
		 //this.Direction=Direction;	
		 //this.Direction = "NORTH";//defaults as up/north
		 //this.totalDistance=0;
		 //this.totalTime=0.0;
		 this.initialLocation=initialLocation;
		 this.currentLocation=initialLocation;
		 this.distanceToExit=0;

	 }

	

	 /**
	  * method move controls the person to move to a direction 
	  * with a speed and distance. It adds to time moved and distance traveled 
	  * and it will update location by calling updateLocation method
	  * @param MoveDirection
	  * @param distance
	  * 
	  */
	 
	/* void move(String MoveDirection, int Distance) {
		 Direction=MoveDirection;
		 
		 this.totalDistance=this.totalDistance+Distance;
		 this.totalTime=this.totalTime+Distance/speed;
		 // update the location for the person after the move
		 
		 updateLocation(MoveDirection,Distance);
				 
		 
	 }
*/

	 /**
	  * method changeDirection takes a new direction and change the person's current location
	  * @param NewDirection
	  * 
	  */
	 
	/* 
	 void changeDirection(String NewDirection) {
		 
		 if(NewDirection.toUpperCase().equals("RIGHT")) {
			  if(NewDirection.toUpperCase().contentEquals("NORTH") ) {
				  Direction = "EAST";
			  }
			  else if(NewDirection.toUpperCase().contentEquals("EAST") ) {
				  Direction = "SOUTH";
			  }
			  else if(NewDirection.toUpperCase().contentEquals("SOUTH") ) {
				  Direction = "WEST";
			  }
			  else if(NewDirection.toUpperCase().contentEquals("WEST") ) {
				  Direction = "NORTH";
			  }
		  }
		  else if(NewDirection.toUpperCase().equals("LEFT")) {
			  if(NewDirection.toUpperCase().contentEquals("NORTH") ) {
				  Direction = "WEST";
			  }
			  else if(NewDirection.toUpperCase().contentEquals("EAST") ) {
				  Direction = "NORTH";
			  }
			  else if(NewDirection.toUpperCase().contentEquals("SOUTH") ) {
				  Direction = "EAST";
			  }
			  else if(NewDirection.toUpperCase().contentEquals("WEST") ) {
				  Direction = "SOUTH";
			  }
		  }
		 
	 }
	 
	 /**
	  * method tracks the person's current location based on his or her moving path
	  * @param NewDirection
	  * 
	  */
	/* void updateLocation(String moveDirection, int distance) {
		 
		 
		 if(moveDirection.toUpperCase().equals("NORTH")) {
			 
			 Location[1]=Location[1]-distance;
			
		 }else if(moveDirection.toUpperCase().equals("SOUTH")) {
			 
			 Location[1]=Location[1]+distance;
		 }else if(moveDirection.toUpperCase().equals("WEST")){
			 Location[2]=Location[2]-distance;
			 
		 }else if(moveDirection.toUpperCase().equals("EAST")){
			 
			 Location[2]=Location[2]+distance;
		 }
		 
		 
		 
	 }
	
	*/ 

	 
	 
}
	
	
