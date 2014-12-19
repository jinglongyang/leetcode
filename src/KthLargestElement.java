import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jinglongyang on 12/18/14.
 */
public class KthLargestElement {
    public static void main(String[] args) {
        System.out.println(new KthLargestElement().kthLargestElement(10, Arrays.asList(1, 2, 3, 4, 5, 6, 8, 9, 10, 7)));
    }

    public int kthLargestElement(int k, List<Integer> numbers) {
        // write your code here
        int size = numbers == null ? 0 : numbers.size();
        if (size < k) {
            throw new IllegalArgumentException("");
        }
        return kthLargestElement(numbers, k - 1, 0, size - 1);
    }

    private int kthLargestElement(List<Integer> numbers, int k, int start, int end) {
        int pivot = numbers.get(start + k);
        int left = start, right = end, idx = start;
        while (idx <= right) {
            if (numbers.get(idx) < pivot) {
                swap(numbers, left, idx);
                left++;
                idx++;
            } else {
                swap(numbers, right, idx);
                right--;
            }
        }
        int diff = end - idx;
        if (diff == k) {
            return pivot;
        } else if (diff > k) {
            return kthLargestElement(numbers, k, idx, end);
        }
        return kthLargestElement(numbers, k - end + idx - 1, start, idx - 1);
    }

    private void swap(List<Integer> numbers, int i, int j) {
        int tmp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, tmp);
    }
}
