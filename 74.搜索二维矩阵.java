/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int up = 0;
        int down = matrix.length;
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        for (int i = up; i < down; i++) {
            if (i == down - 1) {
                up = down - 1;
                break;
            }
            if (matrix[i][0] == target || matrix[i + 1][0] == target) {
                return true;
            }
            if (matrix[i][0] < target && matrix[i + 1][0] > target) {
                up = i;
                break;
            }
        }

        int left = 0;
        int right = matrix[0].length;
        //二分查找法
        while (left <= right) {
            int mid = (right + left)/2;
            if (matrix[up][mid] == target) {
                return true;
            }
            if (matrix[up][mid]>target) {
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }

        // 遍历法可以
        // for (int i = left; i < right; i++) {
        //     if (matrix[up][i] == target) {
        //         return true;
        //     }
        // }
        return false;

    }
}
// @lc code=end
