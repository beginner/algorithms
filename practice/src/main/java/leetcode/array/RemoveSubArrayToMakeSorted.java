package leetcode.array;

// https://leetcode.com/contest/biweekly-contest-34/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
public class RemoveSubArrayToMakeSorted {

    public static void main(String[] args) {
        int[] arr = {1,2,3,10,4,2,3,5};
        //int[] arr = {2,2,2,1,1,1};
        RemoveSubArrayToMakeSorted problem = new RemoveSubArrayToMakeSorted();
        System.out.println(problem.findLengthOfShortestSubarray(arr));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int s = 0, e = n -1;

        while ( s < n -1 && arr[s+1] >= arr[s]) s++;

        if (s == n -1) return 0;

        while (e >= s && arr[e] >= arr[e-1]) e--;

        if (e == 0) return n - 1;

        int result = Math.min(e, n - s -1);

        int i = 0;
        int j = e;

        while (i <= s && j < n) {
            if (arr[j] >= arr[i]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else j++;

        }
        return result;
    }

}
