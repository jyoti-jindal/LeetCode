package array;

public class DiagonalSum1572 {
    public static void main(String[] args) {

    }

    public int diagonalSum(int[][] mat) {
        int primaryDiag = 0;
        for(int i=0; i<mat.length; i++) {
            int k = mat[i].length-1;;
            primaryDiag += mat[i][i];
            if(i != k-i) {
                primaryDiag += mat[i][k-i];
            }
        }
        return primaryDiag;
    }
}
