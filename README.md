# Final-project-team-50
Team Member: Chi Zhang, Fei Han, Yao Yao

Class:
	UserInput
	Exit
	Person
	FloorPlan
	Planner
	Simulation(main)
	
Input:
	1. Number of people on the floor
	2. Number of exit
	
Output:
	The time it will take for everyone exit the floor
	

Detail of Each Class:

*UserInput:
Scan user input of a) number of people and b) number of exit
(restrict the number of exit to be less then 8)

*Exit:
- Location (Point)
- Name (String)
- Color (color) - for the further use of Swing

*Person:
- Location (Point)
- Name (String)
- Color (color) - for the further use of Swing

*FloorPlan:
- Size (int) //assume the floor is a (N x N) square
- FloorPlan (int [][])
- Exits (Exit[])
- People (Person[])
1. Set up the floor design with wall placed (no argument, return void)
2. Random generate the exit location(argument is Number of exit input by user, return void)
3. Locate people (argument is the Number of people input by user, return void)
4. Traverse the floor and check if any people on the floor

*Planner:
-Floor (FloorPlan)
-Exit (Exit)
-Person (Person)
1. Generate an Distance Map represent the distance between one exit to all the available vertices on the floor (argument Exit, return int[][])
2. Build a Person-Exit HashMap, once establish one person will only go to his target exit (argument FloorPlan, return HashMap<Person, Exit>)
	a. For each exit on the floor, generate their Distance Map
	b. For each person on the floor, compare his distance to each exit and find the closest exit.
	c. For all the people on the floor, build the Person-Exit relationship.
3. Calculate the distance between one person to his target Exit (argument Person, return distance)
4. Based on the distance each person to his target exit, determine the priority that once two people meet the one closer to his target exit will move first (argument Person[])


 



