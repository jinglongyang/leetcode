package permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/permutations/
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        int l = num == null ? 0 : num.length;
        if (l == 0) return res;
        helper(res, new ArrayList<Integer>(), l, new boolean[l], num);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, int length, boolean[] visited, int[] num) {
        if (path.size() >= length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            path.add(num[i]);
            helper(res, path, length, visited, num);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{0, 1}));
    }
}
