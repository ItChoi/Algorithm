package test;

public class TestAlgorithm {
	static class Test {
		String name;
		int key;
		double eye;
		
		public Test(String name, int key, double eye) {
			this.name = name;
			this.key = key;
			this.eye = eye;
		}
	}
	
	// 키 평균 값 구하기
	static double avgHeight(Test[] test) {
		
		int sum = 0;
		
		for (int i = 0; i < test.length; i++) {
			sum += test[i].key;
		}
		
		return sum / test.length;
	}
	
	// 시력 분포 구하기
	static void distVision(Test[] test, int[] dist) {
		int i = 0;
		dist[i] = 0;
		
		for (i = 0; i < test.length; i++) {
			if (test[i].eye >= 0.0 && test[i].eye <= 2.1) {
				dist[(int)(test[i].eye * 10)]++;
			}
		}
	}
	
	public static void main(String[] args) {
		Test[] x = {
				new Test("박현규", 162, 0.3),
				new Test("함진아", 173, 0.7),
				new Test("최윤미", 175, 2.0),
				new Test("홍연의", 171, 1.5),
				new Test("이수진", 166, 0.4),
				new Test("김영준", 175, 1.2),
				new Test("박용규", 168, 0.8),
		};
		
		int[] vdist = new int[21];
		
		System.out.println("@신체검사 리스트@");
		System.out.println("이름         키         시력");
		System.out.println("---------------");
		for (int i = 0; i < x.length; i++) {
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].key, x[i].eye);
		}
		
		System.out.printf("\n평균 키: %5.1fcm\n", avgHeight(x));
		
		distVision(x, vdist);
		
		System.out.println("\n시력 분포");
		for (int i = 0; i < 21; i++) {
			System.out.printf("%3.1f~:%2d명\n", i / 10.0, vdist[i]);
		}
		
			
		
	}
	
}


