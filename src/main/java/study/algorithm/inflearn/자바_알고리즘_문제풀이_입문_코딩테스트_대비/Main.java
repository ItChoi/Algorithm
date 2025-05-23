package study.algorithm.inflearn.자바_알고리즘_문제풀이_입문_코딩테스트_대비;

import java.util.*;

class Main {
    /*public static void main(String[] args) {
        *//**
         * Computercooler
         * c
         *//*
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next(); // 입력된 문자열 하나
        char c = kb.next().charAt(0); // 입력된 문자 하나

        System.out.print("result: " + T.문자_찾기_1(str, c));
    }

    private static int 문자_찾기_1(String str, char t) {
        int answer = 0;
        str = str.toUpperCase(); // 대소문자 구분 X, 모두 대문자로 변경
        t = Character.toUpperCase(t);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) {
                answer++;
            }
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next(); // 입력된 문자열 하나
        System.out.print("result: " + T.대소문자_변환_2_1(str));
    }

    private static String 대소문자_변환_2(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isLowerCase(x)) {
                answer += Character.toUpperCase(x);
            } else {
                answer += Character.toLowerCase(x);
            }
        }

        return answer;
    }

    private static String 대소문자_변환_2_1(String str) {
        // 아스키번호 활용
        String answer = "";
        for (char x : str.toCharArray()) {
            if (x >= 65 && x <= 90) {
                // 대문자
                answer += (char) (x + 32);
            } else if (x >= 97 && x <= 122) {
                answer += (char) (x - 32);
            }
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine(); // 입력된 문장
        System.out.print(T.문장_속_단어_indexOf_substring_3(str));
        System.out.print(T.문장_속_단어_indexOf_substring_3_1(str));
    }

    private static String 문장_속_단어_indexOf_substring_3(String str) {
        // split 풀이
        String answer = "";

        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for (String x : s) {
            int len = x.length();
            if (len > m) {
                m = len;
                answer = x;
            }
        }

        return answer;
    }

    private static String 문장_속_단어_indexOf_substring_3_1(String str) {
        // indexOf, substring 풀이
        String answer = "";

        int m = Integer.MIN_VALUE;
        int pos;

        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);

            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }

            str = str.substring(pos + 1);
        }

        // 마지막 단어 처리
        if (str.length() > m) {
            answer = str;
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = kb.next();
        }

//        for (String x : T.단어_뒤집기_StringBuilder_또는_직접뒤집기_4(n, str)) {
//            System.out.println(x);
//        }

        for (String x : T.단어_뒤집기_StringBuilder_또는_직접뒤집기_4_1(n, str)) {
            System.out.println(x);
        }
    }

    private static ArrayList<String> 단어_뒤집기_StringBuilder_또는_직접뒤집기_4(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    private static ArrayList<String> 단어_뒤집기_StringBuilder_또는_직접뒤집기_4_1(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
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
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.특정_문자_뒤집기_5(str));
    }

    private static String 특정_문자_뒤집기_5(String str) {
        String answer = "";

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

        answer = String.valueOf(s);
        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.중복문자제거_6(str));
    }

    private static String 중복문자제거_6(String str) {
        // indexOf 사용 풀이 -> k가 여러 개라도, 첫 발견 index를 반환한다.
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.회문_문자열_7(str));
        System.out.println(T.회문_문자열_7_1(str));
    }

    private static String 회문_문자열_7(String str) {
        // 앞에서 읽을 떄나, 뒤에서 읽을때 동일 -> 회문 문자열 = 팰린드럼
        String answer = "YES";
        str = str.toUpperCase();

        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return "NO";
            }
        }

        return answer;
    }

    private static String 회문_문자열_7_1(String str) {
        // 앞에서 읽을 떄나, 뒤에서 읽을때 동일 -> 회문 문자열 = 팰린드럼
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp)) {
            answer = "YES";
        }
        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.유효한_팰린드롬_8(str));
    }

    private static String 유효한_팰린드롬_8(String s) {
        // replaceAll 정규식 사용, replace는 정규식 사용 불가
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", "");

        String tmp = new StringBuilder(s).reverse().toString();
        if (s.equals(tmp)) answer = "YES";

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.숫자만_추출_9(str));
        System.out.println(T.숫자만_추출_9_1(str));
    }

    private static int 숫자만_추출_9(String s) {
        // 아스키 넘버 활용, 계산식으로 answer를 만든다.
        int answer = 0;
        for (char x : s.toCharArray()) {
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }

        return answer;
    }

    private static int 숫자만_추출_9_1(String s) {
        // 아스키 넘버 활용, 계산식으로 answer를 만든다.
        String answer = "";
        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) {
                answer += x;
            }
        }

        return Integer.parseInt(answer);
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);

        for (int x : T.가장_짧은_문자거리_10(str, c)) {
            System.out.print(x + " ");
        }

//        for (int x : T.가장_짧은_문자거리_10_me(str, c)) {
//            System.out.print(x);
//        }
    }

    private static int[] 가장_짧은_문자거리_10(String s, char c) {
        *//**
         * idx를 이용한다. 초기화 1000
         * 배열의 좌로 한 번, 우로 한 번 총 두 번 루프를 돈다.
         * 루프를 돌며 e를 만나면, idx는 0으로 세팅한다.
         *//*
        int[] answer = new int[s.length()];
        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i] ,p);
            }
        }

        return answer;
    }

    private static int[] 가장_짧은_문자거리_10_me(String s, char c) {
        int[] answer = new int[s.length()];

        int pos = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                pos = 0;
            }

            answer[i] = pos++;
        }

        pos = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pos = 1;
                continue;
            }

            if (answer[i] > pos) {
                answer[i] = pos;
            }

            pos++;
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.문자열압축_11(str));
        System.out.println(T.문자열압축_11_me(str));
    }

    private static String 문자열압축_11(String s) {
        *//**
         * 기존 스트링 문자열 마지막에 빈 문자열을 추가하고,
         * 문자열 length - 1만큼 순환하며, idx i와 i + 1을 비교한다.
         *//*
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

    private static String 문자열압축_11_me(String s) {
        StringBuilder sb = new StringBuilder();
        char tempX = s.charAt(0);
        int tempCnt = 1;

        for (int i = 1; i < s.length(); i++) {
            char x = s.charAt(i);
            if (tempX != x) {
                sb.append(tempX);
                tempX = x;
                if (tempCnt > 1) {
                    sb.append(tempCnt);
                    tempCnt = 1;
                }
                continue;
            }

            tempCnt++;
        }

        sb.append(tempX);
        if (tempCnt > 1) {
            sb.append(tempCnt);
        }

        return sb.toString();
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int i = kb.nextInt();
        String str = kb.next();

        System.out.println(T.암호_12(i, str));
        System.out.println(T.암호_12_me(i, str));
    }

    private static String 암호_12_me(int i, String s) {
        final int LIMIT = 7;
        String answer = "";

        for (int j = LIMIT; j <= s.length(); j += LIMIT) {
            answer += (char) Integer.parseInt(
                    s.substring(j - LIMIT, j)
                            .replaceAll("#", "1")
                            .replaceAll("\\*", "0"), 2);
        }

        return answer;
    }

    private static String 암호_12(int n, String s) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            s = s.substring(7);

        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (Integer x : T.큰_수_출력하기_01(n, arr)) {
            System.out.print(x + " ");
        }

        for (Integer x : T.큰_수_출력하기_01_me(n, arr)) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> 큰_수_출력하기_01_me(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            Integer preNum = arr[i - 1];
            int target = arr[i];

            if (target > preNum) {
                answer.add(target);
            }
        }

        return answer;
    }

    private static List<Integer> 큰_수_출력하기_01(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
            }
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.보이는_학생_02(n, arr));
        System.out.print(T.보이는_학생_02_me(n, arr));
    }

    private static int 보이는_학생_02_me(int n, int[] arr) {
        int answer = 1;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
                answer++;
            }
        }

        return answer;
    }
    */

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = kb.nextInt();
        }

        for (String x : T.가위_바위_보_03_me(n, arr1, arr2)) {
            System.out.println(x);
        }

        for (String x : T.가위_바위_보_03(n, arr1, arr2)) {
            System.out.println(x);
        }
    }

    private static List<String> 가위_바위_보_03_me(int n, int[] arr1, int[] arr2) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int user1 = arr1[i];
            int user2 = arr2[i];

            if (user1 == user2) {
                answer.add("D");
                continue;
            }

            int result = user1 - user2;
            if (result == -1 || result != 1) {
                answer.add("B");
            }  else {
                answer.add("A");
            }
        }

        return answer;
    }

    private static List<String> 가위_바위_보_03(int n, int[] a, int[] b) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                answer.add("D");
            } else if (a[i] == 1 && b[i] == 3) {
                answer.add("A");
            } else if (a[i] == 2 && b[i] == 1) {
                answer.add("A");
            } else if (a[i] == 3 && b[i] == 2) {
                answer.add("A");
            } else {
                answer.add("B");
            }
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        for (Integer x : T.피보나치_수열_04_me(n)) {
            System.out.print(x + " ");
        }

        for (Integer x : T.피보나치_수열_04(n)) {
            System.out.print(x + " ");
        }

        T.피보나치_수열_04_1(n);
    }

    private static List<Integer> 피보나치_수열_04_me(int n) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i < 2) {
                answer.add(1);
                continue;
            }

            answer.add(
                    answer.get(i - 2) + answer.get(i - 1)
            );
        }

        return answer;
    }

    private static int[] 피보나치_수열_04(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;
    }

    private static void 피보나치_수열_04_1(int n) {
        int a = 1;
        int b = 1;
        int c;

        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.print(T.소수_에라토스테네스_체_05_me(n));
        System.out.print(T.소수_에라토스테네스_체_05(n));
    }

    private static int 소수_에라토스테네스_체_05_me(int n) {
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            if (isPrimeNumber_me(i)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isPrimeNumber_me(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static int 소수_에라토스테네스_체_05(int n) {
        // 소수 구하는 방법론 중에 제일 빠르다 (제곱근 이용 보다 빠르다)
        int answer = 0;
        int[] ch = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) {
                    ch[j] = 1;
                }
            }
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (Integer x : T.뒤집은_소수_06_me(n, arr)) {
            System.out.print(x + " ");
        }

        for (Integer x : T.뒤집은_소수_06(n, arr)) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> 뒤집은_소수_06_me(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int realNum = arr[i];
            char[] charNum = String.valueOf(realNum).toCharArray();
            int lastIndex = charNum.length - 1;

            for (int j = 0; j < charNum.length / 2; j++) {
                char temp = charNum[j];
                charNum[j] = charNum[lastIndex - j];
                charNum[lastIndex - j] = temp;
            }

            int num = Integer.parseInt(String.valueOf(charNum));
            if (isPrimeNumber_me(num)) {
                answer.add(num);
            }
        }

        return answer;
    }

    private static boolean isPrimeNumber_me(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> 뒤집은_소수_06(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;

            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            if (isPrime(res)) {
                answer.add(res);
            }
        }

        return answer;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.점수_계산_07_me(n, arr));
        System.out.print(T.점수_계산_07(n, arr));
    }

    private static int 점수_계산_07_me(int n, int[] arr) {
        int answer = 0;

        int score = 1;
        for (int i = 0; i < n; i++) {

            if (arr[i] == 1) {
                answer += score;
                score++; // score 기본 값을 0으로 하면 상단에 올릴 수 있다.
                continue;
            }

            score = 1;
        }

        return answer;
    }

    private static int 점수_계산_07(int n, int[] arr) {
        int answer = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                answer += cnt;
            } else {
                cnt = 0;
            }
        }
        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int i : T.등수_구하기_08_me(n, arr)) {
            System.out.print(i + " ");
        }

        for (int i : T.등수_구하기_08(n, arr)) {
            System.out.print(i + " ");
        }
    }

    private static int[] 등수_구하기_08_me(int n, int[] arr) {
        int[] answer = new int[n];
        Map<Integer, Integer> levelWithScore = new HashMap<>();

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        for (int i = 0 ; i < arr.length; i++) {
            int score = arr[i];
            Integer cache = levelWithScore.get(score);
            if (cache != null) {
                answer[i] = cache;
                continue;
            }

            int level = 1;
            for (int j = sortedArr.length - 1; j >= 0; j--) {
                if (sortedArr[j] == score) {
                    answer[i] = level;
                    levelWithScore.put(score, level);
                    break;
                }

                level++;
            }
        }

        return answer;
    }

    private static int[] 등수_구하기_08(int n, int[] arr) {
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

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.격자판_최대합_09_me(n, arr));
        System.out.println(T.격자판_최대합_09(n, arr));
    }

    private int 격자판_최대합_09_me(int n,
                                 int[][] arr) {
        int answer = 0;

        int ascendingDiagonal = 0;
        int descendingDiagonal = 0;

        for (int i = 0; i < arr.length; i++) {
            int width = 0;
            int height = 0;
            for (int j = 0; j < arr[i].length; j++) {
                width += arr[i][j];
                height += arr[j][i];

            }

            ascendingDiagonal += arr[i][i];
            descendingDiagonal += arr[i][n - 1 - i];

            int winSum = Math.max(width, height);
            if (winSum > answer) {
                answer = winSum;
            }
        }

        return Math.max(answer, Math.max(ascendingDiagonal, descendingDiagonal));
    }

    private int 격자판_최대합_09(int n,
                              int[][] arr) {
        int answer = Integer.MIN_VALUE;
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
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.봉우리_10_me(n, arr));
        System.out.println(T.봉우리_10(n, arr));
    }

    private int 봉우리_10_me(int n,
                           int[][] arr) {
        int result = 0;
        int[] dt1 = {-1, 0, 1, 0};
        int[] dt2 = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isOk = true;

                for (int k = 0; k < dt1.length; k++) {
                    int d1 = i + dt1[k];
                    int d2 = j + dt2[k];

                    if (d1 < 0 || d1 >= n || d2 < 0 || d2 >= n) {
                        continue;
                    }

                    if (arr[i][j] <= arr[d1][d2]) {
                        isOk = false;
                        break;
                    }
                }

                if (isOk) {
                    result++;
                }
            }
        }

        return result;
    }

    private int 봉우리_10(int n,
                        int[][] arr) {
        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) answer++;
            }
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        *//*int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }*//*

        int[][] arr = new int[n + 1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

//        System.out.println(T.임시반장_정하기_11_me(n, arr));
        System.out.println(T.임시반장_정하기_11(n, arr));
    }

    private int 임시반장_정하기_11_me(int n,
                                  int[][] arr) {
        int result = 1;
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                int stNum = j + 1;
                int stBan = arr[j][i];
                for (int k = j + 1; k < n; k++) {
                    int compareStNum = k + 1;
                    int compareStBan = arr[k][i];

                    if (stBan == compareStBan) {
                        Set<Integer> set1 = map.getOrDefault(stNum, new HashSet<>());
                        set1.add(compareStNum);
                        Set<Integer> set2 = map.getOrDefault(compareStNum, new HashSet<>());
                        set2.add(stNum);

                        map.put(stNum, set1);
                        map.put(compareStNum, set2);
                    }
                }
            }
        }


        int max = 0;
        for (Integer student : map.keySet()) {
            int size = map.get(student).size();
            if (max < size) {
                max = size;
                result = student;
            }
        }

        return result;
    }

    private int 임시반장_정하기_11(int n,
                               int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }

            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.멘토링_12_me(n, m, arr));
        System.out.println(T.멘토링_12(n, m, arr));
    }

    private int 멘토링_12_me(int n,
                           int m,
                           int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean isLast = false;
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < m; j++) {
                if (arr[j][n - 1] == i) {
                    isLast = true;
                    break;
                }

                boolean isGo = false;
                for (int k = 0; k < n; k++) {
                    int student = arr[j][k];
                    if (student == i) {
                        isGo = true;
                        continue;
                    }

                    if (!isGo) {
                        continue;
                    }

                    Integer count = map.getOrDefault(student, 0);
                    if (count < j) {
                        continue;
                    }

                    map.put(student, count + 1);
                }
            }

            if (isLast) {
                continue;
            }

            for (Integer student : map.keySet()) {
                if (map.get(student) == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private int 멘토링_12(int n,
                        int m,
                        int[][] arr) {
        // 강사님은 4중 for문을 사용한다고 함
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;

                for (int k = 0; k < m; k++) {
                    int pi = 0;
                    int pj = 0;

                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) {
                            pi = s;
                        }

                        if (arr[k][s] == j) {
                            pj = s;
                        }
                    }

                    if (pi < pj) {
                        cnt++;
                    }
                }
                if (cnt == m) {
                    answer++;
                }
            }
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = kb.nextInt();
        }

        for (int i : T.두_배열_합치기_1_me(n, arr1, m, arr2)) {
            System.out.print(i + " ");
        }

        for (int i : T.두_배열_합치기_1(n, arr1, m, arr2)) {
            System.out.print(i + " ");
        }

    }

    private int[] 두_배열_합치기_1_me(int n,
                                int[] arr1,
                                int m,
                                int[] arr2) {
        int[] answer = new int[n + m];

        int ni = 0;
        int mi = 0;
        for (int i = 0; i < n + m; i++) {
            if (ni < arr1.length && mi < arr2.length) {
                if (arr1[ni] < arr2[mi]) {
                    answer[i] = arr1[ni];
                    ni++;
                } else {
                    answer[i] = arr2[mi];
                    mi++;
                }

                continue;
            }

            boolean isExceedNi = ni >= arr1.length;
            if (isExceedNi) {
                answer[i] = arr2[mi];
                mi++;
            } else {
                answer[i] = arr1[ni];
                ni++;
            }
        }

        return answer;
    }

    private List<Integer> 두_배열_합치기_1(int n,
                             int[] a,
                             int m,
                             int[] b) {
        // 투포인트 알고리즘 사용
        // 퀵 정렬 시간 복잡도: O (n log n)
        List<Integer> answer = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }

        while (p1 < n) answer.add(a[p1++]);
        while (p2 < m) answer.add(b[p2++]);

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = kb.nextInt();
        }

        for (int i : T.공통원소_구하기_2_me(n, arr1, m, arr2)) {
            System.out.print(i + " ");
        }

        for (int i : T.공통원소_구하기_2(n, arr1, m, arr2)) {
            System.out.print(i + " ");
        }

    }

    private List<Integer> 공통원소_구하기_2_me(int n,
                                        int[] a,
                                        int m,
                                        int[] b) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);

        int lt = 0;
        int rt = 0;
        while (lt < n && rt < m) {
            int aVal = a[lt];
            int bVal = b[rt];

            if (aVal == bVal) {
                answer.add(aVal);
                lt++;
                rt++;
                continue;
            }

            if (aVal < bVal) {
                lt++;
            } else {
                rt++;
            }
        }

        return answer;
    }

    private List<Integer> 공통원소_구하기_2(int n,
                                     int[] a,
                                     int m,
                                     int[] b) {
        // 투 포인트 알고리즘은 원소들을 오름차순으로 정렬해야 한다.
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);

        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < m) {
            if (a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            } else if (a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.최대_매출_3_me(n, m, arr));
        System.out.print(T.최대_매출_3(n, m, arr));
    }

    private int 최대_매출_3_me(int n,
                           int m,
                           int[] arr) {
        int answer = 0;

        for (int i = 0; i < m; i++) {
            answer += arr[i];
        }

        int tpIndex = 0;
        int sum = answer;
        for (int i = m; i < n; i++) {
            sum += arr[i];
            sum -= arr[tpIndex++];

            if (answer < sum) {
                answer = sum;
            }
        }

        return answer;
    }

    private int 최대_매출_3(int n,
                        int k,
                        int[] arr) {
        // 슬라이딩 윈도우 사용
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        answer = sum;

        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.연속_부분수열_4_me(n, m, arr));
        System.out.print(T.연속_부분수열_4(n, m, arr));
    }

    private int 연속_부분수열_4_me(int n,
                             int m,
                             int[] arr) {
        int answer = 0;

        int index = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) continue;

            sum += arr[i];
            while (sum > m) {
                sum -= arr[index++];
            }

            if (sum == m) {
                answer++;
                sum -= arr[index++];
            }
        }

        return answer;
    }

    private int 연속_부분수열_4(int n,
                          int m,
                          int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];

            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.print(T.연속된_자연수의_합_05_me(n));
        System.out.print(T.연속된_자연수의_합_05(n));
        System.out.print(T.연속된_자연수의_합_05_other(n));
    }

    private int 연속된_자연수의_합_05_me(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 1;
        for (int rt = 1; rt < n; rt++) {
            sum += rt;
            while (sum > n) {
                sum -= lt;
                lt++;
            }

            if (sum == n) {
                answer++;
            }
        }

        return answer;
    }

    private int 연속된_자연수의_합_05(int n) {
        // n / 2 + 1 까지만 연산을 하면 된다.
        int answer = 0;
        int sum = 0;
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
        }

        return answer;
    }

    private int 연속된_자연수의_합_05_other(int n) {
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

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.최대_길이_연속부분수열_06_me(n, m, arr));
        System.out.print(T.최대_길이_연속부분수열_06(n, m, arr));
    }

    private int 최대_길이_연속부분수열_06_me(int n,
                                       int m,
                                       int[] arr) {
        int answer = 0;

        int lt = -1;
        for (int rt = 0; rt < arr.length; rt++) {
            if (arr[rt] == 0) {
                if (m > 0) {
                    m--;
                    continue;
                }

                int sum = rt - (lt + 1);
                if (answer < sum) {
                    answer = sum;
                }

                for (int i = lt + 1; i <= rt; i++) {
                    if (arr[i] == 0) {
                        lt = i;
                        arr[i] = 2;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    private int 최대_길이_연속부분수열_06(int n,
                                    int m,
                                    int[] arr) {
        int answer = 0;
        int cnt = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) cnt++;

            while (cnt > m) {
                if (arr[lt] == 0) {
                    cnt --;
                }
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String m = kb.next();

        System.out.print(T.학급회장_01_me(n, m));
        System.out.print(T.학급회장_01(n, m));
    }

    private String 학급회장_01_me(int n,
                              String m) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : m.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        for (Character key : map.keySet()) {
            int cnt = map.get(key);
            if (max < cnt) {
                max = cnt;
                answer = String.valueOf(key);
            }
        }

        return answer;
    }

    private char 학급회장_01(int n,
                         String s) {

        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Character key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }


        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String n = kb.next();
        String m = kb.next();

        System.out.print(T.아나그램_02_me(n, m));
        System.out.print(T.아나그램_02(n, m));
    }

    private String 아나그램_02_me(String n,
                              String m) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : n.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : m.toCharArray()) {
            Integer cnt = map.get(c);
            if (cnt == null || cnt < 0) {
                return "NO";
            }

            map.put(c, cnt - 1);
        }

        for (Character c : map.keySet()) {
            if (map.get(c) != 0) {
                return "NO";
            }
        }

        return "YES";
    }

    private String 아나그램_02(String s1,
                           String s2) {
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x) - 1);
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }

        for (int i : T.매출액의_종류_03_me(n, k, arr)) {
            System.out.print(i + " ");
        }

        for (int i : T.매출액의_종류_03(n, k, arr)) {
            System.out.print(i + " ");
        }
    }

    private List<Integer> 매출액의_종류_03_me(int n,
                                 int k,
                                 int[] arr) {
        List<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int key = arr[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        answer.add(map.size());

        for (int i = k; i < n; i++) {
            int key = arr[i];
            map.put(key, map.getOrDefault(key, 0) + 1);

            int removeKey = arr[i - k];
            map.put(removeKey, map.getOrDefault(removeKey, 0) - 1);
            if (map.get(removeKey) <= 0) {
                map.remove(removeKey);
            }

            answer.add(map.size());
        }

        return answer;
    }

    private List<Integer> 매출액의_종류_03(int n,
                              int k,
                              int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> HM = new HashMap<>();

        for (int i = 0; i < k - 1; i++) {
            HM.put(arr[i], HM.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0) + 1);
            answer.add(HM.size());

            HM.put(arr[lt], HM.get(arr[lt]) - 1);
            if (HM.get(arr[lt]) == 0) HM.remove(arr[lt]);
            lt++;
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String s  = kb.next();
        String t  = kb.next();

        System.out.print(T.모든_아나그램_찾기_04_me(s, t));
        System.out.print(T.모든_아나그램_찾기_04(s, t));
    }

    private int 모든_아나그램_찾기_04_me(String s,
                                    String t) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> compareMap = new HashMap<>();

        for (int i = 0; i < t.toCharArray().length - 1; i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            compareMap.put(c, compareMap.getOrDefault(c, 0) + 1);
        }

        int lt = 0;
        for (int i = t.toCharArray().length - 1; i < s.toCharArray().length; i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);

            boolean isOk = true;
            for (Character c : map.keySet()) {
                Integer com1 = map.get(c);
                Integer com2 = compareMap.get(c);
                if (com2 == null || com1 != com2) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) answer++;

            char removeKey = s.charAt(lt);
            map.put(removeKey, map.get(removeKey) - 1);
            if (map.get(removeKey) <= 0) {
                map.remove(removeKey);
            }

            lt++;
        }

        return answer;
    }

    private int 모든_아나그램_찾기_04(String a,
                                  String b) {
        // map1.equals(map2) -> key와 value 모두 비교해서 true/false
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for (Character x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        int L = b.length() - 1;
        for (int i = 0; i < L; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);

            if (am.equals(bm)) {
                answer++;
            }

            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if (am.get(a.charAt(lt)) == 0) {
                am.remove(a.charAt(lt));
            }

            lt++;
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.K번째_큰_수_05_me(n, k, arr));
        System.out.print(T.K번째_큰_수_05(n, k, arr));
    }

    private Integer K번째_큰_수_05_me(int n,
                                  int k,
                                  int[] arr) {
        Integer answer = -1;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1 ; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        List<Integer> repo = new ArrayList<>(set);
        Collections.sort(repo, Collections.reverseOrder());

        if (repo.size() >= k) {
            answer = repo.get(k - 1);
        }

        return answer;
    }

    private Integer K번째_큰_수_05(int n,
                               int k,
                               int[] arr) {
        // TreeSet -> 중복 제거, 정렬 (레드 블랙 트리)
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); // 기본은 오름차순

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (Integer x : Tset) {
            cnt++;
            if (cnt == k) return x;
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String n = kb.next();
        System.out.print(T.올바른_괄호_01_me(n));
        System.out.print(T.올바른_괄호_01(n));
    }

    private String 올바른_괄호_01_me(String n) {
        Stack<Character> stack = new Stack<>();
        for (char c : n.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return "NO";
            }

            stack.pop();
        }

        if (!stack.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

    private String 올바른_괄호_01(String str) {
        // 스택 자료구조 대표적인 문제
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return "NO";
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String n = kb.next();
        System.out.print(T.괄호문자제거_02_me(n));
        System.out.print(T.괄호문자제거_02(n));
    }

    private String 괄호문자제거_02_me(String n) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char c : n.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            } else if (c == ')') {
                stack.pop();
                continue;
            }

            if (stack.isEmpty()) {
                answer = answer + c;
                continue;
            }
        }

        return answer;
    }

    private String 괄호문자제거_02(String str) {
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
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        Integer n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        Integer m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }
        System.out.print(T.크레인_인형뽑기_03_me(n, board, m, moves));
        System.out.print(T.크레인_인형뽑기_03(n, board, m, moves));
    }

    private int 크레인_인형뽑기_03_me(int n,
                               int[][] board,
                               int m,
                               int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int moveIdx = moves[i] - 1;

            for (int j = 0; j < n; j++) {
                int value = board[j][moveIdx];
                if (value == 0) {
                    continue;
                }

                board[j][moveIdx] = 0;
                if (!stack.isEmpty() && stack.peek() == value) {
                    stack.pop();
                    answer += 2;
                    break;
                }

                stack.push(value);
                break;
            }
        }

        return answer;
    }

    private int 크레인_인형뽑기_03(int n,
                            int[][] board,
                            int m,
                            int[] moves) {
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


        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.후위식_연산_04_me(str));
        System.out.print(T.후위식_연산_04(str));
    }

    private int 후위식_연산_04_me(String str) {
        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (isOperator(c)) {
                stack.push(operateNumber(c, stack.pop(), stack.pop()));
                continue;
            }
            stack.push(Character.getNumericValue(c));
        }

        return stack.pop();
    }

    private int operateNumber(char c,
                              int num1,
                              int num2) {
        if (c == '+') {
            return num2 + num1;
        } else if (c == '/') {
            return num2 / num1;
        } else if (c == '*') {
            return num2 * num1;
        } else if (c == '-') {
            return num2 - num1;
        }

        return 0;
    }

    private boolean isOperator(char c) {
        return c == '+'
                || c == '/'
                || c == '*'
                || c == '-';
    }

    private int 후위식_연산_04(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+') stack.push(lt + rt);
                else if(x == '-') stack.push(lt - rt);
                else if(x == '*') stack.push(lt * rt);
                else if(x == '/') stack.push(lt / rt);
            }
        }

        answer = stack.get(0);
        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.쇠막대기_05_me(str));
        System.out.print(T.쇠막대기_05(str));
    }

    private int 쇠막대기_05_me(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);

            if (x == '(') {
                stack.push(x);
                continue;
            }

            stack.pop();
            if (str.charAt(i - 1) == '(') {
                answer += stack.size();
                continue;
            }

            answer++;
        }

        return answer;
    }


    private int 쇠막대기_05(String str) {
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
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();
        System.out.print(T.공주_구하기_06_me(N, K));
        System.out.print(T.공주_구하기_06(N, K));
    }

    private int 공주_구하기_06_me(int N,
                               int K) {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.add(i);
        }

        int cnt = 1;
        while (que.size() != 1) {
            if (K == cnt++) {
                que.poll();
                cnt = 1;
                continue;
            }

            que.add(que.poll());
        }

        return que.poll();
    }


    private int 공주_구하기_06(int n,
                            int k) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) Q.offer(i);
        while(!Q.isEmpty()) {
            for (int i = 1; i < k; i++) Q.offer(Q.poll());
            Q.poll();
            if (Q.size() == 1) answer = Q.poll();
        }
        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String n = kb.next();
        String k = kb.next();
        System.out.print(T.교육과정_설계_07_me(n, k));
        System.out.print(T.교육과정_설계_07(n, k));
    }

    private String 교육과정_설계_07_me(String n,
                                    String k) {
        Set<Character> set = new HashSet<>();
        for (char c : n.toCharArray()) {
            set.add(c);
        }

        Queue<Character> que = new LinkedList<>();
        for (char c : k.toCharArray()) {
            if (set.contains(c)) {
                que.add(c);
            }
        }

        if (que.size() != n.length()) {
            return "NO";
        }

        for (char c : n.toCharArray()) {
            if (c != que.poll()) {
                return "NO";
            }
        }
        
        return "YES";
    }


    private String 교육과정_설계_07(String need,
                                 String plan) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for (char x : need.toCharArray()) Q.offer(x);
        for (char x : plan.toCharArray()) {
            if (Q.contains(x)) {
                if (x != Q.poll()) return "NO";
            }
        }

        if (!Q.isEmpty()) return "NO";

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(T.응급실_08_me(n, m, arr));
        System.out.print(T.응급실_08(n, m, arr));
    }

    private int 응급실_08_me(int n,
                          int m,
                          int[] arr) {
        Queue<Integer> que = new LinkedList<>();
        PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            que.offer(arr[i]);
            if (arr[i] > arr[m]) {
                pQue.offer(arr[i]);
            }
        }

        int answer = 0;
        while (!pQue.isEmpty()) {
            Integer high = pQue.poll();

            for (int i = 0; i < n; i++) {
                Integer compare = que.poll();
                m--;
                if (high == compare) {
                    answer++;
                    break;
                }

                que.offer(compare);
                if (m < 0) {
                    m = que.size() - 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (que.poll() == arr[m]) {
                answer++;
            }
        }

        return answer + 1;
    }

    private int 응급실_08(int n,
                       int m,
                       int[] arr) {
        int answer = 0;
        Queue<응급실_08_Person> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Q.offer(new 응급실_08_Person(i, arr[i]));
        }

        while (!Q.isEmpty()) {
            응급실_08_Person tmp = Q.poll();
            for (응급실_08_Person x : Q) {
                if (x.priority > tmp.priority) {
                    Q.offer(tmp);
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
    }

    class 응급실_08_Person {
        int id;
        int priority;
        public 응급실_08_Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }


        for (int i : T.선택정렬_01_me(n, arr)) {
            System.out.print(i + " ");
        }
        System.out.print(T.선택정렬_01(n, arr));
    }

    private int[] 선택정렬_01_me(int n,
                             int[] arr) {
        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }

            if (idx == i) {
                continue;
            }

            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }

        return arr;
    }

    private int[] 선택정렬_01(int n,
                          int[] arr) {
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
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }


        for (int i : T.버블정렬_02_me(n, arr)) {
            System.out.print(i + " ");
        }
        for (int i : T.버블정렬_02(n, arr)) {
            System.out.print(i + " ");
        }
    }

    private int[] 버블정렬_02_me(int n,
                             int[] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    private int[] 버블정렬_02(int n,
                          int[] arr) {
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
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int i : T.삽입정렬_03_me(n, arr)) {
            System.out.print(i + " ");
        }

        for (int i : T.삽입정렬_03(n, arr)) {
            System.out.print(i + " ");
        }
    }

    private int[] 삽입정렬_03_me(int n,
                             int[] arr) {
        for (int i = 1; i < n; i++) {
            int target = arr[i];
            for (int j = i; j > 0; j--) {
                if (target > arr[j - 1]) {
                    break;
                }

                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }

        return arr;
    }

    private int[] 삽입정렬_03(int n,
                          int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];

            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = tmp;
        }

        return arr;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

//        for (int i : T.LEAST_RECENTLY_USED_04_me(s, n, arr)) {
//            System.out.print(i + " ");
//        }

        for (int i : T.LEAST_RECENTLY_USED_04(s, n, arr)) {
            System.out.print(i + " ");
        }
    }

    private List<Integer> LEAST_RECENTLY_USED_04_me(int s,
                                                    int n,
                                                    int[] arr) {
        List<Integer> cache = new LinkedList<>();
        for (Integer value : arr) {
            if (cache.contains(value)) {
                for (int i = 0; i < cache.size(); i++) {
                    if (value.equals(cache.get(i))) {
                        Integer cVal = cache.get(i);
                        cache.remove(i);
                        cache.add(0, cVal);
                        break;
                    }
                }

                continue;
            }

            while (cache.size() >= s) {
                cache.remove(cache.size() - 1);
            }

            cache.add(0, value);
        }

        return cache;
    }

    private int[] LEAST_RECENTLY_USED_04(int size,
                                         int n,
                                         int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) {
                if (x == cache[i]) {
                    pos = i;
                }
            }

            if (pos == -1) {
                for (int i = size - 1; i >= 1; i--) {
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
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.중복확인_05_me(n, arr));
        System.out.print(T.중복확인_05(n, arr));
    }

    private String 중복확인_05_me(int n,
                           int[] arr) {
        Arrays.sort(arr);

        int temp = 0;
        for (int i : arr) {
            if (i == temp) {
                return "D";
            }

            temp = i;
        }

        return "U";
    }

    private String 중복확인_05(int n,
                           int[] arr) {
        // HashMap 방법도 있지만, 정렬로 풀 수 있는 방법도 있다.
        // 정렬로 풀 때 시간복잡도 n log n
        String result = "U";
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) return "D";
        }

        return result;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int i : T.장난꾸러기_06_me(n, arr)) {
            System.out.print(i + " ");
        }

        for (int i : T.장난꾸러기_06(n, arr)) {
            System.out.print(i + " ");
        }
    }

    private List<Integer> 장난꾸러기_06_me(int n,
                                      int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);
        for (int i = 0; i < n; i++) {
            if (arr[i] != sortArr[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    private List<Integer> 장난꾸러기_06(int n,
                                   int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) answer.add(i + 1);
        }

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        for (int[] iArr : T.좌표_정렬_07_me(n, arr)) {
            for (int i : iArr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    private int[][] 좌표_정렬_07_me(int N,
                                         int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            }

            if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[1] > o2[1]) {
                return 1;
            }

            return 0;
        });

        return arr;
    }

    private static List<T_좌표_정렬_07_Point> T_좌표_정렬_07(int N,
                                                     List<T_좌표_정렬_07_Point> arr) {
        Collections.sort(arr);
        return arr;
    }

    class T_좌표_정렬_07_Point implements Comparable<T_좌표_정렬_07_Point> {
        public int x;
        public int y;

        T_좌표_정렬_07_Point(int x,
                         int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(T_좌표_정렬_07_Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            } else {
                return this.x = o.x;
            }
        }
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.이분검색_08_me(N, K, arr));
        //System.out.print(T.이분검색_08(N, K, arr));
    }

    private int 이분검색_08_me(int N,
                           int K,
                           int[] arr) {
        Arrays.sort(arr);

        int lt = 0;
        int rt = N - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == K) {
                return mid + 1;
            }

            if (arr[mid] < K) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return 0;
    }

    private int 이분검색_08(int n,
                        int m,
                        int[] arr) {
        int answer = 0;
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

        return answer;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.뮤직비디오_09_me(n, m, arr));
//        System.out.print(T.뮤직비디오_09(n, m, arr));
    }

    private int 뮤직비디오_09_me(int n,
                            int m,
                            int[] arr) {
        int answer = Integer.MAX_VALUE;
        int lt = 0;
        int rt = 0;
        for (int i : arr) {
            rt += i;
        }

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int cnt = 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int val = arr[i];
                if (sum + val <= mid) {
                    sum += val;
                    continue;
                }

                sum = val;
                cnt++;

                if (cnt > m) {
                    break;
                }
            }

            if (cnt <= m) {
                if (answer > mid) {
                    answer = mid;
                }

                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    private int 뮤직비디오_09(int n,
                         int m,
                         int[] arr) {
        // 이분 탐색으로 하기, lt rt mid
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (뮤직비디오_09_count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public int 뮤직비디오_09_count(int[] arr,
                              int capacity) {
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

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.마구간_정하기_10_me(n, c, arr));
        //System.out.print(T.마구간_정하기_10(n, c, arr));
    }

    private int 마구간_정하기_10_me(int n,
                              int c,
                              int[] arr) {
        Arrays.sort(arr);
        int answer = 0;

        int lt = 1;
        int rt = arr[arr.length - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (마구간_정하기_10_me_is_ok(mid, c, arr)) {
                if (answer < mid) {
                    answer = mid;
                }
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    private boolean 마구간_정하기_10_me_is_ok(int mid,
                                        int c,
                                        int[] arr) {
        int preVal = arr[0];
        c = c - 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - preVal >= mid) {
                preVal = arr[i];
                if (--c == 0) {
                    break;
                }
            }
        }

        return c == 0;
    }

    private int 마구간_정하기_10(int n,
                           int c,
                           int[] arr) {
        // lt는 arr[0]이 아니라 1로 시작해야 한다.
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n - 1];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (마구간_정하기_10_count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public int 마구간_정하기_10_count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }

        return cnt;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        T.재귀함수_01_me(n);
    }

    private void 재귀함수_01_me(int n) {
        if (n == 0) {
            return;
        }

        재귀함수_01_me(n - 1);
        System.out.print(n + " ");
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        T.재귀함수를_이용한_이진수_출력_02_me(n);
    }

    private void 재귀함수를_이용한_이진수_출력_02_me(int n) {
        if (n == 0) return;
        //System.out.print(n % 2 + " ");
        재귀함수를_이용한_이진수_출력_02_me(n / 2);
        System.out.print(n % 2 + " ");
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(T.팩토리얼_03_me(n));
    }

    private int 팩토리얼_03_me(int n) {
        if (n == 1) return 1;

        return n * 팩토리얼_03_me(n - 1);
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        피보나치_재귀_메모이제이션_04_02_fibo = new int[n + 1];
//        System.out.println(T.피보나치_재귀_04_01(n));

        T.피보나치_재귀_04_02(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(피보나치_재귀_메모이제이션_04_02_fibo[i] + " ");
        }
    }

    private int 피보나치_재귀_04_01(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return 피보나치_재귀_04_01(n - 2) + 피보나치_재귀_04_01(n - 1);
        }
    }

    static int[] 피보나치_재귀_메모이제이션_04_02_fibo;
    private int 피보나치_재귀_04_02(int n) {
        if (n == 1) {
            return 피보나치_재귀_메모이제이션_04_02_fibo[n] = 1;
        } else if (n == 2) {
            return 피보나치_재귀_메모이제이션_04_02_fibo[n] = 1;
        } else {
            return 피보나치_재귀_메모이제이션_04_02_fibo[n] = 피보나치_재귀_04_02(n - 2) + 피보나치_재귀_04_02(n - 1);
        }
    }

    private int 피보나치_재귀_메모이제이션_04_03(int n) {
        if (피보나치_재귀_메모이제이션_04_02_fibo[n] > 0) {
            return 피보나치_재귀_메모이제이션_04_02_fibo[n];
        }
        if (n == 1) {
            return 피보나치_재귀_메모이제이션_04_02_fibo[n] = 1;
        } else if (n == 2) {
            return 피보나치_재귀_메모이제이션_04_02_fibo[n] = 1;
        } else {
            return 피보나치_재귀_메모이제이션_04_02_fibo[n] = 피보나치_재귀_04_02(n - 2) + 피보나치_재귀_04_02(n - 1);
        }
    }*/

    /*public static void main(String[] args) {
        이진트리순회_05_Node root;
        root = new 이진트리순회_05_Node(1);
        root.lt = new 이진트리순회_05_Node(2);
        root.rt = new 이진트리순회_05_Node(3);
        root.lt.lt = new 이진트리순회_05_Node(4);
        root.lt.rt = new 이진트리순회_05_Node(5);
        root.rt.lt = new 이진트리순회_05_Node(6);
        root.rt.rt = new 이진트리순회_05_Node(7);

        이진트리순회_05_DFS(root);
    }

    static class 이진트리순회_05_Node {
        int data;
        이진트리순회_05_Node lt;
        이진트리순회_05_Node rt;

        public 이진트리순회_05_Node(int val) {
            this.data = val;
            lt = null;
            rt = null;
        }
    }

    public static void 이진트리순회_05_DFS(이진트리순회_05_Node root) {
        if (root == null) {
            return;
        } else {
            //System.out.println(root.data); // 전위 순회
            이진트리순회_05_DFS(root.lt);
            //System.out.println(root.data); // 중위 순회
            이진트리순회_05_DFS(root.rt);
            System.out.println(root.data); // 후위 순회
        }
    }*/

    /*static int 부분집합_구하기_06_n = 3;
    static int[] 부분집합_구하기_06_ch = new int[부분집합_구하기_06_n + 1];
    public static void main(String[] args) {
        부분집합_구하기_06_DFS(1);
    }

    public static void 부분집합_구하기_06_DFS(int L) {
        if (L == 부분집합_구하기_06_n + 1) {
//            for (int i = 1; i < 부분집합_구하기_06_ch.length; i++) {
//                if (부분집합_구하기_06_ch[i] == 1) {
//                    System.out.print(i + " ");
//                }
//            }
//            System.out.println();
            String tmp = "";
            for (int i = 1; i <= 부분집합_구하기_06_n; i++) {
                if (부분집합_구하기_06_ch[i] == 1) tmp += (i+" ");
            }
            if (tmp.length() > 0) System.out.println(tmp);
        } else {
            // 왼쪽 - 사용
            부분집합_구하기_06_ch[L] = 1;
            부분집합_구하기_06_DFS(L + 1);

            // 오른쪽 - 사용 안함
            부분집합_구하기_06_ch[L] = 0;
            부분집합_구하기_06_DFS(L + 1);
        }
    }*/

    /*public static void main(String[] args) {
        이진트리_레벨탐색_07_Node root;
        root = new 이진트리_레벨탐색_07_Node(1);
        root.lt = new 이진트리_레벨탐색_07_Node(2);
        root.rt = new 이진트리_레벨탐색_07_Node(3);
        root.lt.lt = new 이진트리_레벨탐색_07_Node(4);
        root.lt.rt = new 이진트리_레벨탐색_07_Node(5);
        root.rt.lt = new 이진트리_레벨탐색_07_Node(6);
        root.rt.rt = new 이진트리_레벨탐색_07_Node(7);

        이진트리_레벨탐색_07_BFS(root);
    }

    static class 이진트리_레벨탐색_07_Node {
        int data;
        이진트리_레벨탐색_07_Node lt;
        이진트리_레벨탐색_07_Node rt;

        public 이진트리_레벨탐색_07_Node(int val) {
            this.data = val;
            lt = null;
            rt = null;
        }
    }

    public static void 이진트리_레벨탐색_07_BFS(이진트리_레벨탐색_07_Node root) {
        Queue<이진트리_레벨탐색_07_Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                이진트리_레벨탐색_07_Node cur = Q.poll();
                System.out.print(cur.data + " ");

                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();

        System.out.print(T.송아지_찾기_08_1_me(s, e));
        System.out.print(T.송아지_찾기_08_1(s, e));
    }

    private int 송아지_찾기_08_1_me(int s,
                               int e) {
        int[] d = {1, -1, 5};
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        Queue<Integer> que = new LinkedList<>();
        que.add(s);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Integer num = que.poll();
                if (set.contains(num)) continue;
                set.add(num);
                if (e == num) {
                    return answer;
                }

                for (int d1 : d) {
                    int target = num + d1;
                    if (target < 0) {
                        continue;
                    }

                    que.add(target);
                }
            }

            answer++;
        }

        return answer;
    }

    private int 송아지_찾기_08_1(int s,
                            int e) {
        int[] dis = {1, -1, 5};
        int[] ch = new int[10001];
        ch[s] = 1;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Integer x = Q.poll();
                for (int j = 0; j < dis.length; j++) {
                    int nx = x + dis[j];
                    if (nx == e) return L + 1;
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }

        return L;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();

        TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node root;
        root = new TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node(1);
        root.lt = new TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node(2);
        root.rt = new TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node(3);
        root.lt.lt = new TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node(4);
        root.lt.rt = new TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node(5);
        root.rt.lt = new TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node(5);
        root.rt.rt = new TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node(5);

        // TODO: 이 문제는 DFS보다, BFS로 푸는 것이 맞지만 학습차원에서 진행
        System.out.print(T.TREE_말단노드까지의_가장_짧은_경로_DFS_09(0, root));
    }

    private int TREE_말단노드까지의_가장_짧은_경로_DFS_09(int L,
                                             TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node root) {
        if (root.lt == null && root.rt == null) {
            return L;
        } else {
            return Math.min(
                    TREE_말단노드까지의_가장_짧은_경로_DFS_09(L + 1, root.lt),
                    TREE_말단노드까지의_가장_짧은_경로_DFS_09(L + 1, root.rt)
            );
        }
    }


    static class TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node {
        int data;
        TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node lt;
        TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node rt;

        public TREE_말단노드까지의_가장_짧은_경로_DFS_09_Node(int val) {
            this.data = val;
            lt = null;
            rt = null;
        }
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();

        TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node root;
        root = new TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node(1);
        root.lt = new TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node(2);
        root.rt = new TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node(3);
        root.lt.lt = new TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node(4);
        root.lt.rt = new TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node(5);
        root.rt.lt = new TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node(5);
        root.rt.rt = new TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node(5);

        System.out.print(T.TREE_말단노드까지의_가장_짧은_경로_BFS_10(root));
    }

    private int TREE_말단노드까지의_가장_짧은_경로_BFS_10(TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node root) {
        Queue<TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;

        while (Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node cur = Q.poll();
                if (cur.lt == null && cur.rt == null) {
                    return L;
                }

                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
        }

        return 0;
    }

    static class TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node {
        int data;
        TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node lt;
        TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node rt;

        public TREE_말단노드까지의_가장_짧은_경로_BFS_10_Node(int val) {
            this.data = val;
            lt = null;
            rt = null;
        }
    }*/


    /*static int 경로탐색_12_DFS_n;
    static int 경로탐색_12_DFS_m;
    static int 경로탐색_12_DFS_answer;
    static int[][] 경로탐색_12_DFS_graph;
    static int[] 경로탐색_12_DFS_ch;
    public static void main(String[] args) {
        // 입력 예제, 답 6
        // 5 9
        // 1 2
        // 1 3
        // 1 4
        // 2 1
        // 2 3
        // 2 5
        // 3 4
        // 4 2
        // 4 5

        Scanner kb = new Scanner(System.in);
        경로탐색_12_DFS_n = kb.nextInt();
        경로탐색_12_DFS_m = kb.nextInt();
        경로탐색_12_DFS_graph = new int[경로탐색_12_DFS_n + 1][경로탐색_12_DFS_n + 1];
        경로탐색_12_DFS_ch = new int[경로탐색_12_DFS_n + 1];
        for (int i = 0; i < 경로탐색_12_DFS_m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            경로탐색_12_DFS_graph[a][b] = 1;
        }

        경로탐색_12_DFS_ch[1] = 1;
        경로탐색_12_DFS(1);
        System.out.println(경로탐색_12_DFS_answer);
    }

    private static void 경로탐색_12_DFS(int v) {
        if (v == 경로탐색_12_DFS_n) 경로탐색_12_DFS_answer++;
        else {
            for (int i = 1; i <= 경로탐색_12_DFS_n; i++) {
                if (경로탐색_12_DFS_graph[v][i] == 1 && 경로탐색_12_DFS_ch[i] ==0) {
                    경로탐색_12_DFS_ch[i] = 1;
                    경로탐색_12_DFS(i);
                    경로탐색_12_DFS_ch[i] = 0;
                }
            }
        }
    }*/

    /*static int 경로탐색_13_인접리스트_n;
    static int 경로탐색_13_인접리스트_m;
    static int[] 경로탐색_13_인접리스트_ch;
    static int 경로탐색_13_인접리스트_answer;
    static List<List<Integer>> 경로탐색_13_인접리스트_graph;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        경로탐색_13_인접리스트_n = kb.nextInt();
        경로탐색_13_인접리스트_m = kb.nextInt();
        경로탐색_13_인접리스트_graph = new ArrayList<>();
        for (int i = 0; i <= 경로탐색_13_인접리스트_n; i++) {
            경로탐색_13_인접리스트_graph.add(new ArrayList<>());
        }
        경로탐색_13_인접리스트_ch = new int[경로탐색_13_인접리스트_n + 1];
        for (int i = 0; i < 경로탐색_13_인접리스트_m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            경로탐색_13_인접리스트_graph.get(a).add(b);
        }
        경로탐색_13_인접리스트_ch[1] = 1;
        경로탐색_13_인접리스트(1);
        System.out.println(경로탐색_13_인접리스트_answer);
    }

    public static void 경로탐색_13_인접리스트(int v) {
        if (v == 경로탐색_13_인접리스트_n) 경로탐색_13_인접리스트_answer++;
        else {
            for (Integer nv : 경로탐색_13_인접리스트_graph.get(v)) {
                if (경로탐색_13_인접리스트_ch[nv] == 0) {
                    경로탐색_13_인접리스트_ch[nv] = 1;
                    경로탐색_13_인접리스트(nv);
                    경로탐색_13_인접리스트_ch[nv] = 0;
                }
            }
        }
    }*/

    /*static int 그래프_최단거리_BFS_14_n;
    static int 그래프_최단거리_BFS_14_m;
    static int[] 그래프_최단거리_BFS_14_ch;
    static int[] 그래프_최단거리_BFS_14_dis;
    static List<List<Integer>> 그래프_최단거리_BFS_14_graph;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        그래프_최단거리_BFS_14_n = kb.nextInt();
        그래프_최단거리_BFS_14_m = kb.nextInt();
        그래프_최단거리_BFS_14_graph = new ArrayList<>();
        for (int i = 0; i <= 그래프_최단거리_BFS_14_n; i++) {
            그래프_최단거리_BFS_14_graph.add(new ArrayList<>());
        }

        그래프_최단거리_BFS_14_ch = new int[그래프_최단거리_BFS_14_n + 1];
        그래프_최단거리_BFS_14_dis = new int[그래프_최단거리_BFS_14_n + 1];
        for (int i = 0; i < 그래프_최단거리_BFS_14_m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            그래프_최단거리_BFS_14_graph.get(a).add(b);
        }

        그래프_최단거리_BFS_14(1);
        for (int i = 2; i <= 그래프_최단거리_BFS_14_n; i++) {
            System.out.println(i + " : " + 그래프_최단거리_BFS_14_dis[i]);
        }
    }

    public static void 그래프_최단거리_BFS_14(int v) {
        Queue<Integer> queue = new LinkedList<>();
        그래프_최단거리_BFS_14_ch[v] = 1;
        그래프_최단거리_BFS_14_dis[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv : 그래프_최단거리_BFS_14_graph.get(cv)) {
                if (그래프_최단거리_BFS_14_ch[nv] == 0) {
                    그래프_최단거리_BFS_14_ch[nv] = 1;
                    queue.offer(nv);
                    그래프_최단거리_BFS_14_dis[nv] = 그래프_최단거리_BFS_14_dis[cv] + 1;
                }
            }
        }
    }*/

    /*static String 합이_같은_부분집합_DFS_01_answer = "NO";
    static int 합이_같은_부분집합_DFS_01_n = 0;
    static int 합이_같은_부분집합_DFS_01_total = 0;
    static boolean 합이_같은_부분집합_DFS_01_flag = false;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
            합이_같은_부분집합_DFS_01_total += arr[i];
        }

        System.out.print(T.합이_같은_부분집합_DFS_01_me(n, arr));
        T.합이_같은_부분집합_DFS_01(0, 0, arr);
        System.out.print(합이_같은_부분집합_DFS_01_answer);
    }

    private String 합이_같은_부분집합_DFS_01_me(int n,
                                        int[] arr) {
        boolean[] ch = new boolean[n];
        for (int i = 0; i < n; i++) {
            ch[i] = true;
            합이_같은_부분집합_DFS(i + 1, n, ch, arr);
            ch[i] = false;
            if ("YES".equals(합이_같은_부분집합_DFS_01_answer)) {
                return "YES";
            }
        }

        return 합이_같은_부분집합_DFS_01_answer;
    }

    private void 합이_같은_부분집합_DFS(int index,
                                int n,
                                boolean[] ch,
                                int[] arr) {
        if ("YES".equals(합이_같은_부분집합_DFS_01_answer)) return;
        if (index >= n) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < n; i++) {
                int value = arr[i];
                if (ch[i]) {
                    a += value;
                } else {
                    b += value;
                }
            }

            if (a == b) {
                합이_같은_부분집합_DFS_01_answer = "YES";
            }
        } else {
            ch[index] = true;
            합이_같은_부분집합_DFS(index + 1, n, ch, arr);
            ch[index] = false;
            합이_같은_부분집합_DFS(index + 1, n, ch, arr);
        }
    }

    private void 합이_같은_부분집합_DFS_01(int L,
                                   int sum,
                                   int[] arr) {
        if (합이_같은_부분집합_DFS_01_flag) return;
        if (sum > 합이_같은_부분집합_DFS_01_total / 2) return;
        if (L == 합이_같은_부분집합_DFS_01_n) {
            if ((합이_같은_부분집합_DFS_01_total - sum) == sum) {
                합이_같은_부분집합_DFS_01_answer = "YES";
                합이_같은_부분집합_DFS_01_flag = true;
            }
        } else {
            합이_같은_부분집합_DFS_01(L + 1, sum + arr[L], arr);
            합이_같은_부분집합_DFS_01(L + 1, sum, arr);
        }
    }*/

    /*static int 바둑이_승차_DFS_02_total = 0;
    static int 바둑이_승차_DFS_02_answer = Integer.MIN_VALUE;
    static int 바둑이_승차_DFS_02_c;
    static int 바둑이_승차_DFS_02_n;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int w = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.바둑이_승차_DFS_02_me(w, n, arr));
        T.바둑이_승차_DFS_02(w, n, arr);
        System.out.print(바둑이_승차_DFS_02_answer);
    }

    private int 바둑이_승차_DFS_02_me(int w,
                                 int n,
                                 int[] arr) {
        바둑이_승차_DFS_02_DFS(0, 0, arr, w);
        return 바둑이_승차_DFS_02_total;
    }

    private void 바둑이_승차_DFS_02_DFS(int index,
                                   int sum,
                                   int[] arr,
                                   int w) {
        if (sum > w) return;
        if (index == arr.length) {
            if (바둑이_승차_DFS_02_total < sum) {
                바둑이_승차_DFS_02_total = sum;
            }
        } else {
            바둑이_승차_DFS_02_DFS(index + 1, sum + arr[index], arr, w);
            바둑이_승차_DFS_02_DFS(index + 1, sum, arr, w);
        }
    }

    private void 바둑이_승차_DFS_02(int L,
                               int sum,
                               int[] arr) {
        if (sum > 바둑이_승차_DFS_02_c) return;
        if (L == 바둑이_승차_DFS_02_n) {
            바둑이_승차_DFS_02_answer = Math.max(바둑이_승차_DFS_02_answer, sum);
        } else {
            바둑이_승차_DFS_02(L + 1, sum + arr[L], arr);
            바둑이_승차_DFS_02(L + 1, sum, arr);
        }
    }*/

    /*static int 최대점수_구하기_03_answer = 0;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[n][2];
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
            a[i] = arr[i][0];
            b[i] = arr[i][1];
        }

        T.최대점수_구하기_03_me_DFS(0, 0, 0, m, arr);
//        T.최대점수_구하기_03_DFS(0, 0, 0, a, b, n, m);
        System.out.print(최대점수_구하기_03_answer);
    }


    private void 최대점수_구하기_03_me_DFS(int index,
                             int sum,
                             int limit,
                             int m,
                             int[][] arr) {
        if (limit > m) {
            return;
        }
        if (index == arr.length) {
            최대점수_구하기_03_answer = Math.max(최대점수_구하기_03_answer, sum);
            return;
        }

        최대점수_구하기_03_me_DFS(index + 1, sum + arr[index][0], limit + arr[index][1], m, arr);
        최대점수_구하기_03_me_DFS(index + 1, sum, limit, m, arr);
    }

    boolean 최대점수_구하기_03_flag = false;
    public void 최대점수_구하기_03_DFS(int L,
                                int sum,
                                int time,
                                int[] ps,
                                int[] pt,
                                int n,
                                int m) {
        if (time > m) {
            return;
        }
        if (L == n) {
            최대점수_구하기_03_answer = Math.max(최대점수_구하기_03_answer, sum);
        } else {
            최대점수_구하기_03_DFS(L + 1, sum + ps[L], time + pt[L], ps, pt, n, m);
            최대점수_구하기_03_DFS(L + 1, sum, time, ps, pt, n, m);
        }
    }*/

    /*static int[] 중복순열_구하기_04_pm;
    static int 중복순열_구하기_04_n;
    static int 중복순열_구하기_04_m;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        중복순열_구하기_04_n = kb.nextInt();
        중복순열_구하기_04_m = kb.nextInt();
        중복순열_구하기_04_pm = new int[중복순열_구하기_04_m];
        T.중복순열_구하기_04_DFS(0);
    }


    private void 중복순열_구하기_04_DFS(int L) {
        if (L == 중복순열_구하기_04_m) {
            for (int x : 중복순열_구하기_04_pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= 중복순열_구하기_04_n; i++) {
                중복순열_구하기_04_pm[L] = i;
                중복순열_구하기_04_DFS(L + 1);
            }
        }
    }*/

    /*static int 동전교환_05_min_count = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int m = kb.nextInt();

        //동전교환_05_me_DFS(0, 0, 0, 0, n, arr, m);
        동전교환_05_DFS(0, 0, n, arr, m);
        System.out.println(동전교환_05_min_count);
    }

    private static void 동전교환_05_me_DFS(int index,
                                       int callCount,
                                       int count,
                                       int sum,
                                       int n,
                                       Integer[] arr,
                                       int m) {
        if (callCount > m || sum > m) return;
        if (sum == m) {
            동전교환_05_min_count = Math.min(동전교환_05_min_count, count);
        } else {
            for (int i = index; i < n; i++) {
                int sumsum = sum + arr[i];
                int callcall = callCount + 1;
                int countcount = count + 1;
                if (sumsum > m || callcall > m || countcount > 동전교환_05_min_count) break;
                동전교환_05_me_DFS(i, callcall, countcount, sumsum, n, arr, m);
            }
        }
    }

    private static void 동전교환_05_DFS(int L,
                                    int sum,
                                    int n,
                                    Integer[] arr,
                                    int m) {
        if (sum > m) return;
        if (L >= 동전교환_05_min_count) return;
        if (sum == m) {
            동전교환_05_min_count = Math.min(동전교환_05_min_count, L);
        } else {
            for (int i = 0; i < n; i++) {
                동전교환_05_DFS(L + 1, sum + arr[i], n, arr, m);
            }
        }
    }*/

    /*static int[] 순열_구하기_06_pm;
    static int[] 순열_구하기_06_ch;
    static int[] 순열_구하기_06_arr;
    static int 순열_구하기_06_n;
    static int 순열_구하기_06_m;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        순열_구하기_06_n = kb.nextInt();
        순열_구하기_06_m = kb.nextInt();
        순열_구하기_06_arr = new int[순열_구하기_06_n];
        for (int i = 0; i < 순열_구하기_06_n; i++) {
            순열_구하기_06_arr[i] = kb.nextInt();
        }
        순열_구하기_06_ch = new int[순열_구하기_06_n];
        순열_구하기_06_pm = new int[순열_구하기_06_m];

        순열_구하기_06_DFS(0);
    }

    public static void 순열_구하기_06_DFS(int L) {
        if (L == 순열_구하기_06_m) {
            for (int x : 순열_구하기_06_pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < 순열_구하기_06_n; i++) {
                if (순열_구하기_06_ch[i] == 0) {
                    순열_구하기_06_ch[i] = 1;
                    순열_구하기_06_pm[L] = 순열_구하기_06_arr[i];
                    순열_구하기_06_DFS(L + 1);
                    순열_구하기_06_ch[i] = 0;
                }
            }
        }
    }*/

    /*static int[][] 조합의_경우수_07_dy = new int[35][35];
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();

//        System.out.println(조합의_경우수_07_DFS_1(n, r));
        System.out.println(조합의_경우수_07_DFS_2(n, r));
    }

    private static int 조합의_경우수_07_DFS_1(int n,
                                        int r) {
        if (n == r || r == 0) return 1;
        return 조합의_경우수_07_DFS_1(n - 1, r - 1) + 조합의_경우수_07_DFS_1(n - 1, r);
    }

    private static int 조합의_경우수_07_DFS_2(int n,
                                        int r) {
        if (조합의_경우수_07_dy[n][r] > 0) return 조합의_경우수_07_dy[n][r];
        if (n == r || r == 0) return 1;
        else return 조합의_경우수_07_dy[n][r] = 조합의_경우수_07_DFS_2(n - 1, r - 1) + 조합의_경우수_07_DFS_2(n - 1, r);
    }*/


    /*static boolean 수열_추측하기_08_me_flag = false;
    static int[] 수열_추측하기_08_b;
    static int[] 수열_추측하기_08_p;
    static int[] 수열_추측하기_08_ch;
    static int 수열_추측하기_08_n;
    static int 수열_추측하기_08_f;
    static boolean 수열_추측하기_08_flag = false;
    static int[][] 수열_추측하기_08_dy = new int[35][35];
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int f = kb.nextInt();

        int[] answer = new int[n];
        boolean[] ch = new boolean[n];

//        수열_추측하기_08_DFS_me(0, answer, ch, n, f);
//        for (int i : answer) {
//            System.out.print(i + " ");
//        }

        수열_추측하기_08_n = n;
        수열_추측하기_08_f = f;
        수열_추측하기_08_b = new int[n];
        수열_추측하기_08_p = new int[n];
        수열_추측하기_08_ch = new int[n + 1];
        for (int i = 0; i < n; i++) {
            수열_추측하기_08_b[i] = 수열_추측하기_08_combi(n - 1, i);
        }

        수열_추측하기_08_DFS(0, 0);
    }

    private static void 수열_추측하기_08_DFS_me(int L,
                                          int[] answer,
                                          boolean[] ch,
                                          int n,
                                          int f) {
        if (수열_추측하기_08_me_flag) return;
        if (L == n) {
            if (수열_추측하기_08_DFS_me_calcSum(answer) == f) {
                수열_추측하기_08_me_flag = true;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (수열_추측하기_08_me_flag) break;
                if (ch[i] == false) {
                    ch[i] = true;
                    answer[L] = i + 1;
                    수열_추측하기_08_DFS_me(L + 1, answer, ch, n, f);
                    ch[i] = false;
                }
            }
        }
    }

    private static int 수열_추측하기_08_DFS_me_calcSum(int[] answer) {
        Queue<Integer> que = new LinkedList<>();
        for (int i : answer) {
            que.add(i);
        }

        while (que.size() > 1) {
            int preNumber = 0;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Integer number = que.poll();
                if (preNumber > 0) {
                    que.add(preNumber + number);
                }
                preNumber = number;
            }
        }

        return que.poll();
    }

    public static int 수열_추측하기_08_combi(int n,
                                       int r) {
        if (수열_추측하기_08_dy[n][r] > 0) return 수열_추측하기_08_dy[n][r];
        if (n == r || r == 0) return 1;
        return 수열_추측하기_08_dy[n][r] = 수열_추측하기_08_combi(n - 1, r - 1) + 수열_추측하기_08_combi(n - 1, r);
    }

    public static void 수열_추측하기_08_DFS(int L,
                                      int sum) {
        if (L == 수열_추측하기_08_n) {
            if (수열_추측하기_08_flag) return;
            if (sum == 수열_추측하기_08_f) {
                for (int x : 수열_추측하기_08_p) System.out.print(x + " ");
                수열_추측하기_08_flag = true;
            }
        } else {
            for (int i = 1; i <= 수열_추측하기_08_n; i++) {
                if (수열_추측하기_08_ch[i] == 0) {
                    수열_추측하기_08_ch[i] = 1;
                    수열_추측하기_08_p[L] = i;
                    수열_추측하기_08_DFS(L + 1, sum + (수열_추측하기_08_p[L] * 수열_추측하기_08_b[L]));
                    수열_추측하기_08_ch[i] = 0;
                }
            }
        }
    }*/

    /*static int[] 조합_구하기_09_combi;
    static int 조합_구하기_09_n;
    static int 조합_구하기_09_m;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        조합_구하기_09_n = kb.nextInt();
        조합_구하기_09_m = kb.nextInt();
        조합_구하기_09_combi = new int[조합_구하기_09_m];

        조합_구하기_09_DFS(0, 1);
    }

    public static void 조합_구하기_09_DFS(int L, int s) {
        if (L == 조합_구하기_09_m) {
            for (int i : 조합_구하기_09_combi) System.out.print(i + " ");
            System.out.println();
        } else {
            for (int i = s; i <= 조합_구하기_09_n; i++) {
                조합_구하기_09_combi[L] = i;
                조합_구하기_09_DFS(L + 1, i + 1);
            }
        }
    }*/

    /*static int 미로탐색_me_answer = 0;
    static int 미로탐색_answer = 0;
    static int[] 미로탐색_dx = {-1, 0, 1, 0};
    static int[] 미로탐색_dy = {0, 1, 0, -1};
    static int[][] 미로탐색_board;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int length = 7;
        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        int[] dh = {-1, 0, 1, 0};
        int[] dw = {0, 1, 0, -1};

        미로탐색_me(0, 0, arr, dh, dw);
        System.out.println(미로탐색_me_answer);

        // 강사님
        미로탐색_board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                미로탐색_board[i][j] = arr[i - 1][j - 1];
            }
        }
        미로탐색_board[1][1] = 1;
        미로탐색_DFS(1, 1);
        System.out.println(미로탐색_answer);

    }

    private static void 미로탐색_me(int h,
                                int w,
                                int[][] arr,
                                int[] dh,
                                int[] dw) {
        if (h == arr.length - 1 && w == arr[0].length - 1) {
            미로탐색_me_answer++;
            return;
        }

        if (arr[h][w] == 1) return;
        arr[h][w] = 1;
        for (int i = 0; i < dh.length; i++) {
            int dhVal = h + dh[i];
            int dwVal = w + dw[i];
            if (!미로탐색_me_isValid(dhVal, dwVal, arr)) {
                continue;
            }

            미로탐색_me(dhVal, dwVal, arr, dh, dw);
        }
        arr[h][w] = 0;
    }

    private static boolean 미로탐색_me_isValid(int dhVal,
                                           int dwVal,
                                           int[][] arr) {
        return (!(dhVal < 0) && dhVal < arr.length)
        && (!(dwVal < 0) && dwVal < arr[0].length);
    }

    private static void 미로탐색_DFS(int x, int y) {
        if (x == 7 && y == 7) {
            미로탐색_answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + 미로탐색_dx[i];
                int ny = y + 미로탐색_dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && 미로탐색_board[nx][ny] == 0) {
                    미로탐색_board[nx][ny] = 1;
                    미로탐색_DFS(nx, ny);
                    미로탐색_board[nx][ny] = 0;
                }
            }
        }
    }*/

    /*static int 미로탐색_11_answer = 1;
    static int[] 미로탐색_11_dx = {-1, 0, 1, 0};
    static int[] 미로탐색_11_dy = {0, 1, 0, -1};
    static int[][] 미로탐색_11_board;
    static int[][] 미로탐색_11_l_board = new int[8][8];;
    static int[][] 미로탐색_11_dis = new int[8][8];;
    static boolean 미로탐색_11_flag;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int length = 7;
        미로탐색_11_board = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                미로탐색_11_board[i][j] = 미로탐색_11_board[i][j] = kb.nextInt();
                미로탐색_11_l_board[i + 1][j + 1] = 미로탐색_11_board[i][j];
            }
        }
        미로탐색_11_BFS_me(0, 0);
        System.out.println(미로탐색_11_answer);

        // 강사님
        미로탐색_11_BFS(1, 1);
        if (미로탐색_11_dis[7][7] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(미로탐색_11_dis[7][7]);
        }
    }

    private static void 미로탐색_11_BFS_me(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {x, y});

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] poll = que.poll();
                미로탐색_11_board[poll[0]][poll[1]] = 1;

                for (int j = 0; j < 4; j++) {
                    int dx = poll[0] + 미로탐색_11_dx[j];
                    int dy = poll[1] + 미로탐색_11_dy[j];
                    if (dx >= 0 && dx < 7 && dy >= 0 && dy < 7 && 미로탐색_11_board[dx][dy] == 0) {
                        if (dx == 6 && dy == 6) {
                            미로탐색_11_flag = true;
                            break;
                        }
                        que.add(new int[] {dx,dy});
                    }
                }
                if (미로탐색_11_flag) break;
            }
            if (미로탐색_11_flag) break;
            미로탐색_11_answer++;
        }

        if (!미로탐색_11_flag) 미로탐색_11_answer = -1;
    }

    private static void 미로탐색_11_BFS(int x, int y) {
        Queue<미로탐색_11_Point> Q = new LinkedList<>();
        Q.offer(new 미로탐색_11_Point(x, y));
        미로탐색_11_l_board[x][y] = 1;

        while (!Q.isEmpty()) {
            미로탐색_11_Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + 미로탐색_11_dx[i];
                int ny = tmp.y + 미로탐색_11_dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && 미로탐색_11_l_board[nx][ny] == 0) {
                    미로탐색_11_l_board[nx][ny] = 1;
                    Q.offer(new 미로탐색_11_Point(nx, ny));
                    미로탐색_11_dis[nx][ny] = 미로탐색_11_dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    static class 미로탐색_11_Point {
        public int x, y;

        미로탐색_11_Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }*/

    /*static int 토마토_12_me_answer = 0;
    static int 토마토_12_me_count = 0;
    static int[] 토마토_12_dx = {-1, 0, 1, 0};
    static int[] 토마토_12_dy = {0, 1, 0, -1};
    static int[][] 토마토_12_board;
    static int[][] 토마토_12_dis;
    static Queue<토마토_12_Point> 토마토_12_Q = new LinkedList<>();
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int m = kb.nextInt();
        int n = kb.nextInt();
        int[][] arr = new int[n][m];
        토마토_12_board = new int[n][m];
        토마토_12_dis = new int[n][m];
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = kb.nextInt();
                토마토_12_board[i][j] = arr[i][j];
                if (arr[i][j] == 0) 토마토_12_me_count++;
                if (arr[i][j] == 1) {
                    que.add(new int[] {i, j});
                    토마토_12_Q.add(new 토마토_12_Point(i, j));
                }
            }
        }

        토마토_12_BFS_me(que, arr, m, n);
        System.out.println(토마토_12_me_answer);

        // 강사님
        토마토_12_BFS(m, n);
        boolean flag = true;
        int 토마토_12_answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (토마토_12_board[i][j] == 0) flag = false;
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    토마토_12_answer = Math.max(토마토_12_answer, 토마토_12_dis[i][j]);
                }
            }
            System.out.println(토마토_12_answer);
        } else {
            System.out.println(-1);
        }
    }

    private static void 토마토_12_BFS_me(Queue<int[]> que,
                                      int[][] arr,
                                      int m,
                                      int n) {
        boolean isEnd = false;
        while (!que.isEmpty() && !isEnd) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] poll = que.poll();
                for (int j = 0; j < 4; j++) {
                    int dx = poll[0] + 토마토_12_dx[j];
                    int dy = poll[1] + 토마토_12_dy[j];
                    if (dx >= 0 && dx < n && dy >= 0 && dy < m && arr[dx][dy] == 0) {
                        arr[dx][dy] = 1;
                        que.add(new int[]{dx, dy});
                        토마토_12_me_count--;

                        if (토마토_12_me_count == 0) {
                            isEnd = true;
                            break;
                        }
                    }
                    if (isEnd) break;
                }
            }
            토마토_12_me_answer++;
        }

        if (토마토_12_me_count > 0) 토마토_12_me_answer = -1;
    }

    private static void 토마토_12_BFS(int m,
                                   int n) {
        while (!토마토_12_Q.isEmpty()) {
            토마토_12_Point tmp = 토마토_12_Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + 토마토_12_dx[i];
                int ny = tmp.y + 토마토_12_dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && 토마토_12_board[nx][ny] == 0) {
                    토마토_12_board[nx][ny] = 1;
                    토마토_12_Q.offer(new 토마토_12_Point(nx, ny));
                    토마토_12_dis[nx][ny] = 토마토_12_dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    static class 토마토_12_Point {
        public int x, y;

        토마토_12_Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }*/

    /*static int 섬나라_아일랜드_13_answer = 0;
    static int 섬나라_아일랜드_13_n;

    static int[] 섬나라_아일랜드_13_dx = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] 섬나라_아일랜드_13_dy = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        섬나라_아일랜드_13_n = n;
        int[][] ch = new int[n][n];
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
                if (arr[i][j] == 1) {
                    ch[i][j] = 1;
                }
            }
        }

        int answer_me = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 || ch[i][j] == 0) continue;
                ch[i][j] = 0;
                answer_me++;
                섬나라_아일랜드_13_DFS_me(i, j, n, arr, ch);
            }
        }
        System.out.println(answer_me);

        // 강사님
        섬나라_아일랜드_13_solution(arr);
        System.out.println(섬나라_아일랜드_13_answer);

    }

    static void 섬나라_아일랜드_13_solution(int[][] board) {
        for (int i = 0; i < 섬나라_아일랜드_13_n; i++) {
            for (int j = 0; j < 섬나라_아일랜드_13_n; j++) {
                if (board[i][j] == 1) {
                    섬나라_아일랜드_13_answer++;
                    board[i][j] = 0;
                    섬나라_아일랜드_13_DFS(i, j, board);
                }
            }
        }
    }

    private static void 섬나라_아일랜드_13_DFS_me(int w,
                                           int h,
                                           int n,
                                           int[][] arr,
                                           int[][] ch) {
        for (int i = 0; i < 8; i++) {
            int nw = w + 섬나라_아일랜드_13_dx[i];
            int nh = h + 섬나라_아일랜드_13_dy[i];
            if (nw >= 0 && nw < n && nh >= 0 && nh < n) {
                if (arr[nw][nh] == 1 && ch[nw][nh] == 1) {
                    ch[nw][nh] = 0;
                    섬나라_아일랜드_13_DFS_me(nw, nh, n, arr, ch);
                }
            }
        }
    }

    private static void 섬나라_아일랜드_13_DFS(int x,
                                        int y,
                                        int[][] board) {
        for (int i = 0; i < 8; i++) {
            int nx = x + 섬나라_아일랜드_13_dx[i];
            int ny = y + 섬나라_아일랜드_13_dy[i];

            if (nx >= 0 && nx < 섬나라_아일랜드_13_n && ny >= 0 && ny < 섬나라_아일랜드_13_n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                섬나라_아일랜드_13_DFS(nx, ny, board);
            }
        }
    }*/

    /*static int 섬나라_아일랜드_13_DFS_answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        피자_배달_거리_DFS_14_n = kb.nextInt();
        피자_배달_거리_DFS_14_m = kb.nextInt();
        피자_배달_거리_DFS_14_pz = new ArrayList<>();
        피자_배달_거리_DFS_14_hs = new ArrayList<>();

        for (int i = 0; i < 피자_배달_거리_DFS_14_n; i++) {
            for (int j = 0; j < 피자_배달_거리_DFS_14_n; j++) {
                int tmp = kb.nextInt();
                if (tmp == 1) {
                    피자_배달_거리_DFS_14_hs.add(new 피자_배달_거리_DFS_14_Point(i, j));
                } else if (tmp == 2) {
                    피자_배달_거리_DFS_14_pz.add(new 피자_배달_거리_DFS_14_Point(i, j));

                }
            }
        }
        피자_배달_거리_DFS_14_len = 피자_배달_거리_DFS_14_pz.size();
        피자_배달_거리_DFS_14_combi = new int[피자_배달_거리_DFS_14_m];
        피자_배달_거리_DFS_14(0, 0);
        System.out.println(피자_배달_거리_DFS_14_answer);
    }

    static int 피자_배달_거리_DFS_14_n;
    static int 피자_배달_거리_DFS_14_m;
    static int 피자_배달_거리_DFS_14_len;
    static int 피자_배달_거리_DFS_14_answer = Integer.MAX_VALUE;
    static int[] 피자_배달_거리_DFS_14_combi;
    static List<피자_배달_거리_DFS_14_Point> 피자_배달_거리_DFS_14_pz;
    static List<피자_배달_거리_DFS_14_Point> 피자_배달_거리_DFS_14_hs;

    private static void 피자_배달_거리_DFS_14(int L,
                                        int s) {
        if (L == 피자_배달_거리_DFS_14_m) {
            int sum = 0;
            for (피자_배달_거리_DFS_14_Point h : 피자_배달_거리_DFS_14_hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : 피자_배달_거리_DFS_14_combi) {
                    dis = Math.min(dis, Math.abs(h.x - 피자_배달_거리_DFS_14_pz.get(i).x) + Math.abs(h.y - 피자_배달_거리_DFS_14_pz.get(i).y));
                }

                sum += dis;
            }
            피자_배달_거리_DFS_14_answer = Math.min(피자_배달_거리_DFS_14_answer, sum);
        } else {
            for (int i = s; i < 피자_배달_거리_DFS_14_len; i++) {
                피자_배달_거리_DFS_14_combi[L] = i;
                피자_배달_거리_DFS_14(L + 1, i + 1);
            }
        }
    }

    static class 피자_배달_거리_DFS_14_Point {
        public int x, y;
        피자_배달_거리_DFS_14_Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        // 내 풀이
//        int[][] arr = new int[n][2];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = kb.nextInt();
//            }
//        }
//        System.out.println(씨름선수_01_my(n, arr));

        // 강사님 풀이
        List<씨름선수_01_Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = kb.nextInt();
            int w = kb.nextInt();
            arr.add(new 씨름선수_01_Body(h, w));
        }
        System.out.println(씨름선수_씨름선수_01_lecturer(arr, n));
    }

    private static int 씨름선수_01_my(int n,
                                  int[][] arr) {
        int answer = n;
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < arr.length; i++) {
            int targetH = arr[i][0];
            int targetW = arr[i][1];
            for (int j = i + 1; j < arr.length; j++) {
                int compareH = arr[j][0];
                int compareW = arr[j][1];

                if (targetH == compareH) continue;
                if (targetW < compareW) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }

    private static int 씨름선수_씨름선수_01_lecturer(List<씨름선수_01_Body> arr,
                                                 int n) {
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;

        for (씨름선수_01_Body ob : arr) {
            if (ob.w > max) {
                max = ob.w;
                cnt++;
            }
        }

        return cnt;
    }

    static class 씨름선수_01_Body implements Comparable<씨름선수_01_Body> {
        public int h, w;
        public 씨름선수_01_Body(int h, int w) {
            this.h = h;
            this.w = w;
        }
        @Override
        public int compareTo(씨름선수_01_Body o) {
            return o.h - this.h;
        }
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<회의실_배정_02_meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add( new 회의실_배정_02_meeting(kb.nextInt(), kb.nextInt()));
        }

        // 내 풀이
        System.out.println(회의실_배정_02_my(n, list));

        // 강사님 풀이
        System.out.println(회의실_배정_02_lecturer(list, n));
    }

    private static int 회의실_배정_02_my(int n,
                                    List<회의실_배정_02_meeting> list) {
        Collections.sort(list);
        int answer = 1;

        회의실_배정_02_meeting target = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            회의실_배정_02_meeting compare = list.get(i);
            if (target.endTime > compare.startTime) {
                continue;
            }

            target = compare;
            answer++;
        }

        return answer;
    }

    static class 회의실_배정_02_meeting implements Comparable<회의실_배정_02_meeting> {
        int startTime;
        int endTime;
        public 회의실_배정_02_meeting(int startTime,
                                 int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(회의실_배정_02_meeting o) {
            if (this.endTime == o.endTime) {
                return this.startTime - o.startTime;
            }

            return this.endTime - o.endTime;
        }
    }

    private static int 회의실_배정_02_lecturer(List<회의실_배정_02_meeting> arr,
                                          int n) {
        int cnt = 0;
        Collections.sort(arr);

        int et = 0;
        for (회의실_배정_02_meeting ob : arr) {
            if (ob.startTime >= et) {
                cnt++;
                et = ob.endTime;
            }
        }

        return cnt;
    }*/

    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<결혼식_03_time> list = new ArrayList<>();
        List<결혼식_03_time_lec> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add( new 결혼식_03_time(kb.nextInt(), kb.nextInt()));
            arr.add(new 결혼식_03_time_lec(list.get(i).s, 's'));
            arr.add(new 결혼식_03_time_lec(list.get(i).e, 'e'));
        }

        // 내 풀이
        System.out.println(결혼식_03_my(n, list));

        // 강사님 풀이
        System.out.println(결혼식_03_lecturer(arr));
    }

    private static int 결혼식_03_my(int n, List<결혼식_03_time> list) {
        Collections.sort(list);
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (결혼식_03_time obj : list) {
            while (!pq.isEmpty() && pq.peek() <= obj.s) {
                pq.poll();
            }

            pq.add(obj.e);
            answer = Math.max(answer, pq.size());
        }

        return answer;
    }

    private static int 결혼식_03_lecturer(List<결혼식_03_time_lec> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);

        int cnt = 0;
        for (결혼식_03_time_lec ob : arr) {
            if (ob.state == 's') {
                cnt++;
            } else {
                cnt--;
            }

            answer = Math.max(answer, cnt);
        }


        return answer;
    }

    static class 결혼식_03_time implements Comparable<결혼식_03_time> {
        int s;
        int e;

        public 결혼식_03_time(int s,
                           int e) {
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(결혼식_03_time o) {
            if (this.s == o.s) {
                return this.e - o.e;
            }

            return this.s - o.s;
        }
    }

    static class 결혼식_03_time_lec implements Comparable<결혼식_03_time_lec> {
        int time;
        int char state;

        public 결혼식_03_time_lec(int time,
                           char state) {
            this.time = time;
            this.state = state;
        }
        @Override
        public int compareTo(결혼식_03_time_lec ob) {
            if (this.time == ob.time) {
                return this.state - ob.state;
            }

            return this.time - ob.time;
        }
    }*/


    /*public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int max = 0;
        List<최대_수입_스케쥴_04_Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = kb.nextInt();
            int day = kb.nextInt();
            arr.add( new 최대_수입_스케쥴_04_Lecture(money, day));
            if (day > max) max = day;
        }

        // 내 풀이
        System.out.println(최대_수입_스케쥴_04_my(n, max, arr));

        // 강사님 풀이
        //System.out.println(결혼식_03_lecturer(n, max, arr));
    }

    private static int 최대_수입_스케쥴_04_my(int n,
                                       int max,
                                       List<최대_수입_스케쥴_04_Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        Collections.sort(arr);


        int j = 0;
        for (int i = max; i > 0; i--) {
            for (; j < n; j++) {
                if (arr.get(j).time < i) break;
                pQ.offer(arr.get(j).money);
            }

            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }

        return answer;
    }

    private static int 결혼식_03_lecturer(int n,
                                       int max,
                                       List<최대_수입_스케쥴_04_Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        Collections.sort(arr);

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr.get(j).time < i) break;
                pQ.offer(arr.get(j).money);
            }

            if (!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }



    static class 최대_수입_스케쥴_04_Lecture implements Comparable<최대_수입_스케쥴_04_Lecture> {
        private int money;
        private int time;
        public 최대_수입_스케쥴_04_Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }
        @Override
        public int compareTo(최대_수입_스케쥴_04_Lecture o) {
            return o.time - this.time;
        }
    }*/

    /*static int 다익스트라_알고리즘_05_n;
    static int 다익스트라_알고리즘_05_m;
    static ArrayList<ArrayList<다익스트라_알고리즘_05_Edge>> 다익스트라_알고리즘_05_graph;
    static int[] 다익스트라_알고리즘_05_dis;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        다익스트라_알고리즘_05_n = kb.nextInt();
        다익스트라_알고리즘_05_m = kb.nextInt();

        *//**
     * 그래프 -> 다익스트라 알고리즘 적용시 전제 조건
     * - 그래프 간선의 가중치 값이 모두 양수여야 한다 (0도 가능)
     *//*
        // 강사님 풀이 - 채점 지원 X
        다익스트라_알고리즘_05_graph = new ArrayList<ArrayList<다익스트라_알고리즘_05_Edge>>();
        for(int i=0; i<=다익스트라_알고리즘_05_n; i++){
            다익스트라_알고리즘_05_graph.add(new ArrayList<다익스트라_알고리즘_05_Edge>());
        }
        다익스트라_알고리즘_05_dis=new int[다익스트라_알고리즘_05_n+1];
        Arrays.fill(다익스트라_알고리즘_05_dis, Integer.MAX_VALUE);
        for(int i=0; i<다익스트라_알고리즘_05_m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            다익스트라_알고리즘_05_graph.get(a).add(new 다익스트라_알고리즘_05_Edge(b, c));
        }
        T.다익스트라_알고리즘_05(1);
        for(int i=2; i<=다익스트라_알고리즘_05_n; i++){
            if(다익스트라_알고리즘_05_dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+다익스트라_알고리즘_05_dis[i]);
            else System.out.println(i+" : impossible");
        }
    }

    public void 다익스트라_알고리즘_05(int v){
        PriorityQueue<다익스트라_알고리즘_05_Edge> pQ = new PriorityQueue<>();
        pQ.offer(new 다익스트라_알고리즘_05_Edge(v, 0));
        다익스트라_알고리즘_05_dis[v]=0;
        while(!pQ.isEmpty()){
            다익스트라_알고리즘_05_Edge tmp=pQ.poll();
            int now=tmp.vex;
            int nowCost=tmp.cost;
            if(nowCost>다익스트라_알고리즘_05_dis[now]) continue;
            for(다익스트라_알고리즘_05_Edge ob : 다익스트라_알고리즘_05_graph.get(now)){
                if(다익스트라_알고리즘_05_dis[ob.vex]>nowCost+ob.cost){
                    다익스트라_알고리즘_05_dis[ob.vex]=nowCost+ob.cost;
                    pQ.offer(new 다익스트라_알고리즘_05_Edge(ob.vex, nowCost+ob.cost));
                }
            }
        }
    }

    static class 다익스트라_알고리즘_05_Edge implements Comparable<다익스트라_알고리즘_05_Edge>{
        public int vex;
        public int cost;
        다익스트라_알고리즘_05_Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(다익스트라_알고리즘_05_Edge ob){
            return this.cost-ob.cost;
        }
    }*/

    /*public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        List<List<Integer>> list = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int f1 = kb.nextInt();
            int f2 = kb.nextInt();
            list.get(f1).add(f2);
        }

        int f1 = kb.nextInt();
        int f2 = kb.nextInt();

        // 내 풀이
//        System.out.println(친구인가_06_my(n, m, list, f1, f2));
        System.out.println(친구인가_06_my_refactoring(n, m, list, f1, f2));

        // 강사님 풀이
    }

    private static String 친구인가_06_my_refactoring(int n,
                                                 int m,
                                                 List<List<Integer>> list,
                                                 int f1,
                                                 int f2) {
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int i = 1; i <= n; i++) {
            for (int friend : list.get(i)) {
                친구인가_06_my_refactoring_union(i, friend, parent);
            }
        }

        return 친구인가_06_my_refactoring_find(f1, parent) == 친구인가_06_my_refactoring_find(f2, parent) ? "YES" : "NO";
    }
    private static void 친구인가_06_my_refactoring_union(int i,
                                                     Integer friend,
                                                     int[] parent) {
        int pa = 친구인가_06_my_refactoring_find(i, parent);
        int pb = 친구인가_06_my_refactoring_find(friend, parent);
        if (pa != pb) parent[pb] = pa;
    }

    private static int 친구인가_06_my_refactoring_find(int i,
                                                   int[] parent) {
        if (parent[i] != i) {
            parent[i] = 친구인가_06_my_refactoring_find(parent[i], parent);
        }
        return parent[i];
    }


    private static String 친구인가_06_my(int n,
                                     int m,
                                     List<List<Integer>> list,
                                     int f1,
                                     int f2) {
        List<Set<Integer>> fGrouping = new ArrayList<>();
        int j = 0;
        boolean[] ch = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
            fGrouping.add(new HashSet<>());

            while (!q.isEmpty()) {
                Integer sFriend = q.poll();
                Set<Integer> friends = fGrouping.get(j);
                if (friends.contains(sFriend)) continue;
                friends.add(sFriend);
                ch[sFriend] = true;
                for (Integer friend : list.get(sFriend)) {
                    q.offer(friend);
                }
            }

            j++;
        }

        for (Set<Integer> friends : fGrouping) {
            if (friends.contains(f1) && friends.contains(f2)) {
                return "YES";
            }
        }

        return "NO";
    }*/

    /*public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 도시 개수
        int m = kb.nextInt(); // 도로 개수

        int[] unf = new int[n + 1];
        List<원더랜드_최소스패닝트리_07_Edge> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new 원더랜드_최소스패닝트리_07_Edge(a, b, c));
        }

        // 내 풀이
        System.out.println(원더랜드_최소스패닝트리_07(unf, arr));

        // 강사님 풀이
        int answer = 0;
        Collections.sort(arr);
        for (원더랜드_최소스패닝트리_07_Edge ob : arr) {
            int v1 = ob.v1;
            int v2 = ob.v2;

            int fv1 = 원더랜드_최소스패닝트리_07_Find(v1, unf);
            int fv2 = 원더랜드_최소스패닝트리_07_Find(v2, unf);
            if (fv1 != fv2) {
                answer += ob.cost;
                원더랜드_최소스패닝트리_07_Union(v1, v2, unf);
            }
        }
        System.out.println(answer);
    }

    private static void 원더랜드_최소스패닝트리_07_Union(int v1, int v2, int[] unf) {
        int fa = 원더랜드_최소스패닝트리_07_Find(v1, unf);
        int fb = 원더랜드_최소스패닝트리_07_Find(v2, unf);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    private static int 원더랜드_최소스패닝트리_07_Find(int v, int[] unf) {
        if (v == unf[v]) return v;
        unf[v] = 원더랜드_최소스패닝트리_07_Find(unf[v], unf);
        return unf[v];
    }

    private static int 원더랜드_최소스패닝트리_07(int[] unf, List<원더랜드_최소스패닝트리_07_Edge> arr) {
        Collections.sort(arr);
        int sum = 0;

        for (원더랜드_최소스패닝트리_07_Edge edge : arr) {
            int v1 = edge.v1;
            int v2 = edge.v2;

            int fv1 = 원더랜드_최소스패닝트리_07_find_my(v1, unf);
            int fv2 = 원더랜드_최소스패닝트리_07_find_my(v2, unf);
            if (fv1 != fv2) {
                sum += edge.cost;
                원더랜드_최소스패닝트리_07_union_my(fv1, fv2, unf);
            }
        }

        return sum;
    }

    private static void 원더랜드_최소스패닝트리_07_union_my(int fv1, int fv2, int[] unf) {
        int fa = 원더랜드_최소스패닝트리_07_find_my(fv1, unf);
        int fb = 원더랜드_최소스패닝트리_07_find_my(fv2, unf);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    private static int 원더랜드_최소스패닝트리_07_find_my(int v, int[] unf) {
        if (v == unf[v]) return v;
        unf[v] = 원더랜드_최소스패닝트리_07_find_my(unf[v], unf);
        return unf[v];
    }

    static class 원더랜드_최소스패닝트리_07_Edge implements Comparable<원더랜드_최소스패닝트리_07_Edge> {
        public int v1;
        public int v2;
        public int cost;
        public 원더랜드_최소스패닝트리_07_Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(원더랜드_최소스패닝트리_07_Edge o) {
            return this.cost - o.cost;
        }
    }*/

    /*public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 도시 개수
        int m = kb.nextInt(); // 도로 개수

        List<List<원더랜드_최소스패닝트리_08_Edge>> arr = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int cost = kb.nextInt();
            arr.get(a).add(new 원더랜드_최소스패닝트리_08_Edge(b, cost));
            arr.get(b).add(new 원더랜드_최소스패닝트리_08_Edge(a, cost));
        }

        // 내 풀이
        System.out.println(원더랜드_최소스패닝트리_08(arr));

        // 강사님 풀이
        // 비슷비슷
    }

    private static int 원더랜드_최소스패닝트리_08(List<List<원더랜드_최소스패닝트리_08_Edge>> arr) {
        boolean[] unf = new boolean[arr.size()];

        int sum = 0;
        PriorityQueue<원더랜드_최소스패닝트리_08_Edge> pq = new PriorityQueue<>();
        pq.add(new 원더랜드_최소스패닝트리_08_Edge(1, 0));

        while (!pq.isEmpty()) {
            원더랜드_최소스패닝트리_08_Edge poll = pq.poll();
            int vex = poll.vex;
            int cost = poll.cost;
            if (unf[vex]) continue;

            for (원더랜드_최소스패닝트리_08_Edge edge : arr.get(vex)) {
                pq.add(new 원더랜드_최소스패닝트리_08_Edge(edge.vex, edge.cost));
            }

            unf[vex] = true;
            sum += cost;
        }

        return sum;
    }

    static class 원더랜드_최소스패닝트리_08_Edge implements Comparable<원더랜드_최소스패닝트리_08_Edge> {
        public int vex;
        public int cost;
        public 원더랜드_최소스패닝트리_08_Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(원더랜드_최소스패닝트리_08_Edge o) {
            return this.cost - o.cost;
        }
    }*/

    /*static int 계단_오르기_01_answer = 0;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 도시 개수

        // 내 풀이
        int[] arr = new int[n + 1];
        계단_오르기_01(1, 0, n, arr);
        System.out.println(계단_오르기_01_answer);

        // 강사님 풀이
        int[] dy = new int[n + 1];
        System.out.println(계단_오르기_01_lecture(n, dy));
    }

    private static int 계단_오르기_01_lecture(int n, int[] dy) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        return dy[n];
    }

    private static void 계단_오르기_01(int index, int sum, int n, int[] arr) {
        if (sum > n) return;
        if (sum == n) {
            계단_오르기_01_answer++;
        } else {
            for (int i = 1; i <= 2; i++) {
                arr[index] = i;
                계단_오르기_01(index + 1, sum + i, n, arr);
                arr[index] = 0;
            }
        }
    }*/

    /*public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 도시 개수

        // 내 풀이
        int[] arr = new int[n + 1];
        System.out.println(돌다리_건너기_02(n, arr));

        // 강사님 풀이
        // 비슷
    }

    private static int 돌다리_건너기_02(int n, int[] arr) {
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr[n];
    }*/

    /*public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 도시 개수

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }

        // 내 풀이
        System.out.println(최대_부분_증가수열_03(n, arr));

        // 강사님 풀이
        System.out.println(최대_부분_증가수열_03_lec(arr));
    }

    private static int 최대_부분_증가수열_03_lec(int[] arr) {
        int[] dy = new int[arr.length];
        int answer = 0;
        dy[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    private static int 최대_부분_증가수열_03(int n, int[] arr) {
        int result = 0;
        int[] dy = new int[n];
        dy[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int target = arr[i];

                if (target > arr[j]) {
                    dy[i] = Math.max(dy[i], dy[j] + 1);
                }
            }
            if (dy[i] == 0) dy[i] = 1;

            if (result < dy[i]) {
                result = dy[i];
            }
        }

        return result;
    }*/

    /*public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 도시 개수

        List<가장_높은_탑_쌓기_04_brick> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new 가장_높은_탑_쌓기_04_brick(kb.nextInt(), kb.nextInt(), kb.nextInt()));
        }

        // 내 풀이
        System.out.println(가장_높은_탑_쌓기_04(n, list));

        // 강사님 풀이
        System.out.println(가장_높은_탑_쌓기_04_lec(n, list));
    }

    private static int 가장_높은_탑_쌓기_04_lec(int n, List<가장_높은_탑_쌓기_04_brick> arr) {
        int answer = 0;
        Collections.sort(arr);
        int[] dy = new int[n];
        dy[0] = arr.get(0).height;
        answer = dy[0];

        for (int i = 1; i < arr.size(); i++) {
            int max_h = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j).weight > arr.get(i).weight && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + arr.get(i).height;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    private static int 가장_높은_탑_쌓기_04(int n, List<가장_높은_탑_쌓기_04_brick> list) {
        Collections.sort(list);
        int result = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {

            가장_높은_탑_쌓기_04_brick target = list.get(i);
            boolean isOk = false;
            for (int j = i - 1; j >= 0; j--) {
                가장_높은_탑_쌓기_04_brick compare = list.get(j);
                if (compare.weight > target.weight) {
                    isOk = true;
                    arr[i] = Math.max(arr[i], arr[j] + target.height);
                }
            }
            if (!isOk) arr[i] = target.height;
        }

        for (int i : arr) {
            if (result < i) {
                result = i;
            }
        }

        return result;
    }

    static class 가장_높은_탑_쌓기_04_brick implements Comparable<가장_높은_탑_쌓기_04_brick> {
        private int baseArea; // 밑면 넓이
        private int height;   // 벽돌 높이
        private int weight;   // 벽돌 무게

        public 가장_높은_탑_쌓기_04_brick(int baseArea,
                                   int height,
                                   int weight) {
            this.baseArea = baseArea;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(가장_높은_탑_쌓기_04_brick o) {
            return o.baseArea - this.baseArea;
        }
    }*/

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 도시 개수
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        int m = kb.nextInt();

        // 내 풀이 -> DFS로는 동전 개수에 따라 time limit, dp로 풀어야 한다.
        System.out.println(동전교환_05_me(arr, m));

        // 강사님 풀이
        System.out.println(동전교환_05_lec(arr, m));
    }

    private static int 동전교환_05_lec(int[] coin, int m) {
        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }

        return dy[m];
    }

    private static int 동전교환_05_me(int[] arr, int m) {
        int[] temp = new int[m + 1];
        Arrays.fill(temp, Integer.MAX_VALUE);
        temp[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            int coin = arr[i];

            for (int j = coin; j <= m; j++) {
                temp[j] = Math.min(temp[j], temp[j - coin] + 1);
            }
        }

        return temp[m];
    }
}

























