package set;

import java.util.HashSet;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/longest-consecutive-sequence/
 * <p/>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        int l = num == null ? 0 : num.length;
        if (l <= 1) return l;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < l; i++) {
            set.add(num[i]);
        }

        int max = 0;
        for (int i = 0; i < l; i++) {
            if (!set.contains(num[i])) continue;

            int count = 1;
            int value = num[i] + 1;
            while (set.contains(value)) {
                set.remove(value);
                value++;
                count++;
            }
            value = num[i] - 1;
            while (set.contains(value)) {
                set.remove(value);
                value--;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
