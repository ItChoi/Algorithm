package study.algorithm.inflearn;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;
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
        int n = arr1.length;
        int m = arr2.length;

        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                answer.add(arr1[p1++]);
            } else {
                answer.add(arr2[p2++]);
            }
        }

        while (p1 < n) answer.add(arr1[p1++]);
        while (p2 < m) answer.add(arr2[p2++]);



        /* 내가 푼 것
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
        }*/

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

    // 5. 연속된 자연수의 합 START
    @Test
    void 연속된_자연수의_합() {
        int n = 15;
        System.out.println("연속된_자연수의_합_함수(n) = " + 연속된_자연수의_합_함수(n));
    }

    private int 연속된_자연수의_합_함수(int n) {
        int answer = 0;
        int cnt = 1;
        n--;
        while (n > 0) {
            cnt++;
            n = n - cnt;
            if (n % cnt == 0) {
                answer++;
            }
        }


        /*int sum = 0;
        int lt = 0;
        int m = n / 2 + 1;
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }

            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }*/

        /* 내가 푼 것
        int sum = 0;
        int lt = 1;
        for (int rt = 1; rt < n; rt++) {
            sum += rt;
            if (sum == n) {
                answer++;
            }

            while (n <= sum) {
                sum -= lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }*/

        return answer;
    }
    // 5. 연속된 자연수의 합 END

    // 6. 최대 길이 연속부분수열 START
    @Test
    void 최대_길이_연속부분수열() {
        int n = 14;
        int k = 2;
        //int[] arr = {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};
        //int[] arr = {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1};
        int[] arr = {1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1};
        System.out.println("최대_길이_연속부분수열_함수() = " + 최대_길이_연속부분수열_함수(n, k, arr));
    }

    private int 최대_길이_연속부분수열_함수(int n, int k, int[] arr) {
        int answer = 0;

        int cnt = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) cnt++;

            while (cnt > k) {
                if (arr[lt] == 0) cnt --;
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }


        /* 내가 푼 것
        int limitCount = 0;
        int tempLength = 0;
        int j = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            if (arr[rt] == 1) {
                tempLength++;
            } else {
                limitCount++;
                j++;
                if (limitCount > k) {
                    if (answer < tempLength) {
                        answer = tempLength;
                    }

                    limitCount = k - 1;
                    tempLength = rt - j;
                } else {
                    tempLength++;
                }

            }
        }*/




        return answer;
    }
    // 6. 최대 길이 연속부분수열 END

    // Tow pointers, Sliding window[효율성 : O(n^2)-->O(n)] END


    // HashMap, TreeSet (해쉬, 정렬지원 Set) START


    // 1. 학급 회장(해쉬) START
    @Test
    void 학급_회장() {
        int n = 15;
        String str = "BACBACCACCBDEDE";
        System.out.println("학급_회장_함수(n, str) = " + 학급_회장_함수(n, str));
    }

    private String 학급_회장_함수(int n, String str) {
        String answer = "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key + "";
            }
        }


        /* 내가 푼 것
        Map<String, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            String s = String.valueOf(c);
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        int max = 0;
        for (String s : map.keySet()) {
            Integer count = map.get(s);
            if (max < count) {
                max = count;
                answer = s;
            }
        }*/

        return answer;
    }
    // 1. 학급 회장(해쉬) END

    // 2. 아나그램(해쉬) START
    @Test
    void 아나그램() {
        /*String str1 = "AbaAeCe";
        String str2 = "baeeACA";*/
        String str1 = "abaCC";
        String str2 = "Caaab";
        System.out.println("result = " + 아나그램_함수(str1, str2));
    }

    private String 아나그램_함수(String str1, String str2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : str2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x) - 1);
        }

        return answer;

        /* 내가 푼 것
        String answer = "YES";

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();


        for (char c : str1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (Character key : map1.keySet()) {
            if (!map2.containsKey(key) || !map1.get(key).equals(map2.get(key))) {
                answer = "NO";
            }
        }

        return answer;*/
    }

    // 2. 아나그램(해쉬) END

    // 3. 매출액의 종류(Hash, sliding window) START
    @Test
    void 매출액의_종류() {
        int n = 7;
        int k = 4;
        int[] arr = {20, 12, 20, 10, 23, 17, 10};
        for (Integer integer : 매출액의_종류_함수(n, k, arr)) {
            System.out.println("result = " + integer);
        }
    }

    private List<Integer> 매출액의_종류_함수(int n, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        return answer;

        /* 내가 푼 것
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int lt = 0;
        for (int rt = 0; rt <= n; rt++) {
            if (rt >= k) {
                for (int i = lt; i < rt; i++) {
                    int key = arr[i];
                    map.put(key, map.getOrDefault(map.get(key), 0) + 1);
                }
                answer.add(map.size());

                map.clear();
                lt++;
            }
        }

        return answer;*/
    }

    // 3. 매출액의 종류(Hash, sliding window) END

    // 4. 모든 아나그램 찾기(Hash, sliding window : 시간복잡도 O(n)) START
    @Test
    void 모든_아나그램_찾기() {
        String s = "bacaAacba";
        String t = "abc";
        System.out.println("RESULT: " + 모든_아나그램_찾기_함수(s, t));
    }

    private int 모든_아나그램_찾기_함수(String s, String t) {
        int answer = 0;
        Map<Character, Integer> am = new HashMap<>();
        Map<Character, Integer> bm = new HashMap<>();

        for (char x : t.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        int L = t.length() - 1;
        for (int i = 0; i < L; i++) {
            am.put(s.charAt(i), am.getOrDefault(s.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = L; rt < s.length(); rt++) {
            am.put(s.charAt(rt), am.getOrDefault(s.charAt(rt), 0) + 1);
            if (am.equals(bm)) answer++;
            am.put(s.charAt(lt), am.get(s.charAt(lt)) - 1);
            if (am.get(s.charAt(lt)) == 0) am.remove(s.charAt(lt));
            lt++;
        }



        /* 내가 푼 것
        int answer = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for (int i = 0; i < t.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            sMap.put(sc, sMap.getOrDefault(sc, 0) + 1);
            tMap.put(tc, tMap.getOrDefault(tc, 0) + 1);
        }

        int tLength = t.length();
        for (int rt = tLength; rt < s.length(); rt++) {
            boolean status = true;
            for (Character c : sMap.keySet()) {
                if (!tMap.containsKey(c) || sMap.get(c) == 0) {
                    status = false;
                    break;
                }

                sMap.put(c, sMap.get(c) - 1);
            }
            sMap.clear();

            if (status) answer++;

            int lt = rt - tLength + 1;
            for (; lt <= rt; lt++) {
                char c = s.charAt(lt);
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }
        }*/

        return answer;
    }
    // 4. 모든 아나그램 찾기(Hash, sliding window : 시간복잡도 O(n)) END

    // 5. K번째 큰 수(영상 후반 TreeSet 추가설명) START
    // TreeSet은 이진 탐색 트리 구조로 이루어져 있다. -> 추가 삭제에는 시간이 걸리지만, 정렬, 검색에 높은 성능을 보이는 자료구조
    @Test
    void K번째_큰_수() {
        int n = 10;
        int k = 3;
        int[] arr = {13, 15, 34, 23, 45, 65, 33, 11, 26, 42};
        System.out.println("RESULT: " + K번째_큰_수_함수(n, k, arr));
    }

    private int K번째_큰_수_함수(int n, int k, int[] arr) {
        int answer = -1;
        // TreeSet - 디폴트가 오름차순, 내림차순으로 해야할 때 파라미터(Collections.reverseOrder()) 추가
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        for (Integer x : Tset) {
            System.out.println(x);

            cnt++;
            if (cnt == k) return x;
        }

        return answer;



        // TODO 풀어보기
        /*int answer = 0;
        return answer;*/
    }
    // 5. K번째 큰 수(영상 후반 TreeSet 추가설명) END

    // HashMap, TreeSet (해쉬, 정렬지원 Set) END

    // Stack, Queue(자료구조) START

    // 1. 올바른 괄호 START
    @Test
    void 올바른_괄호() {
        String str = "(()(()))(()";
//        String str = "(())()";
//        String str = "(()()))";
//        String str = "(()())";
        System.out.println("RESULT: " + 올바른_괄호_함수(str));
    }

    private String 올바른_괄호_함수(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if (!stack.isEmpty()) return "NO";

        return answer;


        // 내가 푼 것 - 규칙 잘못 봄
        /*String answer = "YES";
        Stack<Character> stack = new Stack();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        boolean status = true;
        int cnt = 0;
        for (Character c : stack) {
            if ("(".equals(String.valueOf(c))) {
                cnt++;
                if (!status && cnt != 0) {
                    answer = "NO";
                    break;
                }
            } else {
                status = false;
                cnt--;
            }
            if (cnt == 0) status = true;

        }

        return answer;*/
    }

    // 1. 올바른 괄호 END

    // 2. 괄호문자제거 START
    @Test
    void 괄호문자제거() {
        String str = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";
        System.out.println("RESULT: " + 괄호문자제거_함수(str));
    }

    private String 괄호문자제거_함수(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;

        // 내가 푼 것
        /*String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                stack.pop();
            } else {
                if (stack.isEmpty() || !stack.contains('(')) {
                    stack.push(x);
                }
            }
        }

        return stack.toString();*/
    }
    // 2. 괄호문자제거 END

    // 3. 크레인 인형뽑기(카카오) START
    @Test
    void 크레인_인형뽑기() {
        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        // 4, 3, 1, 1, 2, 3, 4
        System.out.println("RESULT: " + 크레인_인형뽑기_함수(board, moves));
    }

    private int 크레인_인형뽑기_함수(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos - 1] != 0) {
                    int tmp = board[i][pos - 1];
                    board[i][pos - 1] = 0;

                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }


        // 내가 푼 것
        /*Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int moveNum = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {
                if (board[j][moveNum] > 0) {
                    stack.push(board[j][moveNum]);
                    board[j][moveNum] = 0;
                    break;
                }
            }

            while (stack.size() >= 2) {
                int size = stack.size();
                int pre = size - 2;
                int cur = size - 1;
                if (stack.get(pre).equals(stack.get(cur))) {
                    stack.pop();
                    answer++;
                    stack.pop();
                    answer++;
                } else {
                    break;
                }
            }
        }*/

        return answer;
    }
    // 3. 크레인 인형뽑기(카카오) END

    // 4. 후위식 연산(postfix) START
    @Test
    void 후위식_연산() {
        String str = "352+*9-";
        System.out.println("result: " + 후위식_연산_함수(str));
    }

    private int 후위식_연산_함수(String str) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+') {
                    stack.push(lt + rt);
                } else if (x == '-') {
                    stack.push(lt - rt);
                } else if (x == '*') {
                    stack.push(lt * rt);
                } else if (x == '/') {
                    stack.push(lt / rt);
                }
            }
        }
        answer = stack.pop();
        return answer;

        // 내가 푼 것
        /*int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (!(c > 48 && c < 58)) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();

                if (c == '+') {
                    stack.push(pop2 + pop1);
                } else if (c == '-') {
                    stack.push(pop2 - pop1);
                } else if (c == '*') {
                    stack.push(pop2 * pop1);
                } else if (c == '/') {
                    stack.push(pop2 / pop1);
                }

                continue;
            }

            stack.push(Integer.parseInt(c+""));
        }

        answer = stack.pop();

        return answer;*/
    }

    // 4. 후위식 연산(postfix) END

    // 5. 쇠막대기 START (*)
    @Test
    void 쇠막대기() {
        String str = "()(((()())(())()))(())";
        //String str = "(((()(()()))(())()))(()())";
        System.out.println("result: " + 쇠막대기_함수(str));
    }

    private int 쇠막대기_함수(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        return answer;


        // 내가 푼 것
        /*int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                Character pop = stack.pop();
                if (pop == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        return answer;*/
    }
    // 5. 쇠막대기 END

    // 6. 공주 구하기 START
    @Test
    void 공주_구하기() {
        int n = 8;
        int k = 3;
        System.out.println("result: " + 공주_구하기_함수(n, k));
    }

    private int 공주_구하기_함수(int n, int k) {
        int answer = 0 ;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            Q.offer(i);
        }

        while (!Q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                Q.offer(Q.poll());
            }
            Q.poll();
            if (Q.size() == 1) {
                answer = Q.poll();
                break;
            }
        }
        
        return answer;
        
        // 내가 푼 것
        /*Queue<Integer> que = new LinkedList<>();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (que.contains(i)) {
                if (i == n) {
                    i = 0;
                } else {
                    continue;
                }
            } else {
                if (++cnt == k) {
                    que.add(i);
                    cnt = 0;
                }

                if (i == n) {
                    i = 0;
                }

                if (que.size() == n) break;
            }
        }

        while (que.size() != 1) {
            que.poll();
        }

        return que.poll();*/
    }

    // 6. 공주 구하기 END

    // 7. 교육과정설계 START
    @Test
    void 교육과정설계() {
        String a = "CBA";
        String b = "CBDAGE";
//        String b = "CFDBGHA";
        System.out.println("result: " + 교육과정설계_함수(a, b));
    }

    private String 교육과정설계_함수(String a, String b) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for (char x : a.toCharArray()) {
            Q.offer(x);
        }

        for (char x : b.toCharArray()) {
            if (Q.contains(x)) {
                if (x != Q.poll()) {
                    return "NO";
                }
            }
        }
        if (!Q.isEmpty()) return "NO";
        return answer;

        // 내가 푼 것
        /*Queue<Character> que = new LinkedList<>();
        for (char x : b.toCharArray()) {
            que.offer(x);
        }
        int totalCnt = 0;
        int j = 0;
        for (int i = 0; i < b.length(); i++) {
            Character pollVal = que.poll();
            if (a.contains(pollVal + "")) {
                if (a.charAt(j++) != pollVal) {
                    return "NO";
                }
                totalCnt++;
            }
        }
        return totalCnt == a.length() ? "YES" : "NO";*/
    }

    // 7. 교육과정설계 END

    // 8. 응급실 START
    @Test
    void 응급실() {
        /*int n = 5;
        int m = 2;
        int[] arr = {60, 50, 70, 80, 90};*/

        int n = 6;
        int m = 3;
        int[] arr = {70, 60, 90, 60, 60, 60};
        System.out.println("test: " + 응급실_함수(n, m, arr));
    }
    private int 응급실_함수(int n, int m, int[] arr) {
        class Person {
            int id;
            int priority;
            public Person(int id, int priority) {
                this.id = id;
                this.priority = priority;
            }
        }

        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Q.offer(new Person(i, arr[i]));
        }

        while (!Q.isEmpty()) {
            Person tmp = Q.poll();
            for (Person x : Q) {
                if (x.priority > tmp.priority) {
                    Q.add(tmp);
                    tmp = null;
                    break;
                }
            }

            if (tmp != null) {
                answer++;
                if (tmp.id == m) return answer;
            }
        }

        return answer;





        // 내가 푼 것
        /*int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int i : arr) {
            que.offer(i);
        }
        while (answer != (m + 1)) {
            boolean isSuccess = true;
            Integer poll = que.poll();
            for (Integer i : que) {
                if (poll < i) {
                    que.offer(poll);
                    isSuccess = false;
                    break;
                }
            }
            if (isSuccess) {
                answer++;
            }
        }
        return answer;*/
    }
    // 8. 응급실 END

    // Stack, Queue(자료구조) END


    // Sorting and Searching(정렬, 이분검색과 결정알고리즘) START

    // 1. 선택정렬 START
    @Test
    void 선택정렬() {
        int n = 6;
        int[] arr = {13, 5, 11, 7, 23, 15};
        for (Integer i : 선택정렬_함수(n, arr)) {
            System.out.println("result: " + i);
        }
    }
    private int[] 선택정렬_함수(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) idx = j;
            }

            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        return arr;
    }
    // 내가 푼 것 - 배열을 왜 사용안했을까 하하하하핳ㅎ
    /*private List<Integer> 선택정렬_함수(int n, int[] arr) {
        List<Integer> answer = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (answer.get(minIndex) > answer.get(j)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int a = answer.get(i);
                answer.add(i, answer.get(minIndex));
                answer.remove(i + 1);
                answer.add(minIndex, a);
                answer.remove(minIndex + 1);
            }
        }
        return answer;
    }*/

    // 1. 선택정렬 END

    // 2. 버블 정렬 START
    @Test
    void 버블_정렬() {
        int n = 6;
        int[] arr = {13, 5, 11, 7, 23, 15};
        for (int i : 버블_정렬_함수(n, arr)) {
            System.out.println("result: " + i);
        }
    }

    private int[] 버블_정렬_함수(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
        // 내가 푼 것
        /*for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - i; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;*/
    }
    // 2. 버블 정렬 END

    // 3. 삽입 정렬 START
    @Test
    void 삽입_정렬() {
        int n = 6;
        int[] arr = {11, 7, 5, 6, 10, 9};
        for (int i : 삽입_정렬_함수(n, arr)) {
            System.out.println("result: " + i);
        }
    }

    private int[] 삽입_정렬_함수(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int idx = i;
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[i]) {
                    idx = j - 1;
                }
            }
            if (idx != (i)) {
                arr[0]
            }
        }
        return arr;
    }
    // 3. 삽입 정렬 END

    // Sorting and Searching(정렬, 이분검색과 결정알고리즘) END
}
