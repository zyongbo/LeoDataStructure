package leo.impl;

public class Recursion {

	public static int factorial(int n) throws IllegalArgumentException {
		if(n<0)
			throw new IllegalArgumentException("The input is illegal");
		else if(n==0)
			return 1;
		else return n*factorial(n-1);
	}
	
	public static void drawRuler(int nInchese, int majorLength) {
		drawLine(majorLength, 0);
		for(int i=0; i<nInchese; i++) {
			drawInterval(majorLength-1);
			drawLine(majorLength, i);
		}
	}
	private static void drawInterval(int centralLength) {
		if(centralLength>=1) {
			drawInterval(centralLength-1);
			drawLine(centralLength);
			drawInterval(centralLength-1);
		}
	}
	private static void drawLine(int tickLength, int tickLabel) {
		for(int j=0; j<tickLength; j++)
			System.out.print("-");
		if(tickLabel>=0)
			System.out.print(" " + tickLabel);
		System.out.print("\n");
	}
	private static void drawLine(int tickLength) {
		drawLine(tickLength, -1);
	}
	
	public static boolean binarySearch(int[] arr, int target, int lo, int hi) {
		if(hi<lo) return false;
		int mid = (hi+lo)/2;
		if(target == arr[mid]) return true;
		else if(target > arr[mid]) return binarySearch(arr, target, mid+1, hi);
		else return binarySearch(arr, target, lo, mid-1);
	}
	
	public static void reverseArray(int[] data, int lo, int hi) {
		if(lo<hi) {
			int tmp = data[hi];
			data[hi] = data[lo];
			data[lo] = tmp;
			reverseArray(data, lo+1, hi-1);
		}
	}
}
