package leo.impl;

import java.util.Arrays;

public class ThreeSetDisjointness {

	public static boolean disjoint1(int[] groupA, int[] groupB, int[] groupC) {
		for(int a : groupA)
			for(int b : groupB)
				for(int c : groupC)
					if(a==b && b==c)
						return false;
		return true;
	}
	
	public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
		for(int a : groupA)
			for(int b : groupB)
				if(a==b)
					for(int c : groupC)
						if(b==c)
							return false;
		return true;
	}
	
	public static boolean unique1(int[] data) {
		int n = data.length;
		for(int j=0; j<n-1; j++)
			for(int k=j+1; k<n; k++)
				if(data[j]==data[k])
					return false;
		return true;
	}
	
	public static boolean unique2(int[] data) {
		int n = data.length;
		int[] tmp = Arrays.copyOf(data, n);
		Arrays.sort(tmp);
		for(int j=0; j<n-1; j++)
			if(tmp[j]==tmp[j+1])
				return false;
		return true;
	}
}
