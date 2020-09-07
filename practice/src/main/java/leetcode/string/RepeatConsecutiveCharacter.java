package leetcode.string;

// https://leetcode.com/contest/weekly-contest-205/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
public class RepeatConsecutiveCharacter {

    public static void main(String[] args) {
        String test = "?";
        RepeatConsecutiveCharacter problem = new RepeatConsecutiveCharacter();
        System.out.println(problem.modifyString(test));
    }
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i < sb.length(); i++) {
            char current = sb.charAt(i);
            Character left = i == 0 ? null : sb.charAt(i -1);
            Character right = i == sb.length() - 1 ? null : sb.charAt(i +1);
            if (current == '?') {
                for (char replacement = 'a'; replacement <= 'z'; replacement++) {
                    if (left == null && right == null) {
                        sb.setCharAt(i, replacement);
                        break;
                    } else {
                        left = left == null ? right : left;
                        right = right == null ? left : right;
                        if (replacement != left && replacement != right) {
                            sb.setCharAt(i, replacement);
                            break;
                        }
                    }

                }
            }
        }
        return sb.toString();
    }

}
