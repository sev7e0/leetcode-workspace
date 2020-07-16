import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        int down = matrix.length;
        int right = matrix[0].length;
        int up = 0, left = 0;
        int numSum = right * down;
        down--;
        right--;
        while (numSum > 0) {
            for (int i = left; i <= right && numSum > 0; i++) res.add(matrix[up][i]);numSum--;
            up++;
            for (int i = up; i <= down && numSum > 0; i++) res.add(matrix[i][right]);numSum--;
            right--;
            for (int i = right; i >= left && numSum > 0; i--) res.add(matrix[down][i]);numSum--;
            down--;
            for (int i = down; i >= up && numSum > 0; i--) res.add(matrix[i][left]);numSum--;
            left++;
        }
        return res;
    }

}
// @lc code=end
