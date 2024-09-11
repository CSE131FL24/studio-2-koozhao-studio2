package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("How much money do you want to start with?");
		double startAmount = in.nextDouble();
		System.out.println("What win probabilty do you want?");
		double winChance = in.nextDouble();
		System.out.println("How much money are you satisfied winning?");
		double winLimit = in.nextDouble();

		System.out.println("How many days do you want to simulate?");
		int totalSimulations = in.nextInt();

		double money = startAmount;
		double losses, wins;
		losses = 0;
		wins = 0;
		

	for (int i=1; (i <= totalSimulations); i++) {
		money = startAmount;
		while (money <= winLimit){
				double x = Math.random();
				if (x <= winChance) {
					money++;
			//		System.out.println("Simulation "+ i + ": $" + money);
			//		wins++;
				}
				else {
					money--;
			//		System.out.println("Simulation "+ i + ": $" + money);
			//		losses++;
				}	
			}
		if (money <= 0) {
			System.out.println("womp womp");
			return;
		}
		else {
			System.out.println("Win");
		}


	}
	
	double rr = losses/(totalSimulations);

	
	double a = (1-winChance)/winChance;
	if (winChance == 0.5) {
		double er = (1-(startAmount/winLimit));
		System.out.println("Expected Ruin Rate: "+ er);
		System.out.println("Ruin Rate from Simulation: " + rr);
	}
	else {
		double er = (Math.pow(a,startAmount) - (Math.pow(a, winLimit)))/(1-Math.pow(a,winLimit));
		System.out.println("Expected Ruin Rate: "+ er);
		System.out.println("Ruin Rate from Simulation: " + rr);
	}
}
}
