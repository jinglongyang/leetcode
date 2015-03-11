package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jinglongyang on 1/14/15.
 */
public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{10, 2}));
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, new MyComparator());
        if (list.get(0) == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int num : list) {
            res.append(num);
        }
        return res.toString();
    }

    private static class MyComparator implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2) {
            Long l1 = join(i1, i2);
            Long l2 = join(i2, i1);
            return l2.compareTo(l1);
        }

        private Long join(Integer i1, Integer i2) {
            return Long.parseLong(new StringBuffer().append(i1).append(i2).toString());
        }
    }
}
