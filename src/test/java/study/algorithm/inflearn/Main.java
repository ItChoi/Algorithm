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


        // String(문자열) end


    }
