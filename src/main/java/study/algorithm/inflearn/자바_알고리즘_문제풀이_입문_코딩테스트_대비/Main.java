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

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }
        
        System.out.print(T.매출액의_종류_03_me(n, k, arr));
        System.out.print(T.매출액의_종류_03(n, k, arr));
    }

    private int[] 매출액의_종류_03_me(int n,
                                 int k,
                                 int[] arr) {
        int[] answer = {};
        return answer;
    }

    private int[] 매출액의_종류_03(int n,
                              int k,
                              int[] arr) {
        int[] answer = {};
        return answer;
    }
}






























