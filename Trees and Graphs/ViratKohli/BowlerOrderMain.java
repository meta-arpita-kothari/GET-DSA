package ViratKohli;


import java.util.ArrayList;
import java.util.Scanner;

/*
 * class containing main method
 */
public class BowlerOrderMain {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Bowler> bowlerList = new ArrayList<Bowler>();
		
		System.out.println("Enter the number of balls Virat will play:");
		int numberOfBalls = scan.nextInt();
		
		System.out.println("Enter the number of bowlers we have: ");
		int numberOfBowlers = scan.nextInt();
		
		for(int i=0; i<numberOfBowlers;i++) {
			System.out.println("Enter the name of the bowler: ");
			String nameOfTheBowler = scan.next();
			System.out.println("Enter the balls to be thrown by the bowler:");
			int balls = scan.nextInt();
			bowlerList.add(new Bowler(nameOfTheBowler, balls));
		}
		
		System.out.println("Bowling order as decided will be:");
		BowlingOrderDecision object = new BowlingOrderDecision(numberOfBalls, bowlerList);
		
		ArrayList<Bowler> decidedBowlers = object.getOrderOfBowler();
		if(decidedBowlers!=null) {
			for(Bowler b : decidedBowlers) {
				System.out.println(b.getBowlerName());
			}
		} else {
			System.out.println("Unable to find the order !");
		
		}
		scan.close();
	}
}