package programmers.level1;

import java.util.HashSet;

/**
 * 
 * @author ChoiSangHyun
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 
 * 제한사항
 * 1) 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * 2) completion의 길이는 participant의 길이보다 1 작습니다.
 * 3) 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 4) 참가자 중에는 동명이인이 있을 수 있습니다.
 * 
 * 입출력 예
 * participant						completion						return
 * 
 * ["marina", "josipa", 			 ["josipa", "filipa",			"vinko"
 * "nikola", "vinko", "filipa"]		 "marina, "nikola"]	
 * 
 * 
 * ["mislav", "stanko",				["stanko", "ana", "mislav"]		"mislav"
 *  "mislav", "ana"]		
 */

public class 완주하지못한선수 {
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		System.out.println(solution(participant, completion));
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		
		HashSet<String[]> hash = new HashSet<>();
		hash.add(completion);
		
		for (int i = 0; i < participant.length; i++) {
			
		}
		
		
		
        return answer;
    }
}
