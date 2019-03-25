package test;

public class TestAlgorithm {
	
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
		int key = 7;
		
		int result = binSearchX(a, a.length, key);
		
		System.out.println("result: " + result);
		
	}
	
	static int binSearchX(int[] a, int n, int key) {
		
		int start = 0;
		int last = n;
		
		int index = 0;
		
		int result = 0;
		
		while(true) {
			int middle = (start + last) / 2;
			
			if (a[middle] == key) {
				result = middle;
				
				for (int i = 0; i < middle; i++) {
					System.out.println("ai: " + a[i]);
					if (a[i] == key) {
						result = i;
						break;
					}
				}
				
			} else if (a[middle] > key) {
				start = middle + 1;
			} else {
				last = middle - 1;
			}
			
			return result;
		}
		
	}
	
}


