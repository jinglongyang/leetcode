package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jinglongyang on 12/26/14.
 */
public class SubarraySumClosest {
    public static void main(String[] args) {
        System.out.println(new SubarraySumClosest().subarraySumClosest(new int[]{-10, -2, -3, -100, 1, 2, 3, -1, 4}));
    }

    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        int len = nums == null ? 0 : nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        if (len == 1) {
            res.add(0);
            res.add(0);
            return res;
        }

        Element[] sums = new Element[len + 1];
        sums[0] = new Element(-1, 0);
        for (int i = 1; i <= len; i++) {
            sums[i] = new Element(i - 1, sums[i - 1].sum + nums[i - 1]);
        }
        Arrays.sort(sums);
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            int diff = Math.abs(sums[i].sum - sums[i + 1].sum);
            if (diff < min) {
                min = diff;
                start = Math.min(sums[i].index, sums[i + 1].index) + 1;
                end = Math.max(sums[i].index, sums[i + 1].index);
            }
        }

        res.add(start);
        res.add(end);
        return res;
    }

    private static class Element implements Comparable<Element> {
        private int index;
        private int sum;

        private Element(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }

        public int compareTo(Element that) {
            return this.sum - that.sum;
        }
    }
}
