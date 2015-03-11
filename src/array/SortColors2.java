package array;

/**
 * Created by jinglongyang on 12/26/14.
 */
public class SortColors2 {
    public static void main(String[] args) {
        new SortColors2().sortColors2(new int[]{2, 2, 3, 1, 1, 1, 2, 3, 2, 2}, 3);
    }

    public void sortColors2(int[] colors, int k) {
        int len = colors == null ? 0 : colors.length;
        if (len < 2) {
            return;
        }
        int i = 0;
        while (i < len) {
            if (colors[i] >= 1) {
                int index = colors[i] - 1;
                if (colors[index] >= 0) {
                    swap(colors, i, index);
                    colors[index] = -1;
                    continue;
                } else {
                    colors[index]--;
                    colors[i] = 0;
                }
            }
            i++;
        }
        i = k;
        int j = len - 1;
        while (i >= 1) {
            int count = -colors[i - 1];
            while (count >= 1) {
                count--;
                colors[j--] = i;
            }
            i--;
        }
    }

    private void swap(int[] colors, int i, int j) {
        int tmp = colors[i];
        colors[i] = colors[j];
        colors[j] = tmp;
    }
}
