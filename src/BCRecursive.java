import java.util.Scanner; //used to scan inputs from the user
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BCRecursive {
	/*
	 * Recursive program that creates a factorial by multiplying n by a number 1 less than n until 
	 * that number is zero
	 */
	static long factorial(long n) {
		if(n == 0) {
			return 1;
		}else {
			return (n*factorial(n-1));
		}
	}
	
	public static void main(String [] args) {
		
		Scanner s = new Scanner(System.in);
		int N; //variable for the number of items
		int k; //variable for the size of the subset
		long R = 0; //variable for number of possible subsets
		boolean more; //boolean that controls if the loop continues
		String answer; //input from the user for whether to calculate another BC
		try {
		File file = new File("BCRecursive.txt");
		FileWriter fileWriter = new FileWriter("BCRecursive.txt", true); //file that can be wrote to and appended
		//multiple appended lines possible
		
		do {
		System.out.print("Enter N: ");
		N = s.nextInt();
		
		System.out.print("Enter k: ");
		k = s.nextInt();
		
		int nk = N - k; //calculates nk to simplify equation
		
		long startTime = System.currentTimeMillis(); //clock starts 
		
		long Nfact = factorial(N); //factorial of N
		long Kfact = factorial(k); //factorial of k
		long NKfact = factorial(nk); // factorial of (N - k)
		
		R = Nfact / (NKfact * Kfact); //equation to calculate the BC
		
		long stopTime = System.currentTimeMillis(); //clock stops
		long estimateTime = startTime - stopTime; //time to compute is calculated
		
		if (estimateTime < 1000) {
			estimateTime = 1000; //sets any time calculated less than a second to be equal to a second
		}
		
		long estimateSecond = estimateTime / 1000; //milliseconds are converted into seconds
	
		String results = "\n" + "" + N + ", " + k + ", " + R + ", " + estimateSecond + " second";
		//creates string that will be written to the file
		
		fileWriter.write(results); //writes result string to file
		fileWriter.flush();
		
		
		System.out.println("There are " + R + " ways to choose " + k + " subsets from " + N + " items.");
		//prints results to the console
		
		System.out.print("Calculate another Binomial Coefficient? (Y/N): ");
		answer = s.next();
		if(answer.equals("Y")){ 
			more = true;
			} else {
				more = false;
			}
			} while (more == true); //loop controlling whether another BC will be calculated
		fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace(); //hopefully catches any problems with the file writer and alerts the programmer
		}
		}
	}


