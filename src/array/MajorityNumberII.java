package array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jinglongyang on 12/30/14.
 */
public class MajorityNumberII {
    public static void main(String[] args) {
        System.out.println(new MajorityNumberII().majorityNumber(Arrays.asList(1, 1, 2)));
    }

    public int majorityNumber(List<Integer> nums) {
        // write your code
        int candicate1 = 0, candicate2 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candicate1) {
                count1++;
            } else if (nums.get(i) == candicate2) {
                count2++;
            } else if (count1 == 0) {
                candicate1 = nums.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                candicate2 = nums.get(i);
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candicate1) {
                count1++;
            } else if (nums.get(i) == candicate2) {
                count2++;
            }
        }
        return count1 > count2 ? candicate1 : candicate2;
    }
}
