import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * @author feihan
 * This is Junit test for test the locationGenerator method
 *
 */


class ExitTest {



	@Test
	void testLocationGenerator() {
		Exit newExit=new Exit();
		//test case for a 9*9 floor with 3 exits
		newExit.locationGenerator(3, 9);
		//test to see if 3 exits are generated
		boolean test1=false;
		boolean test2=false;
		boolean test=false;
		//test for size
		if(newExit.getExitLocations().size()==3) {
			test1=true;
		}
		//test for location ranges
		for(int[] loc: newExit.getExitLocations()) {
			//System.out.println(loc[0]);
			//System.out.println(loc[1]);
		  if(loc[0]<=9 && loc[1]<=9) {
			   test2=true;
		  }else {
			  test2=false;
			  break;
		  }
		
		}
		if(test1==true&&test2==true) {
			test=true;
				}
		else {
			test=false;
		}
		
		assertTrue(test==true);
	}
	}


