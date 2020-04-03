/**
 * @author feihan
 * The class tracks location,speed, direction of a person
 */

public class Person {

	 int ID;
	 double speed;
	 String Direction;
	 int[] LocationTracker=new int[2];//two numbers to track ppl's location (row and column axis)
	 int totalDistance;
	 double totalTime;
	 
	//constructor
	 Person(int ID, double speed, int[] initialLocation) {
		 this.ID=ID;
		 this.speed=speed;
		 //this.Direction=Direction;
		 this.LocationTracker=initialLocation;
		 this.Direction = "NORTH";//defaults as up/north
		 this.totalDistance=0;
		 this.totalTime=0.0;

	 }

	 /**
	  * method move controls the person to move to a direction 
	  * with a speed and distance. It adds to time moved and distance traveled 
	  * and it will update location by calling updateLocation method
	  * @param MoveDirection
	  * @param distance
	  * 
	  */
	 
	 void move(String MoveDirection, int Distance) {
		 Direction=MoveDirection;
		 
		 this.totalDistance=this.totalDistance+Distance;
		 this.totalTime=this.totalTime+Distance/speed;
		 // update the location for the person after the move
		 
		 updateLocation(MoveDirection,Distance);
				 
		 
	 }


	 /**
	  * method changeDirection takes a new direction and change the person's current location
	  * @param NewDirection
	  * 
	  */
	 
	 
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
	 void updateLocation(String moveDirection, int distance) {
		 
		 
		 if(moveDirection.toUpperCase().equals("NORTH")) {
			 
			 LocationTracker[1]=LocationTracker[1]-distance;
			
		 }else if(moveDirection.toUpperCase().equals("SOUTH")) {
			 
			 LocationTracker[1]=LocationTracker[1]+distance;
		 }else if(moveDirection.toUpperCase().equals("WEST")){
			 LocationTracker[2]=LocationTracker[2]-distance;
			 
		 }else if(moveDirection.toUpperCase().equals("EAST")){
			 
			 LocationTracker[2]=LocationTracker[2]+distance;
		 }
		 
		 
		 
	 }
	 
	 
	 //get location
	 
	  public int[] getLocation() {
	        return this.LocationTracker;
	    }
}
	
	
