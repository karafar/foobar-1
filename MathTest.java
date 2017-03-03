/*
* Author: Farid Karadsheh
* Date: 11/16/2016
* Challenge: Google - foo.bar level 1
* Purpose: When given an area, to find all of the perfect squares that fit within said area.
*		If given 12, then the perfect squares that fit are 9, 1, 1, 1.
*		This is achieved through the answer method, and every value between 1 and a million are checked
* 		through the tester method and main method.
*/
public class MathTest {
	public static void main(String[] args) {
		// Testing every value from 1 to a million.
		// Counters for the while loop and errors. New MathTest object is created
		int counter = 1;
		int errors = 0;
		MathTest mathFun = new MathTest();
		// Confirms that every value between one and a million works.
		while(counter <= 1000000) {
			if(mathFun.tester(mathFun.answer(counter)) != counter)
				errors++;
			System.out.println(counter);
			counter++;
		}
		System.out.println(errors + " Total errors occured");
	}

	public int[] answer(int area) {
		// Creates placeholders for the area and array.
		int myArea = area;
		int[] myArray;

		// The first loop continually recreates the array, and the second loop populates it.
		for(int i = 0; myArea > 0; i++) {
			myArray = new int[i+1];
			myArea = area;
			for(int j = 0; j <= i; j++) {
				// d represents the largest possible perfect square that will fit within the given area.
				// Yet, the myArea gets smaller with each iteration of the loop, thus filling in the original area
				// with smaller, but essential pieces.
				// A double is requred for the square root function
				double d = Math.pow(Math.floor(Math.sqrt(myArea)), 2);
				myArea -= (int)d;
				myArray[j] = (int)d;

			}
			if(myArea == 0)
				return myArray;
		}
		// Failsafe incase something goes wrong.
		return null;
	}

	// This checks that the array that is returned by answer() is correct.
	// This is done by adding every value within the array.
	// When complete, the returned value is checked within main().
	public int tester(int[] answerArray) {
		int workCheck = 0;
		for(int k = 0; k < answerArray.length; k++) {
				workCheck += answerArray[k];
			}
			return workCheck;
	}



}