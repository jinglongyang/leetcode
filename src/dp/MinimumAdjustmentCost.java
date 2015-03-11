package dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jinglongyang on 1/14/15.
 */
public class MinimumAdjustmentCost {
    public static void main(String[] args) {
        System.out.println(new MinimumAdjustmentCost().minAdjustmentCost(new ArrayList(Arrays.asList(11, 11, 3, 5, 11, 16, 12, 11, 15, 11, 16, 16, 16, 16, 16, 11, 16)), 0));
    }

    public int minAdjustmentCost(ArrayList<Integer> a, int target) {
        // write your code here
        int size = a == null ? 0 : a.size();
        int[][] dp = new int[size][101];
        for (int i = 1; i < 101; i++) {
            int diff = Math.abs(a.get(0) - i);
            dp[0][i] = diff;
        }

        for (int i = 1; i < size; i++) {
            int value = a.get(i);
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = -1;
                for (int k = 1; k <= 100; k++) {
                    if (Math.abs(j - k) <= target && dp[i - 1][k] >= 0) {
                        int cost = Math.abs(value - j) + dp[i - 1][k];
                        dp[i][j] = dp[i][j] == -1 ? cost : Math.min(dp[i][j], cost);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            if (dp[size - 1][i] >= 0) {
                min = Math.min(min, dp[size - 1][i]);
            }
        }
        return min;
    }
}
