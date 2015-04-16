package leo.impl;

public class StringBuilderTest {
	
	public static enum weekDays{Mon, Tue, Wed, Thu, Fri};

	//both String and StringBuilder are class type
	//{} is used to initialize new arrays and enum type
	//O(n^2)
	public static String repeat1(char c, int n) {
		String answer = "";
		for(int i=0; i<n; i++) {
			answer += c;
		}
		return answer;
	}
	
	//this is much faster to construct customed string, O(n)
	public static String repeat2(char c, int n) {
		StringBuilder answer = new StringBuilder();
		for(int i=0; i<n; i++) {
			answer.append(c);
		}
		return answer.toString();
	}
	
	public static double[] prefixAverage1(double[] x) {
		int n = x.length;
		double[] a = new double[n];
		
		for(int j=0; j<n; j++) {
			double total = 0;
			for(int i=0; i<=j; i++) {
				total = total + x[i];
			}
			a[j] = total/j+1;
		}
		return a;
	}
	
	public static double[] prefixAverage2(double[] x) {
		int n = x.length;
		double[] a = new double[n];
		double total = 0;
		
		for(int i=0; i<n; i++) {
			total = total + x[i];
			a[i] = total/i+1;
		}
		return a;
	}
	
	public static void main(String[] args) {
		
		int a = Integer.parseInt(args[0]);
		Double b = Double.parseDouble(args[1]);
		
		final char c = '*';
		long startTime = System.nanoTime();
		int count = 0;
		for(int i=0; i<10; i++) {
			count = count + i;
			System.out.println(count);
		}
		//System.currentTimeMillis()
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		System.out.println(elapsedTime);
		
		long startTime1 = System.nanoTime();
		System.out.println(repeat1(c, 50));
		long endTime1 = System.nanoTime();
		long elapsedTime1 = endTime1 - startTime1;
		System.out.println(elapsedTime1);
		
		long startTime2 = System.nanoTime();		
		System.out.println(repeat2(c, 50));
		long endTime2 = System.nanoTime();
		long elapsedTime2 = endTime2 - startTime2;
		System.out.println(elapsedTime2);
		
		long startTime3 = System.currentTimeMillis();
		System.out.println(startTime3);
		
		System.out.println(a);
		System.out.println(b);
	}
}
