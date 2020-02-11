package programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 13:00 ~ TODO....
 * @author itcho
 * 체육복이 도난 당해 없는 학생이 체육복 여분이 있는 학생에게 빌려야 한다.
 * 학생들 번호는 체격 순으로 매겨져 있어 체육복 여분이 있는 학생은 앞, 뒤 학생에게만 빌려줄 수 있다.
 * 최대한 많은 학생이 들을 수 있어야 한다.
 * 체육복 도난 당해 없는 학생들 번호가 담긴 lost
 * 여벌의 체육복이 있는 학생들 번호가 담긴 reserve
 * 
 * 제한사항
 * - 전체 학생 수 2 ~ 30
 * - 체육복 도난 학생 1명 이상, 중복되는 번호는 없다.
 * - 여벌 체육복을 가진 학생도 1명 이상 중복 없다.
 * - 여벌이 있는 학생만 다른 학생에게 빌려주는 것 가능
 * - 여벌 체육복 있는 학생이 도난을 당했을 수도 있다.
 * - 
 *
 */
public class 체육복 {
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
