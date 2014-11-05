package stack;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * <pre>
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * </pre>
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String ops = "+-*/";
        for (String token : tokens) {
            if (ops.contains(token)) {
                int a = stack.pop();
                int b = stack.pop();
                if ("+".equals(token)) {
                    stack.push(b + a);
                } else if ("-".equals(token)) {
                    stack.push(b - a);
                } else if ("-".equals(token)) {
                    stack.push(b * a);
                } else {
                    stack.push(b / a);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
