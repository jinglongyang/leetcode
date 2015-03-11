package bit;

/**
 * @author: ayang
 */
public class UniqueCharacters {
    public static void main(String[] args) {
        System.out.println(new UniqueCharacters().isUnique("abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+"));
    }

    public boolean isUnique(String str) {
        // write your code here
        int len = str == null ? 0 : str.length();
        if (len > Character.MAX_VALUE) {
            return true;
        }
        long[] checkers = new long[8];
        for (char c : str.toCharArray()) {
            int position = 1 << c / 8;
            int idx = c % 8;
            if ((checkers[idx] & position) != 0) {
                return false;
            }
            checkers[idx] |= position;
        }
        return true;
    }
}
