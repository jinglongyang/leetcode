package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * You are given a string, S, and a list of words, L, that are all of the same length.
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * <p/>
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringWithConcatenationAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<>();
        if (L == null || L.length == 0 || S == null || S.length() == 0) return res;

        int l1 = L[0].length();
        int l2 = l1 * L.length;
        if (l2 > S.length()) return res;

        Map<String, Integer> toFound = new HashMap<>(L.length);
        for (int i = 0; i < L.length; i++) {
            Integer count = toFound.get(L[i]);
            if (count != null) {
                toFound.put(L[i], count + 1);
            } else {
                toFound.put(L[i], 1);
            }
        }

        Map<String, Integer> found = new HashMap<>();
        for (int i = 0; i <= S.length() - l2; i++) {
            found.clear();
            int j = 0;
            for (; j < l2; j += l1) {
                int k = i + j;
                String word = S.substring(k, k + l1);
                if (!toFound.containsKey(word)) break;
                if (!found.containsKey(word)) {
                    found.put(word, 1);
                } else {
                    found.put(word, found.get(word) + 1);
                }
                if (found.get(word) > toFound.get(word)) break;
            }
            if (j == l2) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubstringWithConcatenationAllWords().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new SubstringWithConcatenationAllWords().findSubstring("a", new String[]{"a"}));
    }
}
