package study.algorithm.inflearn;

import org.junit.jupiter.api.Test;

import java.util.*;

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
        // 7, 11, 5
        for (int i : 삽입_정렬_함수(n, arr)) {
            System.out.println("result: " + i);
        }
    }

    private int[] 삽입_정렬_함수(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }

        // 내가 푼 것
        /*for (int i = 1; i < n; i++) {
            int idx = i;
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[i]) {
                    idx = j - 1;
                }
            }
            if (idx != (i)) {
                int tmp = arr[i];
                for (int k = i; k > idx; k--) {
                    arr[k] = arr[k - 1];
                }
                arr[idx] = tmp;
            }
        }*/
        return arr;
    }
    // 3. 삽입 정렬 END

    // 4. LRU(캐시, 카카오 변형) (Least Recently Used) START
    @Test
    void LRU() {
        int s = 5;
        int n = 9;
        int[] arr = {1, 2, 3, 2, 6, 2, 3, 5, 7};
        for (int i : LRU_함수(s, n, arr)) {
            System.out.println("result: " + i);
        }
    }

    private int[] LRU_함수(int s, int n, int[] arr) {
        int[] cache = new int[s];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < s; i++) {
                if (x == cache[i]) {
                    pos = i;
                }
            }

            if (pos == -1) {
                for (int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }

            cache[0] = x;
        }

        return cache;

        // 내가 푼 것
        /*int[] answer = new int[s];
        for (int i = 0; i < arr.length; i++) {
            int zeroIndex = -1;
            int targetIndex = s - 1;
            for (int j = targetIndex; j >= 0; j--) {
                if (arr[j] == arr[i]) {
                    targetIndex = j;
                } else {
                    if (answer[j] == 0) {
                        zeroIndex = j;
                    }
                }
            }

            if (zeroIndex >= 0) {
                answer[zeroIndex] = arr[i];
            } else {
                for (int j = targetIndex; j >= 1; j--) {
                    answer[j] = answer[j - 1];
                }
                answer[0] = arr[i];
            }
        }
        return answer;*/
    }

    // 4. LRU(캐시, 카카오 변형) (Least Recently Used) END

    // 5. 중복 확인 START
    @Test
    void 중복_확인() {
        int n = 8;
        int[] arr = {
                20, 25, 52, 30,
                39, 33, 43, 33
        };
        System.out.println("result: " + 중복_확인_함수(n, arr));
    }

    private String 중복_확인_함수(int n, int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return "D";
            }
        }
        return "U";
    }
    // 5. 중복 확인 END

    // 6. 장난꾸러기 START
    @Test
    void 장난꾸러기() {
        int n = 9;
        int[] arr = {120, 125, 152, 130, 135, 135, 143, 127, 160}; // 3, 8
//        int[] arr = {160, 125, 127, 130, 135, 135, 143, 152, 120}; // 1, 9
//        int[] arr = {125, 120, 127, 130, 135, 135, 143, 152, 160}; // 1, 2
//        int[] arr = {120, 125, 127, 130, 135, 135, 143, 160, 152}; // 8, 9
//        int[] arr = {120, 125, 127, 130, 135, 143, 135, 152, 160}; // 6, 7
//        int[] arr = {120, 125, 130, 127, 135, 135, 143, 152, 160}; // 3, 4
        for (int i : 장난꾸러기_함수(n, arr)) {
            System.out.println("result: " + i);
        }
    }

    private List<Integer> 장난꾸러기_함수(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 얕은 복사
        // int[] tmp = arr;

        // 깊은 복사
        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) answer.add(arr[i]);
        }


        return answer;
    }
    // 6. 장난꾸러기 END

    // 7. 좌표 정렬 START
    class Point implements Comparable<Point> {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                //return this.y - o.y;
                return o.y - this.y;
            } else {
                return o.x - this.x;
            }
        }
    }

    @Test
    void 좌표_정렬() {
        int n = 5;

        ArrayList<Point> arr = new ArrayList<>();
        arr.add(new Point(2, 7));
        arr.add(new Point(1, 3));
        arr.add(new Point(1, 2));
        arr.add(new Point(2, 5));
        arr.add(new Point(3, 6));

        for (Point point : 좌표_정렬_함수(n, arr)) {
            System.out.println("result: " + point.x + ", " + point.y);
        }
    }

    private List<Point> 좌표_정렬_함수(int n, List<Point> arr) {
        Collections.sort(arr);
        return arr;
    }
    // 7. 좌표 정렬 END

    // 8. 이분검색 START
    @Test
    void 이분검색() {
        int n = 8;
        int m = 32;
        int[] arr = {23, 87, 65, 12, 57, 32, 99, 81};
        System.out.println("result: " + 이분검색_함수(n, m, arr));
    }

    private int 이분검색_함수(int n, int m, int[] arr) {
        int answer = 0;
        // binary search를 배운다는 느낌으로!
        // 이분 검색은 무조건 정렬이 되어 있어야 한다.
        Arrays.sort(arr);
        int lt = 0;
        int rt = n - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            }

            if (arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }


        //내가 푼 것
        /*Arrays.sort(arr);
        for (int i : arr) {
            answer++;
            if (i == m) break;
        }

        Arrays.sort(arr);
        int lt = 0;
        int rt = arr.length - 1;

        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (m == arr[mid]) {
                answer = mid + 1;
                break;
            } else if (m < arr[mid]) {
                rt = mid + 1;
            } else {
                lt = mid - 1;
            }
        }
        */


        return answer;
    }
    // 8. 이분검색 END

    // 9. 뮤직비디오(결정알고리즘) START
    @Test
    void 뮤직비디오() {
        int n = 9;
        int m = 3;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("result: " + 뮤직비디오_함수(n, m, arr));
    }

    /*public int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }

        return cnt;
    }*/

    private int 뮤직비디오_함수(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        /*while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }*/

        return answer;

        // 내가 푼 것
        /*int answer = 0;
        int lt = arr[arr.length - 1];
        int rt = 0;
        for (int i : arr) rt += i;
        while (lt < rt) {
            int mid = (lt + rt) / 2;

            int sum = 0;
            int j = 1;
            for (int i = 1; i <= arr.length; i++) {
                if (mid < sum + i) {
                    j++;
                    if (j > m) break;

                    sum = 0;
                }
                sum += i;
            }

            if (j <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;*/
    }
    // 9. 뮤직비디오(결정알고리즘) END

    // 10. 마구간 정하기(결정알고리즘) START
    @Test
    void 마구간_정하기() {
        /*int c = 5;
        int n = 3;*/
        int n = 5;
        int c = 3;
        int[] arr = {1, 2, 8, 4, 9};
        System.out.println("test: " + 마구간_정하기_함수(c, n, arr));
    }
    public int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }

        return cnt;
    }
    private int 마구간_정하기_함수(int c, int n, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[n - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
        // 내가 푼 것 - 틀렸나?
        /*int answer = 0;
        int lt = Arrays.stream(arr).min().getAsInt();
        int rt = Arrays.stream(arr).max().getAsInt();
        Arrays.sort(arr);
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            int ep = 1;
            int cnt = 1;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - ep <= mid) {
                    cnt++;
                    ep = arr[i];
                }
            }

            if (cnt <= n) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;*/
    }
    // 10. 마구간 정하기(결정알고리즘) END


    // Sorting and Searching(정렬, 이분검색과 결정알고리즘) END

    // Recursive, Tree, Graph(DFS, BFS 기초) START
    // 섹션 7은 이론, 실습! 점수 채점 하지 않는다~ -> 문제에 없넹
    // 1. 재귀함수(스택프레임) START
    // 재귀함수 (DFS) -> 깊이 우선 탐색의 약자
    // 반복문의 형태
    @Test
    void 재귀함수_DFS() {
        // 재귀함수: 자기가 자기 자신을 호출하는 함수!
        int n = 3;
        재귀함수_DFS_함수(n);
    }

    void 재귀함수_DFS_함수(int n) {
        if (n == 0) return;
        else {
            // TODO 로그 위치에 따라 숫자 정렬이 다르다!
            // DFS는 스택프레임을 사용 (스택 자료구조 사용)
            System.out.print(n + " ");
            재귀함수_DFS_함수(n - 1);
            System.out.print(n + " ");
        }

    }
    // 1. 재귀함수(스택프레임) END

    // 2. 이진수 출력(재귀) START
    @Test
    void 이진수_출력() {
        int n = 11;
        이진수_출력_함수(n);
    }

    void 이진수_출력_함수(int n) {
        if (n == 0) return;

        System.out.print(n % 2 + " ");
        이진수_출력_함수(n/2);
    }
    // 2. 이진수 출력(재귀) END

    // 3. 팩토리얼 START
    @Test
    void 팩토리얼() {
        int n = 5;
        System.out.println("result: " + 팩토리얼_함수(n));
    }

    int 팩토리얼_함수(int n) {
        if (n == 1) return 1;
        return n * 팩토리얼_함수(n-1);
    }
    // 3. 팩토리얼 END

    // 4. 피보나치 재귀(메모이제이션) START
    // DFS와 for문 중 for문이 성능이 더 좋다.
    // 재귀는 스택 프레임이기 떄문이다!
    static int[] fibo;
    @Test
    void 피보나치_재귀() {
        int n = 10;
        //System.out.println("result: " + 피보나치_재귀_함수(n));
        fibo = new int[n+1];
        피보나치_재귀_함수(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");

        }

    }

    int 피보나치_재귀_함수(int n) {
        /*if (n == 1) return 1;
        else if (n == 2) return 1;*/
        // 대부분 이렇게 짜는데 안좋은 코드다.
        //if (n == 1 || n == 2) return 1;
        //else return 피보나치_재귀_함수(n - 2) + 피보나치_재귀_함수(n - 1);
        /*if (n == 1 || n == 2) return fibo[n] = 1;
        else return fibo[n] = 피보나치_재귀_함수(n - 2) + 피보나치_재귀_함수(n - 1);*/
        if (fibo[n] > 0) return fibo[n]; // 메모이제이션 하면 8초 걸리던게 -> 1초!!!!!
        if (n == 1 || n == 2) return fibo[n] = 1;
        else return fibo[n] = 피보나치_재귀_함수(n - 2) + 피보나치_재귀_함수(n - 1);
    }

    // 4. 피보나치 재귀(메모이제이션) END


    // 5. 이진트리순회(DFS : Depth-First Search) START
    Node root;
    @Test
    void 이진트리순회() {
        /**
         * 이진트리 순회 (깊이 우선 탐색)
         * 전위순회: 부모 방문, 왼쪽 자식, 오른쪽 자식
         * 중위순회: 왼쪽 자식, 부모, 오른쪽 자식
         * 후위순회: 왼쪽 자식, 오른쪽 자식, 부모
         */
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        이진트리순회_함수(root);
    }

    void 이진트리순회_함수(Node root) {
        if (root == null) {
            return;
        } else {
            // TODO: 재귀 Stack으로 전위, 중위, 후위 그려보기.
            //System.out.print(root.data + " "); // 전위 순회
            이진트리순회_함수(root.lt);
            //System.out.print(root.data + " "); // 중위 순회
            이진트리순회_함수(root.rt);
            //System.out.print(root.data + " "); // 후위 순회
        }
    }

    class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    // 5. 이진트리순회(DFS : Depth-First Search) END


    // 6. 부분집합 구하기(DFS) START
    /**
     * 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
     * 3 입력
     * 1 2 3
     * 1 2
     * 1 3
     * 1
     * 2 3
     * 2
     * 3
     * - 이진 트리를 배웠는데, 이것도 두 갈래로 뻗는 트리를 만들면 된다. (상태 트리)
     *
     */
    int n;
    int[] ch; // 체크 하고 안하고를 해서 숫자를 부분집합으로 사용 하는지 안하는지
    @Test
    void 부분집합_구하기() {
        n = 3;
        ch = new int[n + 1];
        부분집합_구하기_함수(1);
    }

    void 부분집합_구하기_함수(int L) {
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += i + " ";
                }
            }
            if (tmp.length() > 0) System.out.println(tmp);
        } else {
            // 두 갈래로 뻗는다. (1은 사용, 0은 미사용)
            ch[L] = 1;
            부분집합_구하기_함수(L + 1); // 왼
            ch[L] = 0;
            부분집합_구하기_함수(L + 1); // 오른
        }
    }

    // 6. 부분집합 구하기(DFS) END


    // 7. 이진트리 레벨탐색(BFS : Breadth-First Search) START
    class Node1 {
        int data;
        Node1 lt;
        Node1 rt;

        public Node1(int val) {
            data = val;
            lt = null;
            rt = null;
        }
    }

    @Test
    void 레벨탐색() {
        Node1 root = new Node1(1);
        root.lt = new Node1(2);
        root.rt = new Node1(3);
        root.lt.lt = new Node1(4);
        root.lt.rt = new Node1(5);
        root.rt.lt = new Node1(6);
        root.rt.rt = new Node1(7);
        레벨탐색_함수(root);
    }

    void 레벨탐색_함수(Node1 root) {
        Queue<Node1> Q = new LinkedList<>();
        Q.offer(root);

        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node1 cur = Q.poll();
                System.out.print(cur.data);
                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();

        }
    }
    // 7. 이진트리 레벨탐색(BFS : Breadth-First Search) END

    // 8. 송아지 찾기 1(BFS : 상태트리탐색) START
    @Test
    void 송아지_찾기() {
        System.out.println("result 3 " + 송아지_찾기_함수_BFS(5, 14));
        System.out.println("result 4 " + 송아지_찾기_함수_BFS(5, 13));
        System.out.println("result 2 " + 송아지_찾기_함수_BFS(5, 11));
        System.out.println("result 3 " + 송아지_찾기_함수_BFS(5, 12));
        System.out.println("result 0 " + 송아지_찾기_함수_BFS(5, 5));
        System.out.println("result 1 " + 송아지_찾기_함수_BFS(5, 6));

    }
    // 이해했는지 풀어보기
    private int 송아지_찾기_함수_BFS(int s, int e) {
        int answer = 0;
        int[] dis = {-1, 1, 5};
        int[] ch = new int[10001];

        Queue<Integer> que = new LinkedList<>();
        ch[s] = 1;
        que.offer(s);
        int L = 0;
        while (!que.isEmpty()) {
            int qSize = que.size();

            for (int i = 0; i < qSize; i++) {
                int value = que.poll();
                if (value == e) return L;

                for (int j = 0; j < dis.length; j++) {
                    int childValue = value + dis[j];
                    if (childValue > 0 && childValue <= 10000 && ch[childValue] == 0) {
                        if (childValue == e) return L + 1;
                        ch[childValue] = 1;
                        que.offer(childValue);
                    }
                }
            }
            L++;
        }

        return answer;
    }

    /* 인강 풀이
    int[] dis1 = {1, -1, 5};
    int[] ch1;
    private int 송아지_찾기_함수_BFS(int s, int e) {
        Queue<Integer> Q = new LinkedList<>();

        ch1 = new int[10001];
        ch1[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                if (x == e) return L;
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis1[j];
                    if (nx == e) return L + 1;
                    if (nx >= 1 && nx <= 10000 && ch1[nx] == 0) {
                        ch1[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }

        return 0;
    }*/
    
     /*//내가 푼 것
    private int 송아지_찾기_함수_BFS(int s, int e) {
        int answer = 0;

        int n = 5;
        int tempNum = 0;
        while (s != e) {
            tempNum = s + n;
            if (tempNum < e) {
                s = tempNum;
            } else if (((tempNum - s) / 2 + 1) <= e - s) {
                s = tempNum;
            } else {
                if (s < e) {
                    s++;
                } else {
                    s--;
                }
            }
            answer++;
        }
        return answer;
    }*/
    // 8. 송아지 찾기 1(BFS : 상태트리탐색) END


    // 9. Tree 말단노드까지의 가장 짧은 경로(DFS) START
    @Test
    void Tree_말단노드까지의_가장_짧은_경로_DFS() {
        Node2 root;
        root = new Node2(1);
        root.lt = new Node2(2);
        root.rt = new Node2(3);
        root.lt.lt = new Node2(4);
        root.lt.rt = new Node2(5);
        //System.out.println(Tree_말단노드까지의_가장_짧은_경로_DFS(0, root));
        System.out.println(Tree_말단노드까지의_가장_짧은_경로_BFS(root));
    }

    class Node2 {
        int data;
        Node2 lt;
        Node2 rt;
        public Node2(int val) {
            this.data = val;
            lt = null;
            rt = null;
        }
    }

    private int Tree_말단노드까지의_가장_짧은_경로_DFS(int L, Node2 root) {
        if (root.lt == null && root.rt == null) {
            return L;
        } else {
            return Math.min(Tree_말단노드까지의_가장_짧은_경로_DFS(L + 1, root.lt), Tree_말단노드까지의_가장_짧은_경로_DFS(L + 1, root.rt));
        }
    }

    private int Tree_말단노드까지의_가장_짧은_경로_BFS(Node2 root) {
        Queue<Node2> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node2 cur = Q.poll();
                if (cur.lt == null && cur.rt == null) return L;
                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
        }

        return 0;
    }
    // 9. Tree 말단노드까지의 가장 짧은 경로(DFS) END

    // 12. 경로탐색(DFS) START
    int n1 = 5;
    int m1 = 9;
    int answer1 = 0;
    int[][] graph1 = new int[n1 + 1][n1 + 1];
    int[] ch1 = new int[n1 + 1];
    @Test
    void 경로탐색() {
        graph1[1][2] = 1;
        graph1[1][3] = 1;
        graph1[1][4] = 1;

        graph1[2][1] = 1;
        graph1[2][3] = 1;
        graph1[2][5] = 1;

        graph1[3][4] = 1;

        graph1[4][2] = 1;
        graph1[4][5] = 1;

        ch1[1] = 1;
        경로탐색_함수(1);
        System.out.println("answer1: " + answer1);
    }

    void 경로탐색_함수(int v) {
        if (v == n1) {
            answer1++;
        } else {
            for (int i = 1; i <= n1; i++) {
                if (graph1[v][i] == 1 && ch1[i] ==0) {
                    ch1[i] = 1;
                    경로탐색_함수(i);
                    ch1[i] = 0;
                }
            }
        }

    }


    // 12. 경로탐색(DFS) EMD

    // 13. 경로탐색(인접리스트, ArrayList) START
    int n2 = 5;
    int m2 = 9;
    int answer2 = 0;
    ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();

    int[] ch2 = new int[n2 + 1];
    @Test
    void 경로탐색_인접리스트() {
        graph2.add(new ArrayList<>(0));
        graph2.add(new ArrayList<>(1));
        graph2.add(new ArrayList<>(2));
        graph2.add(new ArrayList<>(3));
        graph2.add(new ArrayList<>(4));
        graph2.add(new ArrayList<>(5));

        graph2.get(1).add(2);
        graph2.get(1).add(3);
        graph2.get(1).add(4);

        graph2.get(2).add(1);
        graph2.get(2).add(3);
        graph2.get(2).add(5);

        graph2.get(3).add(4);

        graph2.get(4).add(2);
        graph2.get(4).add(5);

        ch2[1] = 1;
        경로탐색_인접리스트_함수(1);
        System.out.println("answer2: " + answer2);
        System.out.println("answer2: " + answer2);
    }

    void 경로탐색_인접리스트_함수(int v) {
        if (v == n2) {
            answer2++;
        } else {
            // for문 보다 for each 하는 것이 좋다. (array list - 인접 리스트의 경우)
            for (int nv : graph2.get(v)) {
                if (ch2[nv] == 0) {
                    ch2[nv] = 1;
                    경로탐색_인접리스트_함수(nv);
                    ch2[nv] = 0;
                }
            }
        }
    }

    // 13. 경로탐색(인접리스트, ArrayList) END


    // 14. 그래프 최단거리(BFS) START
    int n3 = 6;
    int m3 = 9;
    ArrayList<ArrayList<Integer>> graph3 = new ArrayList<>();
    int[] ch3 = new int[n3 + 1];
    int[] dis3 = new int[n3 + 1];
    @Test
    void 그래프_최단거리() {
        graph3.add(new ArrayList<>(0));
        graph3.add(new ArrayList<>(1));
        graph3.add(new ArrayList<>(2));
        graph3.add(new ArrayList<>(3));
        graph3.add(new ArrayList<>(4));
        graph3.add(new ArrayList<>(5));
        graph3.add(new ArrayList<>(6));

        graph3.get(1).add(3);
        graph3.get(1).add(4);

        graph3.get(4).add(5);
        graph3.get(4).add(6);

        graph3.get(6).add(2);

        그래프_최단거리_함수(1);

        for (int i : dis3) {
            System.out.println("i : " + i);
        }
    }

    void 그래프_최단거리_함수(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch3[v] = 1;
        dis3[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv : graph3.get(cv)) {
                if (ch3[nv] == 0) {
                    ch3[nv] = 1;
                    queue.offer(nv);
                    dis3[nv] = dis3[cv] + 1;
                }
            }
        }

    }
    // 14. 그래프 최단거리(BFS) END
    // Recursive, Tree, Graph(DFS, BFS 기초) END


    // DFS, BFS 활용 START

    // 1. 합이 같은 부분집합 START
    String answer4 = "NO";
    int n4 = 6;
    int total4 = 0; // 33
    boolean flag4 = false;
    @Test
    void 합이_같은_부분집합() {
        //System.out.println("result: 6 " + 합이_같은_부분집합_함수(6, new int[] {1, 3, 5, 6, 7, 10}));
        int[] arr4 = new int[] {1, 3, 5, 6, 7, 10};
        for (int i : arr4) total4 += i;
        합이_같은_부분집합_함수(0, 0, arr4);
        System.out.println("result: " + answer4);
    }

    private void 합이_같은_부분집합_함수(int L, int sum, int[] arr4) {
        if (flag4) return;
        if (sum > total4 / 2) return;
        if (L == n4) {
            if ((total4 - sum) == sum) {
                answer4 = "YES";
                flag4 = true;
            }
        } else {
            합이_같은_부분집합_함수(L + 1, sum + arr4[L], arr4);
            합이_같은_부분집합_함수(L + 1, sum, arr4);
        }
    }

    // 1. 합이 같은 부분집합 END

    // 2. 바둑이 승차(DFS) START
    int c5 = 259;
    int n5 = 5;
    int answer5 = 0;
    @Test
    void 바둑이_승차() {
        int[] n = {81, 58, 42, 33, 61};
        바둑이_승차_함수(0, 0, n);
        System.out.println("result 242: " + answer5);
    }

    private void 바둑이_승차_함수(int l, int sum, int[] n) {
        if (c5 <= sum) return;
        if (l == n5) {
            if (answer5 < sum) answer5 = sum;
        } else {
            바둑이_승차_함수(l + 1, sum + n[l], n);
            바둑이_승차_함수(l + 1, sum, n);
        }
    }

    /* 내가 푼 것
    private void 바둑이_승차_함수(int l, int sum, int[] n) {
        if (c5 <= sum) return;
        if (l == n5) {
            if (answer5 < sum) answer5 = sum;
        } else {
            바둑이_승차_함수(l + 1, sum + n[l], n);
            바둑이_승차_함수(l + 1, sum, n);
        }
    }*/


    // 2. 바둑이 승차(DFS) END

    // 3. 최대점수 구하기(DFS) START
    int n6 = 5;
    int m6 = 20;
    int[][] arr = {
            {10, 5},
            {25, 12},
            {15, 8},
            {6, 3},
            {7, 4}
    };
    int answer6 = 0;

    @Test
    void 최대점수_구하기() {
        최대점수_구하기_함수(0, 0, 0, arr);
        System.out.println("result: 41 " + answer6);
    }

    private void 최대점수_구하기_함수(int l, int sum, int time, int[][] arr) {
        if (time > m6) return;
        if (l == n6) {
            if (answer6 < sum) answer6 = sum;
        } else {
            최대점수_구하기_함수(l + 1, sum + arr[l][0], time + arr[l][1], arr);
            최대점수_구하기_함수(l + 1, sum, time, arr);
        }

    }

    // 3. 최대점수 구하기(DFS) END

    // 4. 중복순열(채점지원안됨) START
    int[] pm7;
    int n7, m7;
    @Test
    void 중복순열() {
        n7 = 3;
        m7 = 2;
        pm7 = new int[m7];
        중복순열_함수(0);
    }

    private void 중복순열_함수(int L) {
        if (L == m7) {
            for (int x : pm7) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 1; i<= n7; i++) {
                pm7[L] = i;
                중복순열_함수(L + 1);
            }
        }
    }
    // 4. 중복순열(채점지원안됨) END

    // 5. 동전교환 START
    int n8 = 3; // 동전의 종류 개수
    //int[] m8 = {1, 2, 5}; // 동전의 종류
    Integer[] m8 = {1, 2, 5}; // 동전의 종류 - Collections.reverseOrder() 사용하려면 원시타입은 안되고 wrapping으로 선언
    int count8 = Integer.MAX_VALUE;
    int m88 = 15;
    @Test
    void 동전교환() {
        int p = 15; // 금액
        /*동전교환_함수(p, 0, 0);
        System.out.println("result: " + count8);*/

        Arrays.sort(m8, Collections.reverseOrder());
        //for (Integer integer : m8) System.out.println("integer = " + integer);
        동전교환_함수_참고(0, 0, m8);
        System.out.println("result: " + count8);
    }

    // 내가 푼 것
    private void 동전교환_함수(int price, int sumPrice, int count) {
        /**
         * 1. DFS로 누적 금액이 지정 금액과 같으면 리턴
         * 2. DFS로 누적 금액에서 어떤 금액을 넣어도 지정 금액을 초과 할 때 리턴
         * 3. 반환 받은 값이랑 count랑 비교
         */
        if (price < sumPrice) return;
        if (price == sumPrice) {
            if (count8 > count) count8 = count;
            return;
        }

        for (int i = 0; i < m8.length; i++) {
            동전교환_함수(price, sumPrice + m8[i], count + 1);
        }
    }
    // 인프런 강사님이 푼 것 1 - 타임 리밋
    /*private void 동전교환_함수_참고(int L, int sum, int[] arr) {
        if (sum > m88) return;
        if (L >= m88) return; // L의 5로 해서 구했다고 헀을 때 이 값 보다 초과되는 경우는 연산을 할 필요가 없다. - 시간 복잡도에서 줄이기 노하우!
        if (sum == m88) {
            count8 = Math.min(count8, L); // Math.min()을 자꾸 까먹는다..... 활용하기!
        } else {
            for (int i = 0; i < n8; i++) {
                동전교환_함수_참고(L + 1, sum + arr[i], arr);
            }
        }
    }*/

    // 인프런 강사님이 푼 것 1 - 타임 리밋 리팩토링
    private void 동전교환_함수_참고(int L, int sum, Integer[] arr) {
        if (sum > m88) return;
        if (L >= m88) return; // L의 5로 해서 구했다고 헀을 때 이 값 보다 초과되는 경우는 연산을 할 필요가 없다. - 시간 복잡도에서 줄이기 노하우! ***
        if (sum == m88) {
            count8 = Math.min(count8, L); // Math.min()을 자꾸 까먹는다..... 활용하기! ***
        } else {
            // 작은 금액부터 큰 금액이었는데, 거꾸로! (큰 금액부터 적용!) *** (자료구조를 reverse하기 ex: Arrays.sort(arr, Collections.reverseOrder());
            for (int i = 0; i < n8; i++) {
                //for (int i = n8 - 1; i > 0; i--) {
                동전교환_함수_참고(L + 1, sum + arr[i], arr);
            }
        }
    }
    // 5. 동전교환 END


    // 6. 순열 구하기(채점지원안됨) START
    @Test
    void 순열_구하기() {
        /*int n = 3;
        int m = 2;
        int[] arr = {3, 6, 9};
        int[] checkArr = new int[arr.length];
        순열_구하기_함수(n, m, arr, checkArr, 0);*/
        int n = 3;
        int m = 2;
        int[] arr = {3, 6, 9};
        int[] ch = new int[n];
        int[] pm = new int[m];
        순열_구하기_함수(0, n, m, arr, ch, pm);

    }
    // 내가 푼 것 - 푸는중
    /*private void 순열_구하기_함수(int n , int m, int[] arr, int[] checkArr,int index) {
        if (index == m) {
            for (int i = 0; i < checkArr.length; i++) {
                if (checkArr[i] == 1) System.out.printf("%2d", arr[i]);
            }
            System.out.println();
            return;
        }


        for (int i = 0; i < arr.length; i++) {
            if (checkArr[i] == 1) continue;
            checkArr[i] = 1;
            순열_구하기_함수(n, m, arr, checkArr, i);
            checkArr[i] = 0;
        }
    }*/
    // 인프런 강사님이 푼 것
    private void 순열_구하기_함수(int L, int n, int m, int[] arr, int[] ch, int[] pm) {
        if (L == m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    순열_구하기_함수(L + 1, n, m, arr, ch, pm);
                    ch[i] = 0;
                }
            }
        }
    }
    // 6. 순열 구하기(채점지원안됨) END

    // 7. 조합의 경우수(메모이제이션) START
    @Test
    void 조합의_경우수() {
        int n = 33;
        int r = 19;
        int[][] arr = new int[n + 1][r + 1];

        System.out.println("result: " + 조합의_경우수_함수(n, r, arr));
    }

    // 내가 푼 것
    /*private int 조합의_경우수_함수(int n, int r, int[][] arr) {
        if (arr[n][r] != 0) return arr[n][r];
        if (r == 0 || n == r) return 1;

        int result = 0;
        int nVal = 조합의_경우수_함수(n - 1, r - 1, arr);
        result += nVal;
        arr[n - 1][r - 1] = nVal;
        int rVal = 조합의_경우수_함수(n - 1, r, arr);
        arr[n - 1][r] = rVal;
        result += rVal;

        return result;
    }*/
    // 강사님이 푼 것
    private int 조합의_경우수_함수(int n, int r, int[][] arr) {
        if (arr[n][r] > 0) return arr[n][r];
        if (n == r || r == 0) return 1;
        // 값에 넣어주고 그 값을 리턴하는 형식으로 하네...
        else return arr[n][r] = 조합의_경우수_함수(n - 1, r - 1, arr) + 조합의_경우수_함수(n - 1, r, arr);
    }
    // 7. 조합의 경우수(메모이제이션) END

    // 8. 수열 추측하기 START
    boolean flag1 = false; // 재귀로 답을 찾을 경우 멈추게 할 플래그 값
    @Test
    void 수열_추측하기() {
        int n = 4;
        int f = 16;
        int[] b = new int[n]; // Combination 값 저장
        int[] p = new int[n]; // 순열 저장
        int[] ch = new int[n + 1]; // 순열 체크 (중복 순열이 아니라 체크 배열 필요!)
        int[][] dy = new int[35][35]; // 조합 수 (메모이제이션을 위한 배열)

        for (int i = 0; i < n; i++) b[i] = 수열_추측하기_combi(n - 1, i, dy);
        수열_추측하기_DFS(0, 0, f, b, p, ch);
    }
    // combination 값을 구하는 함수
    private int 수열_추측하기_combi(int n, int r, int[][] dy) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        return dy[n][r] = 수열_추측하기_combi(n - 1, r - 1, dy) + 수열_추측하기_combi(n - 1, r, dy);
    }

    private void 수열_추측하기_DFS(int L, int sum, int f, int[] b, int[] p, int[] ch) {
        if (flag1) return;
        if (L == b.length) {
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                }
                flag1 = true;
            }
        } else {
            // TODO 상태 트리 그려보기
            for (int i = 1; i <= b.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    수열_추측하기_DFS(L + 1, sum + (p[L] * b[L]), f, b, p, ch);
                    ch[i] = 0;
                }
            }
        }
    }

    // 내가 푼 것 - 푸는 중
    /*@Test
    void 수열_추측하기() {
        int n = 4;
        int f = 16;
        int[][] repo = new int[n + 1][n + 1];
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = 수열_추측하기_함수1(n - 1,  i, arr, repo);

        int[] result = new int[n];
        for (int i = 1; i <= n; i++) result[i - 1] = i;
        수열_추측하기_함수2(f, result, arr);

        for (int i : result) {
            System.out.println("result = " + i);
        }


    }

    private int 수열_추측하기_함수1(int n, int r, int[] intArr, int[][] repo) {
        if (repo[n][r] != 0) return repo[n][r];
        if (n == r || r == 0) return 1;
        return repo[n][r] = 수열_추측하기_함수1(n - 1, r - 1, intArr, repo) + 수열_추측하기_함수1(n - 1, r, intArr, repo);
    }

    private void 수열_추측하기_함수2(int f, int[] newArr, int[] intArr) {
        if (checkValues(f, newArr, intArr)) return;

    }


    private boolean checkValues(int f, int[] newArr, int[] intArr) {
        int sum = 0;
        for (int i = 0; i < newArr.length; i++) {
            sum += newArr[i] * intArr[i];
        }
        return sum == f;
    }*/


    // 8. 수열 추측하기 END


    // 9. 조합 구하기(채점지원안됨) START
    @Test
    void 조합_구하기() {
        int n = 4;
        int m = 3;
        int[] combi = new int[m];
        조합_구하기_함수(0, 1, n, m, combi);
    }

    private void 조합_구하기_함수(int L, int S, int n, int m, int[] combi) {
        if (L == m) {
            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = S; i <= n; i++) {
            combi[L] = i;
            조합_구하기_함수(L + 1, i + 1, n, m, combi);
        }
    }
    // 9. 조합 구하기(채점지원안됨) END

    // 10. 미로탐색(DFS) START
    int result1 = 0;
    //강
    @Test
    void 미로탐색() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0}
        };
        board[1][1] = 1;
        미로탐색_함수(1, 1, dx, dy, board);
        System.out.println("result: " + result1);
    }
    private void 미로탐색_함수(int x, int y, int[] dx, int[] dy, int[][] board) {
        if (x == 7 && y == 7) {
            result1++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                미로탐색_함수(nx, ny, dx, dy, board);
                board[nx][ny] = 0;
            }
        }

    }
    //내
    /*
    @Test
    void 미로탐색() {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };
        //int[] dArr = {-1, 1, 1, -1};
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        미로탐색_함수(0, 0, board, dx, dy);
        System.out.println("result: " + result10);
    }

    private void 미로탐색_함수(int x, int y, int[][] board, int[] dx, int[] dy) {
        int bLength = board.length - 1;
        if (x < 0 || y < 0 || x > bLength || y > bLength) return;
        if (x == bLength & y == bLength) {
            result1++;
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            if (board[x][y] == 1) return;
            board[x][y] = 1;
            미로탐색_함수(x + dx[i], y + dy[i], board, dx, dy);
            board[x][y] = 0;
        }
    }*/
    // 10. 미로탐색(DFS) END

    // 11. 미로의 최단거리 통로(BFS) START
    int result2 = Integer.MAX_VALUE;
    //내 - BFS인데 DFS로 풀어버렸네 ㅠㅠ BFS 클래스 노드 사용해서 해보기.
    /*@Test
    void 미로의_최단거리_통로() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0}
        };
        int[][] dis = new int[board.length][board[0].length];
        board[1][1] = 1;
        미로의_최단거리_통로_함수(1, 1, 1, dx, dy, board, dis);
        System.out.println("result: " + result2);
    }

    private void 미로의_최단거리_통로_함수(int x, int y, int L, int[] dx, int[] dy, int[][] board, int[][] dis) {
        if (x == 7 && y == 7) {
            if (result2 > L) result2 = L;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx <= 7 && ny >= 0 && ny <= 7 && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                미로의_최단거리_통로_함수(nx, ny, L + 1, dx, dy, board, dis);
                board[nx][ny] = 0;
            }
        }
    }*/

    //강
    /*@Test
    void 미로의_최단거리_통로() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0}
        };
        int[][] dis = new int[board.length][board[0].length];
        미로의_최단거리_통로_함수(1, 1, dx, dy, board, dis);
        if (dis[7][7] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(dis[7][7]);
        }
    }

    class Point1 {
        public int x, y;
        public Point1(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void 미로의_최단거리_통로_함수(int x, int y, int[] dx, int[] dy, int[][] board, int[][] dis) {
        Queue<Point1> Q = new LinkedList<>();
        Q.offer(new Point1(x, y));
        board[x][y] = 1;

        while (!Q.isEmpty()) {
            Point1 tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point1(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
    // 11. 미로의 최단거리 통로(BFS) END

    // 12. 토마토(BFS 활용) START
    //강
    @Test
    void 토마토() {
        int n = 4;
        int m = 6;
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, -1, 0, 0, 0},
                {0, 0, 0, 1, 0, -1, 0},
                {0, 0, 0, -1, 0, 0, 0},
                {0, 0, 0, 0, 0, -1, 1}
        };
        int[][] dis = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int result = 토마토_함수(n, m, board, dis, dx, dy);
        System.out.println("result = " + result);
    }

    private int 토마토_함수(int n, int m, int[][] board, int[][] dis, int[] dx, int[] dy) {
        Queue<Point1> Q = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) Q.offer(new Point1(i, j));
            }
        }
        while(!Q.isEmpty()) {
            Point1 tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point1(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) flag = false;
            }
        }

        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    result = Math.max(result, dis[i][j]);
                }
                System.out.println(result);
            }
        } else {
            System.out.println("-1");
            return -1;
        }

        return result;
    }*/

    //내
    @Test
    void 토마토() {
        int n = 4;
        int m = 6;
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, -1, 0, 0, 0},
                {0, 0, 0, 1, 0, -1, 0},
                {0, 0, 0, -1, 0, 0, 0},
                {0, 0, 0, 0, 0, -1, 1}
        };
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int result = 토마토_함수(dx, dy, n, m, board);
        System.out.println(result);
    }

    class Tomato {
        public int x;
        public int y;
        Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int 토마토_함수(int[] dx, int[] dy, int n, int m, int[][] board) {
        Queue<Tomato> Q = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int tomato = board[i][j];
                if (tomato == 1) {
                    Q.offer(new Tomato(i, j));
                }
            }
        }

        int qSize = Q.size();
        int qCount = 0;
        while(!Q.isEmpty()) {
            Tomato poll = Q.poll();
            qCount++;
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx > 0 && nx <= n && ny > 0 && ny <= m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Tomato(nx, ny));
                }
            }

            if (qSize == qCount && !Q.isEmpty()) {
                qSize = Q.size();
                qCount = 0;
                count++;
            }
        }

        return count == 0 ? -1 : count;
    }
    // 12. 토마토(BFS 활용) END

    // 13. 섬나라 아일랜드 START
    int result3 = 0;
    // 내
    /*@Test
    void 섬나라_아일랜드() {
        int n = 7;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] islands = {
            {1 ,1 ,0 ,0 ,0 ,1 ,0},
            {0 ,1 ,1 ,0 ,1 ,1 ,0},
            {0 ,1 ,0 ,0 ,0 ,0 ,0},
            {0 ,0 ,0 ,1 ,0 ,1 ,1},
            {1 ,1 ,0 ,1 ,1 ,0 ,0},
            {1 ,0 ,0 ,0 ,1 ,0 ,0},
            {1 ,0 ,1 ,0 ,1 ,0 ,0},
        };
        섬나라_아일랜드_함수(n, islands, dx, dy);
        System.out.println("result3: " + result3);
    }

    private void 섬나라_아일랜드_함수(int n, int[][] islands, int[] dx, int[] dy) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (islands[i][j] == 1) {
                    islands[i][j] = 0;
                    섬나라_아일랜드_함수_DFS(i, j, n, islands, dx, dy);
                    result3++;
                }
            }
        }
    }

    private void 섬나라_아일랜드_함수_DFS(int x, int y, int n, int[][] islands, int[] dx, int[] dy) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && islands[nx][ny] == 1) {
                islands[nx][ny] = 0;
                섬나라_아일랜드_함수_DFS(nx, ny, n, islands, dx, dy);
            }
        }
    }*/

    // 강
    // 13. 섬나라 아일랜드 END
    @Test
    void 섬나라_아일랜드() {
        int n = 7;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] islands = {
                {1 ,1 ,0 ,0 ,0 ,1 ,0},
                {0 ,1 ,1 ,0 ,1 ,1 ,0},
                {0 ,1 ,0 ,0 ,0 ,0 ,0},
                {0 ,0 ,0 ,1 ,0 ,1 ,1},
                {1 ,1 ,0 ,1 ,1 ,0 ,0},
                {1 ,0 ,0 ,0 ,1 ,0 ,0},
                {1 ,0 ,1 ,0 ,1 ,0 ,0},
        };
        섬나라_아일랜드_함수(n, islands, dx, dy);
        System.out.println("result: " + result3);

    }

    private void 섬나라_아일랜드_함수(int n, int[][] islands, int[] dx, int[] dy) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (islands[i][j] == 1) {
                    result3++;
                    islands[i][j] = 0;
                    섬나라_아일랜드_함수_DFS(i, j, n, islands, dx, dy);
                }
            }
        }
    }

    private void 섬나라_아일랜드_함수_DFS(int x, int y, int n, int[][] islands, int[] dx, int[] dy) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && islands[nx][ny] == 1) {
                islands[nx][ny] = 0;
                섬나라_아일랜드_함수_DFS(nx, ny, n, islands, dx, dy);
            }
        }
    }


    // 14. 섬나라 아일랜드(BFS) START
    @Test
    void 섬나라_아일랜드_BFS() {
        int n = 7;
        int[][] islands = {
                {1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}
        };
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        System.out.println("result: " + 섬나라_아일랜드_BFS_함수(n, islands, dx, dy));
    }

    class Island {
        int x;
        int y;

        public Island(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int 섬나라_아일랜드_BFS_함수(int n, int[][] islands, int[] dx, int[] dy) {
        int result = 0;
        Queue<Island> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (islands[i][j] == 1) {
                    result++;
                    islands[i][j] = 0;
                    que.offer(new Island(i, j));
                    섬나라_아일랜드_BFS_함수_BFS(i, j, n, islands, que, dx, dy);
                }
            }
        }

        return result;
    }

    private void 섬나라_아일랜드_BFS_함수_BFS(int x, int y, int n, int[][] islands, Queue<Island> que, int[] dx, int[] dy) {
        while (!que.isEmpty()) {
            Island island = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = island.x + dx[i];
                int ny = island.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && islands[nx][ny] == 1) {
                    islands[nx][ny] = 0;
                    que.offer(new Island(nx, ny));
                }
            }
        }
    }
    // 14. 섬나라 아일랜드(BFS) END



    //15. 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용) START
    int result4 = Integer.MAX_VALUE;
    @Test
    void 피자_배달_거리() {
        int n = 4;
        int m = 4;
        int[][] area = {
                {0, 1, 2, 0},
                {1, 0, 2, 1},
                {0, 2, 1, 2},
                {2, 0, 1, 2},
        };
        List<Point> homeList = new ArrayList<>();
        List<Point> pizzaList = new ArrayList<>();
        int[] combi = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = area[i][j];
                if (val == 1) {
                    homeList.add(new Point(i, j));
                } else if (val == 2) {
                    pizzaList.add(new Point(i, j));
                }
            }
        }

        class Point {
            int x;
            int y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        피자_배달_거리_함수_DFS(0, 0, n, m, homeList, pizzaList, combi);
        System.out.println("result: " + result4);
    }

    private void 피자_배달_거리_함수_DFS(int L, int s, int n, int m, List<Point> homeList, List<Point> pizzaList, int[] combi) {
        if (L == m) {
            int sum = 0;
            for (Point home : homeList) {
                int min = Integer.MAX_VALUE;
                for (int j : combi) {
                    Point pizza = pizzaList.get(j);
                    int absVal = Math.abs(home.x - pizza.x) + Math.abs(home.y - pizza.y);
                    if (min > absVal) min = absVal;
                }
                sum += min;
            }

            if (result4 > sum) result4 = sum;
            return;
        }

        for (int i = s; i < pizzaList.size(); i++) {
            combi[L] = i;
            피자_배달_거리_함수_DFS(L + 1, i + 1, n, m, homeList, pizzaList, combi);
        }
    }
    //15. 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용) END
    // DFS, BFS 활용 END

    // Greedy Algorithm START


    // 2. 회의실 배정 START
    @Test
    void 회의실_배정() {
        int n = 5;
        int[][] times = {
                {1, 4},
                {2, 3},
                {3, 5},
                {4, 6},
                {5, 7}
        };

        /*int n = 3;
        int[][] times = {
                {3, 3},
                {1, 3},
                {2, 3}
        };*/
        System.out.println("result: " + 회의실_배정_함수(n, times));

    }

    class MeetingRoom implements Comparable<MeetingRoom> {
        int start;
        int end;

        public MeetingRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MeetingRoom o) {
            if (this.end == o.end) return this.start - this.end;
            return this.end - o.end;
        }
    }

    private int 회의실_배정_함수(int n, int[][] times) {
        int result = 0;
        List<MeetingRoom> meetingRoomList = new ArrayList<>();
        for (int[] time : times) {
            meetingRoomList.add(new MeetingRoom(time[0], time[1]));
        }

        Collections.sort(meetingRoomList);
        result++;
        int tStart = meetingRoomList.get(0).start;
        int tEnd = meetingRoomList.get(0).end;

        for (int i = 1; i < meetingRoomList.size(); i++) {
            MeetingRoom target = meetingRoomList.get(i);
            if (tEnd <= target.start) {
                result++;
                tStart = target.start;
                tEnd = target.end;
            }
        }

        return result;
    }
    // 2. 회의실 배정 END

    // 3. 결혼식 START
    // 강
    /**
     * 배운점
     * - 정렬 대상 객체를 어떻게 구성하느냐에 따라 시간 복잡도를 줄일 수 있다.
     * - Math 함수를 자꾸 까먹는다. 활용하기.
     */
    @Test
    void 결혼식() {
        List<Time1> arr = Arrays.asList(
                new Time1(14, 's'),
                new Time1(18, 'e'),
                new Time1(12, 's'),
                new Time1(15, 'e'),
                new Time1(15, 's'),
                new Time1(20, 'e'),
                new Time1(20, 's'),
                new Time1(30, 'e'),
                new Time1(5, 's'),
                new Time1(14, 'e')
        );
        System.out.println("result: " + 결혼식_함수(arr));
    }
    class Time1 implements Comparable<Time1> {
        public int time;
        public char state;
        public Time1(int time, char state) {
            this.time = time;
            this.state = state;
        }
        @Override
        public int compareTo(Time1 o) {
            if (this.time == o.time) return this.state - o.state;
            return this.time - o.time;
        }
    }
    private int 결혼식_함수(List<Time1> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for (Time1 ob : arr) {
            if (ob.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    // 내
    /*@Test
    void 결혼식() {
        List<Friend> friends = Arrays.asList(
                new Friend(14, 18),
                new Friend(12, 15),
                new Friend(15, 20),
                new Friend(20, 30),
                new Friend(5, 14)
        );
        System.out.println("result: " + 결혼식_함수(friends));
    }
    class Friend implements Comparable<Friend> {
        int start;
        int end;
        public Friend(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Friend o) {
            if (this.start == o.start) return this.end - this.start;
            return this.start - o.start;
        }
    }


    private int 결혼식_함수(List<Friend> friends) {
        int result = 0;
        Collections.sort(friends);

        for (int i = 0; i < friends.size(); i++) {
            Friend targetF = friends.get(i);
            int tempResult = 1;
            for (int j = i + 1; j < friends.size(); j++) {
                Friend compareF = friends.get(j);
                if (compareF.start >= targetF.end) break;
                if (compareF.start >= targetF.start || (compareF.end >= targetF.start && compareF.end < targetF.end)) {
                    tempResult++;
                }
            }
            if (result < tempResult) result = tempResult;
        }

        return result;
    }*/
    // 3. 결혼식 END

    // 4. 최대 수입 스케쥴(PriorityQueue 응용문제) START
    @Test
    void 최대_수입_스케줄() {
        List<Lecture> list = Arrays.asList(
                new Lecture(50, 2),
                new Lecture(20, 1),
                new Lecture(40, 2),
                new Lecture(60, 3),
                new Lecture(30, 3),
                new Lecture(30, 1)
        );
        Collections.sort(list);
        System.out.println("150, result: " + 최대_수입_스케줄_함수(list));
    }

    class Lecture implements Comparable<Lecture> {
        int money;
        int time;
        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }
        @Override
        public int compareTo(Lecture o) {
            return o.time - this.time;
        }
    }

    private int 최대_수입_스케줄_함수(List<Lecture> list) {
        int max = list.get(0).time;
        int n = list.size();
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (list.get(j).time < i) break;
                que.offer(list.get(j).money);
            }
            if (!que.isEmpty()) answer += que.poll();
        }



        return answer;
    }

    // 4. 최대 수입 스케쥴(PriorityQueue 응용문제) END

    // 5. 다익스트라 알고리즘(채점지원안됨) START
    /**
     * 다익스트라 알고리즘 적용시 전제 조건이 있다. 그래프의 가중치 값이 음수가 나오면 절대 안된다. 다 양수 (0 포함)
     * O(n)으로 돌면서 최소 값을 찾는다.
     *  -> n log n으로 찾는 방법이 있다. Priority Queue 사용 (이진 트리로 구성 되어 있다.)
     * 문제: 가중치 방향 그래프에서 1번 정점에서 모든 정점으로의 최소 거리 비용 출력 (경로 없을 시 Impossible 출력)
     *
     * 입력
     * 1 2 12 // 1번 정점에서 2번 정점으로 가는데 비용이 12
     * 1 3 4
     * 2 1 2
     * 2 3 5
     * 2 5 5
     * 3 4 5
     * 4 2 2
     * 4 5 5
     * 6 4 5
     * * 출력
     * 2 : 11
     * 3 : 4
     * 4 : 9
     * 5 : 14
     * 6 : impossible
     *
     */

    class Edge implements Comparable<Edge> {
        int vex;
        int cost;
        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    @Test
    void 다익스트라_알고리즘() {
        int n = 6; // 정점 개수
        int m = 9; // 간선 개수
        int[] dis = new int[n + 1];
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(dis, Integer.MAX_VALUE);
        graph.get(1).add(new Edge(2, 12));
        graph.get(1).add(new Edge(3, 4));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 5));
        graph.get(2).add(new Edge(5, 5));
        graph.get(3).add(new Edge(4, 5));
        graph.get(4).add(new Edge(2, 2));
        graph.get(4).add(new Edge(5, 5));
        graph.get(6).add(new Edge(4, 5));

        다익스트라_알고리즘_함수(1, dis, graph);
        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }

    private void 다익스트라_알고리즘_함수(int v, int[] dis, List<List<Edge>> graph) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) continue;
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }

    // 5. 다익스트라 알고리즘(채점지원안됨) END

    // Greedy Algorithm END

}

