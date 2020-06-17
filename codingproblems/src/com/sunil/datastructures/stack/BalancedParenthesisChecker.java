package com.sunil.datastructures.stack;

/**
 * Check whether given string is balanced expression or not with the assumption valid expression characters are
 * '{', '}', '(', ')', '[' and ']'.
 *
 */
public class BalancedParenthesisChecker {
    public static void main(String[] args) {
        String str = "{a * (b + c) } - { c * [d + e] - f}";
        boolean isValid = isValidExpression(str);
        if (isValid) {
            System.out.println("Given expression is valid one");
        } else {
            System.out.println("Given expression is not valid one");
        }
    }

    private static boolean isValidExpression(String expression) {
        CharacterStack stack = new CharacterStack();
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if(ch == '}' || ch == ']' || ch == ')') {
                char getCh = stack.pop();
                if(!isMatchingPair(getCh, ch)) {
                    return false;
                }
            }
        }
        return stack.top == -1;
    }

    private static boolean isMatchingPair(char left, char right) {
        return (left == '{' && right == '}') || (left == '[' && right == ']') || (left == '(' && right == ')');
    }
}
