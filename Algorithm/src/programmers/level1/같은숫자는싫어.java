package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itcho
 * ���� ����
 * �迭 ���� 0 ~ 9�� �̷������ arr�� �־�����. �̶� arr�� ���������� ��Ÿ���� ���ڴ� �ϳ��� ����� ���� ����
 * ��, ���� �� ���� ������ ��ȯ �� ������ ������ ����
 * ex)
 * arr = [1, 1, 3, 3, 0, 1, 1] -> [1, 3, 0, 1] return
 * arr = [4, 4, 4, 3, 3] -> [4, 3] return 
 *
 */
public class �������ڴ½Ⱦ� {
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
