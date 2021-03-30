package ViratKohli;

import java.util.ArrayList;
import java.util.Collections;



/*
 * class containing bowling order decision related methods
 * 
 */
public class BowlingOrderDecision {
	// number of balls required for Virat to play
	private int numberOfBalls = 0;
	//list of bowlers
	private ArrayList<Bowler> bowlersList ;
	
	public BowlingOrderDecision(int numberOfBalls, ArrayList<Bowler>  bowlersList) {
		this.numberOfBalls = numberOfBalls;
		this.bowlersList = bowlersList;
	}
	
	/*
	 * method to find order of bowlers
	 * @return an array consisting order of bowlers
	 */
	public ArrayList<Bowler> getOrderOfBowler() {
		ArrayList<Bowler> orderOfBowlers;
		int index=0;
		sortBowlerList();
		int totalBalls = 0;
		// calculating totalBalss available
		while (totalBalls < numberOfBalls && index!=bowlersList.size()) {
			totalBalls += bowlersList.get(index++).getNumberOfBalls();
		}
		//if totalBalls is less than number of Balls , return null
		if(index == bowlersList.size() && totalBalls < numberOfBalls) {
			return null;
		}
		orderOfBowlers = bowlersList;
		return orderOfBowlers;
	}
	
	/*
	 * method sort the bowlerList in descending order on the basis of number of balls
	 */
	private void sortBowlerList() {
		Collections.sort(bowlersList);
	}
	
}