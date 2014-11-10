package array;

/**
 * https://oj.leetcode.com/problems/search-insert-position/
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * <pre>
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * </pre>
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int l = A == null ? 0 : A.length;
        if (l == 0) return 0;
        int low = 0, high = l - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target) return mid;
            if (target > A[mid]) {
                low = mid + 1;
            } else if (target < A[mid]) {
                high = mid - 1;
            }
        }
        return low;
    }
}
