package string;

/**
 * @author: ayang
 */
public class TwoStringsAreAnagrams {
    public static void main(String[] args) {
        System.out.println(new TwoStringsAreAnagrams().anagram("abcd", "aabd"));
    }

    public boolean anagram(String s, String t) {
        // write your code here
        int len1 = s == null ? 0 : s.length();
        int len2 = t == null ? 0 : t.length();
        if (len1 != len2) {
            return false;
        }
        if (len1 == 0) {
            return true;
        }
        int[] cache = new int[256];
        for (int i = 0; i < len1; i++) {
            cache[s.charAt(i)]++;
        }

        for (int i = 0; i < len1; i++) {
            int idx = t.charAt(i);
            cache[idx]--;
            if (cache[idx] < 0) {
                return false;
            }
        }
        return true;
    }
}
