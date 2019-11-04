import java.util.Scanner; 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CatalanRecursive {
	
	static long factorial(long n) {
		if(n == 0) {
			return 1;
		}else {
			return (n*factorial(n-1));
		}
	}
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int N;
		long Cat = 0;
		String answer;
		boolean more;
		
		try {
			FileWriter fileWriter = new FileWriter("CatalanRecursive.txt", true);
		
		do {
		System.out.print("Enter N: ");
		N = s.nextInt();
		
		long startTime = System.currentTimeMillis();
		
		long numN = factorial(2*N);
		long denomN = factorial(N+1);
		long factN = factorial(N);
		
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
		if(answer.equals("Y")){ 
			more = true;
			} else {
				more = false;
			}
			} while (more == true);
		fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
