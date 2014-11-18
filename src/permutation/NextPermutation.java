package permutation;

/**
 * https://oj.leetcode.com/problems/next-permutation/
 * <p/>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <pre>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * </pre>
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        int l = num == null ? 0 : num.length;
        if (l < 2) return;
        int idx = l - 1;
        while (idx > 0) {
            if (num[idx - 1] < num[idx]) {
                break;
            }
            idx--;
        }
        if (idx > 0) {
            idx--;
            int right = l - 1;
            while (right >= 0 && num[right] <= num[idx]) {
                right--;
            }
            swap(num, idx, right);
            idx++;
        }
        int end = l - 1;
        while (end > idx) {
            swap(num, idx, end);
            end--;
            idx++;
        }
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
