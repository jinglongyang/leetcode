package array;

/**
 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * There are two sorted arrays A and B of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int l = A.length + B.length;
        if (l % 2 == 0) {
            return (findKth(A, 0, B, 0, l / 2) + findKth(A, 0, B, 0, l / 2 + 1)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, l / 2 + 1);
        }
    }

    private int findKth(int A[], int startA, int B[], int startB, int k) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        int keyA = startA + k - 1 >= A.length ? Integer.MAX_VALUE : A[startA + k - 1];
        int keyB = startB + k - 1 >= B.length ? Integer.MAX_VALUE : B[startB + k - 1];
        if (keyA < keyB) {
            return findKth(A, startA + k / 2, B, startB, k - k / 2);
        }
        return findKth(A, startA, B, startB + k / 2, k - k / 2);
    }
}
