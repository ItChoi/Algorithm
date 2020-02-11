package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itcho
 * 문제 설명
 * 배열 원소 0 ~ 9로 이루어지는 arr이 주어진다. 이때 arr에 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거
 * 단, 제거 후 남은 수들을 반환 시 원소의 순서는 유지
 * ex)
 * arr = [1, 1, 3, 3, 0, 1, 1] -> [1, 3, 0, 1] return
 * arr = [4, 4, 4, 3, 3] -> [4, 3] return 
 *
 */
public class 같은숫자는싫어 {
	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		// int[] arr = {4, 4, 4, 3, 3};
		int answer[] = solution(arr);
		
		for (int a : answer) {
			System.out.println("result: " + a);
		}
		
	}
	
	public static int[] solution(int []arr) {
		int temp = -1;
		
		List<Integer> list = new ArrayList<>();
		for (int a : arr) {
			if (temp != a) {
				list.add(a);
			}
			
			temp = a;
		}
		
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        
        return answer;
	}
}
