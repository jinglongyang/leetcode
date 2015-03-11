package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jinglongyang on 2/7/15.
 */
public class JoinedString {
    public String joinWords(String[] words) {
        //remove the word if it is a substring of another one
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            boolean ok = true;
            for (int j = 0; j < words.length; j++) {
                if (j != i && words[i].length() < words[j].length() && words[j].contains(words[i])) {
                    ok = false;
                }
            }
            if (ok) {
                set.add(words[i]);
            }
        }
        String[] validWords = set.toArray(new String[set.size()]);
        int length = validWords.length;

        //overlapLengths[i][j]
        int[][] overlapLengths = new int[length + 1][length + 1];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= length; j++) {
                overlapLengths[i][j] = getOverlapLength(j == length ? null : validWords[j], i == length ? null : validWords[i]);
            }
        }

        String[][] results = new String[1 << length][length + 1];
        return helper((1 << length) - 1, length, validWords, results, overlapLengths);
    }

    private int getOverlapLength(String s1, String s2) {
        if (s2 == null) {
            return 0;
        }
        if (s1 == null) {
            return 0;
        }

        for (int l = Math.min(s2.length(), s1.length()); l >= 1; l--) {
            if (s2.substring(s2.length() - l).equals(s1.substring(0, l))) {
                return l;
            }
        }
        return 0;
    }

    private String helper(int row, int col, String[] words, String[][] results, int[][] overlapLengths) {
        if (results[row][col] != null) {
            return results[row][col];
        }
        if (row == 0) {
            results[row][col] = "";
            return results[row][col];
        }
        for (int i = 0; i < words.length; i++) {
            if ((row & (1 << i)) != 0) {
                int index = overlapLengths[col][i];
                String result = words[i].substring(index) + helper(row - (1 << i), i, words, results, overlapLengths);
                if (results[row][col] == null || isLess(result, results[row][col])) {
                    results[row][col] = result;
                }
            }
        }
        return results[row][col];
    }

    private boolean isLess(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return true;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        return s1.compareTo(s2) < 0;
    }
}
