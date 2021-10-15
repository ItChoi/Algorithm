package study.algorithm.programmers;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 프로그래머스 알고리즘 문제 2레벨을 풀어보자.
 */
public class Level2 {

    // 스택/큐 - 주식가격 start
    @Test
    public void 주식가격() {
        int[] prices = {1,2,3,2,3};
        for (int price : 주식가격_함수(prices)) {
            System.out.println("result: " + price);
        }
    }

    private int[] 주식가격_함수(int[] prices) {
        int[] answer = new int [prices.length];

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
            for (int j = 0 ; j < numbers.length; j++) {
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

        String s = "abccbaf";	//1
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

            while (sum >= n && (sum + rt) >- n) {
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
        for(int i=1; i<land.length; i++){
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][1], land[i-1][0]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][0]);
        }

        int[] answer = land[land.length-1];
        Arrays.sort(answer);

        return answer[answer.length-1];
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
        System.out.println("result: false " + 전화번호_목록_함수(new String[] {"119", "97674223", "1195524421"}));
        System.out.println("result: true " + 전화번호_목록_함수(new String[] {"123","456","789"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[] {"12","123","1235","567","88"}));
        System.out.println("result: true " + 전화번호_목록_함수(new String[] {"1234", "1235", "567"}));
        System.out.println("result: true " + 전화번호_목록_함수(new String[] {"2", "32"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[] {"11", "22", "33", "44", "123", "345", "12345", "4567", "34566"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[] {"11", "22", "33", "44", "345", "12345", "4567", "34566"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[] {"34566789", "11", "22", "33", "44", "345667", "345", "12345", "4567", "34566"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[] {"34566789", "11", "22", "33", "44", "345667", "12345", "4567", "34566"}));
        System.out.println("result: false " + 전화번호_목록_함수(new String[] {"34566789", "345667"}));
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
        int[][] queries = new int[][] {
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
        /*String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};*/

        // ["ACD", "AD", "ADE", "CD", "XYZ"]
        /**
         * ad 3
         * cd 3
         * acd 2
         * ade 2
         * xyz 2
         */
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};

        // ["WX", "XY"]
        /*String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};*/

        for (String i : 메뉴_리뉴얼_함수(orders, course)) System.out.println("result: " + i);
    }

    private String[] 메뉴_리뉴얼_함수(String[] orders, int[] course) {
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
                    if (isExists && targetMenu.equals(createSetMenu)) continue;
                    setMenu.put(createSetMenu, setMenu.getOrDefault(createSetMenu, 1) + 1);
                }
            }
        }

        int i = 0;
        for (String key : setMenu.keySet()) {
            System.out.println(++i + ": key: " + key + ", val: " + setMenu.get(key));
        }


        return null;
    }
    // 2021 KAKAO BLIND RECRUITMENT - 메뉴 리뉴얼 END

}



























