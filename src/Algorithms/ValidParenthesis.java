package Algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 Example 1:

 Input: "()"
 Output: true
 Example 2:

 Input: "()[]{}"
 Output: true
 Example 3:

 Input: "(]"
 Output: false
 Example 4:

 Input: "([)]"
 Output: false
 Example 5:

 Input: "{[]}"
 Output: true

 */
public class ValidParenthesis {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                dq.push(c);
            } else {
                if (dq.size() == 0 || map.get(c) != dq.pop()) return false;
            }
        }
        return dq.size() == 0;
    }

    public static void main(String[] args) {
        ValidParenthesis sol = new ValidParenthesis();
        System.out.println(sol.isValid("{[]}"));
    }
}
