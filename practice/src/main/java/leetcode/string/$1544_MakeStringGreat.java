package leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/contest/weekly-contest-201/problems/make-the-string-great/
public class $1544_MakeStringGreat {

    public String makeGood(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);

            if (! deque.isEmpty() && (deque.peek() ^ 32) == ch) {
                deque.pop();
            } else {
                deque.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }


}
