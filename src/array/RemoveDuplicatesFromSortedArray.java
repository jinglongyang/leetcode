package array;

/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        int l = A == null ? 0 : A.length;
        if (l <= 1) return l;
        int i = 0;
        for (int j = 1; j < l; j++) {
            if (A[j] != A[j - 1]) {
                i++;
                A[i] = A[j];
            }
        }
        return i + 1;
    }
}
