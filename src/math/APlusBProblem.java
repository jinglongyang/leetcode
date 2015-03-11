package math;

/**
 * @author: ayang
 */
public class APlusBProblem {
    public static void main(String[] args) {
        System.out.println(new APlusBProblem().aplusb(-4, 1));
    }

    public int aplusb(int a, int b) {
        // Just submit this code, then you will get accepted!
        // return a + b;
        while (b != 0) {
            int carry = a & b;
            a ^= b;
            b = carry << 1;
        }
        return a;
    }
}
