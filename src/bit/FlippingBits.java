package bit;

/**
 * Created by jinglongyang on 1/26/15.
 */
public class FlippingBits {
    private static long flip(long value, long carry) {
        return value ^ carry;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        long carry = 1;
        for (int i = 0; i < 31; i++) {
            carry <<= 1;
            carry |= 1;
        }
        System.out.println(Long.toBinaryString(carry));
        System.out.println(Long.toBinaryString(2147483647L));
        System.out.println(Long.toBinaryString(flip(2147483647L, carry)) + " " + flip(2147483647, carry));
        System.out.println(Long.toBinaryString(2147483648L));

//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            long value = in.nextLong();
//            System.out.println(flip(value, carry));
//        }
    }
}
