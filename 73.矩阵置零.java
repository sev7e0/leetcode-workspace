/*
 * @lc app=leetcode.cn id=73 lang=java
 * @lcpr version=30201
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        boolean col0 = false;
        boolean row0 = false;
        for (int i = 0; i < x; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        for (int i = 0; i < y; i++) {
            if (matrix[0][i] == 0) {
                row0 = true;
                break;
            }
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 最后处理第一列
        if (col0) {
            for (int i = 0; i < x; i++) {
                matrix[i][0] = 0;
            }
        }

        // 最后处理第一行
        if (row0) {
            for (int j = 0; j < y; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,1,1],[1,0,1],[1,1,1]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[0,1,2,0],[3,4,5,2],[1,3,1,5]]\n
 * // @lcpr case=end
 * 
 */
