package dp;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * <p/>
 * Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SubsetSum {
    /**
     * dp
     *
     * @param set
     * @param sum
     * @return
     */
    public boolean isSubSetSum(int set[], int sum) {
        if (sum < 0) return false;
        int l = set == null ? 0 : set.length;
        if (l == 0) return false;
        boolean[][] dp = new boolean[l + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= sum; j++) {
                if (sum >= set[i]) {
                    dp[i][j] = dp[i - 1][sum] || dp[i - 1][sum - set[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[l][sum];
    }

    /**
     * recursive
     *
     * @param set
     * @param sum
     * @return
     */
    public boolean isSubSetSum2(int[] set, int sum) {
        if (sum < 0) return false;
        int l = set == null ? 0 : set.length;
        if (l == 0) return false;
        return isSubSetSum2(set, l - 1, sum);
    }

    public boolean isSubSetSum2(int[] set, int index, int sum) {
        if (sum == 0) return true;
        if (index == 0) return false;
        if (set[index - 1] > sum)
            return isSubSetSum2(set, index - 1, sum);
        return isSubSetSum2(set, index - 1, sum) || isSubSetSum2(set, index - 1, sum - set[index - 1]);
    }

    public boolean isSubsetSum3(int set[], int sum) {
        int n = set == null ? 0 : set.length;
        // The value of subset[i][j] will be true if there is a subset of set[0..j-1]
        //  with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];
        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;
        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in botton up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
            }
        }
        return subset[sum][n];
    }

}
