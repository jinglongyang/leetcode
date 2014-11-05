/**
 * Created by jinglongyang on 10/16/14.
 */
public class CountFive {
    public long search(int n) {
        if (n < 5) return 0;

        long count = 0;
        long i = 1;
        long current = 0, after = 0, before = 0;
        int j = 0;
        while ((n / i) != 0) {
            current = (n / i) % 10;
            before = n / (i * 10);
            after = n - (n / i) * i;

            if (current > 5)
                count += (before + 1) * i;
            else if (current < 5)
                count += (before * i);
            else {
                count += (before * i + after + 1);
            }
            i = i * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountFive().search(56));
        System.out.println(new CountFive().search2(56));
    }

    public long search2(int n) {
        int i = 5;
        long count = 0;
        while (i <= n) {
            if (String.valueOf(i).indexOf('5') > -1) {
//                System.out.printf(i);
                count++;
            }
            i++;
        }
        return count;
    }
}
