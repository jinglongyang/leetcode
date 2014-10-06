package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/subsets/
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * <pre>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * </pre>
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        int l = S == null ? 0 : S.length;
        List<List<Integer>> res = new ArrayList<>();
        if (l == 0) return res;
        Arrays.sort(S);
        helper(res, new ArrayList<Integer>(), 0, l, S);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, int start, int l, int[] S) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < l; i++) {
            path.add(S[i]);
            helper(res, path, i + 1, l, S);
            path.remove(path.size() - 1);
        }
    }
}
