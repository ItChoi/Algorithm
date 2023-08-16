package study.algorithm;

import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class AllTest {

    @Test
    void 테스트1_달팽이() {
        int n = 6;
        int length = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int limitN = n - 1;
        int[][] squre = new int[n][n];

        int number = 1;
        for (int i = 0; i < length; i++) {
            squre[i][i] = number++;

            int lt = i;
            int rt = i;

            while ((lt != i + 1 || rt != i) && number <= n * n) {
                if (lt <= rt && rt != limitN) {
                    rt++;
                } else if (rt == limitN && lt < limitN) {
                    lt++;
                } else if (lt == limitN && rt > i) {
                    rt--;
                } else if (rt == i) {
                    lt--;
                }
                squre[lt][rt] = number++;
            }

            limitN--;
        }


        for (int[] i : squre) {
            for (int j : i) {
                System.out.printf("%2d ", j);
            }
            System.out.println();
        }
    }

    @Test
    void 문제1() {
        System.out.println("[true] result: " + 문제1(4,4,0,2,1,2));
        System.out.println("[true] result: " + 문제1(3,3,3,2,2,2));
        System.out.println("[false] result: " + 문제1(2,2,1,1,1,2));
    }

    public boolean 문제1(int a, int b, int c, int d, int e, int f) {
        boolean answer = true;

        int availableCount = 0;
        int bufferA = a - d;
        boolean isOkA = bufferA > 0;
        if (bufferA > 1) {
            int divideCount = bufferA / 2;
            if (divideCount > 0) {
                availableCount += divideCount;
                bufferA = bufferA % 2;
            }
        }

        int bufferB = b - e;
        boolean isOkB = bufferB > 0;
        if (bufferB > 1) {
            int divideCount = bufferB / 2;
            if (divideCount > 0) {
                availableCount += divideCount;
                bufferB = bufferB % 2;
            }
        }

        int bufferC = c - f;
        boolean isOkC = bufferC > 0;
        if (bufferC > 1) {
            int divideCount = bufferC / 2;
            if (divideCount > 0) {
                availableCount += divideCount;
                bufferC = bufferC % 2;
            }
        }

        if (isOkA && isOkB && isOkC) {
            return true;
        }

        if (!isOkA && !isOkB && !isOkC) {
            return false;
        }

        if (!isOkA) {
            while (availableCount > 0 || bufferA < 0) {
                bufferA++;
                availableCount--;
            }

            if (bufferA != 0) {
                return false;
            }
        }

        if (!isOkB) {
            while (availableCount > 0 || bufferB < 0) {
                bufferB++;
                availableCount--;
            }

            if (bufferB != 0) {
                return false;
            }
        }

        if (!isOkC) {
            while (availableCount > 0 && bufferC < 0) {
                bufferC++;
                availableCount--;
            }

            if (bufferC != 0) {
                return false;
            }
        }

        return answer;
    }

    @Test
    void 문제2() {
        System.out.println("[2] result: " +
                solution2(new int[][] {{1,3}, {3,1}, {3,5}, {2,5}, {5,3}})
        );
    }

    public int solution2(int[][] p) {
        int answer = 0;

        Map<Integer, List<Integer>> likesWithA = new HashMap<>();

        for (int i = 0; i < p.length; i++) {
            int a = p[i][0];

            List<Integer> likes = likesWithA.getOrDefault(a, new ArrayList<>());
            likes.add(p[i][1]);
            likesWithA.put(a, likes);
        }

        for (Integer keyA : likesWithA.keySet()) {
            List<Integer> aLikes = likesWithA.get(keyA);
            for (Integer like : aLikes) {
                List<Integer> integers = likesWithA.get(like);

                if (integers != null) {
                    if (integers.contains(keyA)) {
                        integers.remove(keyA);
                        aLikes.remove(keyA);
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    @Test
    void 문제3() {
        System.out.println("[1] result: " + solution(new String[] {"U", "R", "D", "L", "U", "R", "D", "L"}));
        System.out.println("[5] result: " + solution(new String[] {"U", "U", "R", "D", "L", "L", "L", "U", "R", "D", "D", "D", "L", "U", "R", "R", "R", "D", "L", "U"}));
        System.out.println("[1] result: " + solution(new String[] {"U", "L", "D", "R", "R", "D", "D", "L", "U", "U"}));
    }

    public int solution(String[] moves) {
        int answer = 0;

        String[] moveStr = {"U", "R", "D", "L"};
        int[] movepoInt1 = {-1, 0, 1, 0};
        int[] movepoInt2 = {0, 1, 0, -1};

        int mLength = moves.length;

        boolean[][] board = new boolean[mLength*2][mLength*2];

        int lt = mLength;
        int rt = mLength;
        for (int i = 0; i < mLength; i++) {
            String move = moves[i];

            int idx = 0;
            if (move.equals(moveStr[0])) {
                idx = 0;
            } else if (move.equals(moveStr[1])) {
                idx = 1;
            } else if (move.equals(moveStr[2])) {
                idx = 2;
            } else {
                idx = 3;
            }

            for (int j = 0; j < 2; j++) {
                lt = lt + movepoInt1[idx];
                rt = rt + movepoInt2[idx];
                if (lt < 0) {
                    lt = 0;

                }
                if (rt > mLength * 2) {
                    rt = mLength * 2;
                }

                board[lt][rt] = true;
            }
        }


        for (int i = 2; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 2; j++) {
                if (!board[i][j]) continue;

                boolean isOk = true;
                int tempI = i;
                int tempJ = j;
                for (int k = 0; k < moveStr.length; k++) {
                    for (int l = 0; l < 2; l++) {
                        tempI = tempI + movepoInt1[k];
                        tempJ = tempJ + movepoInt2[k];
                        if (!board[tempI][tempJ]) {
                            isOk = false;
                            break;
                        }
                        if (!isOk) {
                            break;
                        }
                    }
                }

                if (isOk) {
                    answer++;
                }
            }
        }

        return answer;
    }
    @Test
    void 문제4() {

    }
    @Test
    void 문제5() {
        /**
         * 2416 : 49 -> 1
         * 63 -> 2
         */
    }

}
