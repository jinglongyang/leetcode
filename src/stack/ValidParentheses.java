package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/valid-parentheses/
 * <p/>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        int length = s == null ? 0 : s.length();
        if (length < 2) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char tmp = s.charAt(i);
            if ('(' == tmp || '{' == tmp || '[' == tmp) {
                stack.push(tmp);
            } else {
                if (stack.isEmpty() || map.get(tmp).charValue() != stack.peek().charValue()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
