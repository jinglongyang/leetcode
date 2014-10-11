/**
 * https://oj.leetcode.com/problems/regular-expression-matching/
 * implement regular expression matching with support for '.' and '*'.
 * <pre>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * </pre>
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0) {
            return isEmptyOrStar(p);
        }
        if (p.length() == 0) {
            return false;
        }
        char s1 = s.charAt(0);
        char p1 = p.charAt(0), p2 = '0';
        if (p.length() > 1) {
            p2 = p.charAt(1);
        }
        if ('*' == p2) {
            if (s1 == p1 || p1 == '.') {
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if (s1 == p1 || p1 == '.') {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }


    }

    private boolean isEmptyOrStar(String p) {
        if (p.length() % 2 != 0) {
            return false;
        }
        for (int i = 1; i < p.length(); i += 2) {
            //check if the pattern is a*a*
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
