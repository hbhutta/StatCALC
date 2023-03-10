package capstonepackage;
import java.util.Scanner;

public class Binomial {

	static Scanner binom_scan = new Scanner(System.in);
	
	static void chooseBinomial() {
		System.out.println("Choose a specific binomial calculation:\n\t" 
				+ "Enter [1] for GetBinomForKEqual\n\t"
				+ "Enter [2] for GetBinomForKLessThanEqual\n\t" 
				+ "Enter [3] for GetBinomforKGreaterThanEqual");
		int getBinomChoice = binom_scan.nextInt();
		
		System.out.println("Enter n, p and k_binom:\n");
		int n = binom_scan.nextInt();
		double p = binom_scan.nextDouble();
		int k_binom = binom_scan.nextInt();
		
		if (getBinomChoice == 1) {
			System.out.printf("P(X=%d) = %f", k_binom, GetBinomForKEqual(k_binom, n, p));
		}
		
		if (getBinomChoice == 2) {
			System.out.printf("P(X<=%d) = %f", k_binom, GetBinomForKLessThanEqual(k_binom, n, p));
		}
		
		if (getBinomChoice == 3) {
			System.out.printf("P(X>=%d) = %f", k_binom, 1 - GetBinomForKLessThanEqual(k_binom, n, p));
		}
	}
	
	static double GetBinomForKEqual(int k_binom, int n, double p) { // First Method
		double binomPMFVal = 0;
		if (n > 0 && k_binom > 0 && n >= k_binom) {
			int nCk = StatCalc.GetFactorial(n) / (StatCalc.GetFactorial(k_binom) * StatCalc.GetFactorial(n - k_binom));
			binomPMFVal = nCk * Math.pow(p, k_binom) * Math.pow(1 - p, n - k_binom);
		}
		
		else if (p == 0 || p == 1) {
			return 0; 
		}
		
		else if (n > 0 || k_binom > 0 || n >= k_binom) {
			System.out.printf("%d and %d are not valid values. Enter 'Exit' or try again", n, k_binom); 
				// Informs user if n and k_binom are negative or if k_binom is greater than n
			String getBinomTryAgain = binom_scan.next();
			if (getBinomTryAgain == "Exit") {
				System.exit(0);
			}
			else {
				chooseBinomial();
			}
		}
		return binomPMFVal;
	}
	
	static double GetBinomForKLessThanEqual(int k_binom, int n, double p) { // Second Method
		double binomPMFval = 0;
		if (n > 0 && k_binom > 0 && n >= k_binom) {
			for (int i = 0; i <= k_binom; i++) {
				int nCk = StatCalc.GetFactorial(n) / (StatCalc.GetFactorial(i) * StatCalc.GetFactorial(n - i));
				binomPMFval += nCk * Math.pow(p, i) * Math.pow(1 - p, n - i);
				// sums up discrete probabilities 
			}
		}
		else if (p == 0 || p == 1) {
			return 0; // Since binomPMFVal will evaluate to 0 for p = 0 or p = 1
		}
		
		else if (n > 0 || k_binom > 0 || n >= k_binom) {
			System.out.printf("%d and %d are not valid values. Enter 'Exit' or try again", n, k_binom); 
				// Informs user if n and k_binom are negative or if k_binom is greater than n
			String getBinomTryAgain = binom_scan.next();
			if (getBinomTryAgain == "Exit") {
				System.out.println("Bye");
				System.exit(0);
			}
			else {
				chooseBinomial();
			}
		}
		return binomPMFval;
	}
	
	public static void main(String[] args) {
		chooseBinomial();
	}
}