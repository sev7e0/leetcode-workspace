/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution1 {
    public static void main(String[] args) {
        new Solution1().generateMatrix(3);
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n<1) {
            return res;
        }
        int left = 0, right=n-1;
        int up = 0, down = n-1;
        int numSum = n*n;
        int nowValue = 1;
        while (nowValue <= numSum) {
            for (int i = left; i <= right && nowValue <= numSum; i++) {
                res[up][i] = nowValue;
                nowValue++;
            }
            up++;
            for (int i = up; i <=down && nowValue <= numSum; i++) {
                res[i][right] = nowValue;
                nowValue++;
            }
            right--;
            for (int i = right; i >= left  && nowValue <= numSum; i--) {
                res[down][i] = nowValue;
                nowValue++;
            }
            down--;
            for (int i = down; i >= up  && nowValue <= numSum; i--) {
                res[i][left] = nowValue;
                nowValue++;
            }
            left++;
        }
        return res;
    }
}
// @lc code=end

