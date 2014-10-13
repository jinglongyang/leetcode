import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/4sum/
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p/>
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * <pre>
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 * </pre>
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int l = num == null ? 0 : num.length;
        if (l < 4) return res;

        Arrays.sort(num);

        for (int i = 0; i < l - 3; i++) {
            if (i > 0 && num[i - 1] == num[i]) continue;
            for (int j = i + 1; j < l - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1])
                    continue;
                int k = j + 1, m = l - 1;
                while (k < m) {
                    int sum = num[i] + num[j] + num[k] + num[m];
                    if (sum == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[k]);
                        tmp.add(num[m]);
                        res.add(tmp);
                        k++;
                        m--;
                        while (k < m && num[k] == num[k - 1]) {
                            k++;
                        }
                        while (k < m && num[m] == num[m + 1]) {
                            m--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        m--;
                    }
                }
            }
        }
        return res;
    }
}
