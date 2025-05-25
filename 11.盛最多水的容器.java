/**
 * @lc app=leetcode.cn id=11 lang=java
 *
 *     [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // 定义对向双指针，结果
        int left = 0, right = height.length - 1, res = 0;
        while (left != right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int areaTemp = h * w;
            res = Math.max(areaTemp, res);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }

        }
        return res;
    }
}
// @lc code=end

/**
 * 如果遇到左右两边的情况可以考虑使用----》双端指针问题
 */