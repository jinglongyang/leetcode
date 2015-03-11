package array;

/**
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */
public class SearchRotatedSortedArrayII {
    public int search(int[] A, int target) {
        int l = A == null ? 0 : A.length;
        if (l == 0) return -1;

        int low = 0, high = l - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (target == A[mid]) {
                return mid;
            } else if (A[mid] >= A[low]) {
                if (A[low] <= target && target < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
