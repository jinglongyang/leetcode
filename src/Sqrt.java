/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x. 
 *
 *Note: Need to decalre the i,j,mid as long in order to avoid overflow when compute square.
 *
 */
public class Sqrt {
  public int sqrt(int x) {
        long i = 0, j = x / 2 + 1;
        while (i <= j) {
            long mid = i + (j - i) / 2;
            long square = mid * mid;
            if (square == x) return (int)mid;
            if (square < x) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return (int)j;
    }
}
