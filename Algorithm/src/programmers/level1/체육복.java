package programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 13:00 ~ TODO....
 * @author itcho
 * ü������ ���� ���� ���� �л��� ü���� ������ �ִ� �л����� ������ �Ѵ�.
 * �л��� ��ȣ�� ü�� ������ �Ű��� �־� ü���� ������ �ִ� �л��� ��, �� �л����Ը� ������ �� �ִ�.
 * �ִ��� ���� �л��� ���� �� �־�� �Ѵ�.
 * ü���� ���� ���� ���� �л��� ��ȣ�� ��� lost
 * ������ ü������ �ִ� �л��� ��ȣ�� ��� reserve
 * 
 * ���ѻ���
 * - ��ü �л� �� 2 ~ 30
 * - ü���� ���� �л� 1�� �̻�, �ߺ��Ǵ� ��ȣ�� ����.
 * - ���� ü������ ���� �л��� 1�� �̻� �ߺ� ����.
 * - ������ �ִ� �л��� �ٸ� �л����� �����ִ� �� ����
 * - ���� ü���� �ִ� �л��� ������ ������ ���� �ִ�.
 * - 
 *
 */
public class ü���� {
	public static void main(String[] args) {
//		int n = 5;
//		int n = 5;
//		int n = 3;
		int n = 5;
		
//		int[] lost = {2, 4};
//		int[] lost = {2, 4};
//		int[] lost = {3};
		int[] lost = {1, 3, 5};
		
//		int[] reserve = {1, 3, 5};
//		int[] reserve = {3};
//		int[] reserve = {1};
		int[] reserve = {2, 3, 4};
		
		int maxPeople = solution(n, lost, reserve);
		System.out.println("result: " + maxPeople);
	}

	public static int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (j < lost.length && i == lost[j]) {
        			lostList.add(i);
        		}
        		
        		if (j < reserve.length && i == reserve[j]) {
        			reserveList.add(i);
        		}
        	}
		}
        
        IntStream.range(0, lostList.size())
        	.forEach(i -> {
        		System.out.println("i: " + lostList.size());
        		IntStream.range(0, reserveList.size())
        			.forEach(j -> {
        				System.out.println("j: " + reserveList.size());
        				if (lostList.get(i) == reserveList.get(j)) { 
        					lostList.remove(i);
        					reserveList.remove(j); 
        				}
						 
        			});
        		
        	});
        
        int answer = n - lostList.size();
        
        for (int i = 0; i < lostList.size(); i++) {
        	for (int j = 0; j < reserveList.size(); j++) {
        		if (checkValue(lostList.get(i) - 1, reserveList.get(j)) || checkValue(lostList.get(i) + 1, reserveList.get(j))) {
        			reserveList.remove(j);
        			answer++;
        		}
        		
        	}
        }
        
        return answer;
    }
	
	private static boolean checkValue(int lost, int reserve) {
		boolean sameValue = false;
		if (lost == reserve) {
			sameValue = true;
		}
		
		return sameValue;
	}
}
