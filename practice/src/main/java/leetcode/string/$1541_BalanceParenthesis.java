package leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/contest/biweekly-contest-32/problems/minimum-insertions-to-balance-a-parentheses-string/
public class $1541_BalanceParenthesis {

    /**
     * Idea is to maintain a Stack, which will keep track of how many ")" would be needed to balance.
     */
    public int minInsertions(String s) {

        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for(char ch : s.toCharArray()) {
            if (ch == '(') {
                if (deque.isEmpty() || deque.peek() == 2) { // "(" , "(("
                    deque.push(2);
                } else if (deque.peek() == 1) { // "()("
                    result++;
                    deque.pop();
                    deque.push(2);
                }
            } else if (ch == ')') {
                if (deque.isEmpty()) { // ")" , "()))"
                    deque.push(1);
                    result++;
                } else if (deque.peek() == 1) { // "())"
                    deque.pop();
                } else if (deque.peek() == 2) { // "()"
                    deque.pop();
                    deque.push(1);
                }
            }
        }

        // the stack contains how many right brackets would be required.
        while (!deque.isEmpty()) {
            result += deque.pop();
        }
        return result;
    }


    /**
     * Idea is to maintain counter which will denote the number of brackets ")"
     */
    public int minInsertionsSol2(String s) {

        int result = 0;
        int rightBrackets = 0;

        for(char ch : s.toCharArray()) {
            if (ch == '(') {
                rightBrackets += 2;
                if (rightBrackets % 2 != 0) {
                    rightBrackets--;
                    result++;
                }
            } else if (ch == ')') {
                rightBrackets--;
                if (rightBrackets < 0) {
                    rightBrackets += 2;
                    result++;
                }
            }


        }



        return result + rightBrackets;
    }



}
