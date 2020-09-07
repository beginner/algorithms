package leetcode.array;

public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {

        int sum = 0;

        for(int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            sum += mat[mat.length -1 -i][i];
        }

        if ( mat.length % 2 == 1) {
            sum -= mat[mat.length /2][mat.length /2];
        }
        return sum;
    }


}
