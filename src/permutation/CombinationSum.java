package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/combination-sum/
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int l = candidates == null ? 0 : candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (l < 1) return res;
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), candidates, target, 0, l);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int start, int l) {
        if (0 == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        int prev = -1;
        for (int i = start; i < l; i++) {
            if (candidates[i] <= target && (prev == -1 || prev != candidates[i])) {
                path.add(candidates[i]);
                helper(res, path, candidates, target - candidates[i], i, l);
                path.remove(path.size() - 1);
                prev = candidates[i];
            }
        }
    }

}
