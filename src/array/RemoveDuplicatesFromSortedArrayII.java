package array;

/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        int l = A == null ? 0 : A.length;
        if (l < 3) return l;
        int i = 0, count = 1;
        for (int j = 1; j < l; j++) {
            if (A[j] == A[i]) {
                if (count == 2) {
                    continue;
                }
                count++;
            } else {
                count = 1;
            }
            A[++i] = A[j];
        }
        return i + 1;
    }
}
