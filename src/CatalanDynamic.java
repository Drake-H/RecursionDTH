import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CatalanDynamic {
	
	static long dynamicFactorial (long n) {
		long a = n;
		for (long g = 1; (a - g) > 0; g++) {
			n = n * (a-g);
		}
		return n;
	}

	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		long N;
		long Cat = 0;
		String answer;
		boolean more = true;
		
		try {
			FileWriter fileWriter = new FileWriter("CatalanDynamic.txt", true);
		
		while (more == true) {
		System.out.print("Enter N: ");
		N = s.nextLong();
		
		long startTime = System.currentTimeMillis();
		
		long numN = dynamicFactorial(2*N);
		long denomN = dynamicFactorial(N+1);
		long factN = dynamicFactorial(N);
		
		Cat = numN / (denomN * factN);
		
		long stopTime = System.currentTimeMillis();
		long estimateTime = startTime - stopTime;
		
		if (estimateTime < 1000) {
			estimateTime = 1000;
		}
		
		long estimateSecond = estimateTime / 1000;
	
		String results = "\n" + "" + N + ", " + Cat + ", " + estimateSecond + " second";
		
		fileWriter.write(results);
		fileWriter.flush();
		
		
		System.out.println("C(" + N + ") =" + " " + Cat);
		System.out.print("Calculate another Catalan Number? (Y/N): ");
		answer = s.next();
		if(answer.equals("Y")) 
			more = true;
		if(answer.equals("N"))
			more = false;
			} 
		fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
