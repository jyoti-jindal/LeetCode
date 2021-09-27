package problems.array.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/set-matrix-zeroes/">73. Set Matrix Zeroes</a>
 * <b>
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 * You must do it in place.
 *</b>
 *
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 *
 * TODO Follow up:
 *
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * TODO - Could you devise a constant space solution?
 */
public class SetMatrixZeroes73 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Intuition: If any cell of the matrix has a zero we can record its row and column number.
     * All the cells of this recorded row and column can be marked zero in the next iteration.
     * <p>
     * Time Complexity: O(M×N) where M and N are the number of rows and columns respectively.
     * Space Complexity: O(M+N).
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        // Loop over tha matrix, mark the rows and columns that are to be made zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

// Iterate over the matrix once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
