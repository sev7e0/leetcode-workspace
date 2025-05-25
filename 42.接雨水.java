import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // 左指针从 1 开始（第 0 个左边接不到水）
        int left = 0;

        // 右指针从倒数第 1 个位置开始（最后一个右边接不到水）
        int right = height.length - 1;

        int result = 0;

        // 记录左右两边最大值
        int leftMax = 0;
        int rightMax = 0;

        // 修改为 left < right，更安全，避免重复处理中间位置
        while (left < right) {
            // 谁的最大高度值小，就处理哪一边
            if (height[left] < height[right]) {
                // 如果左边能接水
                if (height[left] < leftMax) {
                    result += leftMax - height[left];
                } else {
                    // 否则更新最大值索引
                    leftMax = height[left];
                }
                left++;
            } else {
                // 如果右边能接水
                if (height[right] < rightMax) {
                    result += rightMax - height[right];
                } else {
                    // 否则更新最大值索引
                    rightMax = height[right];
                }
                right--;
            }
        }

        return result;
    }
}

/**
 * Your runtime beats 99.99 % of java submissions
 * Your memory usage beats 12.86 % of java submissions (39.5 MB)
 */
// @lc code=end
