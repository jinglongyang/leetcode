package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/permutations-ii/
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        int l = num == null ? 0 : num.length;
        List<List<Integer>> res = new ArrayList<>();
        if (l == 0) return res;
        Arrays.sort(num);
        helper(res, new ArrayList<Integer>(), l, new boolean[l], num);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, int length, boolean[] visited, int[] num) {
        if (path.size() == length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (visited[i] || (i != 0 && num[i - 1] == num[i] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            path.add(num[i]);
            helper(res, path, length, visited, num);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
