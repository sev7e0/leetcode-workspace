/*
 * @lc app=leetcode.cn id=303 lang=java
 * @lcpr version=30201
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {
    public int[] s;

    public NumArray(int[] nums) {
        s = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i+1] = s[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

/*
 * // @lcpr case=start
 * // ["NumArray", "sumRange", "sumRange", "sumRange"]\n[[[-2, 0, 3, -5, 2,
 * -1]], [0, 2], [2, 5], [0, 5]]\n
 * // @lcpr case=end
 * 
 */
