package permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/permutation-sequence/
 * <p/>
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if (k < 1 || n < 1) return "";
        int fact = 1;
        List<Integer> list = new ArrayList<>(2 * n);
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
            fact *= (i + 1);
        }
        if (k > fact) return "";
        k--;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int chose = k / fact;
            res.append(list.get(chose));
            list.remove(chose);
            k %= fact;
        }
        return res.toString();
    }
}
