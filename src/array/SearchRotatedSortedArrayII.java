package array;

/**
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchRotatedSortedArrayII {
    public int search(int[] A, int target) {
        int l = A == null ? 0 : A.length;
        if (l == 0) return -1;
        int low = 0, high = l - 1;
        while (low <= high) {
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
