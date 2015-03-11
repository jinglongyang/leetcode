package array;

/**
 * https://oj.leetcode.com/problems/find-peak-element/
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(new FindPeakElement().findPeakElement(new int[]{1, 2, 3}));
    }

    public int findPeakElement(int[] num) {
        int len = num == null ? 0 : num.length;
        if (len < 1) {
            return -1;
        }

        int start = 0, end = len - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
                return mid;
            } else if (num[mid] < num[mid - 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return num[start] > num[end] ? start : end;
    }
}
