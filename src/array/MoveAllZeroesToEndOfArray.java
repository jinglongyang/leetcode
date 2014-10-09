package array;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/move-zeroes-end-array/
 * Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
 * For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}.
 * The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1)
 */
public class MoveAllZeroesToEndOfArray {
    public void pushZerosToEnd(int arr[]) {
        int length = arr == null ? 0 : arr.length;
        if (length == 0) return;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }
        while (index < length) {
            arr[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        new MoveAllZeroesToEndOfArray().pushZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }
}
