package array;

/**
 * Created by jinglongyang on 1/5/15.
 */
public class Median {
    public static void main(String[] args) {
        System.out.println(new Median().median(new int[]{1, 2, 3, 4, 5, 6, 7, 100, 200, 1000}));
    }

    public int median(int[] nums) {
        // write your code here
        int len = nums == null ? 0 : nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("");
        }
        return partition(nums, 0, len - 1, (len - 1) / 2);
    }

    private int partition(int[] nums, int start, int end, int count) {
        if (start == end) {
            return nums[start];
        }
        int pivital = nums[start];
        int left = start, right = end, idx = start + 1;
        while (idx <= right) {
            if (nums[idx] < pivital) {
                swap(nums, left, idx);
                left++;
                idx++;
            } else {
                swap(nums, right, idx);
                right--;
            }
        }

        int diff = left - start;
        if (diff == count) {
            return pivital;
        } else if (diff > count) {
            return partition(nums, start, left - 1, count);
        }
        return partition(nums, left + 1, end, count - diff - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
