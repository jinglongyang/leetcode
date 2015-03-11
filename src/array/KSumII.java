package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: ayang
 */
public class KSumII {
    public static void main(String[] args) {
        System.out.println(new KSumII().kSumII(new int[]{1, 4, 5, 6, 8}, 1, 4));//1, 4, 7,
    }

    public ArrayList<ArrayList<Integer>> kSumII(int nums[], int k, int target) {
        // write your code here
        int len = nums == null ? 0 : nums.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), nums, k, target, 0, len - 1);
        return res;
    }

    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int a[], int k, int target, int start, int end) {
        if (k == 1) {
            oneSum(res, path, a, target, start, end);
        } else if (k == 2) {
            twoSum(res, path, a, target, start, end);
        } else {
            for (int i = start; i <= end; i++) {
                path.add(a[i]);
                helper(res, path, a, k - 1, target - a[i], i + 1, end);
                path.remove(path.size() - 1);
            }
        }
    }

    private void oneSum(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int a[], int target, int start, int end) {
        int left = start, right = end;
        boolean found = false;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target == a[mid]) {
                found = true;
                break;
            } else if (target < a[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (!found && (a[left] == target || a[right] == target)) {
            found = true;
        }
        if (found) {
            ArrayList<Integer> solution = new ArrayList<>(path);
            solution.add(target);
            res.add(solution);
        }
    }

    private void twoSum(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int[] a, int target, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            int sum = a[left] + a[right];
            if (sum == target) {
                ArrayList<Integer> solution = new ArrayList<>(path);
                solution.add(a[left]);
                solution.add(a[right]);
                res.add(solution);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
