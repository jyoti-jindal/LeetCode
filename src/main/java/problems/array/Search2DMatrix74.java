package problems.array;

public class Search2DMatrix74 {
    public static void main(String[] args) {

    }

    /**
     * Approach 1: Brute Force
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j< matrix[i].length; j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixApproach2(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++) {
            int col = matrix[i].length;
            if(target>matrix[i][col-1]) {
                continue;
            } else {
                for(int j=0; j<col;j++) {
                    if(target == matrix[i][j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * TODO- Approach 3: Using Binary Search
     */
}
