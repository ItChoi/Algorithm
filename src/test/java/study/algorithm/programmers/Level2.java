package study.algorithm.programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 프로그래머스 알고리즘 문제 2레벨을 풀어보자.
 */
public class Level2 {

    // 스택/큐 - 주식가격 start
    @Test
    public void 주식가격() {
        int[] prices = {1, 2, 3, 2, 3};
        for (int price : 주식가격_함수(prices)) {
            System.out.println("result: " + price);
        }
    }

    private int[] 주식가격_함수(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;

            for (int j = i; j < prices.length; j++) {
                if (i == j) continue;
                count++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
    // 스택/큐 - 주식가격 end


    // 스택/큐 - 프린터 start
    @Test
    public void 프린터() {
        int[] properties = {2, 1, 3, 2};
        int location = 2;

        /*int[] properties = {1, 1, 9, 1, 1, 1};
        int location = 0;*/
        System.out.println("result: " + 프린터_함수(properties, location));
    }

    private int 프린터_함수(int[] priorities, int location) {
        int answer = location;

        List<Integer> list = new LinkedList<>();
        for (int priority : priorities) {
            list.add(priority);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    j = i;
                    list.add(list.remove(i));
                    if (answer > i) {
                        answer--;
                    } else if (answer == i) {
                        answer = list.size() - 1;
                    }
                }
            }
        }

        return answer + 1;
    }
    // 스택/큐 - 프린터 end


    // 스택/큐 - 기능개발 start
    @Test
    public void 기능개발() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        for (int i : 기능개발_함수(progresses, speeds)) {
            System.out.println("result: " + i);
        }
    }

    private int[] 기능개발_함수(int[] progresses, int[] speeds) {
        int point = 0;
        int size = progresses.length;

        List<Integer> list = new ArrayList<>();

        while (point != size) {
            for (int i = point; i < size; i++) {
                if (progresses[i] >= 100) {
                    continue;
                }
                progresses[i] += speeds[i];
            }

            if (progresses[point] >= 100) {
                int count = 1;
                point++;
                for (int i = point; i < size; i++) {
                    if (progresses[i] < 100) {
                        break;
                    }
                    point++;
                    count++;
                }

                list.add(count);
            }

        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // 스택/큐 - 기능개발 end


    // Summer/Winter Coding(~2018) - 스킬트리 start
    @Test
    public void 스킬트리() {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
//        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "ZXC"};
//        String[] skill_trees = {"BDA"};
//        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "AQWER"};
//        String[] skill_trees = {"CXF", "ASF", "BDF", "CEFD"};
//        String[] skill_trees = {"CEFD"};

        System.out.println("result: " + 스킬트리_함수(skill, skill_trees));
    }

    private int 스킬트리_함수(String skill, String[] skill_trees) {
        int answer = 0;

        String firstS = String.valueOf(skill.charAt(0));
        for (int i = 0; i < skill_trees.length; i++) {
            boolean success = true;
            int checkIndex = -1;
            boolean firstCheck = false;

            if (skill_trees[i].contains(firstS)) {
                firstCheck = true;
            }

            for (int j = 0; j < skill.length(); j++) {
                String s = String.valueOf(skill.charAt(j));

                if (skill_trees[i].contains(s)) {
                    if (!firstCheck) {
                        success = false;
                        break;
                    }

                    int indexOf = skill_trees[i].indexOf(s);
                    if (checkIndex > indexOf) {
                        success = false;
                        break;
                    }
                    int preNum = checkIndex == -1 ? -1 : skill.indexOf(skill_trees[i].charAt(checkIndex));
                    int nextNum = skill.indexOf(skill_trees[i].charAt(indexOf));

                    if (preNum + 1 != nextNum) {
                        success = false;
                        break;
                    }

                    checkIndex = indexOf;
                }
            }

            if (success) {
                answer++;
            }
        }

        return answer;
    }
    // Summer/Winter Coding(~2018) - 스킬트리 end


    // 해시 - 위장 start
    @Test
    public void 위장() {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println("result: " + 위장함수(clothes));
    }

    private int 위장함수(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            String kind = clothe[1];
            Integer count = map.get(kind);
            map.put(clothe[1], count == null ? 1 : count + 1);
        }

        for (String s : map.keySet()) {
            answer *= map.get(s) + 1;
        }

        return answer - 1;
    }
    // 해시 - 위장 end


    // 월간 코드 챌린지 시즌1 - 두 개 뽑아서 더하기 start
    @Test
    public void 두개_뽑아서_더하기() {
        //int[] numbers = {2,1,3,4,1};
        //int[] numbers = {5,0,2,7};
        int[] numbers = {1, 2, 4, 8, 16, 32, 64};
        for (int i : 두개_뽑아서_더하기_함수(numbers)) {
            System.out.println("result: " + i);
        }

    }

    private int[] 두개_뽑아서_더하기_함수(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }
        return set.stream().sorted().mapToInt(a -> a.intValue()).toArray();
    }
    // 월간 코드 챌린지 시즌1 - 두 개 뽑아서 더하기 end


    // 월간 코드 챌린지 시즌1 - 3진법 뒤집기 start
    @Test
    public void 삼진법_뒤집기() {
        int n = 45;
        // int n = 125
        System.out.println("result: " + 삼진법_뒤집기_함수(n));
    }

    private int 삼진법_뒤집기_함수(int n) {
        int answer = 0;

        return answer;
    }

    // 월간 코드 챌린지 시즌1 - 3진법 뒤집기 end


    // 스택/큐 다리를 지나는 트럭 start
    @Test
    public void 다리를_지나는_트럭() {
        // TEST START

        // TEST END
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        /*int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};*/

        System.out.println("result: " + 다리를_지나는_트럭_함수(bridge_length, weight, truck_weights));
    }

    private int 다리를_지나는_트럭_함수(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> que = new ConcurrentLinkedQueue<>();

        int totalWeight = 0;
        for (int truckWeight : truck_weights) {
            while (true) {
                if (que.isEmpty()) {
                    answer++;
                    que.add(truckWeight);
                    totalWeight += truckWeight;
                    break;
                } else if (que.size() == bridge_length) {
                    totalWeight -= que.poll();
                } else {
                    if (totalWeight + truckWeight > weight) {
                        answer++;
                        que.add(0);
                    } else {
                        answer++;
                        que.add(truckWeight);
                        totalWeight += truckWeight;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
        // TODO: 완벽하게 이해하기.
    /*private int 다리를_지나는_트럭_함수(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();

        int totalWeight = 0;
        for (Integer truckWeight : truck_weights) {
            while (true) {
                if (que.isEmpty()) {
                    que.add(truckWeight);
                    answer++;
                    totalWeight += truckWeight;
                    break;
                } else if (que.size() == bridge_length) {
                    totalWeight -= que.poll();
                } else {
                    if (totalWeight + truckWeight > weight) {
                        answer++;
                        que.add(0);
                    } else {
                        answer++;
                        que.add(truckWeight);
                        totalWeight += truckWeight;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;*/
    }

    /*private int 다리를_지나는_트럭_함수(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        int truckWeightsLength = truck_weights.length;

        int totalWeigh = 0;
        for (int i = 0; i < truckWeightsLength; i++) {
            int count = que.size() == 1 ? bridge_length - 1 : bridge_length;

            while (true) {
                if (que.isEmpty()) {
                    int truckWeight = truck_weights[i];
                    totalWeigh += truckWeight;
                    que.add(truckWeight);
                } else if (i != truckWeightsLength -1 && weight >= (totalWeigh + truck_weights[i + 1])) {
                    int nextTructWeight = truck_weights[i + 1];
                    count--;
                    answer++;
                    totalWeigh += nextTructWeight;
                    que.add(nextTructWeight);
                    continue;
                } else {
                    if (count-- <= 0) {
                        totalWeigh -= que.poll();
                        break;
                    }
                    answer++;
                }
            }
        }

        return answer + 1;
    }*/

    /*private int 다리를_지나는_트럭_함수(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Map<Integer, Integer> passingTruck = new HashMap<>();

        int totalWeigh = 0;
        int truckWeightsLength = truck_weights.length;
        for (int i = 0; i < truckWeightsLength; i++) {
            totalWeigh += truck_weights[i];
            passingTruck.put(truck_weights[i], bridge_length);

            if (i != truckWeightsLength - 1 && weight > (totalWeigh + truck_weights[i + 1])) {
                continue;
            }

            List<Integer> removeTargetList = new ArrayList<>();
            boolean isWorking = true;
            while (isWorking) {
                answer++;
                for (Integer key : passingTruck.keySet()) {
                    int val = passingTruck.get(key) - 1;
                    passingTruck.put(key, val);

                    if (val == 0) {
                        removeTargetList.add(key);
                        totalWeigh -= key;
                        isWorking = false;
                    }
                }
            }

            for (Integer key : removeTargetList) {
                passingTruck.remove(key);
            }
        }
        return answer;
    }*/

    /*private int 다리를_지나는_트럭_함수1(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        List<Integer> tempTruckWeights = Arrays.stream(truck_weights).boxed().collect(Collectors.toList());
        Map<Integer, Integer> passingTruckMap = new HashMap<>();
        int pointer = 0;

        int truckSize = tempTruckWeights.size();
        for (int i = 0; i < truckSize; i++) {
            totalWeight += tempTruckWeights.get(i);
            passingTruckMap.put(i, tempTruckWeights.get(i));

            int j = i + 1;
            if (j < truckSize) {
                for (; j < truckSize; j++) {
                    if (weight < (totalWeight + tempTruckWeights.get(j))) {
                        break;
                    }

                    totalWeight += tempTruckWeights.get(j);
                    //passingTruckList.add(j);
                    passingTruckMap.put(j, tempTruckWeights.get(j));
                    i = j;
                }
            }

            for (int k = 0; k < bridge_length; k++) {
                for (Integer index : passingTruckMap.keySet()) {
                    if (passingTruckMap.get(index) == 0) {
                        totalWeight -= passingTruckMap.get(index);
                        passingTruckMap.remove(index);
                        break;
                    }
                    passingTruckMap.put(index, passingTruckMap.get(index) - 1);
                    answer++;
                }
            }
        }
        return answer;
    }*/
    // 스택/큐 다리를 지나는 트럭 end

    // 짝지어 제거하기 start
    @Test
    void 짝지어_제거하기() {
//        String s = "baabaa";
//        String s = "cdcd";

        String s = "abccbaf";    //1
//        String s = "abcccba";	//0
//        String s = "abccccbaaa";	//1
//        String s = "abccaabaa";	//0
//        String s = "a";	//0
        System.out.println("result: " + 짝지어_제거하기_함수(s));
    }

    // stack 이용 하여 풀기 -> 자료 구조를 잘 활용하자.
    private int 짝지어_제거하기_함수(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    // 내가 푼 것 -> 효율성 0.....
    /*private int 짝지어_제거하기_함수(String s) {
        int answer = 0;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < s.length() -1; i++) {
                char c = s.charAt(i);
                if (c == s.charAt(i + 1)) {
                    cnt++;
                    String temp = c + "" + c;
                    s = s.replaceFirst(temp, "");
                    break;
                }
            }

            if (s.length() == 0) {
                answer = 1;
                break;
            } else if (cnt == 0) {
                break;
            }
        }

        return answer;
    }*/

    // 짝지어 제거하기 end


    // Summer/Winter Coding(~2018) 점프와 순간 이동 START - 문제 해석 능력을 키우자. 어떤 포인트에 집중 할 지 파악하기.
    @Test
    void 점프와_순간_이동() {
//        int n = 5; // 2
//        int n = 6; // 2
        int n = 5000; // 5
        System.out.println("result: " + 점프와_순간_이동_함수(n));
    }

    private int 점프와_순간_이동_함수(int n) {
        int answer = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                answer++;
            }
        }

        /* ...오마이갓
        int answer = 1;
        int cnt = 1;
        int multipliedByNum = 2;
        // n = 6
        while (cnt < n) {
            int realVal = cnt * multipliedByNum; // 2
            if (realVal < n) {
                int tempVal = (realVal) * multipliedByNum; // 4
                if (tempVal < n && (n - tempVal) <= cnt) { //
                    cnt++;
                } else {
                    answer++;
                }
                cnt = realVal;
            } else {
                cnt++;
                answer++;
            }
        }*/

        return answer;
    }
    // Summer/Winter Coding(~2018) 점프와 순간 이동 END


    // 월간 코드 챌린지 시즌1 삼각 달팽이 START
    @Test
    void 삼각_달팽이() {
        System.out.println("!!@@:: " + 1 % 3);
//        int n = 4;
        int n = 5;
//        int n = 6;
        for (int i : 삼각_달팽이_함수(n)) {
            System.out.println("result: :" + i);
        }

    }

    private int[] 삼각_달팽이_함수(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] tmpData = new int[n][n];
        int num = 1;
        int x = -1;
        int y = 0;
        for (int i = 0; i < n; i++) {
            int jLength = n - i;
            for (int j = 0; j < jLength; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }

                tmpData[x][y] = num++;
            }
        }

        int j = 0;
        for (int[] tmpDatum : tmpData) {
            for (int i : tmpDatum) {
                if (i == 0) break;
                answer[j++] = i;
            }
        }

        return answer;
    }
    // 월간 코드 챌린지 시즌1 삼각 달팽이 END

    // 월간 코드 챌린지 시즌1 이진 변환 반복하기 START
    @Test
    void 이진_변환_반복하기() {
//        String s = "110010101001";
        String s = "01110";
//        String s = "1111111";
        for (int i : 이진_변환_반복하기_함수(s)) {
            System.out.println("result: " + i);
        }
    }

    private int[] 이진_변환_반복하기_함수(String s) {
        int convertCount = 0;
        int zeroCount = 0;

        int sLength = s.length();
        while (sLength != 1) {
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                }
            }

            sLength = s.replaceAll("0", "").length();
            s = Integer.toBinaryString(sLength);
            convertCount++;
        }

        int[] answer = {convertCount, zeroCount};
        return answer;
    }

    // 연습문제 숫자의 표현 START
    @Test
    void 숫자의_표현() {
        int n = 15;
        System.out.println("result: " + 숫자의_표현_함수(n));
    }

    private int 숫자의_표현_함수(int n) {
        int answer = 0;

        int sum = 0;
        int lt = 1;
        for (int rt = 1; rt <= n; rt++) {
            sum += rt;
            if (sum <= n) {
                if (sum == n) {
                    answer++;
                }
            }

            while (sum >= n && (sum + rt) > -n) {
                sum -= lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }
    // 연습문제 숫자의 표현 END

    // 연습문제 땅따먹기 START
    @Test
    void 땅따먹기() {
        /*int[][] land = {
            {1, 2, 3, 5},
            {5, 6, 7, 8},
            {4, 3, 2, 1}
        };*/

        int[][] land = {
                {4, 3, 2, 1},
                {2, 2, 2, 1},
                {6, 6, 6, 4},
                {8, 7, 6, 5}
        };

        /*int[][] land = {
            {9, 5, 2, 3},
            {9, 8, 6, 7},
            {8, 9, 7, 1},
            {100, 9, 8, 1}
        };*/
        System.out.println("result: " + 땅따먹기_함수(land));
    }

    private int 땅따먹기_함수(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
            land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
            land[i][2] += Math.max(Math.max(land[i - 1][1], land[i - 1][0]), land[i - 1][3]);
            land[i][3] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][0]);
        }

        int[] answer = land[land.length - 1];
        Arrays.sort(answer);

        return answer[answer.length - 1];
        /*int noTargetIndex = 0;
        int max = 0;
        for (int i = 0; i < land[0].length; i++) {
            noTargetIndex = i;
            int sum = land[0][i];

            for (int j = 1; j < land.length; j++) {
                int hangMax = 0;
                int tmpIndex = 0;
                for (int k = 0; k < land[j].length; k++) {
                    if (noTargetIndex == k) continue;
                    if (hangMax < land[j][k]) {
                        hangMax = land[j][k];
                        tmpIndex = k;
                    }
                }
                sum += hangMax;
                noTargetIndex = tmpIndex;
            }

            if (max < sum) max = sum;

        }

        return max;*/
    }

    // 연습문제 땅따먹기 END

    // 월간 코드 챌린지 시즌1 이진 변환 반복하기 END


    // Summer/Winter Coding(~2018) 영어 끝말잇기 START
    @Test
    void 영어_끝말잇기() {
        String test = "testa";
        String peekEndStr = test.substring(test.length() - 1);
        System.out.println("test: " + peekEndStr);
        int n = 3;
//        String[] words = {
//                "tank", "kick", "know", "wheel",
//                "land", "dream", "mother", "robot", "tank"
//        };
//        String[] words = {
//                "hello", "observe", "effect", "take",
//                "either", "recognize", "encourage", "ensure",
//                "establish", "hang", "gather", "refer",
//                "reference", "estimate", "executive"
//        };
        String[] words = {
                "hello", "one", "even", "never",
                "now", "world", "draw"
        };
        for (int i : 영어_끝말잇기_함수(n, words)) {
            System.out.println("result: " + i);
        }
    }

    private int[] 영어_끝말잇기_함수(int n, String[] words) {
        int nNum = 0;
        int count = 0;

        Stack<String> alreadyExists = new Stack<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String peekEndStr = alreadyExists.isEmpty() ? "" : alreadyExists.peek().substring(alreadyExists.peek().length() - 1);
            boolean fail = !word.startsWith(peekEndStr);
            if (alreadyExists.contains(word) || fail) {
                if (i < n) {
                    nNum = i;
                    count = 1;
                } else {
                    if (fail) {
                        nNum = i / n;
                        count = i / n;
                    } else {
                        nNum = i / n + 1;
                        count = i / n + 1;
                    }
                }
                break;
            }

            alreadyExists.add(word);
        }

        return new int[]{nNum, count};
    }
    // Summer/Winter Coding(~2018) 영어 끝말잇기 END

    // 2020 카카오 인턴십 수식 최대화 START
    @Test
    void 수식_최대화() {
        String expression = "100-200*300-500+20"; // 60420
        System.out.println("test: " + expression.contains("/"));
        //String expression = "50*6-3*2"; // 300
        //String expression = "200-300-500-600*40+500+500"; // 1248000
        System.out.println("result: " + 수식_최대화_함수(expression));
    }

    private long 수식_최대화_함수(String expression) {
        long answer = 0;

        String[] prior = {"*", "+", "-"};
        int[][] priorIndex = {
                {0, 1, 2}, {0, 2, 1},
                {1, 2, 0}, {1, 0, 2},
                {2, 0, 1}, {2, 1, 0}
        };

        int max = 0;
        //for (int )


        return answer;
    }
    // 2020 카카오 인턴십 수식 최대화 END

    // Summer/Winter Coding(~2018) 방문 길이 START
    @Test
    void 방문_길이() {
//        String dirs = "ULURRDLLU";	//7
//        String dirs = "LULLLLLLU";	//7
//        String dirs = "LLLLRLRLRLL"; //6
//        String dirs = "UUUUDUDUDUUU"; //6
//        String dirs = "LURDLURDLURDLURDRULD"; //7
//        String dirs = "RRRRRRRRRRRRRRRRRRRRRUUUUUUUUUUUUULU"; //11
        String dirs = "UDU";
        System.out.println("result: " + 방문_길이_함수(dirs));
    }

    private int 방문_길이_함수(String dirs) {
        int lt = 5;
        int rt = 5;
        Set<String> set = new HashSet<>();
        for (char c : dirs.toCharArray()) {
            String temp = lt + "" + rt;
            if (c == 'U' && lt > 0) {
                lt--;
            } else if (c == 'D' && lt < 10) {
                lt++;
            } else if (c == 'L' && rt > 0) {
                rt--;
            } else if (c == 'R' && rt < 10) {
                rt++;
            } else {
                continue;
            }

            set.add(temp + lt + rt);
            set.add("" + lt + rt + temp);
        }

        return set.size() / 2;
    }
    // Summer/Winter Coding(~2018) 방문 길이 END

    // 2018 KAKAO BLIND RECRUITMENT [3차] 방금그곡 START
    @Test
    void 방금그곡() {
        //"HELLO"
        String m = "ABCDEFG";
        String[] musicinfos = {
                "12:00,12:14,HELLO,CDEFGAB",
                "13:00,13:05,WORLD,ABCDEF"
        };
        //"FOO"
//        String m = "CC#BCC#BCC#BCC#B";
//        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        //"WORLD"
//        String m = "ABC";
//        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        /**
         * 1. 방금 들은 곡 제목 찾기
         * 2. 한 음악 반복 재생 할 때도 있다.
         * 3. 한 음악을 중간에 끊는 경우도 있다.
         * 4. 조건 일치 하는 곳 여러 개 일 때 재생 시간 > 먼저 입력
         * 5. 조건 불일치 None 반환
         */
        System.out.println("result: " + 방금그곡_함수(m, musicinfos));
    }

    private String 방금그곡_함수(String m, String[] musicinfos) {
        String answer = "";

        String selectTitle = "";
        int selectTime = 0;
        int a = 0;
        for (String musicinfo : musicinfos) {
            String[] args = musicinfo.split(",");
            int startSeconds = getSeconds(args[0]);
            int endSeconds = getSeconds(args[1]);
            String title = args[2];
            String content = args[3];

            int ingTime = endSeconds - startSeconds;
            int j = 0;
            int k = 0;

            Stack<Character> tempChar = new Stack<>();
            for (int i = 0; i < ingTime; i++) {
                if (content.length() == i) j = 0;
                if (m.charAt(k++) != content.charAt(j)) {
                    if (k != 0) tempChar.clear();
                    k = 0;
                    continue;
                }
                tempChar.push(content.charAt(j));
            }
            if (title.equals(tempChar.toString())) {

            }

        }

        return answer;
    }

    private int getSeconds(String startTime) {
        String[] time = startTime.split(":");
        return (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
    }

    // 2018 KAKAO BLIND RECRUITMENT [3차] 방금그곡 END

    // 더_맵게 START
    @Test
    void 더_맵게() {
        /**
         * 스코빌 지수
         * 1. 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번 째로 맵지 않은 음식의 스코빌 지수 * 2)
         * 2. 모든 음식 스코빌 지수 K 이상이 될 때 까지 반복하여 섞음
         * 3. 모든 음식의 스코빌 지수가 K 이상으로 만들기 위해 섞어야 하는 최소 횟수 리턴
         */
        // 2
        System.out.println("result: 2 " + 더_맵게_함수(new int[]{1, 2, 3, 9, 10, 12}, 7)); //, 2)
        System.out.println("result: 2 " + 더_맵게_함수(new int[]{1, 1, 1}, 4)); //, 2)
        System.out.println("result: 4 " + 더_맵게_함수(new int[]{10, 10, 10, 10, 10}, 100)); //, 4)
        System.out.println("result: 2 " + 더_맵게_함수(new int[]{1, 2, 3, 9, 10, 12}, 7)); //, 2)
        System.out.println("result: 2 " + 더_맵게_함수(new int[]{0, 2, 3, 9, 10, 12}, 7)); //, 2)
        System.out.println("result: 3 " + 더_맵게_함수(new int[]{0, 0, 3, 9, 10, 12}, 7)); //, 3)
        System.out.println("result: -1 " + 더_맵게_함수(new int[]{0, 0, 0, 0}, 7)); //, -1)
        System.out.println("result: -1 " + 더_맵게_함수(new int[]{0, 0, 3, 9, 10, 12}, 7000)); //, -1)
        System.out.println("result: 2 " + 더_맵게_함수(new int[]{0, 0, 3, 9, 10, 12}, 1)); //, 2)
        System.out.println("result: -1 " + 더_맵게_함수(new int[]{0, 0}, 1)); //, -1)
        System.out.println("result: 1 " + 더_맵게_함수(new int[]{1, 0}, 1)); //, 1)
        System.out.println("result: 0 " + 더_맵게_함수(new int[]{0, 0, 3, 9, 10, 12}, 0)); //, 0)
        System.out.println("result: 0 " + 더_맵게_함수(new int[]{0, 0}, 0)); //, 0)
        System.out.println("result: 1 " + 더_맵게_함수(new int[]{1, 2}, 3)); //, 0)
    }

    /* 내가 푼 것 (틀림 - 테스트 케이스 못 찾겠음)
    private int 더_맵게_함수(int[] scoville, int K) {
        int answer = 0;

        Arrays.sort(scoville);
        boolean isValid = false;
        for (int i = 1; i < scoville.length; i++) {
            int t1 = scoville[i - 1];
            int t2 = scoville[i];

            if (t1 < K || t2 < K) {
                int min = Math.min(t1, t2);
                int max = Math.max(t1, t2);
                scoville[i] = min + (max * 2);
                answer++;
                if (scoville[i] >= K) isValid = true;
            } else {
                isValid = true;
            }
        }

        return isValid ? answer : -1;
    }*/

    // 소스 코드 참고 - Prio9rityQueue
    private int 더_맵게_함수(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i : scoville) que.offer(i);

        while (que.peek() < K) {
            if (que.size() < 2) return -1;
            int t1 = que.poll();
            int t2 = que.poll();
            que.offer(Math.min(t1, t2) + (Math.max(t1, t2) * 2));
            answer++;
        }

        return answer;
    }
    // 더_맵게 END

    // 깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버 START
    @Test
    void 타겟_넘버() {
        System.out.println("result: 5 " + 타겟_넘버_함수(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println("result: 3 " + 타겟_넘버_함수(new int[]{1, 2, 1, 2}, 2));
        System.out.println("result: 1 " + 타겟_넘버_함수(new int[]{1, 2, 1, 2}, 6));
    }

    int 타겟_넘버_함수(int[] numbers, int target) {
        int answer = 0;
        int n = numbers.length;
        int[] ch = new int[n];
        answer += 타겟_넘버_함수_DFS(numbers, ch, target, 0);

        return answer;
    }

    int 타겟_넘버_함수_DFS(int[] numbers, int[] ch, int target, int index) {
        int answer = 0;
        if (index == numbers.length) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (ch[i] == 1) {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }
            if (sum == target) return 1;
        } else {
            int tempIndex = index + 1;
            ch[index] = 1;
            answer += 타겟_넘버_함수_DFS(numbers, ch, target, tempIndex);
            ch[index] = 0;
            answer += 타겟_넘버_함수_DFS(numbers, ch, target, tempIndex);
        }

        return answer;
    }
    // 깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버 END

    // 2019 KAKAO BLIND RECRUITMENT - 오픈채팅방 START
    @Test
    void 오픈채팅방() {
        System.out.println("result: " + 오픈채팅방_함수(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}));
    }

    private String[] 오픈채팅방_함수(String[] record) {
        Map<String, String> map = new HashMap<>();
        final String ENTER = "Enter";
        final String LEAVE = "Leave";
        final String CHANGE = "Change";

        List<String> result = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] divStr = record[i].split(" ");
            String action = divStr[0];
            String uid = divStr[1];
            String nick = divStr.length == 3 ? divStr[2] : "";

            String findMapValByUid = map.getOrDefault(uid, "");
            if ("".equals(findMapValByUid) || ENTER.equals(action) || CHANGE.equals(action)) map.put(uid, nick);

            if (ENTER.equals(action)) {
                result.add(uid + "님이 들어왔습니다.");
            } else if (LEAVE.equals(action)) {
                result.add(uid + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[result.size()];
        int i = 0;
        for (String s : result) {
            //String cutUid = s.substring(0, 7);
            String cutUid = s.substring(0, s.lastIndexOf("님"));
            answer[i++] = s.replace(cutUid, map.get(cutUid));

        }

        return answer;
    }


    // 2019 KAKAO BLIND RECRUITMENT - 오픈채팅방 END

    // 해시 - 전화번호 목록 START
    @Test
    void 전화번호_목록() {
        System.out.println("result: false " + 전화번호_목록_함수(new String[]{"119", "97674223", "1195524421"}));
        System.out.println("result: true " + 전화번호_목록_함수(new String[]{"123", "456", "789"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[]{"12", "123", "1235", "567", "88"}));
        System.out.println("result: true " + 전화번호_목록_함수(new String[]{"1234", "1235", "567"}));
        System.out.println("result: true " + 전화번호_목록_함수(new String[]{"2", "32"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[]{"11", "22", "33", "44", "123", "345", "12345", "4567", "34566"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[]{"11", "22", "33", "44", "345", "12345", "4567", "34566"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[]{"34566789", "11", "22", "33", "44", "345667", "345", "12345", "4567", "34566"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[]{"34566789", "11", "22", "33", "44", "345667", "12345", "4567", "34566"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[]{"34566789", "345667"}));
    }

    private boolean 전화번호_목록_함수(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            String prev = phone_book[i - 1];
            String next = phone_book[i];
            if (prev.startsWith(next) || next.startsWith(prev)) return false;
        }

        return true;
    }
    // 해시 - 전화번호 목록 END

    // Summer/Winter Coding(2019) - 멀쩡한 사각형 START
    @Test
    void 멀쩡한_사각형() {
        System.out.println("result: 80 " + 멀쩡한_사각형_함수(8, 12));
    }

    private long 멀쩡한_사각형_함수(int w, int h) {
        // 96 - 20 -
        return ((long) w * h) - (w + h - 유클리드호제_함수(w, h));
    }

    private int 유클리드호제_함수(int w, int h) {
        int f = Math.max(w, h);
        int s = Math.min(w, h);

        while (s > 0 && f % s != 0) {
            int temp = f % s;
            f = s;
            s = temp;
        }

        return s;
    }
    // Summer/Winter Coding(2019) - 멀쩡한 사각형 END

    // 2021 Dev-Matching: 웹 백엔드 개발자(상반기) - 행렬 테두리 회전하기 START
    @Test
    void 행렬_테두리_회전하기() {
        // [1, 1, 5, 3]
        int rows = 3;
        int columns = 3;
        int[][] queries = new int[][]{
                {1, 1, 2, 2},
                {1, 2, 2, 3},
                {2, 1, 3, 2},
                {2, 2, 3, 3}
        };

        // [1]
        /*int rows = 100;
        int columns = 97;
        int[][] queries = new int[][] {
                {1, 1, 100, 97}
        };*/

        // [8, 10, 25]
        /*int rows = 6;
        int columns = 6;
        int[][] queries = new int[][] {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}
        };*/

        for (int i : 행렬_테두리_회전하기_함수(rows, columns, queries)) {
            System.out.println("result: " + i);
        }
    }

    private int[] 행렬_테두리_회전하기_함수(int rows, int columns, int[][] queries) {
        int[] result = new int[queries.length];
        int[][] repo = new int[rows + 1][columns + 1];
        int k = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                repo[i][j] = k++;
            }
        }

        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            int aRow = queries[i][0];
            int aCol = queries[i][1];
            int bRow = queries[i][2];
            int bCol = queries[i][3];

            int minNum = Integer.MAX_VALUE;
            int lt = aRow;
            int rt = aCol;
            int tempA = repo[lt][rt];
            int tempB = 0;
            while (true) {
                if (tempA < minNum) minNum = tempA;
                if (aRow == lt && bCol > rt) {
                    rt++;
                } else if (bCol == rt && bRow > lt) {
                    lt++;
                } else if (bRow == lt && aCol < rt) {
                    rt--;
                } else {
                    lt--;
                }
                tempB = repo[lt][rt];

                repo[lt][rt] = tempA;
                tempA = tempB;
                if (lt == aRow && rt == aCol) break;
            }

            result[index++] = minNum;
        }

        return result;
    }
    // 2021 Dev-Matching: 웹 백엔드 개발자(상반기) - 행렬 테두리 회전하기 END

    // 2021 KAKAO BLIND RECRUITMENT - 메뉴 리뉴얼 START
    @Test
    void 메뉴_리뉴얼() {
        // ["AC", "ACDE", "BCFG", "CDE"]
        // AC 2
        System.out.println("AC: 4, CDE: 3, BCFG: 2, ACDE: 2");
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        // ["ACD", "AD", "ADE", "CD", "XYZ"]
        /*System.out.println("AD: 3, CD: 3, ACD: 2, ADE: 2, XYZ: 2");
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};*/

        // ["WX", "XY"]
        /*System.out.println("WX: 2, XY: 2");
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};*/

        // ["AB"]
        /*String[] orders = {
                "ABCDE", "AB", "CDAB", "ABDE",
                "XABYZ", "ABXYZ", "ABCD",
                "ABCDE", "ABCDE", "ABCDE",
                "AB", "AB", "AB", "AB", "AB",
                "AB", "AB", "AB", "AB", "AB"
        };
        int[] course = {2};*/

        for (String i : 메뉴_리뉴얼_함수(orders, course)) System.out.println("result: " + i);
    }

    // TODO 참고 - 다시 풀어보기
    int maxLength;
    Map<String, Integer> orderMapWithMenu = new HashMap<>();
    private String[] 메뉴_리뉴얼_함수(String[] orders, int[] course) {
        PriorityQueue<String> qQue = new PriorityQueue<>();

        for (int i = 0; i < course.length; i++) {
            orderMapWithMenu.clear();
            maxLength = 0;

            for (int j = 0; j < orders.length; j++) {
                메뉴_리뉴얼_함수_recur(course[i], 0, 0, "", orders[j]);
            }

            for (String key : orderMapWithMenu.keySet()) {
                if (orderMapWithMenu.get(key) == maxLength && maxLength > 1) {
                    qQue.offer(key);
                }
            }

        }

        String[] result = new String[qQue.size()];

        int i = 0;
        while (!qQue.isEmpty()) {
            result[i++] = qQue.poll();
        }
        return result;
    }

    private void 메뉴_리뉴얼_함수_recur(int targetLength, int index, int count, String str, String order) {
        if (targetLength == count) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String menu = "";
            for (int i = 0; i < chars.length; i++) menu += chars[i];
            int value = orderMapWithMenu.getOrDefault(menu, 0) + 1;
            orderMapWithMenu.put(menu, value);
            maxLength = Math.max(value, maxLength);
            return;
        }

        for (int i = index; i < order.length(); i++) {
            메뉴_리뉴얼_함수_recur(targetLength, i + 1, count + 1, str + order.charAt(i), order);
        }
    }








    /*HashMap<String,Integer> map;
    int m;
    private String[] 메뉴_리뉴얼_함수(String[] orders, int[] course) {
        PriorityQueue<String> pQue = new PriorityQueue<>();
        for (int i = 0; i < course.length; i++){
            map = new HashMap<>();
            m = 0;
            for (int j = 0; j < orders.length; j++) {
                메뉴_리뉴얼_함수_recur(0, "", course[i], 0, orders[j]);
            }
            for (String s : map.keySet()){
                if (map.get(s) == m && m > 1){
                    pQue.offer(s);
                }
            }
        }
        String  ans[] = new String[pQue.size()];
        int k=0;
        while (!pQue.isEmpty()){
            ans[k++] = pQue.poll();
        }
        return ans;
    }

    private void 메뉴_리뉴얼_함수_recur(int cnt, String str, int targetNum, int idx, String word) {
        if (cnt == targetNum){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temps="";
            for (int i = 0;i < c.length; i++) temps += c[i];
            map.put(temps, map.getOrDefault(temps,0) + 1);
            m = Math.max(m, map.get(temps));
            return;
        }
        for (int i = idx; i < word.length(); i++){
            char now = word.charAt(i);
            메뉴_리뉴얼_함수_recur(cnt + 1,str + now, targetNum,i + 1, word);
        }
    }*/


    /*private String[] 메뉴_리뉴얼_함수(String[] orders, int[] course) {
        Map<String, Integer> ordersCountingMap = new HashMap<>();
        Map<Integer, Integer> maxCountMapByStrLength = new HashMap<>();

        List<String> containSetMenuList = new ArrayList<>();
        for (int i = 1; i < orders.length; i++) {
            String targetOrder = orders[i];

            for (int j = 0; j < i; j++) {
                String comparingOrder = orders[j];
                int count = 0;
                String dump = "";

                for (int k = 0; k < orders[j].length(); k++) {
                    String strC = String.valueOf(comparingOrder.charAt(k));
                    if (targetOrder.contains(strC)) {
                        count++;
                        dump += strC;

                        if (count >= 2) {
                            if (!containSetMenuList.contains(dump)) {
                                int length = dump.length();
                                int value = ordersCountingMap.getOrDefault(dump, 1) + 1;
                                ordersCountingMap.put(dump, value);
                                containSetMenuList.add(dump);

                                if (value > maxCountMapByStrLength.getOrDefault(length, 0)) {
                                    maxCountMapByStrLength.put(length, value);
                                }
                            }
                        }
                    }
                }
            }
            containSetMenuList.clear();
        }

        List<String> resultList = new ArrayList<>();
        for (String key : ordersCountingMap.keySet()) {
            int length = key.length();
            int value = ordersCountingMap.get(key);

            if (Arrays.stream(course).anyMatch(i -> i == value)) {
                if (maxCountMapByStrLength.get(length) == value) {
                    resultList.add(key);
                }
            }
        }

        Collections.sort(resultList);
        String[] result = new String[resultList.size()];
        return resultList.toArray(result);
    }*/

    /*private String[] 메뉴_리뉴얼_함수(String[] orders, int[] course) {
        Map<String, Integer> setMenu = new HashMap<>();

        for (int i = 0; i < orders.length; i++) {
            boolean isExists = false;
            String targetMenu = orders[i];
            if (setMenu.containsKey(targetMenu)) isExists = true;

            for (int j = i + 1; j < orders.length; j++) {
                String order = orders[j];
                int count = 0;
                String createSetMenu = "";

                for (int k = 0; k < order.length(); k++) {
                    String strC = String.valueOf(order.charAt(k));
                    if (targetMenu.contains(strC)) {
                        count++;
                        createSetMenu += strC;
                    }
                }

                if (count >= 2) {
                    if (isExists && (targetMenu.equals(createSetMenu))) continue;
                    setMenu.put(createSetMenu, setMenu.getOrDefault(createSetMenu, 1) + 1);
                }
            }
        }

        int i = 0;
        for (String key : setMenu.keySet()) {
            System.out.println(++i + ": key: " + key + ", val: " + setMenu.get(key));
        }


        return null;
    }*/
    // 2021 KAKAO BLIND RECRUITMENT - 메뉴 리뉴얼 END

    // 2020 KAKAO BLIND RECRUITMENT - 문자열 압축 START
    @Test
    void 문자열_압축() {
        System.out.println("7 - result: " + 문자열_압축_함수("aabbaccc"));
        System.out.println("9 - result: " + 문자열_압축_함수("ababcdcdababcdcd"));
        System.out.println("8 - result: " + 문자열_압축_함수("abcabcdede"));
        System.out.println("14 - result: " + 문자열_압축_함수("abcabcabcabcdededededede"))	;
        System.out.println("17 - result: " + 문자열_압축_함수("xababcdcdababcdcd"))	;

    }

    private int 문자열_압축_함수(String s) {
        int length = s.length();
        int minLength = s.length();
        for (int i = 1; i <= length / 2; i++) {
            String result = "";
            int count = 1;
            String temp = "";
            int lt = 0;
            int rt = i;
            while (lt < length) {
                String str = s.substring(lt, Math.min(rt, length));

                if (!"".equals(temp)) {
                    if (temp.equals(str)) {
                        count++;
                    } else {
                        result += count > 1 ? temp + count : temp;
                        count = 1;
                    }
                }

                temp = str;
                lt = rt;
                rt += i;
                if (lt >= length) result += count > 1 ? temp + count : temp;
            }

            minLength = Math.min(minLength, result.length());
        }

        return minLength;
    }
    // 2020 KAKAO BLIND RECRUITMENT - 문자열 압축 END

    // 2017 카카오코드 예선 - 카카오프렌즈 컬러링북 START
    @Test
    void 카카오프렌즈_컬러링북() {
        // result [4, 5]
//        int m = 6;
//        int n = 4;
        /*int[][] picture =
                {
                    {1, 1, 1, 0},
                    {1, 2, 2, 0},
                    {1, 0, 0, 1},
                    {0, 0, 0, 1},
                    {0, 0, 0, 3},
                    {0, 0, 0, 3}
                };*/

        // 0, 0
        //int[][] picture = new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};

        // 3, 1
        /*int m = 5;
        int n = 5;
        int[][] picture = new int[][] {
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };*/

        // 1, 25
        int m = 5;
        int n = 5;
        int[][] picture = new int[][] {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        // 2, 24
        //int[][] picture = new int[][] {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 100, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};

        // 2, 6
        //int[][] picture = new int[][] {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};

        // 12, 120
        //int[][] picture = new int[][] {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0}, {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};
        for (int i : 카카오프렌즈_컬러링북_함수(m, n, picture)) System.out.println("result: " + i);

    }

    private int[] 카카오프렌즈_컬러링북_함수(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] checkVisitArray = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0) continue;
                int count = 카카오프렌즈_컬러링북_함수_DFS(i, j, i, j, picture, checkVisitArray);
                if (count > 0) {
                    numberOfArea++;
                    if (maxSizeOfOneArea < count) maxSizeOfOneArea = count;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int 카카오프렌즈_컬러링북_함수_DFS(int x, int y, int xx, int yy, int[][] picture, boolean[][] isVisitArray) {
        if (isVisitArray[xx][yy] || picture[x][y] != picture[xx][yy]) return 0;
        isVisitArray[xx][yy] = true;
        if (picture[xx][yy] == 0) return 0;

        int count = 1;
        if (xx - 1 > 0) count += 카카오프렌즈_컬러링북_함수_DFS(x, y, xx - 1, yy, picture, isVisitArray);
        if (xx + 1 < picture.length) count += 카카오프렌즈_컬러링북_함수_DFS(x, y, xx + 1, yy, picture, isVisitArray);
        if (yy - 1 > 0) count += 카카오프렌즈_컬러링북_함수_DFS(x, y, xx, yy - 1, picture, isVisitArray);
        if (yy + 1 < picture[xx].length) count += 카카오프렌즈_컬러링북_함수_DFS(x, y, xx, yy + 1, picture, isVisitArray);

        return count;
    }
    // 2017 카카오코드 예선 - 카카오프렌즈 컬러링북 END

    // 2020 KAKAO BLIND RECRUITMENT - 괄호 변환 START
    @Test
    void 괄호_변환() {
//        System.out.println("(()())() result: " + 괄호_변환_함수("(()())()"));
//        System.out.println("() result: " + 괄호_변환_함수(")("));
        System.out.println("()(())() result: " + 괄호_변환_함수("()))((()"));
    }

    private String 괄호_변환_함수(String p) {
        if (괄호_변환_함수_check(p)) return p;
        return 괄호_변환_함수_splitStr(p);
    }

    private String 괄호_변환_함수_splitStr(String p) {
        if ("".equals(p)) return "";

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int index = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                index++;
            } else {
                index--;
            }

            if (index == 0) {
                u.append(p, 0, i + 1);
                v.append(p, i + 1, p.length());
                break;
            }
        }

        if (괄호_변환_함수_check(u.toString())) {
            u.append(괄호_변환_함수_splitStr(v.toString()));
        } else {
            return "(" + 괄호_변환_함수_splitStr(v.toString()) + ")" + 괄호_변환_함수_reverseU(u.toString());
        }


        return u.toString();
    }

    private String 괄호_변환_함수_reverseU(String u) {
        StringBuilder target = new StringBuilder();
        target.append(u, 1, u.length() - 1);

        for (int i = 0; i < target.length(); i++) {
            if ("(".equals(target.substring(i, i + 1))) {
                target.replace(i, i + 1, ")");
            } else {
                target.replace(i, i + 1, "(");
            }
        }

        return target.toString();
    }

    private boolean 괄호_변환_함수_check(String p) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) return false;
            stack.pop();
        }

        return true;
    }
    // 2020 KAKAO BLIND RECRUITMENT - 괄호 변환 END

    // [1차] 뉴스 클러스터링 START
    @Test
    void 뉴스_클러스터링() {
//        System.out.println("16384 result: " + 뉴스_클러스터링_함수("FRANCE",	"french"));
//        System.out.println("65536 result: " + 뉴스_클러스터링_함수("handshake", "shake hands"));
//        System.out.println("43690 result: " + 뉴스_클러스터링_함수("aa1+aa2", "AAAA12"));
//        System.out.println("65536 result: " + 뉴스_클러스터링_함수("E=M*C^2", "e=m*c^2"));
//        System.out.println("0 result: " + 뉴스_클러스터링_함수("A+C", "DEF"));
        System.out.println("0 result: " + 뉴스_클러스터링_함수("DEF", "A+C"));
    }

    private int 뉴스_클러스터링_함수(String str1, String str2) {
        List<String> list1 = 뉴스_클러스터링_함수_divStr(str1.toLowerCase());
        List<String> list2 = 뉴스_클러스터링_함수_divStr(str2.toLowerCase());
        if (list1.size() == 0 && list2.size() == 0) return 65536;

        int intersectionCount = 0;
        for (String s1 : list1) {
            if (list2.contains(s1)) {
                intersectionCount++;
                list2.remove(s1);
            }
        }
        int unionCount = list1.size() + list2.size();

        return (int) (((double) intersectionCount / unionCount) * 65536);
    }

    private List<String> 뉴스_클러스터링_함수_divStr(String str) {
        List<String> divStrList = new ArrayList<>();
        String regEx = "^[a-zA-Z]*";
        for (int i = 0; i < str.length() - 1; i++) {
            String subStr = str.substring(i, i + 2);
            if (subStr.matches(regEx)) {
                divStrList.add(subStr);
            }
        }

        return divStrList;
    }
    // [1차] 뉴스 클러스터링 END

    // 탐욕법(Greedy) 조이스틱 START
    @Test
    void 조이스틱() {
        System.out.println("56: " + 조이스틱_함수("JEROEN"));
        //System.out.println("23: " + 조이스틱_함수("JAN"));
    }

    private int 조이스틱_함수(String name) {
        /**
         A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
         0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25

         Z  Y  X  W  V  U  T  S  R  Q  P  O  N  M  L  K  J  I  H  G  F  E  D  C  B  A
         0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
         */

        // 알파벳 맞추기 (위, 아래: A->Z 가능)
        // 커서 이동 방향 정하기
        // 커서 이동 - 재귀

        int i = 0;
        while (i != name.length()) {

        }
        char c = name.charAt(i);
        int result = findAlphabet(c);

        return 0;
    }

    private int findAlphabet(char c) {
        char compareC = 'A';
        if (c == compareC) return 0;

        char tempA = compareC;
        char tempB = 'Z';

        int count = 0;
        int compareInt = 1;
        while (true) {
            count++;
            if (c == (tempA + compareInt)) return count;
            if (c == (tempB - compareInt)) return count + 1;
            compareInt++;
        }
    }

    // 탐욕법(Greedy) 조이스틱 END

    // 2019 카카오 개발자 겨울 인턴십 - 튜플 START
    @Test
    void 튜플() {
//        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";	// [2, 1, 3, 4]
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";	// [2, 1, 3, 4]
//        String s = "{{20,111},{111}}";	// [111, 20]
//        String s = "{{123}}";	// [123]
//        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";	// [3, 2, 4, 1]
        for (int i : 튜플_함수(s)) {
            System.out.println("result: " + i);
        }
    }

    private int[] 튜플_함수(String s) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Arrays.stream(s.split("\\W"))
                .filter(str -> str.length() > 0)
                .mapToInt(Integer::parseInt)
                .forEach(i -> {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                });

        /*int[] answer = new int[map.size()];

        LinkedList<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, ((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            answer[i++] = entry.getKey();
        }

        return answer;*/

        return map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey).mapToInt(x -> x).toArray();
    }
    // 2019 카카오 개발자 겨울 인턴십 - 튜플 END

    // N개의 최소공배수 START
    @Test
    void N개의_최소공배수() {
        System.out.println("result: " + N개의_최소공배수_함수(new int[] {2,6,8,14}));
        //System.out.println("result: " + N개의_최소공배수_함수(new int[] {1,2,3}));
    }

    public int N개의_최소공배수_함수(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int answer = arr[length - 1];;

        int j = 2;
        for (int i = 0; i < length - 1; i++) {
            if (answer % arr[i] != 0) {
                i = -1;
                answer = arr[length - 1] * j++;
                continue;
            }
        }

        return answer;
    }

    // N개의 최소공배수 END


    // 2021 KAKAO BLIND RECRUITMENT - 메뉴 리뉴얼 START
    @Test
    void 메뉴_리뉴얼_재도전() {
        // ["AC", "ACDE", "BCFG", "CDE"]
        // AC 2
        //System.out.println("AC: 4, CDE: 3, BCFG: 2, ACDE: 2");
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        // ["ACD", "AD", "ADE", "CD", "XYZ"]
        //System.out.println("AD: 3, CD: 3, ACD: 2, ADE: 2, XYZ: 2");
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2, 3, 5};

        // ["WX", "XY"]
        //System.out.println("WX: 2, XY: 2");
//        String[] orders = {"XYZ", "XWY", "WXA"};
//        int[] course = {2, 3, 4};

        // ["AB"]
//        String[] orders = {
//                "ABCDE", "AB", "CDAB", "ABDE",
//                "XABYZ", "ABXYZ", "ABCD",
//                "ABCDE", "ABCDE", "ABCDE",
//                "AB", "AB", "AB", "AB", "AB",
//                "AB", "AB", "AB", "AB", "AB"
//        };
//        int[] course = {2};

        // ["ACD", "AD", "ADE", "CD", "XYZ"]
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2, 3};

        for (String i : 메뉴_리뉴얼_재도전_함수(orders, course)) System.out.println("result: " + i);
    }

    /*private String[] 메뉴_리뉴얼_재도전_함수(String[] orders, int[] course) {
        Arrays.sort(orders);
        Map<String, Integer> countWithAlphabet = new HashMap<>();
        Map<Integer, Integer> maxLengthWithCourse = new HashMap<>();
        for (int c : course) {
            maxLengthWithCourse.put(c, 0);
        }

        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            String tempOrder = String.valueOf(chars);
            메뉴_리뉴얼_재도전_함수(0, "", tempOrder, countWithAlphabet, maxLengthWithCourse);
        }

        List<String> results = new ArrayList<>();
        for (String key : countWithAlphabet.keySet()) {
            Integer maxLength = maxLengthWithCourse.get(key.length());
            if (maxLength < 2) continue;
            if (countWithAlphabet.get(key) == maxLength) {
                results.add(key);
            }
        }

        Collections.sort(results);
        return results.toArray(new String[results.size()]);

    }

    private void 메뉴_리뉴얼_재도전_함수(int index, String value, String order, Map<String, Integer> countWithAlphabet, Map<Integer, Integer> maxLengthWithCourse) {
        for (int i = index; i < order.length(); i++) {
            String temp = value + order.charAt(i);

            int tempLength = temp.length();
            if (tempLength >= 2) {
                if (!maxLengthWithCourse.containsKey(tempLength)) continue;

                int count = countWithAlphabet.getOrDefault(temp, 0) + 1;
                if (maxLengthWithCourse.get(tempLength) < count) {
                    maxLengthWithCourse.put(tempLength, Math.max(maxLengthWithCourse.get(tempLength), count));
                }

                countWithAlphabet.put(temp, count);
            }

            메뉴_리뉴얼_재도전_함수(i + 1, temp, order,countWithAlphabet, maxLengthWithCourse);
        }
    }*/

    int maxLength1 = 0;
    Map<String, Integer> countWithAlphabet = new HashMap<>();
    private String[] 메뉴_리뉴얼_재도전_함수(String[] orders, int[] course) {
        List<String> results = new ArrayList<>();
        for (int c : course) {
            maxLength1 = 0;
            countWithAlphabet.clear();

            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                String tempOrder = String.valueOf(chars);
                메뉴_리뉴얼_재도전_함수(c, 0, "", tempOrder);
            }

            LinkedHashMap<String, Integer> orderedMapWithKey = convertOrderedMap(countWithAlphabet);
            for (String key : orderedMapWithKey.keySet()) {
                Integer count = orderedMapWithKey.get(key);
                if (count < maxLength1 || count < 2) break;

                results.add(key);
            }
        }

        Collections.sort(results);
        return results.toArray(new String[results.size()]);
    }

    private LinkedHashMap<String, Integer> convertOrderedMap(Map<String, Integer> countWithAlphabet) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(countWithAlphabet.entrySet());
        entries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    private void 메뉴_리뉴얼_재도전_함수(int validLength, int index, String value, String order) {
        if (value.length() == validLength) return;
        for (int i = index; i < order.length(); i++) {
            String temp = value + order.charAt(i);
            int tempLength = temp.length();

            if (validLength == tempLength) {
                int count = countWithAlphabet.getOrDefault(temp, 0) + 1;
                maxLength1 = Math.max(count, maxLength1);
                countWithAlphabet.put(temp, count);
            }

            메뉴_리뉴얼_재도전_함수(validLength, i + 1, temp, order);
        }
    }

    // 2018 KAKAO BLIND RECRUITMENT [1차] 캐시 START
    @Test
    void 캐시() {
        //캐시크기(cacheSize)	도시이름(cities)	실행시간
        //50
//        int cacheSize = 3;
//        String[] cities = {
//            "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
//        };

        //21
//        int cacheSize = 3;
//        String[] cities = {
//            "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"
//        };

        //60
//        int cacheSize = 2;
//        String[] cities = {
//            "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
//        };

        //52
//        int cacheSize = 5;
//        String[] cities = {
//            "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
//        };

        // 16
//        int cacheSize = 2;
//        String[] cities = {
//            "Jeju", "Pangyo", "NewYork", "newyork"
//        };

        // 25
//        int cacheSize = 0;
//        String[] cities = {
//            "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
//        };

        // 11
//        int cacheSize = 3;
//        String[] cities = {
//            "A", "B", "A"
//        };

        // 10
        int cacheSize = 0;
        String[] cities = {
                "LA", "LA"
        };

        System.out.println("result: " + 캐시(cacheSize, cities));


    }

    private int 캐시(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;

        final int CACHE_HIT = 1;
        final int CACHE_MISS = 5;

        List<String> LRU = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();

            // if (LRU.contains(city)) { // indexOf 활용 가능
            if (LRU.indexOf(city) >= 0) {
                answer += CACHE_HIT;
                LRU.remove(city);
            } else {
                answer += CACHE_MISS;
                if (LRU.size() >= cacheSize) {
                    LRU.remove(0);
                }
            }

            LRU.add(city);
        }

        return answer;
    }
    // 2018 KAKAO BLIND RECRUITMENT [1차] 캐시 END

    // JadenCase 문자열 만들기 START

    @Test
    void JadenCase_문자열_만들기() {
        // "3people Unfollowed Me"
        System.out.println("result: " + JadenCase_문자열_만들기("3people unFollowed me"));
        // "For The Last Week"
        System.out.println("result: " + JadenCase_문자열_만들기("for the last week"));
        // A A A A A A A A A A
        System.out.println("result: " + JadenCase_문자열_만들기("a a a a a a a a a a "));
        // A A A A
        System.out.println("result: " + JadenCase_문자열_만들기("a   a   a a"));
    }

    private String JadenCase_문자열_만들기(String s) {
        StringBuilder answer = new StringBuilder();



        return "";
    }

    // JadenCase 문자열 만들기 END



    // 2021 KAKAO BLIND RECRUITMENT 순위 검색 START
    @Test
    void 순위검색() {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        for (int i : 순위검색(info, query)) {
            System.out.println("result: " + i);
        }
    }

    private int[] 순위검색(String[] info, String[] query) {
        int[] answer = new int[query.length];
        final String ALL_PERMIT = "-";

        Map<String, Integer> infoWithScore = new HashMap<>();
        for (String i : info) {
            int iScore = Integer.parseInt(i.substring(i.lastIndexOf(" ") + 1));
            infoWithScore.put(i, iScore);
        }

        List<String> sortedInfos = infoWithScore.keySet().stream()
            .sorted(((o1, o2) -> infoWithScore.get(o2).compareTo(infoWithScore.get(o1))))
            .collect(Collectors.toList());


        int j = 0;
        for (String q : query) {
            String[] qDiv = q.replaceAll("and ", "").split(" ");
            String qScoreStr = qDiv[qDiv.length - 1];
            String qLang = qDiv[0];
            String qPart = qDiv[1];
            String qCareer = qDiv[2];
            String qFood = qDiv[3];

            boolean isCheckLang = !ALL_PERMIT.equals(qLang);
            boolean isCheckPart = !ALL_PERMIT.equals(qPart);
            boolean isCheckCareer = !ALL_PERMIT.equals(qCareer);
            boolean isCheckFood = !ALL_PERMIT.equals(qFood);

            boolean isCheckScore = !ALL_PERMIT.equals(qScoreStr);
            int qScore = isCheckScore ? Integer.parseInt(qScoreStr) : 0;

            int count = 0;
            for (String i : sortedInfos) {
                if (isCheckScore) {
                    int iScore = Integer.parseInt(i.substring(i.lastIndexOf(" ") + 1));
                    if (iScore < qScore) break;

                    String[] iDiv = i.replaceAll("and ", "").split(" ");
                    String iLang = iDiv[0];
                    String iPart = iDiv[1];
                    String iCareer = iDiv[2];
                    String iFood = iDiv[3];

                    if (isCheckLang) {
                        if (!iLang.equals(qLang)) continue;
                    }
                    if (isCheckPart) {
                        if (!iPart.equals(qPart)) continue;
                    }
                    if (isCheckCareer) {
                        if (!iCareer.equals(qCareer)) continue;
                    }
                    if (isCheckFood) {
                        if (!iFood.equals(qFood)) continue;
                    }
                }
                count++;
            }
            answer[j++] = count;
        }

        return answer;
    }

    // 2021 KAKAO BLIND RECRUITMENT 순위 검색 END

    // 올바른 괄호 START
    @Test
    void 올바른_괄호() {
        // true
        System.out.println("result: " + 올바른_괄호("()()"));
        // true
        System.out.println("result: " + 올바른_괄호("(())()"));
        // false
        System.out.println("result: " + 올바른_괄호(")()("));
        // false
        System.out.println("result: " + 올바른_괄호("(()("));
    }

    private boolean 올바른_괄호(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
    // 올바른 괄호 END

    // Summer/Winter Coding(~2018) 영어 끝말잇기 RETRY START
    @Test
    void 영어_끝말잇기_RETRY() {
        String test = "testa";
        String peekEndStr = test.substring(test.length() - 1);
        System.out.println("test: " + peekEndStr);
        /*int n = 3;
        String[] words = {
                "tank", "kick", "know", "wheel",
                "land", "dream", "mother", "robot", "tank"
        };*/
        /*int n = 5;
        String[] words = {
                "hello", "observe", "effect", "take",
                "either", "recognize", "encourage", "ensure",
                "establish", "hang", "gather", "refer",
                "reference", "estimate", "executive"
        };*/
        int n = 2;
        String[] words = {
            "hello", "one", "even", "never",
            "now", "world", "draw"
        };

        for (int i : 영어_끝말잇기_RETRY_함수(n, words)) {
            System.out.println("result: " + i);
        }
    }

    private int[] 영어_끝말잇기_RETRY_함수(int n, String[] words) {
        int targetPersonNum = 1;
        int indexOrder = 1;

        Set<String> usedWords = new HashSet<>();
        boolean isWrong = false;
        char preLastChar = ' ';
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            usedWords.add(word);

            if (usedWords.size() != i + 1 || (preLastChar != ' ' && word.charAt(0) != preLastChar)) {
                isWrong = true;
                break;
            }

            preLastChar = word.charAt(word.length() - 1);

            targetPersonNum++;
            if (targetPersonNum > n) {
                targetPersonNum = 1;
                indexOrder++;
            }
        }

        return isWrong ? new int[] {targetPersonNum, indexOrder} : new int[] {0, 0};
    }
    // Summer/Winter Coding(~2018) 영어 끝말잇기 RETRY END

    // 완전탐색 카펫 START
    @Test
    void 카펫() {

        System.out.println("test12(4,3): " + Math.sqrt(12));
        System.out.println("test9(3,3): " + Math.sqrt(9));
        System.out.println("test48(8,6): " + Math.sqrt(48));
        System.out.println("test56(8,7): " + Math.sqrt(56));
        System.out.println("test28(7,4): " + Math.sqrt(28));
        System.out.println("test72(24,3): " + Math.sqrt(72));
        System.out.println("test25(5,5): " + Math.sqrt(25));
//        for (int result : 카펫(10, 2)) {
//            System.out.println("result [4, 3]: " + result);
//        }
//
//        for (int result : 카펫(8, 1)) {
//            System.out.println("result [3, 3]: " + result);
//        }
//
//        for (int result : 카펫(24, 24)) {
//            System.out.println("result [8, 6]: " + result);
//        }
//
//        for (int result : 카펫(26, 30)) {
//            System.out.println("result [8, 7]: " + result);
//        }
//
//        for (int result : 카펫(18, 10)) {
//            System.out.println("result [7, 4]: " + result);
//        }
//
//        for (int result : 카펫(50, 22)) {
//            System.out.println("result [24, 3]: " + result);
//        }
//
//        for (int result : 카펫(16, 9)) {
//            System.out.println("result [5, 5]: " + result);
//        }

    }

    public int[] 카펫(int brown, int yellow) {
        int total = brown + yellow;
        int width = 3;
        int height = 3;

        for (int i = width; i < total; i++) {
            if (total % i == 0) {
                width = total / i;
                height = i;

                if (yellow == (width - 2) * (height - 2)) {
                    break;
                }
            }
        }

        return new int[] {width, height};
    }
    // 완전탐색 카펫 END

    // 탐욕법(Greedy) - 구명보트 START
    @Test
    public void 구명보트() {
//        System.out.println("[3] result: " + 구명보트(new int[] {70, 50, 80, 50}, 100));
        System.out.println("[3] result: " + 구명보트(new int[] {70, 80, 60}, 100));
    }

    public int 구명보트(int[] people,
                    int limit) {
        Arrays.sort(people);
        int answer = 0;

        int lt = 0;
        int rt = people.length - 1;
        while (lt <= rt) {
            int lWeight = people[lt];
            int rWeight = people[rt];

            if (lWeight + rWeight > limit) {
                rt--;
            } else {
                lt++;
                rt--;
            }

            answer++;
        }

        return answer;
    }
    // 탐욕법(Greedy) - 구명보트 END

    // 2017 팁스타운 - 예상 대진표 START
    @Test
    void 예상_대진표() {
        System.out.println("[3]result: " + 예상_대진표(8, 4, 7));
    }

    public int 예상_대진표(int n,
                        int a,
                        int b) {
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
    // 2017 팁스타운 - 예상 대진표 END

    // 귤 고르기 START
    @Test
    void 귤_고르기() {
        System.out.println("[3]result: " + 귤_고르기(6, new int[] {1,3,2,5,4,5,2,3}));
//        System.out.println("[2]result: " + 귤_고르기(4, new int[] {1,3,2,5,4,5,2,3}));
//        System.out.println("[1]result: " + 귤_고르기(2, new int[] {1,1,1,1,2,2,2,3}));
    }

    public int 귤_고르기(int k,
                     int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            int number = tangerine[i];
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            Integer number = map.get(key);
            list.add(number);
        }

        list.sort(Comparator.reverseOrder());
        for (Integer quantity : list) {
            if (quantity > k) {
                break;
            }

            answer++;
            k -= quantity;
        }

        if (k > 0) {
            answer++;
        }

        return answer;
    }
    // 귤 고르기 END

    // 월간 코드 챌린지 시즌2 - 괄호 회전하기 START
    @Test
    void 괄호_회전하기() {
//        System.out.println("[3]result: " + 괄호_회전하기("[](){}"));
//        System.out.println("[2]result: " + 괄호_회전하기("}]()[{"));
//        System.out.println("[0]result: " + 괄호_회전하기("[)(]"));
//        System.out.println("[0]result: " + 괄호_회전하기("}}}"));
        System.out.println("[0]result: " + 괄호_회전하기("{(["));
    }
    public int 괄호_회전하기(String s) {
        int answer = 0;

        String rotateS = s;
        for (int i = 0; i < s.length(); i++) {
            rotateS = rotateS.substring(1) + rotateS.substring(0, 1);

            Stack<Character> stack = new Stack<>();
            boolean isOk = true;
            for (char c : rotateS.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                    continue;
                }

                if (stack.isEmpty()) {
                    isOk = false;
                    break;
                }

                Character popC = stack.pop();
                if (c == ')') {
                    if (popC != '(') {
                        isOk = false;
                        break;
                    }
                }

                if (c == '}') {
                    if (popC != '{') {
                        isOk = false;
                        break;
                    }
                }

                if (c == ']') {
                    if (popC != '[') {
                        isOk = false;
                        break;
                    }
                }
            }

            if (isOk && stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
    // 월간 코드 챌린지 시즌2 - 괄호 회전하기 END

    // 연속 부분 수열 합의 개수 START
    @Test
    void 연속_부분_수열_합의_개수() {
        System.out.println("[18] result: " + 연속_부분_수열_합의_개수(new int[] {7,9,1,1,4}));
    }

    public int 연속_부분_수열_합의_개수(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int eLength = elements.length;
        for (int i = 0; i < eLength; i++) {
            int tempI = i;
            int sum = 0;
            for (int j = 1; j <= eLength; j++) {
                sum += elements[tempI];
                tempI = tempI + 1 >= eLength ? 0 : tempI + 1;

                set.add(sum);
            }
        }

        return set.size();
    }
    // 연속 부분 수열 합의 개수 END

    // 할인 행사 START

    /**
     * 마트 -> 일정 금액 지불시 10일간 회원 자격 부여
     * 마트 -> 매일 한 가지 제품 할인 행사 -> 할인 제품은 하루에 하나씩 구매 가능
     * 이용자 -> 자신이 원하는 제품, 수량이 할인 날짜와 10일 연속 일치할 경우 회원가입
     *
     */
    @Test
    void 할인_행사() {
        System.out.println("[3] result: " + 할인_행사(new String[] {"banana", "apple", "rice", "pork", "pot"}, new int[] {3, 2, 2, 2, 1},	new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
//        System.out.println("[0] result: " + 할인_행사(new String[] {"apple"},	new int[] {10},	new String[] {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
//        System.out.println("[0] result: " + 할인_행사(new String[] {"apple"},	new int[] {10},	new String[] {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "apple"}));
//        System.out.println("[0] result: " + 할인_행사(new String[] {"apple"},	new int[] {10},	new String[] {"banana", "apple", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "apple"}));
//        System.out.println("[1] result: " + 할인_행사(new String[] {"banana", "apple"},	new int[] {9, 1},	new String[] {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "apple"}));
//        System.out.println("[3] result: " + 할인_행사(new String[] {"banana", "apple"},	new int[] {8, 2},	new String[] {"chicken", "rice", "apple", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "apple", "banana"}));
//        System.out.println("[0] result: " + 할인_행사(new String[] {"banana", "apple"},	new int[] {8, 2},	new String[] {"chicken", "rice", "apple", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "apple", "rice", "banana"}));
//        System.out.println("[0] result: " + 할인_행사(new String[] {"banana", "apple"},	new int[] {8, 2},	new String[] {"chicken", "rice", "apple", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "rice", "apple"}));
//        System.out.println("[0] result: " + 할인_행사(new String[] {"banana", "apple"},	new int[] {8, 2},	new String[] {"chicken", "rice", "apple", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "apple", "rice", "apple"}));
//        System.out.println("[0] result: " + 할인_행사(new String[] {"banana", "apple"},	new int[] {7, 3},	new String[] {"apple", "apple", "apple", "apple", "apple", "banana", "banana", "banana", "banana", "banana", "banana", "rice", "banana"}));
//        System.out.println("[11] result: " + 할인_행사(new String[] {"banana", "rice", "apple"},	new int[] {3, 4, 3},	new String[] {"apple", "apple", "apple", "apple", "apple", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "rice", "rice", "rice", "rice", "apple", "apple", "apple", "apple", "banana", "banana", "banana"}));
//        System.out.println("[1] result: " + 할인_행사(new String[] {"banana", "pot"},	new int[] {3, 7},	new String[] {"banana", "pot", "pot", "pot", "pot", "pot", "pot", "pot", "banana", "banana", "pot", "pot", "pot", "pot", "pot", "pot", "pot", "banana"}));
//        System.out.println("[9] result: " + 할인_행사(new String[] {"banana", "pot"},	new int[] {3, 7},	new String[] {"pot", "pot", "pot", "pot", "pot", "pot", "pot", "pot", "banana", "banana", "pot", "pot", "pot", "pot", "pot", "pot", "pot", "banana"}));
    }

    // 방법 1
    /*public int 할인_행사(String[] want,
                     int[] number,
                     String[] discount) {
        int answer = 0;

        Map<String, Integer> basket = new HashMap<>();
        int isNotClearCount = want.length;
        for (int i = 0; i < want.length; i++) {
            basket.put(want[i], number[i]);
        }

        int limitDay = 10;
        for (int i = 0; i < limitDay; i++) {
            String key = discount[i];
            Integer num = basket.get(key);

            if (num == null) {
                continue;
            }

            basket.put(key, basket.get(key) - 1);

            if (basket.get(key) == 0) {
                isNotClearCount--;
            }
        }

        if (isNotClearCount == 0) {
            answer++;
        }

        for (int i = limitDay; i < discount.length; i++) {
            String removeTargetKey = discount[i - limitDay];
            Integer removeTargetNum = basket.get(removeTargetKey);
            if (removeTargetNum != null) {
                int num = basket.get(removeTargetKey) + 1;
                basket.put(removeTargetKey, num);

                if (num == 1) {
                    isNotClearCount++;
                }
            }

            String key = discount[i];
            Integer num = basket.get(key);

            if (num == null) {
                continue;
            }

            basket.put(key, basket.get(key) - 1);

            if (basket.get(key) == 0) {
                isNotClearCount--;
            }

            if (isNotClearCount == 0) {
                answer++;
            }
        }

        return answer;
    }*/

    // 방법 2
    public int 할인_행사(String[] want,
                     int[] number,
                     String[] discount) {
        int answer = 0;

        int isClearKey = want.length;
        Map<String, Integer> basket = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            basket.put(want[i], number[i]);
        }

        int lt = 0;
        int rt = 0;
        while (rt < discount.length) {
            if (rt - lt >= 10) {
                String restoreTarget = discount[lt];
                Integer restoreNum = basket.get(restoreTarget);
                if (restoreNum != null) {
                    if (restoreNum == 0) {
                        isClearKey++;
                    }

                    basket.put(restoreTarget, basket.get(restoreTarget) + 1);
                }

                lt++;
            }

            String targetKey = discount[rt++];
            Integer targetNum = basket.get(targetKey);
            if (targetNum == null) {
                continue;
            }

            basket.put(targetKey, basket.getOrDefault(targetKey, 0) - 1);
            if (basket.get(targetKey) == 0) {
                isClearKey--;
            }

            if (isClearKey == 0) {
                answer++;
            }
        }

        return answer;
    }
    // 할인 행사 END

    @Test
    void k진수에서_소수_개수_구하기() {
        // n -> k 진수 변환 후 10진수 기준으로 소수인지 판단
        System.out.println("[3] result: " + k진수에서_소수_개수_구하기(437674, 3));
        //System.out.println("[2] result: " + k진수에서_소수_개수_구하기(110011, 10));

    }

    public int k진수에서_소수_개수_구하기(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n, k).replaceAll("(0{2,})", "0");
        List<Long> target = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int numberLeng = number.length();
        for (int i = 0; i < numberLeng; i++) {
            char c = number.charAt(i);

            if ((c == '0' && sb.length() > 0)) {
                target.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                continue;
            }
            if (c != '0') {
                sb.append(c);
                if (i == numberLeng - 1) {
                    target.add(Long.parseLong(sb.toString()));
                }
            }
        }

        for (Long num : target) {
            boolean isPrime = true;
            if (num == 1) {
                isPrime = false;
            } else if (num != 2) {
                for (int j = 2; j <= (int) Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                answer++;
            }
        }

        return answer;
    }

    // 2018 KAKAO BLIND RECRUITMENT - [3차] 압축 START
    @Test
    void 압축() {
        // [11, 1, 27, 15]
//        for (int a : 압축("KAKAO")) {
//            System.out.println("result = " + a);
//        }
        // [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        for (int a : 압축("TOBEORNOTTOBEORTOBEORNOT")) {
            System.out.println("result = " + a);
        }
        // [1, 2, 27, 29, 28, 31, 30]
//        for (int a : 압축("ABABABABABABABAB")) {
//            System.out.println("result = " + a);
//        }
    }

    public int[] 압축(String msg) {
        List<Integer> tempAnswer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int j = 1;
        for (int i = 65; i <= 90; i++) {
            String str = String.valueOf((char) i);
            map.put(str, j++);
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        Integer answer = null;
        while (i < msg.length()) {
            sb.append(msg.charAt(i));
            if (map.containsKey(sb.toString())) {
                answer = map.get(sb.toString());
                i++;
            } else {
                tempAnswer.add(answer);
                map.put(sb.toString(), map.size() + 1);
                sb.setLength(0);
            }
        }

        if (sb.length() > 0) {
            tempAnswer.add(answer);
        }

        int tSize = tempAnswer.size();
        int[] result = new int[tSize];
        for (int k = 0; k < tSize; k++) {
            result[k] = tempAnswer.get(k);
        }

        return result;
    }
    // 2018 KAKAO BLIND RECRUITMENT - [3차] 압축 END

    // 2018 KAKAO BLIND RECRUITMENT - [3차] n진수 게임 START
    @Test
    void n진수_게임() {
        System.out.println("[0111] result: " + n진수_게임(2, 4, 2, 1));
        System.out.println("[02468ACE11111111] result: " + n진수_게임(16, 16, 2, 1));
        System.out.println("[13579BDF01234567] result: " + n진수_게임(16, 16, 2, 2));
    }

    public String n진수_게임(int n,
                         int t,
                         int m,
                         int p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t * m; i++) {
            sb.append(Integer.toString(i, n).toUpperCase());
        }

        StringBuilder result = new StringBuilder();
        String sbStr = sb.toString();
        for (int i = p - 1; i < sbStr.length(); i += m) {
            if (result.length() >= t) {
                break;
            }
            result.append(sbStr.charAt(i));
        }

        return result.toString();
    }
    // 2018 KAKAO BLIND RECRUITMENT - [3차] n진수 게임 END

    // 2022 KAKAO BLIND RECRUITMENT - 주차 요금 계산 START
    @Test
    void 주차_요금_계산() {
        // result [14600, 34400, 5000]
        for (int s : 주차_요금_계산(new int[] {180, 5000, 10, 600}, new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})) {
            System.out.println("s = " + s);
        }
    }

    public int[] 주차_요금_계산(int[] fees, String[] records) {
        Map<String, Long> totalFeeWithId = new HashMap<>();
        Map<String, List<String>> groupWithId = new ConcurrentHashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            String id = record[1];

            List<String> group = groupWithId.getOrDefault(id, new ArrayList<>());
            group.add(records[i]);
            groupWithId.put(id, group);
        }

        for (String groupKey : groupWithId.keySet()) {
            boolean isOut = false;
            LocalTime startTime = null;
            LocalTime endTime = null;

            for (String recordInGroup : groupWithId.get(groupKey)) {
                String[] record = recordInGroup.split(" ");
                String time = record[0];
                String type = record[2];

                if ("IN".equals(type)) {
                    isOut = false;
                    startTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
                } else {
                    isOut = true;
                    endTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
                    totalFeeWithId.put(groupKey, totalFeeWithId.getOrDefault(groupKey, 0L) + Duration.between(startTime, endTime).getSeconds());
                }
            }

            if (!isOut) {
                endTime = LocalTime.parse("23:59", DateTimeFormatter.ofPattern("HH:mm"));
                totalFeeWithId.put(groupKey, totalFeeWithId.getOrDefault(groupKey, 0L) + Duration.between(startTime, endTime).getSeconds());
            }
        }

        List<String> list = new ArrayList<>(totalFeeWithId.keySet());
        Collections.sort(list);

        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        int[] answer = new int[list.size()];
        int i = 0;
        for (String key : list) {
            Long totalSeconds = totalFeeWithId.get(key);
            int useTime = (int) (totalSeconds / 60) - baseTime;
            if (useTime <= 0) {
                answer[i++] = baseFee;
                continue;
            }
            int calculateFee = baseFee + useTime / unitTime * unitFee;
            if (useTime % unitTime > 0) {
                calculateFee += unitFee;
            }

            answer[i++] = calculateFee;
        }

        return answer;
    }
    // 2022 KAKAO BLIND RECRUITMENT - 주차 요금 계산 END

    // 깊이/너비 우선 탐색(DFS/BFS) - 게임 맵 최단거리 START
    @Test
    void 게임_맵_최단거리() {
        System.out.println("[11] result: " + 게임_맵_최단거리(new int[][] {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        }));
        System.out.println("[-1] result: " + 게임_맵_최단거리(new int[][] {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}
        }));
    }

    public int 게임_맵_최단거리(int[][] maps) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int n = maps.length;
        int m = maps[0].length;
        int[][] ch = new int[n][m];
        int w = 0;
        int h = 0;

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{w, h});

        while (!que.isEmpty()) {
            int[] target = que.poll();

            int targetPrefix = target[0];
            int targetSuffix = target[1];
            int value = ch[targetPrefix][targetSuffix] + 1;

            for (int j = 0; j < dx.length; j++) {
                int tempW = targetPrefix + dx[j];
                int tempH = targetSuffix + dy[j];

                if (tempW < 0 || tempH < 0 || tempW >= n || tempH >= m || maps[tempW][tempH] == 0) {
                    continue;
                }

                if (ch[tempW][tempH] == 0 || ch[tempW][tempH] > value) {
                    que.offer(new int[] {tempW, tempH});
                    ch[tempW][tempH] = value;
                    maps[tempW][tempH] = 0;
                }
            }
        }


        return ch[n - 1][m - 1] == 0 ? -1 : ch[n - 1][m - 1] + 1;
    }


    // 깊이/너비 우선 탐색(DFS/BFS) - 게임 맵 최단거리 END

    // 완전탐색 모음사전 START
    boolean is_모음사전 = false;
    int 모음사전_result = 0;
    @Test
    void 모음사전() {
//        System.out.println("[6] result: " + 모음사전("AAAAE"));
//        System.out.println("[10] result: " + 모음사전("AAAE"));
//        System.out.println("[1563] result: " + 모음사전("I"));
        System.out.println("[1189] result: " + 모음사전("EIO"));
    }

    public int 모음사전(String word) {
        final String AEIOU = "AEIOU";

        모음사전("", 0, word, AEIOU);

        return 모음사전_result;
    }

    public void 모음사전(String target,
                      int idx,
                      String word,
                      String AEIOU) {
        if (is_모음사전) {
            return;
        }

        if (target.equals(word)) {
            is_모음사전 = true;
            return;
        }

        if (target.length() >= AEIOU.length()) {
            return;
        }

        for (int i = 0; i < AEIOU.length(); i++) {
            String newTarget = target + AEIOU.charAt(i);
            모음사전_result++;
            모음사전(newTarget, i, word, AEIOU);
            if (is_모음사전) {
                break;
            }
        }
    }
    // 완전탐색 모음사전 END

    // 2018 KAKAO BLIND RECRUITMENT - [3차] 파일명 정렬 START
    @Test
    void 파일명_정렬() {
        // result: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
//        for (String a : 파일명_정렬(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})) {
//            System.out.println(a + " ");
//        }
//        System.out.println();

        //result: ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
//        for (String b : 파일명_정렬(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})) {
//            System.out.println(b + " ");
//        }
//        System.out.println();

//        for (String b : 파일명_정렬(new String[] {"A-10 23", "A-10 21", "C-1 3", "A-10 10", "A-9 101"})) {
//            System.out.println(b + " ");
//        }
//        System.out.println();

        for (String b : 파일명_정렬(new String[] {"A-10 abc", "A-10 abc", "C-1 abc", "A-10 abc", "A-9 abc"})) {
            System.out.println(b + " ");
        }

    }
    /*public String[] 파일명_정렬(String[] files) {

        int fLength = files.length;
        String[] answer = new String[fLength];

        List<String> orderedFiles = Arrays.stream(files)
                .sorted((f1, f2) -> {
                    String HEAD1 = f1.split("[0-9]")[0];
                    String HEAD2 = f2.split("[0-9]")[0];

                    int compareHead = HEAD1.compareToIgnoreCase(HEAD2);
                    if (compareHead == 0) {
                        StringBuilder n1 = new StringBuilder();
                        StringBuilder n2 = new StringBuilder();
                        for (int i = HEAD1.length(); i < f1.length(); i++) {
                            char c = f1.charAt(i);
                            if (!Character.isDigit(c)) {
                                break;
                            }
                            n1.append(c);
                        }

                        for (int i = HEAD2.length(); i < f2.length(); i++) {
                            char c = f2.charAt(i);
                            if (!Character.isDigit(c)) {
                                break;
                            }
                            n2.append(c);
                        }

                        String NUMBER1 = n1.toString();
                        String NUMBER2 = n2.toString();

                        return Integer.parseInt(NUMBER1) - Integer.parseInt(NUMBER2);
                    } else {
                        return compareHead;
                    }
                })
                .collect(Collectors.toList());

        for (int i = 0; i < fLength; i++) {
            answer[i] = orderedFiles.get(i);
        }

        return answer;
    }*/
    // 리팩토링
    public String[] 파일명_정렬(String[] files) {
        Pattern p = Pattern.compile("([a-zA-Z\\s.-]+)([0-9]{1,5})");
        return Arrays.stream(files)
                .sorted((f1, f2) -> {
                    Matcher m1 = p.matcher(f1);
                    Matcher m2 = p.matcher(f2);
                    m1.find();
                    m2.find();

                    String HEAD1 = m1.group(1);
                    String HEAD2 = m2.group(1);

                    int compareHead = HEAD1.compareToIgnoreCase(HEAD2);
                    if (compareHead == 0) {
                        String NUMBER1 = m1.group(2);
                        String NUMBER2 = m2.group(2);

                        return Integer.parseInt(NUMBER1) - Integer.parseInt(NUMBER2);
                    } else {
                        return compareHead;
                    }
                })
                .toArray(String[]::new);
    }
    // 2018 KAKAO BLIND RECRUITMENT - [3차] 파일명 정렬 END

    // 2018 KAKAO BLIND RECRUITMENT [1차] 프렌즈4블록 START
    @Test
    void 프렌즈4블록() {
//        int m = 4;
//        int n = 5;
//        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
//        System.out.println("result[14]: " + 프렌즈4블록(m, n, board));
        System.out.println();
//        int m = 6;
//        int n = 6;
//        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
//        System.out.println("result[15]: " + 프렌즈4블록(m, n, board));
        System.out.println();
//        int m = 7;
//        int n = 2;
//        String[] board = {"AA", "BB", "AA", "BB", "ZZ", "ZZ", "CC"};
//        System.out.println("result[4]: " + 프렌즈4블록(m, n, board));
        System.out.println();
//        int m = 4;
//        int n = 5;
//        String[] board = {"AAAAA","AUUUA","AUUAA","AAAAA"};
//        System.out.println("result[14]: " + 프렌즈4블록(m, n, board));
        System.out.println();
//        int m = 4;
//        int n = 4;
//        String[] board = {"ABCD", "BACE", "BCDD", "BCDD"};
//        System.out.println("result[8]: " + 프렌즈4블록(m, n, board));
        System.out.println();
//        int m = 5;
//        int n = 6;
//        String[] board = {"AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"};
//        System.out.println("result[24]: " + 프렌즈4블록(m, n, board));
        System.out.println();
//        int m = 6;
//        int n = 6;
//        String[] board = {"AABBEE", "AAAEEE", "VAAEEV", "AABBEE", "AACCEE", "VVCCEE"};
//        System.out.println("result[32]: " + 프렌즈4블록(m, n, board));


//        int m = 4; int n = 5;  String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
//        System.out.println("result[14]: " +  프렌즈4블록(m, n , board));

//        int m = 6; int n = 6;  String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
//        System.out.println("result[15]: " +  프렌즈4블록(m, n , board));

//        int m = 6; int n = 6;  String[] board = {"OXXOXX", "OXXXXX", "OOXXXX", "OXXOXX", "OXXXXX", "OOXXXX"};
//        System.out.println("result[30]: " +  프렌즈4블록(m, n , board));


//        int m = 6; int n = 6;  String[] board = {"AABBEE","AAAEEE","VAAEEV","AABBEE","AACCEE","VVCCEE"};
//        System.out.println("result[32]: " +  프렌즈4블록(m, n , board));


        System.out.println("result[4]: " +  프렌즈4블록(3,2, new String[]{"AA", "AA", "AB"})) ;
        System.out.println("result[8]: " +  프렌즈4블록(4,2, new String[]{"CC", "AA", "AA", "CC"}) )  ;
        System.out.println("result[12]: " +  프렌즈4블록(6,2, new String[]{"DD", "CC", "AA", "AA", "CC", "DD"}));
        System.out.println("result[8]: " +  프렌즈4블록(8,2, new String[]{"FF", "AA", "CC", "AA", "AA", "CC", "DD", "FF"}) );
        System.out.println("result[8]: " +  프렌즈4블록(6,2, new String[]{"AA", "AA", "CC", "AA", "AA", "DD"})) ;
        System.out.println("result[4]: " +  프렌즈4블록(2,2, new String[]{"AA", "AA"}) ) ;
        System.out.println("result[0]: " +  프렌즈4블록(2,2, new String[]{"AA", "AB"})) ;
        System.out.println("result[4?]: " +  프렌즈4블록(8,5, new String[]{"HGNHU", "CRSHV", "UKHVL", "MJHQB", "GSHOT", "MQMJJ", "AGJKK", "QULKK"})) ;
        System.out.println("result[20]: " +  프렌즈4블록(6,5, new String[]{
                "AANAA",
                "CCMCC",
                "CCNAA",
                "AAMAA",
                "GSNCC",
                "AANAA"})) ;
        System.out.println("result[8]: " +  프렌즈4블록(6,5, new String[]{
                "AANQW",
                "CCMWE",
                "CCAQW",
                "CAACA",
                "GSCWQ",
                "AANQW"})) ;
        System.out.println("result[20]: " +  프렌즈4블록(7,5, new String[]{
                "CAACC",
                "ACACC",
                "AAABA",
                "AAACA",
                "CAACC",
                "CCCWQ",
                "AANQW"})) ;
        System.out.println("result[11]: " +  프렌즈4블록(5,5, new String[]{
                "ABBBA",
                "AAACA",
                "CAAAC",
                "CBAAQ",
                "ABBQW"})) ;
        System.out.println("result[13]: " +  프렌즈4블록(6,5, new String[]{
                "ABBBA",
                "ABBBA",
                "AAACA",
                "CAAAC",
                "CBAAQ",
                "ABBQW"})) ;
        System.out.println("result[13]: " +  프렌즈4블록(6,5, new String[]{
                "ACBBB",
                "ABBCB",
                "AAACA",
                "CAABC",
                "CAABQ",
                "ABBQW"})) ;
        System.out.println("result[20]: " +  프렌즈4블록(6,5, new String[]{
                "ABBBB",
                "AAAAA",
                "AAAAA",
                "CBBBB",
                "CAABB",
                "ABBBB"})) ;
        System.out.println("result[21]: " +  프렌즈4블록(6,5, new String[]{
                "BAAAA",
                "AABAA",
                "AAAAA",
                "AAAAA",
                "AAABA",
                "AABAB"})) ;
        System.out.println("result[21]: " +  프렌즈4블록(6,5, new String[]{
                "ABABA",
                "ABABA",
                "ABABA",
                "BAAAB",
                "BAAAB",
                "BAAAB"})) ;

        System.out.println("result[32]: " +  프렌즈4블록(6,6, new String[]{"AABBEE","AAAEEE","VAAEEV","AABBEE","AACCEE","VVCCEE" })) ;
    }

    public int 프렌즈4블록(int m,
                      int n,
                      String[] board) {
        int[][] checkDirArr = {
                {0, 1},
                {1, 1},
                {1, 0}
        };

        boolean[][] countCheck = new boolean[m][n];
        String[][] block = new String[m][n];
        for (int i = 0; i < board.length; i++) {
            String b = board[i];
            for (int j = 0; j < b.length(); j++) {
                block[i][j] = String.valueOf(b.charAt(j));
            }
        }

        return 프렌즈4블록_DFS(block, countCheck, checkDirArr);
    }

    private int 프렌즈4블록_DFS(String[][] block,
                           boolean[][] countCheck,
                           int[][] checkDirArr) {
        boolean hasAtLeastOne;
        int count = 0;

        do {
            hasAtLeastOne = false;
            for (int i = 0; i < block.length - 1; i++) {
                for (int j = 0; j < block[i].length - 1; j++) {
                    boolean isMatch = true;
                    if (block[i][j] == null) continue;

                    for (int k = 0; k < checkDirArr.length; k++) {
                        if (!block[i][j].equals(block[i + checkDirArr[k][0]][j + checkDirArr[k][1]])) {
                            isMatch = false;
                            break;
                        }
                    }

                    if (isMatch) {
                        hasAtLeastOne = true;

                        countCheck[i][j] = true;
                        for (int k = 0; k < checkDirArr.length; k++) {
                            countCheck[i + checkDirArr[k][0]][j + checkDirArr[k][1]] = true;
                        }
                    }
                }
            }

            if (hasAtLeastOne) {
                for (int i = 0; i < countCheck[0].length; i++) {
                    for (int j = countCheck.length - 1; j >= 0; j--) {
                        int tempJ = j;
                        if (countCheck[j][i]) {
                            countCheck[j][i] = false;
                            block[j][i] = null;
                            count++;
                        }

                        if (countCheck[j][i] || block[j][i] == null) {
                            while (--tempJ >= 0) {
                                if (block[tempJ][i] != null && !countCheck[tempJ][i]) {
                                    block[j][i] = block[tempJ][i];
                                    block[tempJ][i] = null;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } while (hasAtLeastOne);

        return count;
    }
    // 2018 KAKAO BLIND RECRUITMENT [1차] 프렌즈4블록 END

    // 롤케이크 자르기 START
    @Test
    void 롤케이크_자르기() {
        System.out.println("result[2]: " + 롤케이크_자르기(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println("result[0]: " + 롤케이크_자르기(new int[]{1, 2, 3, 1, 4}));
    }

    public int 롤케이크_자르기(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            int t = topping[i];
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            int t = topping[i];
            set.add(t);

            Integer value = map.get(t);
            if (value != null) {
                if (value == 1) {
                    map.remove(t);
                } else {
                    map.put(t, map.get(t) - 1);
                }
            }

            if (set.size() == map.size()) {
                answer++;
            }
        }

        return answer;
    }
    // 롤케이크 자르기 END

    // 2 x n 타일링 START
    @Test
    void 타일링() {
        System.out.println("result[5]: " + 타일링_ASDASD(4));
        //System.out.println("result[5]: " + 타일링_ASDASD(3));
    }

    public int 타일링_ASDASD(int n) {
        int[] ch = new int[n];
        ch[0] = 1;
        ch[1] = 2;

        for (int i = 2; i < n; i++) {
            ch[i] = (ch[i - 2] + ch[i - 1]) % 1000000007;
        }

        return ch[ch.length - 1];
    }

    /*public int 타일링(int n) {
        return 타일링_DFS(n, 0);
    }

    public int 타일링_DFS(int n,
                       int idx) {
        if (idx > n) {
            return 0;
        }

        if (idx == n) {
            return 1;
        }

        return (타일링_DFS(n, idx + 1) + 타일링_DFS(n, idx + 2)) % 1000000007;
    }*/
    // 2 x n 타일링 END

    // 택배상자 START
    @Test
    void 택배상자() {
        System.out.println("result[2]: " + 택배상자(new int[] {4, 3, 1, 2, 5}));
        System.out.println("result[5]: " + 택배상자(new int[] {5, 4, 3, 2, 1}));
    }

    public int 택배상자(int[] order) {
        int answer = 0;

        int n = order.length;

        Stack<Integer> stack = new Stack<>();

        int j = 1;
        int i = 0;
        for (; i < n; i++) {
            int box = order[i];

            if (!stack.isEmpty()) {
                if (stack.peek() == box) {
                    answer++;
                    stack.pop();
                    continue;
                }
            }

            while (j <= n) {
                if (box == j) {
                    j++;
                    answer++;
                    break;
                }

                stack.push(j);
                j++;
            }

            if (j > n) {
                i++;
                break;
            }
        }

        while (!stack.isEmpty()) {
            Integer ii = stack.pop();
            if (i >= n || order[i] != ii) {
                break;
            }
            i++;
            answer++;
        }

        return answer;
    }
    // 택배상자 END

    // 월간 코드 챌린지 시즌2- 2개 이하로 다른 비트 START
    @Test
    void 두개_이하로_다른_비트() {
        for (long a : 두개_이하로_다른_비트(new long[] {2, 7})) {System.out.println("[3, 11] " + a);}
        System.out.println();
        for (long a : 두개_이하로_다른_비트(new long[] {10, 21})) {System.out.println("[11, 22] " + a);}
        System.out.println();
        for (long a : 두개_이하로_다른_비트(new long[] {11, 14})) {System.out.println("[13, 15] " + a);}
        System.out.println();
        for (long a : 두개_이하로_다른_비트(new long[] {15, 22})) {System.out.println("[23, 23] " + a);}
        System.out.println();
        for (long a : 두개_이하로_다른_비트(new long[] {0, 43})) {System.out.println("[1, 45] " + a);}
        System.out.println();
    }

    public long[] 두개_이하로_다른_비트(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binaryStr = Long.toBinaryString(numbers[i]);
            int bStrLeng = binaryStr.length();
            if (binaryStr.charAt(bStrLeng - 1) == '0') {
                answer[i] = Long.parseLong(binaryStr.substring(0, bStrLeng - 1) + "1", 2);
                continue;
            }

            if (!binaryStr.contains("0")) {
                answer[i] = Long.parseLong("1" + binaryStr.replaceFirst("1", "0"), 2);
                continue;
            }


            Stack<Character> stack = new Stack<>();
            boolean isZero = false;
            for (int j = bStrLeng - 1; j >= 0; j--) {
                char c = binaryStr.charAt(j);

                if (c == '0' && !isZero) {
                    isZero = true;
                    stack.pop();
                    stack.push('0');
                    stack.push('1');
                } else {
                    stack.push(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            answer[i] = Long.valueOf(Long.parseLong(sb.toString(), 2));
        }

        return answer;
    }
    // 월간 코드 챌린지 시즌2- 2개 이하로 다른 비트 END

    // 정렬 - H-Index START
    @Test
    void H_INDEX() {
        System.out.println("result[3]: " + H_INDEX(new int[] {3, 0, 6, 1, 5}));
        // 6,5,3,1,0, n = 5
        System.out.println("result[0]: " + H_INDEX(new int[] {0, 0, 0}));
        System.out.println("result[2]: " + H_INDEX(new int[] {22, 42}));
        // 42, 22, n = 2

        System.out.println("result[4]: " + H_INDEX(new int[] {5, 5, 5, 5}));
        System.out.println("result[2]: " + H_INDEX(new int[] {3, 4}));
        System.out.println("result[4]: " + H_INDEX(new int[] {6, 5, 5, 5, 3, 2, 1, 0}));
        System.out.println("result[4]: " + H_INDEX(new int[] {0, 5, 6, 7, 8}));
        // 8, 7, 6, 5, 0, n = 5
    }

    public int H_INDEX(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        int cLength = citations.length;

        int rank = 0;
        for (int i = cLength - 1; i >= 0; i--) {
            rank++;
            int citation = citations[i];
            if (rank == citation) {
                return citation;
            }

            if (citation >= rank) {
                answer = Math.max(rank, answer);
            }

        }

        return answer;
    }
    // 정렬 - H-Index END

    // 정렬 - 가장 큰 수 START
    @Test
    void 가장_큰_수() {
        /*
        o1과 o2를 문자열 형태로 번갈아서 더한 후 더 큰 값을 체크하면 됐는데, 꽤 늦게 인지했다.
        o1과 o2를 각 각 비교해서 더 복잡한 형태로 고민을 하다보니 시간이 조금 걸렸다.
        문제의 핵심을 조금 더 파악할 필요가 있을 것 같다.
         */
        System.out.println("6210 result: " + 가장_큰_수_함수(new int[]{6, 10, 2}));
        System.out.println("9534330 result: " + 가장_큰_수_함수(new int[]{3, 30, 34, 5, 9}));
        System.out.println("0 result: " + 가장_큰_수_함수(new int[]{0, 0, 0}));
    }


    private String 가장_큰_수_함수(int[] numbers) {
        List<String> collect = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.toList());

        String result = collect.stream().collect(Collectors.joining());
        if ('0' == result.charAt(0)) {
            return "0";
        }
        return result;
    }
    // 정렬 - 가장 큰 수 END

    // 숫자 변환하기 START
    @Test
    void 숫자_변환하기() {
        System.out.println("result[2]: " + 숫자_변환하기(10, 40, 5));
//        System.out.println("result[1]: " + 숫자_변환하기(10, 40, 30));
//        System.out.println("result[-1]: " + 숫자_변환하기(2, 5, 4));
    }

    public int 숫자_변환하기(int x, int y, int n) {
        if (x == y) return 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(x);

        Map<Integer, Integer> map = new HashMap<>();

        int cnt = 0;
        while (!que.isEmpty()) {
            cnt++;
            int size = que.size();

            for (int i = 0; i < size; i++) {
                Integer number = que.poll();

                int plusN = number + n;
                if (plusN == y) {
                    return cnt;
                }

                int multiTwo = number * 2;
                if (multiTwo == y) {
                    return cnt;
                }

                int multiThree = number * 3;
                if (multiThree == y) {
                    return cnt;
                }

                if (plusN < y && map.get(plusN) == null) {
                    map.put(plusN, plusN);
                    que.add(plusN);
                }

                if (multiTwo < y && map.get(multiTwo) == null) {
                    map.put(multiTwo, multiTwo);
                    que.add(multiTwo);
                }

                if (multiThree < y && map.get(multiThree) == null) {
                    map.put(multiThree, multiThree);
                    que.add(multiThree);
                }
            }
        }

        return -1;
    }

    // 숫자 변환하기 END

    // 월간 코드 챌린지 시즌3 - n^2 배열 자르기 START
    @Test
    void n_제곱_배열_자르기() {
//        System.out.println("[3,2,2,3] result");
//        for (int i : n_제곱_배열_자르기(3, 2, 5)) {
//            System.out.println(i + " ");
//        }
//        System.out.println();

        System.out.println("[4,3,3,3,4,4,4,4] result");
        for (int i : n_제곱_배열_자르기(4, 7, 14)) {
            System.out.println(i + " ");
        }
//        System.out.println();

//        System.out.println("[2, 2] result");
//        for (int i : n_제곱_배열_자르기(3, 3, 4)) {
//            System.out.println(i + " ");
//        }
//        System.out.println();

//        for (int i : n_제곱_배열_자르기(10000000, 99999999999L, 99999999999L)) {
//            System.out.println(i + " ");
//        }
//        System.out.println();

    }

    public int[] n_제곱_배열_자르기(int n,
                                long left,
                                long right) {
        int[] answer = new int[(int) (right - left) + 1];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            long height = i / n;
            long width = i % n;

            answer[idx++] = (int) Math.max(height, width) + 1;
        }

        return answer;
    }
    // 월간 코드 챌린지 시즌3 - n^2 배열 자르기 END

    // 뒤에 있는 큰 수 찾기 START
    @Test
    void 뒤에_있는_큰_수_찾기() {
        /**
         * 2, 3, 3, 5
         *
         */
        // result : [3, 5, 5, -1]
        for (int i : 뒤에_있는_큰_수_찾기(new int[]{2, 3, 3, 5})) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println();
        // result : [-1, 5, 6, 6, -1, -1]
//        for (int i : 뒤에_있는_큰_수_찾기(new int[] {9, 1, 5, 3, 6, 2})) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
    }

    public int[] 뒤에_있는_큰_수_찾기(int[] numbers) {
        int numLength = numbers.length;
        int[] answer = new int[numLength];

        Stack<Integer> stack = new Stack<>();


        for (int i = numLength - 1; i >= 0; i--) {
            int targetNum = numbers[i];

            while (!stack.isEmpty()) {
                if (stack.peek() <= targetNum) {
                    stack.pop();
                } else {
                    answer[i] = stack.peek();
                    break;
                }
            }

            stack.push(targetNum);
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }

        return answer;
    }
    // 뒤에 있는 큰 수 찾기 END

    // 완전탐색 소수 찾기 START
    @Test
    void 소수_찾기() {
//        System.out.println("[3] result: " + 소수_찾기("17"));
        System.out.println("[2] result: " + 소수_찾기("011"));
    }

    private int 소수_찾기(String numbers) {
        Set<Integer> savePrime = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        소수_찾기_DFS("", visited, savePrime, numbers);

        return savePrime.size();
    }

    private void 소수_찾기_DFS(String targetStr,
                           boolean[] visited,
                           Set<Integer> savePrime,
                           String numbers) {
        if (!소수_찾기_availableVisit(visited)) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            String appendStr = targetStr + numbers.charAt(i);
            if (소수_찾기_isPrime(appendStr)) {
                savePrime.add(Integer.parseInt(appendStr));
            }

            소수_찾기_DFS(appendStr, visited, savePrime, numbers);
            visited[i] = false;
        }



    }

    private boolean 소수_찾기_isPrime(String numStr) {
        int num = Integer.parseInt(numStr);

        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private boolean 소수_찾기_availableVisit(boolean[] visited) {
        for (boolean visit : visited) {
            if (!visit) {
                return true;
            }
        }

        return false;
    }
    // 완전탐색 소수 찾기 END

    // 월간 코드 챌린지 시즌1 - 쿼드압축 후 개수 세기 START
    @Test
    void 쿼드압축_후_개수_세기() {
        /*int[][] arr = new int[][] {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };*/

        int[][] arr = new int[][] {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
        };


        // result [4,9]
        for (int i : 쿼드압축_후_개수_세기(arr)) {
            System.out.println("result: " + i);
        }
    }

    int zero = 0;
    int one = 0;
    public int[] 쿼드압축_후_개수_세기(int[][] arr) {
        int arrLength = arr.length;
        쿼드압축_후_개수_세기_DFS(0, 0, arrLength, arr);

        return new int[] {zero, one};
    }

    private void 쿼드압축_후_개수_세기_DFS(int i, int j, int arrLength, int[][] arr) {
        if (arrLength <= 0) {
            return;
        }

        int targetNum = arr[i][j];
        if (isAllMatch(i, j, arrLength, arr, targetNum)) {
            if (targetNum == 1) {
                one++;
                return;
            }

            zero++;
            return;
        }

        int divArrLength = arrLength / 2;
        쿼드압축_후_개수_세기_DFS(i, j, divArrLength, arr);
        쿼드압축_후_개수_세기_DFS(i, j + divArrLength, divArrLength, arr);
        쿼드압축_후_개수_세기_DFS(i + divArrLength, j, divArrLength, arr);
        쿼드압축_후_개수_세기_DFS(i + divArrLength, j + divArrLength, divArrLength, arr);
    }

    private boolean isAllMatch(int i, int j, int arrLength, int[][] arr, int targetNum) {
        for (int tempI = 0; tempI < arrLength; tempI++) {
            for (int tempJ = 0; tempJ < arrLength; tempJ++) {
                if (arr[tempI + i][tempJ + j] != targetNum) {
                    return false;
                }
            }
        }

        return true;
    }
    // 월간 코드 챌린지 시즌1 - 쿼드압축 후 개수 세기 END

    // 2022 KAKAO TECH INTERNSHIP - 두 큐 합 같게 만들기 START
    @Test
    void 두_큐_합_같게_만들기() {
        System.out.println("[2] result: " + 두_큐_합_같게_만들기(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println("[7] result: " + 두_큐_합_같게_만들기(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println("[-1] result: " + 두_큐_합_같게_만들기(new int[]{1, 1}, new int[]{1, 5}));
        System.out.println("[-1] result: " + 두_큐_합_같게_만들기(new int[]{1, 4}, new int[]{3, 4}));
        System.out.println("[-1] result: " + 두_큐_합_같게_만들기(new int[]{101, 100}, new int[]{102, 103}));
    }

    public int 두_큐_합_같게_만들기(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            int queVal1 = queue1[i];
            int queVal2 = queue2[i];
            sum1 += queVal1;
            sum2 += queVal2;

            que1.add(queVal1);
            que2.add(queVal2);
        }

        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        int answer = 0;

        long limitLength = queue1.length * 4;
        int i = 0;
        while(sum1 != sum2) {
            i++;
            answer++;
            if (sum1 > sum2) {
                Integer que1Poll = que1.poll();
                sum1 -= que1Poll;
                sum2 += que1Poll;
                que2.add(que1Poll);
            } else {
                Integer que2Poll = que2.poll();
                sum2 -= que2Poll;
                sum1 += que2Poll;
                que1.add(que2Poll);
            }

            if (que1.isEmpty() || que2.isEmpty() || i >= limitLength) {
                return -1;
            }
        }

        return answer;
    }
    // 2022 KAKAO TECH INTERNSHIP - 두 큐 합 같게 만들기 END

    // 탐욕법(Greedy) - 큰 수 만들기 START
    @Test
    void 큰_수_만들기() {
        System.out.println("[94] result: " + 큰_수_만들기("1924", 2));
        System.out.println("[3234] result: " + 큰_수_만들기("1231234", 3));
        System.out.println("[775841] result: " + 큰_수_만들기("4177252841", 4));
        System.out.println("[99] result: " + 큰_수_만들기("999", 1));
//        System.out.println("[9] result: " + 큰_수_만들기("91", 1));
//        System.out.println("[333] result: " + 큰_수_만들기("333222111", 6));
//        System.out.println("[3332221] result: " + 큰_수_만들기("333222111", 2));
//        System.out.println("[234567890123456789012345678901234567890] result: " + 큰_수_만들기("1234567890123456789012345678901234567890", 1));
//        System.out.println("[1] result: " + 큰_수_만들기("111", 2));
//        System.out.println("[11] result: " + 큰_수_만들기("111", 1));
//        System.out.println("[89781299] result: " + 큰_수_만들기("3879781299", 2));
//        System.out.println("[999] result: " + 큰_수_만들기("9999", 1));
//        System.out.println("[99] result: " + 큰_수_만들기("9999", 2));
//        System.out.println("[9] result: " + 큰_수_만들기("9999", 3));
//        System.out.println("[9] result: " + 큰_수_만들기("89", 1));
//        System.out.println("[8] result: " + 큰_수_만들기("87", 1));
//        System.out.println("[7] result: " + 큰_수_만들기("77", 1));
//        System.out.println("[988] result: " + 큰_수_만들기("928857", 3));
//        System.out.println("[99] result: " + 큰_수_만들기("99991", 3));
//        System.out.println("[11] result: " + 큰_수_만들기("10001", 3));
//        System.out.println("[1] result: " + 큰_수_만들기("10001", 4));
//        System.out.println("[101] result: " + 큰_수_만들기("10001", 2));
//        System.out.println("[1001] result: " + 큰_수_만들기("10001", 1));
//        System.out.println("[999] result: " + 큰_수_만들기("98989", 2));
//        System.out.println("[9989] result: " + 큰_수_만들기("98989", 1));
//        System.out.println("[99] result: " + 큰_수_만들기("98989", 3));
//        System.out.println("[11011] result: " + 큰_수_만들기("101011", 1));
//        System.out.println("[1111] result: " + 큰_수_만들기("101011", 2));
//        System.out.println("[1000] result: " + 큰_수_만들기("100000", 2));
//        System.out.println("[11111] result: " + 큰_수_만들기("111110", 1));
//        System.out.println("[11111] result: " + 큰_수_만들기("111101", 1));
//        System.out.println("[11111] result: " + 큰_수_만들기("111011", 1));
//        System.out.println("[11111] result: " + 큰_수_만들기("110111", 1));
//        System.out.println("[11111] result: " + 큰_수_만들기("101111", 1));
//        System.out.println("[11111] result: " + 큰_수_만들기("011111", 1));
//        System.out.println("[987654] result: " + 큰_수_만들기("9876543214", 4));
//        System.out.println("[900002] result: " + 큰_수_만들기("190000002", 3));
//        System.out.println("[6543] result: " + 큰_수_만들기("654312", 2));
//        System.out.println("[7378] result: " + 큰_수_만들기("720378", 2));
    }

    public String 큰_수_만들기(String number, int k) {
        String answer = "";

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while (!stack.isEmpty() && k != 0) {
                if (stack.peek() >= c) break;

                stack.pop();
                k--;
            }

            stack.push(c);
        }

        int count = number.length() - k;
        for (Character c : stack) {
            answer += c;
            count--;
            if (count <= 0) break;
        }

        return answer;
    }
    // 탐욕법(Greedy) - 큰 수 만들기 END

    // 연속된 부분 수열의 합 START
    @Test
    void 연속된_부분_수열의_합() {
        // [2, 3]
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;

        /*int[] sequence = {2, 2, 2, 2, 2, 10, 10, 10, 10, 10, 10};
        int k = 30;*/

        // [6, 6]
        int[] sequence1 = {1, 1, 1, 2, 3, 4, 5};
        int k1 = 5;

        // [0, 2]
        int[] sequence2 = {2, 2, 2, 2, 2};
        int k2 = 6;

        for (int i : 연속된_부분_수열의_합(sequence, k)) {
            System.out.println(i);
        }
    }

    public int[] 연속된_부분_수열의_합(int[] sequence, int k) {
        int answerLt = 0;
        int answerRt = sequence.length - 1;

        int lt = 0;
        int rt = 0;

        int sum = 0;
        for (; rt < sequence.length; rt++) {
            sum += sequence[rt];

            if (sum == k) {
                if (lt == rt) {
                    answerLt = lt;
                    answerRt = rt;
                    break;
                }

                if (rt - lt < answerRt - answerLt) {
                    answerRt = rt;
                    answerLt = lt;
                }
            }

            while (sum >= k && lt <= rt) {
                sum -= sequence[lt++];

                if (sum == k) {
                    if (lt == rt) {
                        answerLt = lt;
                        answerRt = rt;
                        return new int[] {answerLt, answerRt};
                    }

                    if (rt - lt < answerRt - answerLt) {
                        answerLt = lt;
                        answerRt = rt;
                        break;
                    }
                }
            }
        }

        return new int[] {answerLt, answerRt};
    }
    // 연속된 부분 수열의 합 END

    // 124 나라의 숫자 START
    @Test
    void 일이사_나라의_숫자() {
//        System.out.println("[1] result : " + 일이사_나라의_숫자(1));
//        System.out.println("[2] result : " + 일이사_나라의_숫자(2));
//        System.out.println("[4] result : " + 일이사_나라의_숫자(3));
//        System.out.println("[11] result : " + 일이사_나라의_숫자(4));
//        System.out.println("[12] result : " + 일이사_나라의_숫자(5));
//        System.out.println("[14] result : " + 일이사_나라의_숫자(6));
//        System.out.println("[21] result : " + 일이사_나라의_숫자(7));
//        System.out.println("[22] result : " + 일이사_나라의_숫자(8));
//        System.out.println("[24] result : " + 일이사_나라의_숫자(9));
//        System.out.println("[41] result : " + 일이사_나라의_숫자(10));
        System.out.println("[114] result : " + 일이사_나라의_숫자(15));

//        System.out.println("[14] result : " + 일이사_나라의_숫자(6));
//        System.out.println("[24] result : " + 일이사_나라의_숫자(9));
//        System.out.println("[41] result : " + 일이사_나라의_숫자(10));
    }

    public String 일이사_나라의_숫자(int n) {
        if (n < 3) {
            return n + "";
        }

        StringBuilder sb = new StringBuilder();
        while (n / 3 > 0 || n % 3 != 0) {
            int nmg = n % 3;
            n = n / 3;

            if (nmg == 0) {
                n--;
                sb.insert(0, "4");
            } else {
                sb.insert(0, nmg);
            }
        }

        return sb.toString();
    }
    // 124 나라의 숫자 END

    // 완전탐색 전력망을 둘로 나누기 START
    @Test
    void 전력망을_둘로_나누기() {
//        System.out.println("[3] result: " + 전력망을_둘로_나누기(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
//        System.out.println("[0] result: " + 전력망을_둘로_나누기(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
//        System.out.println("[1] result: " + 전력망을_둘로_나누기(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
        System.out.println("[0] result: " + 전력망을_둘로_나누기(4, new int[][]{{1, 2}, {3, 4}, {2, 4}}));
    }

    public int 전력망을_둘로_나누기(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;

        List<List<Integer>> repo = 전력망을_둘로_나누기_extracted(n, wires);
        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            int lt = wire[0];
            int rt = wire[1];

            int result = 전력망을_둘로_나누기_DFS(lt, rt, repo);
            result = Math.max(n - result, result) - Math.min(n - result, result);
            min = Math.min(min, result);
        }

        return min;
    }

    private int 전력망을_둘로_나누기_DFS(int no, int go, List<List<Integer>> repo) {

        int result = 0;
        for (Integer value : repo.get(go)) {
            if (no == value) {
                result++;
                continue;
            }
            result += 전력망을_둘로_나누기_DFS(go, value, repo);
        }

        return result;
    }


    private List<List<Integer>> 전력망을_둘로_나누기_extracted(int n, int[][] wires) {
        List<List<Integer>> repo = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            repo.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            int lt = wire[0];
            int rt = wire[1];

            repo.get(lt).add(rt);
            repo.get(rt).add(lt);
        }

        return repo;
    }
    // 완전탐색 전력망을 둘로 나누기 END

    // 마법의 엘리베이터 START
    @Test
    void 마법의_엘리베이터() {
        System.out.println("[6] result: " + 마법의_엘리베이터(16));
        System.out.println("[16] result: " + 마법의_엘리베이터(2554));
        System.out.println("[14] result: " + 마법의_엘리베이터(545));
        System.out.println("[14] result: " + 마법의_엘리베이터(555));
        System.out.println("[11] result: " + 마법의_엘리베이터(485));
        System.out.println("[11] result: " + 마법의_엘리베이터(155));
        System.out.println("[10] result: " + 마법의_엘리베이터(154));
        System.out.println("[9] result: " + 마법의_엘리베이터(45));
        System.out.println("[2] result: " + 마법의_엘리베이터(999));
        System.out.println("[2] result: " + 마법의_엘리베이터(99));
        System.out.println("[6] result: " + 마법의_엘리베이터(95));
        System.out.println("[2] result: " + 마법의_엘리베이터(9));
        System.out.println("[8] result: " + 마법의_엘리베이터(678));
        System.out.println("[1] result: " + 마법의_엘리베이터(1000));
        System.out.println("[9] result: " + 마법의_엘리베이터(56));
        System.out.println("[9] result: " + 마법의_엘리베이터(46));
        System.out.println("[11] result: " + 마법의_엘리베이터(155));
        System.out.println("[10] result: " + 마법의_엘리베이터(55));
        System.out.println("[8] result: " + 마법의_엘리베이터(75));
        System.out.println("[14] result: " + 마법의_엘리베이터(555));
        System.out.println("[22] result: " + 마법의_엘리베이터(123456789));
        System.out.println("[6] result: " + 마법의_엘리베이터(95));
        System.out.println("[9] result: " + 마법의_엘리베이터(45));
        System.out.println("[18] result: " + 마법의_엘리베이터(5454));
        System.out.println("[17] result: " + 마법의_엘리베이터(5654));
        System.out.println("[18] result: " + 마법의_엘리베이터(5555));
        System.out.println("[9] result: " + 마법의_엘리베이터(65));
        System.out.println("[8] result: " + 마법의_엘리베이터(75));
        System.out.println("[9] result: " + 마법의_엘리베이터(54));
        System.out.println("[9] result: " + 마법의_엘리베이터(56));
        System.out.println("[26] result: " + 마법의_엘리베이터(57595358));
        // 57595358
        // 8 5 3 5 9 5 7 5
        // 2 4 4 5 0 4 2 4 1 -> 15, 11
    }

    public int 마법의_엘리베이터(int storey) {
        int answer = 0;

        while (storey > 0) {
            int nmg = storey % 10;
            storey = storey / 10;

            if (5 < nmg || 5 == nmg && 5 <= storey % 10) {
                answer += 10 - nmg;
                storey++;
                continue;
            }

            answer += nmg;
        }

        return answer;
    }

    /*성공
    public int 마법의_엘리베이터(int storey) {
        int answer = 0;

        Queue<Integer> que = new LinkedList<>();
        while (storey > 0) {
            que.add(storey % 10);
            storey = storey / 10;
        }

        Integer num = que.poll();
        boolean isPlus = false;
        while (!que.isEmpty()) {
            Integer nextNum = que.poll();
            if (isPlus) {
                num++;
                if (num == 10) {
                    num = nextNum;
                    continue;
                }
                isPlus = false;
            }

            if (nextNum >= 5) {
                if (num >= 5) {
                    answer += 10 - num;
                    isPlus = true;
                } else {
                    if (num > 5) {
                        answer += 10 - num;
                        isPlus = true;
                    } else {
                        answer += num;
                    }
                }
            } else {
                if (num > 5) {
                    answer += 10 - num;
                    isPlus = true;
                } else {
                    answer += num;
                }
            }

            num = nextNum;
        }

        if (isPlus) {
            num++;
        }

        if (num > 5) {
            if (10 - num == 0) {
                answer++;
            } else {
                answer += 10 - num + 1;
            }
        } else {
            answer += num;
        }

        return answer;
    }*/
    // 마법의 엘리베이터 END

    // 호텔 대실 START
    @Test
    public void 호텔_대실() {
        System.out.println("[3] result: " + 호텔_대실(new String[][]{
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"}}));
        System.out.println("[1] result: " + 호텔_대실(new String[][]{
                {"09:10", "10:10"},
                {"10:20", "12:20"}}));
        System.out.println("[3] result: " + 호텔_대실(new String[][]{
                {"10:20", "12:30"},
                {"10:20", "12:30"},
                {"10:20", "12:30"}}));
        System.out.println("[2] result: " + 호텔_대실(new String[][]{
                {"00:01", "00:10"},
                {"00:19", "00:29"}}));
        System.out.println("[2] result: " + 호텔_대실(new String[][]{
                {"08:00", "08:30"},
                {"08:00", "13:00"},
                {"12:30", "13:30"}}));
        System.out.println("[1] result: " + 호텔_대실(new String[][]{
                {"16:00", "16:10"},
                {"16:20", "16:30"},
                {"16:40", "16:50"}}));
        System.out.println("[1] result: " + 호텔_대실(new String[][]{
                {"09:10", "10:10"},
                {"10:20", "12:20"},
                {"12:30", "13:20"}}));
        System.out.println("[1] result: " + 호텔_대실(new String[][]{
                {"10:00", "10:10"}}));
    }

    public int 호텔_대실(String[][] book_time) {
        int answer = 0;

        Arrays.sort(book_time,
                Comparator.comparing((String[] o1) -> o1[0])
                        .thenComparing(o1 -> o1[1])
        );

        List<Integer> roomEndTime = new ArrayList<>();
        for (int i = 0; i < book_time.length; i++) {
            int startT = 호텔_대실_convertInt(book_time[i][0]);
            int endT = 호텔_대실_convertInt(book_time[i][1]) + 10;

            List<Integer> removeIdx = new ArrayList<>();
            for (int j = 0; j < roomEndTime.size(); j++) {
                int endTime = roomEndTime.get(j);
                if (endTime <= startT) {
                    removeIdx.add(j);
                }
            }
            removeIdx.sort(Comparator.reverseOrder());
            for (int idx : removeIdx) {
                roomEndTime.remove(idx);
            }

            roomEndTime.add(endT);
            if (answer < roomEndTime.size()) {
                answer = roomEndTime.size();
            }
        }

        return answer;
    }

    private int 호텔_대실_convertInt(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]) * 60;
        int m = Integer.parseInt(t[1]);

        return h + m;
    }
    // 호텔 대실 END

    // 시소 짝궁 START
    @Test
    public void 시소_짝꿍() {
        System.out.println("[4] result: " + 시소_짝꿍(new int[]{100, 180, 360, 100, 270}));
        System.out.println("[7] result: " + 시소_짝꿍(new int[]{100, 50, 100, 150, 300, 25}));
        System.out.println("[4] result: " + 시소_짝꿍(new int[]{100, 50, 150, 300, 25}));
        System.out.println("[3] result: " + 시소_짝꿍(new int[]{200, 300, 300}));
        System.out.println("[1] result: " + 시소_짝꿍(new int[]{101, 202}));
        System.out.println("[0] result: " + 시소_짝꿍(new int[]{100, 300}));
        System.out.println("[3] result: " + 시소_짝꿍(new int[]{100, 100, 100}));
    }

    public long 시소_짝꿍(int[] weights) {
        long answer = 0;

        Map<Long, Long> x1 = new HashMap<>();
        Map<Long, Long> x234 = new HashMap<>();
        for (long weight : weights) {
            long w1 = weight;
            long w2 = weight * 2;
            long w3 = weight * 3;
            long w4 = weight * 4;

            x1.put(w1, x1.getOrDefault(w1, 0L) + 1);
            x234.put(w2, x234.getOrDefault(w2, 0L) + 1);
            x234.put(w3, x234.getOrDefault(w3, 0L) + 1);
            x234.put(w4, x234.getOrDefault(w4, 0L) + 1);

            long x1Cnt = x1.get(w1) - 1;
            answer += x1Cnt;
            answer += x234.get(w2) - x1Cnt - 1;
            answer += x234.get(w3) - x1Cnt - 1;
            answer += x234.get(w4) - x1Cnt - 1;
        }

        return answer;
    }
    // 시소 짝궁 END


    @DisplayName("테스트를 위한 테스트")
    @Test
    void test() throws Exception {
//        int[] A = {1, 3, 6, 4, 1, 2};
//        int[] A = {1, 2, 3};
        int[] A = {-1, -3};

        Arrays.sort(A);

        /*int num = 1;
        int i = 0;
        while (i < A.length) {
            if (A[i] < num) {
                i++;
                continue;
            }
            if (A[i] != num) {
                break;
            }
            num++;
            i++;
        }*/

        int num = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < num) continue;
            if (A[i] == num) num++;      // 예상 값과 일치하면 다음 수로 이동
            else break;                  // 건너뛰는 순간 num이 정답
        }

        System.out.println(num);
    }

    // 2025 프로그래머스 코드챌린지 2차 예선 - 서버 증설 횟수 START
    @Test
    void 서버_증설_횟수() throws Exception {
        // result 7
        int m = 3;
        int k = 5;
        int[] players = {
            0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5
        };
        System.out.println(서버_증설_횟수(players, m, k));

        // result 11
        /*int m = 5;
        int k = 1;
        int[] players = {
            0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0
        };*/

        // result 12
        /*int m = 1;
        int k = 1;
        int[] players = {
            0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1
        };*/
    }

    public int 서버_증설_횟수(int[] players,
                        int m,
                        int k) {
        int answer = 0;
        Queue<Integer> serverStore = new LinkedList<>();

        for (int playerCnt : players) {
            if (playerCnt >= m) {
                int requireServerCnt = playerCnt / m;
                while (requireServerCnt > serverStore.size()) {
                    serverStore.add(k);
                    answer++;
                }
            }

            int serverStoreSize = serverStore.size();
            for (int i = 0; i < serverStoreSize; i++) {
                Integer server = serverStore.poll() - 1;
                if (server > 0) {
                    serverStore.add(server);
                }
            }
        }

        return answer;
    }
    // 2025 프로그래머스 코드챌린지 2차 예선 - 서버 증설 횟수 END

    // 숫자 카드 나누기 START
    @Test
    void 숫자_카드_나누기() {
        // BASIC TEST CASE
//        int[] arrayA = new int[]{10, 17};
//        int[] arrayB = new int[]{5, 20};
//        System.out.println("[0]result: " + 숫자_카드_나누기(arrayA, arrayB));
//        int[] arrayA = new int[]{10, 20};
//        int[] arrayB = new int[]{5, 17};
//        System.out.println("[10]result: " + 숫자_카드_나누기(arrayA, arrayB));
//        int[] arrayA = new int[]{14, 35, 119};
//        int[] arrayB = new int[]{18, 30, 102};
//        System.out.println("[7]result: " + 숫자_카드_나누기(arrayA, arrayB));
        // TEST CASE
        int[] arrayA = new int[]{6, 15};
        int[] arrayB = new int[]{9, 15};
        System.out.println("[7]result: " + 숫자_카드_나누기(arrayA, arrayB));


    }

    public int 숫자_카드_나누기(int[] arrayA, int[] arrayB) {
        int size = arrayA.length;
        int aGcd = arrayA[0];
        int bGcd = arrayB[0];
        for (int i = 1; i < size; i++) {
            aGcd = getGcd(aGcd, arrayA[i]);
            bGcd = getGcd(bGcd, arrayB[i]);
        }

        if (aGcd == 1 && bGcd == 1) return 0;
        if (aGcd > bGcd) {
            for (int num : arrayB) {
                if (num % aGcd == 0) {
                    return 0;
                }
            }
            return aGcd;
        }

        for (int num : arrayA) {
            if (num % bGcd == 0) {
                return 0;
            }
        }
        return bGcd;
    }


    public int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }
    // 숫자 카드 나누기 END

    // 미로 탈출 START
    @Test
    void 미로_탈출() throws Exception {
//        String[] maps = new String[] {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
//        System.out.println("[16] result : " + 미로_탈출(maps));

        String[] maps = new String[] {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
        System.out.println("[-1] result : " + 미로_탈출(maps));

//        String[] maps = new String[] {"SOEOL", "XXXXX", "XXXXX", "XXXXX", "OOOOO"};
//        System.out.println("[6] result : " + 미로_탈출(maps));
//


    }

    public int 미로_탈출(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        Map<String, int[]> mazeInfo = new HashMap<>();
        String[][] maze = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                String value = maps[i].charAt(j) + "";
                maze[i][j] = value;
                if ("S".equals(value) || "L".equals(value) || "E".equals(value)) {
                    mazeInfo.put(value, new int[] {i, j});
                }
            }
        }

        int answer = 0;
        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        boolean isOnLever = false;

        Queue<int[]> que = new LinkedList();
        int[] start = mazeInfo.get("S");
        que.add(start);
        maze[start[0]][start[1]] = "C";

        while (!que.isEmpty()) {
            answer++;
            int qSize = que.size();
            for (int i = 0; i < qSize; i++) {
                int[] poll = que.poll();
                int x = poll[0];
                int y = poll[1];

                for (int j = 0; j < dx.length; j++) {
                    int tempX = x + dx[j];
                    int tempY = y + dy[j];
                    if (!미로_탈출_isAvailableNumber(tempX, tempY, maze)) {
                        continue;
                    }

                    if (isOnLever) {
                        if (미로_탈출_isMatch("E", mazeInfo, tempX, tempY)) {
                            return answer;
                        }

                        maze[tempX][tempY] = "X";
                    } else {
                        if ("C".equals(maze[tempX][tempY])) {
                            continue;
                        }

                        if (미로_탈출_isMatch("L" ,mazeInfo, tempX, tempY)) {
                            isOnLever = true;
                            que.clear();
                            que.add(new int[]{tempX, tempY});
                            qSize = 0;
                            break;
                        }

                        if (!미로_탈출_isMatch("E", mazeInfo, tempX, tempY)) {
                            maze[tempX][tempY] = "C";
                        }
                    }

                    que.add(new int[] {tempX, tempY});
                }
            }
        }

        return -1;
    }

    private boolean 미로_탈출_isMatch(String type, Map<String, int[]> mazeInfo, int x, int y) {
        int[] target = mazeInfo.get(type);
        if (target == null) return false;

        return target[0] == x && target[1] == y;
    }

    private boolean 미로_탈출_isAvailableNumber(int x, int y, String[][] maze) {
        return x >= 0 && x < maze.length
                && y >= 0 && y < maze[0].length
                && !"X".equals(maze[x][y]);
    }
    // 미로 탈출 END

    // Summer/Winter Coding(~2018) - 배달 START
    @DisplayName("")
    @Test
    void 배달() throws Exception {
        int[][] road1 = new int[][] {
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}
        };
        System.out.println("[4] result: " + 배달(5, road1, 3));

        /*int[][] road2 = new int[][] {
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 2},
                {3, 4, 3},
                {3, 5, 2},
                {3, 5, 3},
                {5, 6, 1}
        };
        System.out.println("[4] result: " + 배달(6, road2, 4));*/
    }

    public int 배달(int N, int[][] road, int K) {
        List<List<배달_edge>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] nums : road) {
            list.get(nums[0]).add(new 배달_edge(nums[1], nums[2]));
            list.get(nums[1]).add(new 배달_edge(nums[0], nums[2]));
        }

        int answer = 0;
        int[] arr = new int[N + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;
        PriorityQueue<배달_edge> pq = new PriorityQueue<>();
        pq.offer(new 배달_edge(1, 0));

        while (!pq.isEmpty()) {
            배달_edge parentEdge = pq.poll();

            for (배달_edge edge : list.get(parentEdge.vex)) {
                int sumCost = arr[parentEdge.vex] + edge.cost;
                if (arr[edge.vex] <= sumCost) continue;
                pq.offer(edge);

                arr[edge.vex] = sumCost;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= K) answer++;
        }
        return answer;
    }

    class 배달_edge implements Comparable<배달_edge> {
        int vex;
        int cost;

        public 배달_edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(배달_edge o) {
            return this.cost - o.cost;
        }
    }
    // Summer/Winter Coding(~2018) - 배달 END

    // 2018 KAKAO BLIND RECRUITMENT - [3차] 방금그곡 START
    @Test
    void 방금그곡_3차() throws Exception {
//        String m = "ABCDEFG";
//        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//        System.out.println("[HELLO] result: " + 방금그곡_3차(m, musicinfos));
//        String m = "CC#BCC#BCC#BCC#B";
//        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
//        System.out.println("[FOO] result: " + 방금그곡_3차(m, musicinfos));
//        String m = "ABC";
//        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//        System.out.println("[WORLD] result: " + 방금그곡_3차(m, musicinfos));
          String m = "ABCABC";
        String[] musicinfos = {"12:00,12:10,HI,ABC", "12:30,12:39,BYE,ABC", "12:50,13:00,BYE,ABC"};
        System.out.println("[BYE] result: " + 방금그곡_3차(m, musicinfos));

    }

    public String 방금그곡_3차(String m, String[] musicinfos) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        m = 방금그곡_3차_replace(m);
        String answer = "";
        for (int i = 0; i < musicinfos.length; i++) {
//            String musicinfo = musicinfos[i];
            String musicinfo = musicinfos[i];

            String[] split = musicinfo.split(",");
            int sTime = 방금그곡_3차_getMinutes(split[0]);
            int eTime = 방금그곡_3차_getMinutes(split[1]);
            int n = eTime - sTime;
            String title = split[2];
            String content = 방금그곡_3차_replace(split[3]);

            StringBuilder sb = new StringBuilder();
            int j = 0;
            for (int count = 0; count < n; count++) {
                if (j >= content.length()) j = 0;
                sb.append(content.charAt(j++));
            }

            int indexOf = sb.toString().indexOf(m);
            if (indexOf < 0) {
                continue;
            }
            pq.offer(new int[] {i, n});
        }

        if (pq.isEmpty()) return "(None)";

        int[] poll = pq.poll();
        return musicinfos[poll[0]].split(",")[2];
    }

    private String 방금그곡_3차_replace(String musicinfo) {
        return musicinfo
                .replaceAll("A#", "Z")
                .replaceAll("B#", "Y")
                .replaceAll("C#", "X")
                .replaceAll("D#", "J")
                .replaceAll("E#", "K")
                .replaceAll("F#", "L")
                .replaceAll("G#", "M");
    }

    private int 방금그곡_3차_getMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    // 2018 KAKAO BLIND RECRUITMENT - [3차] 방금그곡 END

}























