package heap;

import java.util.Arrays;

/**
 * Given an integer array, heapify it into a min-heap array.
 * For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 * Example
 * Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
 */
public class Heapify {
    public static void main(String[] args) {
        int[] a = new int[]{45, 39, 32, 11};
        new Heapify().heapify(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * @param a: Given an integer array
     * @return: void
     */
    public void heapify(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int i = a.length / 2 - 1;
        while (i >= 0) {
            heapify(a, i);
            i--;
        }
    }

    private void heapify(int[] a, int i) {
        int left = 2 * i + 1;
        int right = left + 1;
        if (left >= a.length) {
            return;
        }
        int minIndex = right >= a.length ? left : (a[left] > a[right] ? right : left);
        if (a[i] > a[minIndex]) {
            swap(a, i, minIndex);
        }
        heapify(a, minIndex);
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
