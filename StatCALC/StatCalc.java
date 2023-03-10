package capstonepackage;

import java.util.Scanner; 

public class StatCalc {
	static int GetFactorial(int n) {
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}
	
	static void askInput() {
		System.out.println("Choose a distribution\n\t"
				+ "[1] Poisson distribution (Poisson) \n\t"
				+ "[2] Binomial distribution (Binomial) \n\t");
		
		Scanner s = new Scanner(System.in); 	
		int getChoice = s.nextInt(); 
		
		if (String.valueOf(getChoice).equals("1")) { //works
			Poisson.choosePoisson();
			System.exit(0);
		}
		
		if (String.valueOf(getChoice).equals("2")) {
			Binomial.chooseBinomial();
			System.exit(0);
		}
		
		else {
			System.out.println("Invalid inputs. Try again or enter 'Exit' to end the program.");
			String getTryagain = s.next();
			if (getTryagain.equals("Exit")) {
				System.out.println("Bye!");
				System.exit(0); // terminates code
			}
			
			if (Integer.valueOf(getTryagain) == 1) {
				Poisson.choosePoisson();
			}
			
			if (Integer.valueOf(getTryagain) == 2) {
				Binomial.chooseBinomial();
			}
		}
	}
	
	public static void main(String[] args) {
		askInput();
	}
}
