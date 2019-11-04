import java.util.Scanner; 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BCDynamic {
	/*
	 * Calculates a factorial dynamically by storing a constant value a which is the original n
	 * the value g is incrementally increased, subtracted from a, and then multiplied by n
	 * n increases until it is equal to the factorial of a
	 */
	static long dynamicFact (long n) {
		long a = n;
		for (long g = 1; (a - g) > 0; g++) {
			n = n * (a-g);
		}
		return n;
	}
	public static void main (String [] args) {
		
		Scanner s = new Scanner(System.in); //takes inputs from the user
		int N; //set of items
		int k; //size of subset
		long R = 0; //number of subsets
		boolean more; //boolean to continue or not
		String answer; //string input response from user
		try {
		File file = new File("BCDynamic.txt");
		FileWriter fileWriter = new FileWriter("BCDynamic.txt", true);
		
		do {
		System.out.print("Enter N: ");
		N = s.nextInt();
		
		System.out.print("Enter k: ");
		k = s.nextInt();
		
		int nk = N - k; //nk simplifies equation compared to n - k
		
		long startTime = System.currentTimeMillis();//start clock
		
		long NFact = dynamicFact(N);//factorial N
		long KFact = dynamicFact(k);//factorial k
		long NKFact = dynamicFact(nk);//factorial of (n - k)
		
		R = NFact / (NKFact * KFact);
		
		long stopTime = System.currentTimeMillis();//stop clock
		long estimateTime = startTime - stopTime;
		
		if (estimateTime < 1000) {
			estimateTime = 1000;
		}
		
		long estimateSecond = estimateTime / 1000; //time to compute in seconds
	
		String results = "\n" + "" + N + ", " + k + ", " + R + ", " + estimateSecond + " second";
		//creates string of results
		
		fileWriter.write(results);
		fileWriter.flush();
			
		
		System.out.println("There are " + R + " ways to choose " + k + " subsets from " + N + " items.");
		
		System.out.print("Calculate another Binomial Coefficient? (Y/N): ");
		answer = s.next();
		if(answer.equals("Y")){ 
			more = true;
			} else {
				more = false;
			}
			} while (more == true);
		fileWriter.close();
		//loop controlling whether another BC is calculated
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
