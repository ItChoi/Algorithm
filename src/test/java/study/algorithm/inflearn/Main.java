package study.algorithm.inflearn;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 (인프런 강의)
 */
public class Main {

    // String(문자열) start
    // 3. 문장 속 단어 start
    // 3. 문장 속 단어(indexOf(), substring())
    @Test
    public void 문장_속_단어() {
        System.out.println("RESULT::: " + 문장_속_단어_함수("it is time to study"));

    }

    // substring, indexof를 활용할 수도 있네.......
    public String 문장_속_단어_함수(String str) {
        String answer = "";

        int m = Integer.MIN_VALUE;
        int pos = Integer.MIN_VALUE;

        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);

            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }

            str = str.substring(pos + 1);
        }

        if (str.length() > m) {
            answer = str;
        }

        /*String[] s = str.split(" ");
        for (String x : s) {
            int len = x.length();

            if (len > m) {
                m = len;
                answer = x;
            }
        }*/

        return answer;
    }
    // 3. 문장 속 단어 end


    // 4. 단어 뒤집기(StringBuilder이용법 또는 직접뒤집기) start
    @Test
    public void 단어_뒤집기() {
        // StringBuilder reverse?

        int n = 3;
        String[] str = new String[n];
        str[0] = "good";
        str[1] = "Time";
        str[2] = "Big";

        for (String x : 단어_뒤집기_함수(n, str)) {
            System.out.println(x);
        }
    }

    private ArrayList<String> 단어_뒤집기_함수(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        for (String x : str) {
            /* 방법 1
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
            */
            
            // 방법 2 직접 뒤집기
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() - 1;
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }
    // 4. 단어 뒤집기(StringBuilder이용법 또는 직접뒤집기) end

    // 5. 특정 문자 뒤집기(toCharArray()) start
    @Test
    void 특정_문자_뒤집기() {
        System.out.println("result:: " + 특정_문자_뒤집기_함수("a@fb"));
        //System.out.println("result:: " + 특정_문자_뒤집기_함수("a#b!GE*T@S"));
    }

    private String 특정_문자_뒤집기_함수(String str) {
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(s[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(s[rt])) {
                rt--;
            } else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;

                lt++;
                rt--;
            }
        }

        return String.valueOf(s);
    }
    // 5. 특정 문자 뒤집기(toCharArray()) end


    // 6. 중복문자제거 start
    @Test
    void 중복_문자_제거() {
        System.out.println("result::: " + 중복_문자_제거_함수("ksskkset"));
    }

    private String 중복_문자_제거_함수(String str) {
        String answer = "";

        // charAt 자리와 indexOf 자리가 똑같으면 중복 문자가 아니다.
        for (int i = 0; i < str.length(); i++) {
            //System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));

            if (str.indexOf(str.charAt(i)) != i){
                answer += str.charAt(i);
            }
        }

        return answer;
    }
    // 6. 중복문자제거 end

    // 7. 회문문자열 start
    @Test
    void 회문_문자열() {
        System.out.println("result::: " + 회문_문자열_함수("gooG"));
    }

    private String 회문_문자열_함수(String str) {
        // 방법1
        /*String answer = "Yes";
        str = str.toUpperCase();
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return "NO";
            }
        }*/
        // 방법2
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp)) {
            answer = "YES";
        }

        return answer;
    }
    // 7. 회문문자열 end

    // 8. 유효한 팰린드롬(replaceAll 정규식이용) start
    @Test
    void 유효한_팰린드롬() {
        String s = "found7, time: study; Yduts; emit, 7Dnuof";
        System.out.println("result:: " + 유효한_팰린드롬_함수(s));
    }

    private String 유효한_팰린드롬_함수(String s) {
        String answer = "NO";

        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(s).reverse().toString();
        if (s.equals(tmp)) {
            answer = "YES";
        }

        return answer;
    }
    // 8. 유효한 팰린드롬(replaceAll 정규식이용) end

    // 9. 숫자만 추출 start
    @Test
    void 숫자만_추출() {
        System.out.println("result: " + 숫자만_추출_함수("g0en2T0s8eSoft"));
    }

    private int 숫자만_추출_함수(String s) {
        // 방법 1
        /*int answer = 0;

        for (char x : s.toCharArray()) {
            if (x >= 48 && x <= 57) {
                // 아스키넘버랑 +가 결합되면 0인데, 아스키 넘버 48으로 연산된다.
                answer = answer * 10 + (x-48);
            }
        }
        return answer;*/

        // 방법 2
        String answer = "";
        for (char x : s.toCharArray()) {
            // char 값이 숫자인지 체크해주는 함수
            if (Character.isDigit(x)) {
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }
    // 9. 숫자만 추출 end


    // 10. 가장 짧은 문자거리 start
    @Test
    void 가장_짧은_문자거리() {
        String s = "teachermode";
        //String t = "e";
        char t = 'e';
        for (int i : 가장_짧은_문자거리_함수(s, t)) {
            System.out.println("result: " + i);
        }
    }

    private int[] 가장_짧은_문자거리_함수(String s, char t) {
        /* 내가 푼 거
        int[] answer = new int[s.length()];
        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i)+"").equals(t)) {
                p = 0;
                answer[i] = p;
                continue;
            }
            answer[i] = ++p;
        }
        p = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i)+"").equals(t)) {
                p = 0;
                continue;
            }
            if (answer[i] > p) {
                answer[i] = ++p;
                continue;
            }
            p++;
        }
        return answer;*/

        int[] answer = new int[s.length()];
        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }

        p = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }
    // 10. 가장 짧은 문자거리 end

    // 11. 문자열 압축 start
    @Test
    void 문자열_압축() {
        String s = "KKHSSSSSSSE";
        System.out.println("RESULT::: " + 문자열_압축_함수(s));
    }

    private String 문자열_압축_함수(String s) {
        /*StringBuilder answer = new StringBuilder();
        int i = 0;
        char compareC = 0;
        for (char c : s.toCharArray()) {
            if (compareC != 0) {
                if (c == compareC) {
                    i++;
                } else {
                    if (i >= 2) {
                        answer.append(i);
                        answer.append(c);
                    } else {
                        answer.append(c);
                    }
                    compareC = 0;
                    i = 0;
                }
            } else {
                i++;
                compareC = c;
                answer.append(c);
            }
        }
        return answer.toString();*/

        String answer = "";
        s = s + " ";
        int cnt = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                answer += s.charAt(i);
                if (cnt > 1) {
                    answer += cnt;
                    cnt = 1;
                }
            }
        }

        return answer;
    }
    // 11. 문자열 압축 end


    // 12. 암호 start

    /**
     * #****## --> 'C'
     * #**#### --> 'O'
     * #**#### --> 'O'
     * #**##** --> 'L'
     */
    @Test
    void 암호() {
        /*String s = "#****###**#####**#####**##**";
        System.out.println("result::: " + 암호_함수(s));*/

        String s = "#****###**#####**#####**##**";
        System.out.println("result::: " + 암호_함수(4, s));
    }

    /*private String 암호_함수(String s) {
        String answer = "";
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.charAt(i) + "";
            if (s1.equals("#")) {
                temp += "1";
            } else if (s1.equals("*")) {
                temp += "0";
            }
        }

        int start = 0;
        int end = 7;
        String tempS = "";
        for (int i = 0; i < temp.length() / 7; i++) {
            tempS = temp.substring(start, end);
            int i1 = Integer.parseInt(tempS, 2);
            answer += (char) i1;

            start = end;
            end = end + 7;
        }

        return answer;
    }*/
    private String 암호_함수(int n, String s) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            s = s.substring(7);
        }

        return answer;
    }
    // 12. 암호 end
    // String(문자열) end



    // Array(1, 2차원 배열) start

    // 1. 큰 수 출력하기 start
    @Test
    void 큰_수_출력하기() {
        int n = 6;
        int[] arr = {7, 3, 9, 5, 6, 12};
        for (Integer integer : 큰_수_출력하기_함수(n, arr)) {
            System.out.println("result::: " + integer);
        }

    }

    private ArrayList<Integer> 큰_수_출력하기_함수(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                answer.add(arr[i]);
            }
        }

        return answer;
    }
    // 1. 큰 수 출력하기 end

    // 2. 보이는 학생 start
    @Test
    void 보이는_학생() {
        int n = 6;
        int[] arr = {130, 135, 148, 140, 145, 150, 150, 153};
        System.out.println("result::: " + 보이는_학생_함수(n, arr));
    }

    private int 보이는_학생_함수(int n, int[] arr) {
        int result = 1;
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                result++;
                max = arr[i];
            }
        }
        return result;
    }
    // 2. 보이는 학생 end

    // 3. 가위바위보 start
    @Test
    void 가위바위보() {
        int n = 5;
        int[] user1 = {2, 3, 3, 1, 3};
        int[] user2 = {1, 1, 2, 2, 3};
        for (String result : 가위바위보_함수(n, user1, user2)) {
            System.out.println("result::: " + result);
        }
    }

    private List<String> 가위바위보_함수(int n, int[] user1, int[] user2) {
        List<String> answer = new ArrayList<>();
        // 1: 가위, 2: 바위, 3: 보
        for (int i = 0; i < n; i++) {
            /* 방법 1 - 내가 푼 것
            if (user1[i] == user2[i]) {
                answer.add("D");
            } else if (user1[i] != 3 && user1[i] + 1 == user2[i]) {
                answer.add("B");
            } else if(user1[i] == 3 && user1[i] -2 == user2[i]) {
                answer.add("B");
            } else {
                answer.add("A");
            }*/
            if (user1[i] == user2[i]) {
                answer.add("D");
            } else if (user1[i] == 1 && user2[i] == 3) {
                answer.add("A");
            } else if (user1[i] == 2 && user2[i] == 1) {
                answer.add("A");
            } else if (user1[i] == 3 && user2[i] == 2) {
                answer.add("A");
            } else {
                answer.add("B");
            }
        }
        return answer;
    }
    // 3. 가위바위보 end

    // 4. 피보나치 수열 start
    @Test
    void 피보나치_수열() {
        int n = 3;
        for (Integer result : 피보나치_수열_함수(n)) {
            System.out.println("result: " + result);
        }
    }

    private List<Integer> 피보나치_수열_함수(int n) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                answer.add(1);
                continue;
            }
            answer.add(answer.get(i - 1) + answer.get(i-2));
        }
        return answer;
    }
    // 4. 피보나치 수열 end

    // 5. 소수(에라토스테네스 체) start
    @Test
    void 소수_에라토스테네스체() {
        int n = 20;
        System.out.println("result::: " + 소수_에라토스테네스체_함수(n));
    }

    private int 소수_에라토스테네스체_함수(int n) {
        int result = 0;
        int[] ch = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                result++;
                for (int j = i; j <= n; j=j+i) {
                    ch[j] = 1;
                }
            }
        }
        /*for (int i = 3; i <= n; i++) {
            boolean isSosu = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isSosu = false;
                    break;
                }
            }

            if (isSosu) {
                result++;
            }
        }*/
        return result;
    }
    // 5. 소수(에라토스테네스 체) end


    // 6. 뒤집은 소수 start
    @Test
    void 뒤집은_소수() {
        int n = 9;
        int[] arr = {32, 55, 62, 20, 250, 370, 200, 30, 100};
        System.out.println("result::: " + 뒤집은_소수_함수(n, arr));
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> 뒤집은_소수_함수(int n, int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (isPrime(res)) {
                result.add(res);
            }
        }
        /*for (int i = 0; i < arr.length; i++) {
            String val = arr[i] + "";
            String temp = "";
            for (int j = val.length() - 1; j >= 0; j--) {
                temp += val.charAt(j);
            }
            int checkNum = Integer.parseInt(temp);

            boolean isSosu = checkNum > 1;
            for (int k = 2; k < checkNum; k++) {
                if (checkNum % k == 0) {
                    isSosu = false;
                    break;
                }
            }

            if (isSosu) {
                result.add(checkNum);
            }
        }*/
        return result;
    }
    // 6. 뒤집은 소수 end

    // 7. 점수계산 start
    @Test
    void 점수계산() {
        int n = 10;
        int[] arr = {1, 0, 1, 1, 1, 0, 0, 1, 1, 0};
        System.out.println("result::: " + 점수계산_함수(n, arr));
    }

    private int 점수계산_함수(int n, int[] arr) {
        int result = 0;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                result += cnt;
            } else {
                cnt = 0;
            }
        }

        /*int bonus = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                result += 1 + bonus;
                bonus++;
                continue;
            }

            bonus = 0;
        }*/

        return result;
    }
    // 7. 점수계산 end

    // 8. 등수구하기 start
    @Test
    void 등수구하기() {
        int n = 3;
        int[] arr = {2,2,1};
        for (Integer result : 등수구하기_함수(n, arr)) {
            System.out.println("result = " + result);
        }
    }
    private int[] 등수구하기_함수(int n, int[] arr) {
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        /*int n = arr.length;
        List<Integer> tempCopy = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j-1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tempCopy.get(i) == arr[j]) {
                    result.add(j+1);
                    break;
                }
            }
        }*/
        return answer;
    }
    // 8. 등수구하기 end

    // 9. 격자판 최대합 start
    @Test
    void 격자판_최대합() {
        int n = 5;
        int[][] arr = {
            {10, 13, 10, 12, 15},
            {12, 39, 30, 23, 11},
            {11, 25, 50, 53, 15},
            {19, 27, 29, 37, 27},
            {19, 13, 30, 13, 19}
        };
        System.out.println("resutl::: " + 격자판_최대합_함수(n, arr));
    }
    private int 격자판_최대합_함수(int n, int[][] arr) {
        int answer = 0;

        int sum1;
        int sum2;
        for (int i = 0; i < n; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = 0;
        sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }
    // 9. 격자판 최대합 end

    // 10. 봉우리 start
    @Test
    void 봉우리() {
        int n = 5;
        int[][] arr = {
            {5, 3, 7, 2, 3},
            {3, 7, 1, 6, 1},
            {7, 2, 5, 3, 4},
            {4, 3, 6, 4, 1},
            {8, 7, 3, 5, 2}
        };
        System.out.println("result::: " + 봉우리_함수(n, arr));
    }

    private int 봉우리_함수(int n, int[][] arr) {
        int answer = 0;

        // if문 4개 보다 해당 지점에 방향의 인덱스 번호를 배열로 관리하는게 좋다.
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;

                for (int k = 0; k < 4; k++) {
                    // 행좌표
                    int nx = i + dx[k];
                    // 열좌표
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                }
            }
        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int point = arr[i][j];

                if (i - 1 >= 0) {
                    if (point <= arr[i - 1][j]) {
                        continue;
                    }
                }

                if (i + 1 != n) {
                    if (point <= arr[i + 1][j]) {
                        continue;
                    }
                }

                if (j - 1 >= 0) {
                    if (point <= arr[i][j - 1]) {
                        continue;
                    }
                }

                if (j + 1 != n) {
                    if (point <= arr[i][j + 1]) {
                        continue;
                    }
                }

                answer++;
            }
        }*/

        return answer;
    }

    // 10. 봉우리 end

    // 11. 임시반장정하기 start
    @Test
    void 임시반장정하기() {
        int n = 5;
        int[][] arr = {
            {2, 3, 1, 7, 3},
            {4, 1, 9, 6, 8},
            {5, 5, 2, 4, 4},
            {6, 5, 2, 6, 7},
            {8, 4, 2, 2, 2}
        };

        System.out.println("result::: " + 임시반장정하기_함수(n, arr));
    }

    private int 임시반장정하기_함수(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        // 학생 번호
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }

            if (cnt > max) {
                max = cnt;
                answer = i + 1;
            }
        }




        /* 내가 푼 것 - 틀렸었네...
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int compareCount = 0;
            for (int j = 0; j < n; j++) {
                List<Integer> existsIndex = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (j == k || existsIndex.contains(k)) {
                        continue;
                    }

                    if (arr[i][j] == arr[j][k]) {
                        existsIndex.add(k);
                        compareCount++;
                    }
                }

                if (maxCount < compareCount) {
                    maxCount = compareCount;
                    answer = i;
                }
            }
        }*/

        return answer;
    }
    // 11. 임시반장정하기 end


    // 12. 멘토링 start
    @Test
    void 멘토링() {
        int n = 4;
        int m = 3;
        int[][] arr = {
                {3, 4, 1, 2},
                {4, 3, 2, 1},
                {3, 1, 4, 2}
        };

        System.out.println("result:: " + 멘토링_함수(n, m, arr));
    }

    private int 멘토링_함수(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi = 0;
                    int pj = 0;
                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) pi = s;
                        if (arr[k][s] == j) pj = s;
                    }

                    if (pi < pj) {
                        cnt++;
                    }
                }
                if (cnt == m) answer++;
            }

        }

        return answer;
    }
    // 12. 멘토링 end


    // Array(1, 2차원 배열) end


    // Tow pointers, Sliding window[효율성 : O(n^2)-->O(n)] START



    // 1. 두 배열 합치기(two pointers algorithm) START
    @Test
    void 두_배열_합치기() {
        /*int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 3, 6, 7, 9};*/
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 3, 5};
        for (Integer integer : 두_배열_합치기_함수(arr1, arr2)) {
            System.out.println("result: " + integer);
        }
    }

    private List<Integer> 두_배열_합치기_함수(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (; j < arr2.length; j++) {
                if (arr1[i] < arr2[j]) {
                    answer.add(arr1[i]);
                    break;
                } else {
                    answer.add(arr2[j]);
                }
            }

            if (i == arr1.length - 1 && j < arr2.length) {
                for (; j < arr2.length; j++) {
                    answer.add(arr2[j]);
                }
            } else if (j == arr2.length - 1 && i < arr1.length) {
                for (; i < arr1.length; i++) {
                    answer.add(arr1[i]);
                }
            }
        }

        return answer;
    }
    // 1. 두 배열 합치기(two pointers algorithm) END


    // 2. 공통원소 구하기 START
    @Test
    void 공통원소_구하기() {
        int[] arr1 = {1, 3, 9, 5, 2};
        int[] arr2 = {3, 2, 5, 7, 8};
        for (Integer integer : 공통원소_구하기_함수(arr1, arr2)) {
            System.out.println("result = " + integer);
        }
    }

    private List<Integer> 공통원소_구하기_함수(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n = arr1.length;
        int m = arr2.length;

        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1++]);
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        /* my resolve
        int length1 = arr1.length;
        int length2 = arr2.length;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0;
        int p2 = 0;
        while (p1 < length1 && p2 < length2) {
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            } else {
                p1++;
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    answer.add(arr1[i]);
                    break;
                }
            }
        }

        Collections.sort(answer);*/
        return answer;
    }
    // 2. 공통원소 구하기 END

    // 3. 최대 매출 START
    @Test
    void 최대_매출() {
        int n = 10;
        int k = 3;
        int[] arr = {12, 15, 11, 20, 25, 10, 20, 19, 13, 15};
        System.out.println("result::: " + 최대_매출_함수(n, k, arr));
    }
    private int 최대_매출_함수(int n, int k, int[] arr) {
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) sum += arr[i];
        answer = sum;

        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }



        /* my resolve
        int tempMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i >= k) {
                if (answer < tempMax) {
                    answer = tempMax;
                }
                tempMax -= arr[i-k];
            }

            tempMax += arr[i];
        }
        for (int i = 0; i < arr.length - k; i++) {
            int tempMax = 0;
            for (int j = i; j < i + k; j++) {
                tempMax += arr[j];
            }

            if (max < tempMax) {
                max = tempMax;
            }
        }*/

        return answer;
    }
    // 3. 최대 매출 END


    // 4. 연속 부분수열
    @Test
    void 연속_부분수열() {
        int n = 8;
        int m = 6;
        /*int[] arr = {1, 2, 1, 3, 1, 1, 1, 2};*/
        int[] arr = {1, 1, 1, 1, 1, 1, 5, 1};
        System.out.println("연속_부분수열_함수 = " + 연속_부분수열_함수(n, m, arr));
    }
    private int 연속_부분수열_함수(int n, int m, int[] arr) {
        int answer = 0;
        /*int sum = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) {
                answer++;
            }

            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }*/


        // my resolve
        int lt = 0;
        int rt = 0;
        int sum = 0;
        while (rt < n) {
            if (sum <= m) {
                sum += arr[rt++];
            }
            if (sum == m) {
                sum -= arr[lt++];
                answer++;
            } else if (sum > m) {
                sum -= arr[lt++];
                if (sum == m) {
                    answer++;
                }
            }
        }



        return answer;
    }




    // Tow pointers, Sliding window[효율성 : O(n^2)-->O(n)] END
}
