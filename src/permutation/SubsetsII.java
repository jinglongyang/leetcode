package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/subsets-ii/
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * <pre>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * </pre>
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int l = nums == null ? 0 : nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (l == 0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), 0, l, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, int start, int l, int[] nums) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < l; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                path.add(nums[i]);
                helper(res, path, i + 1, l, nums);
                path.remove(path.size() - 1);
            }
        }
    }
}
