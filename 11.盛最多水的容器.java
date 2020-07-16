/** 
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        //使用双指针进行遍历
        while (left < right) {
            int l = height[left];
            int r = height[right];
            int tempMaxArea;
            if (l > r) {
                tempMaxArea = r * (right - left);
                right--;
            } else {
                tempMaxArea = l * (right - left);
                left++;
            }
            maxArea = tempMaxArea > maxArea ? tempMaxArea : maxArea;
        }
        return maxArea;
    }
}
// @lc code=end


/**
 * 如果遇到左右两边的情况可以考虑使用----》双端指针问题
 */