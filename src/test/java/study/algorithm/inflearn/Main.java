package study.algorithm.inflearn;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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


}
