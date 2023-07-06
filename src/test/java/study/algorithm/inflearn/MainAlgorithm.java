package study.algorithm.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 자바(Java) 알고리즘 문제풀이 입문: 코딩테스트 대비 - 김태원 (인프런 강의) -> 재복습
 */
public class MainAlgorithm {

    // 1. 문자 찾기 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);

        System.out.println(T.solution(str, c));
    }

    public int solution(String str, char t) {
        int answer = 0;

        t = Character.toLowerCase(t);
        for (char c : str.toLowerCase().toCharArray()) {
            if (c == t) {
                answer++;
            }
        }

        return answer;
    }*/
    // 1. 문자 찾기 END

    // 2. 대소문자 변환 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        StringBuilder answer = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer.append(Character.toUpperCase(c));
                continue;
            }

            answer.append(Character.toLowerCase(c));
        }

        return answer.toString();
    }*/
    // 2. 대소문자 변환 END

    // 3. 문장 속 단어 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        String[] arr = str.split(" ");

        String result = "";
        for (int i = 0; i < arr.length; i++) {
            String compareStr = arr[i];

            if (result.length() < compareStr.length()) {
                result = compareStr;
            }
        }

        return result;
    }*/
    // 3. 문장 속 단어 END

    // 4. 단어 뒤집기 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        String[] str = new String[3];
        str[0] = kb.next();
        str[1] = kb.next();
        str[2] = kb.next();

        for (String s : T.solution(str)) {
            System.out.println(s);
        }
    }

    public String[] solution(String[] str) {
        String[] result = new String[str.length];


        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            int sLength = s.length();
            int iLength = sLength / 2;

            char[] cArr = s.toCharArray();

            for (int j = 0; j < iLength; j++) {
                int jLength = sLength - j - 1;
                char tempC = cArr[j];
                cArr[j] = cArr[jLength];
                cArr[jLength] = tempC;
            }

            result[i] = new String(cArr);
        }

        return result;
    }*/
    // 4. 단어 뒤집기 END

    // 5. 특정 문자 뒤집기 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        char[] strC = str.toCharArray();

        int sLength = str.length();
        int lt = 0;
        int rt = sLength - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(strC[lt])) {
                lt++;
                continue;
            }

            if (!Character.isAlphabetic(strC[rt])) {
                rt--;
                continue;
            }

            char tempC = strC[lt];
            strC[lt] = strC[rt];
            strC[rt] = tempC;

            lt++;
            rt--;
        }

        return String.valueOf(strC);
    }*/
    // 5. 특정 문자 뒤집기 END

    // 6. 중복문자제거 START
    public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        Set<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }

        return set.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
    }
    // 6. 중복문자제거 END
}
