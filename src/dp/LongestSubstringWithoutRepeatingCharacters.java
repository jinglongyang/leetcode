package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int l = s == null ? 0 : s.length();
        if (l < 2) return l;

        Map<Character, Integer> map = new HashMap<>();
        int longest = 1;
        int index = 0, start = 0;
        while (index < l) {
            char c = s.charAt(index);
            if (map.containsKey(c)) {
                int end = map.get(c);
                for (int i = start; i < end; i++) {
                    map.remove(s.charAt(i));
                }
                start = end + 1;
            }
            map.put(c, index);
            index++;
            longest = Math.max(longest, index - start);
        }
        return longest;
    }

    public static void main(String[] args) {
        String tmp = "qopubjguxhxdipfzwswybgfylqvjzhar";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(tmp));
    }
}
