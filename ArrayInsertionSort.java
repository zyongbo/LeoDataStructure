package leo.impl;

public class ArrayInsertionSort {

	//1+2+3+4+...+n-1 = n*(n-1)/2 = O(n^2)
	public static void insertionSort(char[] data) {
		int n = data.length;
		for(int k=1; k<n; k++) {
			char cur = data[k];
			int i = k;
			while(i>0 && data[i-1]>cur) {
				data[i] = data[i-1];
				i--;
			}
			data[i] = cur;
		}
	}
}
