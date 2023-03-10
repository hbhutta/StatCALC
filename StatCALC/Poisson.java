package capstonepackage;
import java.lang.Math;

import java.util.Scanner;

public class Poisson {
	static double e = Math.exp(1); // e = 2.7182818
		// value of e will remain constant due to final keyword
	
	static Scanner poisson_scan = new Scanner(System.in);
	
	static void choosePoisson() {
		System.out.println("Choose a specific Poisson calculation:\n\t" 
				+ "Enter [1] for GetPoissonForKEqual\n\t"
				+ "Enter [2] for GetPoissonForKLessThanEqual\n\t" 
				+ "Enter [3] for GetPoissonforKGreaterThanEqual");
		int getPoissChoice = poisson_scan.nextInt();
		
		System.out.println("Enter lambda and k_poisson:\n");
		double lambda = poisson_scan.nextDouble();
		int k_poisson = poisson_scan.nextInt();
		// lambda and k_poisson values applicable to all functions in Poisson.java class
		
		if (getPoissChoice == 1) {
			System.out.printf("P(X=%d) = %f", k_poisson, GetPoissonForKEqual(lambda, k_poisson));
		}
		
		if (getPoissChoice == 2) {
			System.out.printf("P(X<=%d) = %f", k_poisson, GetPoissonForKLessThanEqual(lambda, k_poisson));
		}
		
		if (getPoissChoice == 3) {
			System.out.printf("P(X>=%d) = %f", k_poisson, 1 - GetPoissonForKLessThanEqual(lambda, k_poisson));
		}
	}
	
	static double GetPoissonForKEqual(double lambda, int k_poisson) { //works
		double poissonPMFVal = 0;
		if (Integer.class.isInstance(k_poisson) == true) {
			poissonPMFVal = (Math.pow(e, -lambda)) * (Math.pow(lambda, k_poisson) / StatCalc.GetFactorial(k_poisson)); // * 
		}
		
		else {
			System.out.printf("%d cannot be a double. Enter 'Exit' or try again", k_poisson); 
				// Informs user if n and k_binom are negative or if k_binom is greater than n
			String getBinomTryAgain = poisson_scan.next();
			if (getBinomTryAgain == "Exit") {
				System.exit(0);
			}
			else {
				choosePoisson();
			}
		}
		return poissonPMFVal; // Returns Pois(X = k)
	}
	
	static double GetPoissonForKLessThanEqual(double lambda, int k_poisson) { //works
		double poissonPMFVal = 0;
		double poissonSum = 0;
		if (Integer.class.isInstance(k_poisson) == true) {
			for (int i = 0; i <= k_poisson; i++) {
				poissonPMFVal = (Math.pow(lambda, i) * Math.pow(e, -lambda)) / StatCalc.GetFactorial(i);
				poissonSum += poissonPMFVal;
			}
		}
		
		else {
			System.out.printf("%d cannot be a double. Enter 'Exit' or try again", k_poisson); 
				// Informs user if n and k_binom are negative or if k_binom is greater than n
			String getBinomTryAgain = poisson_scan.next();
			if (getBinomTryAgain == "Exit") {
				System.exit(0);
			}
			else {
				choosePoisson();
			}
		}
		return poissonSum; // Returns Pois(X <= k )
		// poissoncdf(
	}

	public static void main(String[] args) {
		choosePoisson();
	}
}
