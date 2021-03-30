package ViratKohli;
/*
 * class containing attributes of a bowler
 * 
 */
public class Bowler implements Comparable<Bowler>{
	private String bowlerName;
	private int numberOfBalls;
	
	public Bowler (String bowlerName, int numberOfBalls) {
		this.bowlerName = bowlerName;
		this.numberOfBalls = numberOfBalls;
	}

	public String getBowlerName() {
		return bowlerName;
	}

	public int getNumberOfBalls() {
		return numberOfBalls;
	}

	public int compareTo(Bowler b) {
		//sorting in descending order
		return b.getNumberOfBalls()-this.numberOfBalls;
	}


	
	
}