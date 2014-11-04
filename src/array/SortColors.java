package array;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/sort-colors/
 * <p/>
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SortColors {
    public void sortColors(int[] A) {
        int len = A == null ? 0 : A.length;
        if (len < 2) return;
        int i = 0, left = 0, right = len - 1;
        while (i < right) {
            if (A[i] == 0) {
                swap(A, i, left);
                left++;
                i++;
            } else if (A[i] == 1) {
                i++;
            } else {
                swap(A, i, right);
                right--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {2, 0, 1};
        new SortColors().sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}
