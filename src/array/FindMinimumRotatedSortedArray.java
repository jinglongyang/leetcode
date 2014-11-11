package array;

/**
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * <p/>
 * You may assume no duplicate exists in the array.
 */
public class FindMinimumRotatedSortedArray {
    public int findMin(int[] num) {
        int l = num == null ? 0 : num.length;
        if (l == 0) return -1;
        if (num[0] <= num[l - 1]) return num[0];
        int low = 0, high = l - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num[mid] > num[high]) {
                low = mid + 1;
            } else if (num[mid] < num[mid - 1]) {
                return num[mid];
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public int findMin2(int[] num) {
        int l = num == null ? 0 : num.length;
        if (l == 0) return 0;
        if (l == 1) return num[0];
        return findMin(num, 0, num.length - 1);
    }

    private int findMin(int[] num, int start, int end) {
        if (end < start) return num[0];

        if (end == start) return num[start];

        int middle = start + (end - start) / 2;
        if (middle > start && num[middle - 1] > num[middle]) {
            return num[middle];
        }
        if (middle < end && num[middle + 1] < num[middle]) {
            return num[middle + 1];
        }
        if (num[end] > num[middle])
            return findMin(num, start, middle - 1);
        return findMin(num, middle, end);
    }
}
