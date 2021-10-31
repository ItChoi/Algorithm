package study.algorithm;

import org.junit.jupiter.api.Test;

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
}
