package leetcode.string;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/contest/weekly-contest-205/problems/minimum-deletion-cost-to-avoid-repeating-letters/
public class CostDeleteRepeatableCharacter {

    public static void main(String[] args) {
        String test = "abaac";
        CostDeleteRepeatableCharacter problem = new CostDeleteRepeatableCharacter();

        System.out.println(problem.minCost(test, new int[]{1,2,3,4,5}));
    }

    public int minCost(String s, int[] cost) {
        int n = s.length();
        int minCost = 0;

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int num = 1;
            while (i + 1 < n && s.charAt(i +1) == c) {
                num++;
                i++;
            }
            if (num >= 2) {
                int start = i - num + 1;
                int max = Integer.MIN_VALUE;
                for(int j = start; j <= i; j++) {
                    max = Math.max(max, cost[j]);
                    minCost += cost[j];
                }
                minCost -= max;

            }

        }

        return minCost;
    }


}
