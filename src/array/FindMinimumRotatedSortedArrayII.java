package array;

/**
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 */
public class FindMinimumRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(new FindMinimumRotatedSortedArrayII().findMin(new int[]{10, 1, 10, 10, 10}));
    }

    public int findMin(int[] num) {
        int l = num == null ? 0 : num.length;
        if (l == 0) return -1;
        if (num[0] < num[l - 1]) return num[0];
        int low = 0, high = l - 1;
        while (low < high && num[low] >= num[high]) {
            int mid = low + (high - low) / 2;
            if (num[mid] > num[high]) {
                low = mid + 1;
            } else if (num[mid] < num[high]) {
                high = mid;
            } else {
                low++;
            }
        }
        return num[low];
    }
}
