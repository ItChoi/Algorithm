package study.algorithm.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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
    /*public static void main(String[] args) {
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
    }*/
    // 6. 중복문자제거 END

    // 7. 회문 문자열 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        str = str.toLowerCase();
        int sLength = str.length();

        for (int i = 0; i < sLength; i++) {
            int compareJ = sLength - i - 1;
            if (str.charAt(i) != str.charAt(compareJ)) {
                return "NO";
            }
        }

        return "YES";
    }*/
    // 7. 회문 문자열 END

    // 8. 유효한 팰린드롬 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int sLength = str.length();

        for (int i = 0; i < sLength; i++) {
            int compareJ = sLength - i - 1;
            if (str.charAt(i) != str.charAt(compareJ)) {
                return "NO";
            }
        }

        return "YES";
    }*/
    // 8. 유효한 팰린드롬 END

    // 9. 숫자만 추출 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public int solution(String str) {
        return Integer.valueOf(str.replaceAll("[^0-9]", ""));
    }*/
    // 9. 숫자만 추출 END

    // 10. 문자거리 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        char t = kb.next().charAt(0);

        System.out.println(T.solution(s, t));
    }

    public int[] solution(String s,
                           char t) {
        int[] answer = new int[s.length()];

        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            if (s.charAt(i) == t) {
                answer[i] = 0;
                continue;
            }

            int lt = i;
            int rt = i;

            int targetNum = 1;
            while (lt > 0 || rt < sLength) {
                lt--;
                rt++;
                if (lt > 0 && s.charAt(lt) == t) {
                    answer[i] = targetNum;
                    break;
                }
                if (rt < sLength && s.charAt(rt) == t) {
                    answer[i] = targetNum;
                    break;
                }

                targetNum++;
            }
        }
        return answer;
    }*/
    // 10. 문자거리 END

    // 11. 문자열 압축 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int sLength = s.length();
        int j = 1;
        for (int i = 0; i < sLength; i++) {
            char sCharAt = s.charAt(i);

            if (i + 1 == sLength) {
                sb.append(sCharAt);
                if (j > 1) {
                    sb.append(j);
                }
                continue;
            }

            if (sCharAt == s.charAt(i + 1)) {
                j++;
            } else {
                sb.append(sCharAt);
                if (j > 1) {
                    sb.append(j);
                }

                j = 1;
            }
        }

        return sb.toString();
    }*/
    // 11. 문자열 압축 END

    // 12. 암호 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        String str = kb.next();

        System.out.println(T.solution(num, str));
    }

    public String solution(int num,
                           String str) {
        int dLength = 7;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            String encryption = str.substring(0, dLength);
            String targetStr = encryption.replace('#', '1').replace('*', '0');

            char c = (char) Integer.parseInt(targetStr, 2);
            sb.append(c);

            str = str.substring(dLength);
        }


        return sb.toString();
    }*/
    // 12. 암호 END

    // 2. 큰 수 출력하기 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(kb.nextInt());
        }

        System.out.println(T.solution(num, list));
    }

    public List<Integer> solution(int num,
                           List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        result.add(list.get(0));

        for (int i = 1; i < num; i++) {
            Integer target = list.get(i);
            if (list.get(i - 1) < target) {
                result.add(target);
            }
        }

        return result;
    }*/
    // 2. 큰 수 출력하기 END

    // 3. 보이는 학생 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list1.add(kb.nextInt());
        }

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list2.add(kb.nextInt());
        }

        for (String s : T.solution(num, list1, list2)) {
            System.out.println(s);
        }
    }

    public List<String> solution(int num,
                        List<Integer> user1,
                        List<Integer> user2) {
        List<String> result = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            Integer u1 = user1.get(i);
            Integer u2 = user2.get(i);
            int a = u1 - u2;
            if (a == 0) {
                result.add("D");
            } else {
                if (a == -1 || a == 2) {
                    result.add("B");
                } else {
                    result.add("A");
                }
            }
        }

        return result;
    }*/
    // 3. 보이는 학생 END

    // 4. 피보나치 수열 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();

        for (Integer integer : T.solution(num)) {
            System.out.print(integer + " ");
        }
    }

    public List<Integer> solution(int num) {
        List<Integer> result = new ArrayList<>(num);

        result.add(1);
        result.add(1);
        for (int i = 2; i < num; i++) {
            result.add(result.get(i - 2) + result.get(i - 1));
        }

        return result;
    }*/
    // 4. 피보나치 수열 END

    // 5. 소수(에라토스테네스 체) START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();

        System.out.print(T.solution(num));
    }

    public int solution(int num) {
        int result = 0;
        boolean[] isSosu = new boolean[num + 1];
        Arrays.fill(isSosu, true);

        for (int i = 2; i * i <= num; i++) {
            for (int j = i * i; j <= num; j += i) {
                isSosu[j] = false;
            }
        }

        for (int i = 2; i < isSosu.length; i++) {
            if (isSosu[i]) {
                result++;
            }
        }

        return result;
    }*/
    // 5. 소수(에라토스테네스 체) END

    // 6. 뒤집은 소수 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        List<Integer> numbers = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            numbers.add(kb.nextInt());
        }

        for (Integer integer : T.solution(num, numbers)) {
            System.out.print(integer + " ");
        }
    }

    public List<Integer> solution(int num,
                                  List<Integer> numbers) {

        List<Integer> result = new ArrayList<>();

        List<Integer> reversedNumbers = reversedNumbers(numbers);
        int maxNum = calculateMaxNum(reversedNumbers);
        boolean[] isSosu = new boolean[maxNum + 1];
        Arrays.fill(isSosu, true);
        isSosu[1] = false;

        for (int i = 2; i * i <= maxNum; i++) {
            for (int j = i * i; j <= maxNum; j += i) {
                isSosu[j] = false;
            }
        }

        for (int i = 0; i < reversedNumbers.size(); i++) {
            Integer targetNum = reversedNumbers.get(i);
            if (isSosu[targetNum]) {
                result.add(targetNum);
            }
        }

        return result;
    }

    private List<Integer> reversedNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {
            char[] cArr = String.valueOf(number).toCharArray();
            int length = cArr.length / 2;

            for (int i = 0; i < length; i++) {
                int iLength = cArr.length - i - 1;
                char tempC = cArr[i];
                cArr[i] = cArr[iLength];
                cArr[iLength] = tempC;
            }

            result.add(Integer.parseInt(new String(cArr)));
        }

        return result;
    }

    private int calculateMaxNum(Collection<Integer> numbers) {
        return numbers.stream()
            .max(Comparator.comparing(Integer::intValue))
            .orElse(0);
    }*/
    // 6. 뒤집은 소수 END

    // 7. 점수계산 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        List<Integer> numbers = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            numbers.add(kb.nextInt());
        }

        System.out.println(T.solution(num, numbers));
    }

    public int solution(int num,
                        List<Integer> numbers) {
        int result = 0;

        int k = 0;
        for (Integer number : numbers) {
            if (number == 0) {
                k = 0;
                continue;
            }

            result += 1 + k++;
        }

        return result;
    }*/
    // 7. 점수계산 END

    // 8. 등수구하기 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        List<Integer> numbers = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            numbers.add(kb.nextInt());
        }

        for (Integer integer : T.solution(num, numbers)) {
            System.out.print(integer + " ");
        }
    }

    public List<Integer> solution(int num,
                                  List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        int numberSize = numbers.size();
        for (int i = 0; i < numberSize; i++) {
            int score = 1;
            Integer target = numbers.get(i);
            for (int j = 0; j < numberSize; j++) {
                if (i == j) continue;

                if (target < numbers.get(j)) score++;
            }

            result.add(score);
        }

        return result;
    }*/
    // 8. 등수구하기 END

    // 9. 격자판 최대합 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int[][] numbers = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                numbers[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(num, numbers));
    }

    public int solution(int num,
                        int[][] numbers) {
        int max = 0;

        int diagonalT = 0;
        int diagonalB = 0;
        for (int i = 0; i < num; i++) {
            int width = 0;
            int height = 0;

            for (int j = 0; j < num; j++) {
                width += numbers[i][j];
                height += numbers[j][i];
            }

            diagonalT += numbers[i][i];
            diagonalB += numbers[num - i - 1][num - i - 1];

            max = Math.max(max, Math.max(width, height));
        }

        max = Math.max(max, Math.max(diagonalT, diagonalB));
        return max;
    }*/
    // 9. 격자판 최대합 END

    // 10. 봉우리 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int[][] numbers = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                numbers[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(num, numbers));
    }

    public int solution(int num,
                        int[][] numbers) {
        int result = 0;

        int[] checkH = {-1, 0, 1, 0};
        int[] checkW = {0, 1, 0, -1};

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                boolean isBong = true;
                int target = numbers[i][j];
                for (int k = 0; k < checkH.length; k++) {
                    int tempI = i + checkH[k];
                    int tempJ = j + checkW[k];
                    if (tempI < 0 || tempI >= num || tempJ < 0 || tempJ >= num) {
                        continue;
                    }

                    if (target <= numbers[tempI][tempJ]) {
                        isBong = false;
                        break;
                    }
                }

                if (isBong) {
                    j++;
                    result++;
                }
            }
        }

        return result;
    }*/
    // 10. 봉우리 END

    // 11. 임시반장 정하기 START
    /*public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int[][] numbers = new int[num][5];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 5; j++) {
                numbers[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(num, numbers));
    }

    public int solution(int num,
                        int[][] numbers) {
        int result = 1;
        int max = 0;
        int numLeng = numbers.length;
        for (int i = 0; i < numLeng; i++) {
            int[] ch = new int[numLeng];

            for (int j = 0; j < numbers[i].length; j++) {
                int target = numbers[i][j];

                for (int k = 0; k < numLeng; k++) {
                    if (i == k) continue;
                    if (ch[k] == 1) continue;

                    int compare = numbers[k][j];
                    if (target == compare) {
                        ch[k] = 1;
                    }
                }
            }

            int temp = 0;
            for (int c : ch) {
                if (c == 1) temp++;
            }

            if (max < temp) {
                max = temp;
                result = i + 1;
            }
        }

        return result;
    }*/
    // 11. 임시반장 정하기 END

    // 12. 멘토링 START
    public static void main(String[] args) {
        MainAlgorithm T = new MainAlgorithm();
        Scanner kb = new Scanner(System.in);
        int width = kb.nextInt();
        int height = kb.nextInt();
        int[][] numbers = new int[height][width];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(width, height, numbers));
    }

    public int solution(int width,
                        int height,
                        int[][] numbers) {
        int result = 1;



        return result;
    }
    // 12. 멘토링 END

}
