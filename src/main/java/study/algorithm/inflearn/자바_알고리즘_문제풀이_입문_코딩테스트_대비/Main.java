package study.algorithm.inflearn.자바_알고리즘_문제풀이_입문_코딩테스트_대비;

import java.util.Scanner;

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

    public static void main(String[] args) {
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
    }
}
