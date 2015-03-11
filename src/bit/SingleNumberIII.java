package bit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinglongyang on 12/30/14.
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        System.out.println(new SingleNumberIII().singleNumberIII(new int[]{1, 2, 3, 3, 2, 4, 1, 5}));
    }

    public List<Integer> singleNumberIII(int[] nums) {
        // write your code here
        int len = nums == null ? 0 : nums.length;
        int c = nums[0];
        for (int i = 1; i < len; i++) {
            c ^= nums[i];
        }

        int shift = getShift(c);
        int idx = partition(nums, len, shift);

        List<Integer> res = new ArrayList<>();
        int first = nums[0] ^ c;
        for (int i = 1; i < idx; i++) {
            first ^= nums[i];
        }
        int second = nums[idx] ^ c;
        for (int i = idx + 1; i < len; i++) {
            second ^= nums[i];
        }

        res.add(first);
        res.add(second);
        return res;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private int partition(int[] a, int len, int shift) {
        int start = 1, end = len - 1, idx = 1;
        int target = (a[0] >> shift) & 1;
        while (idx <= end) {
            if (((a[idx] >> shift) & 1) == target) {
                swap(a, start, idx);
                start++;
            }
            idx++;
        }
        return start;
    }

    private int getShift(int value) {
        int i = 0;
        while (i < 32 && ((value >> i) & 1) == 0) {
            i++;
        }
        return i;
    }
}
