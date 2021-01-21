/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //数组操作尽量不要再中间删除元素，要想办法将
        //这个元素移动到数组尾部
        int fast = 1, slow = 0;
        while (fast<nums.length) {
            //使用快慢指针的方式可以根据
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            } 
            fast++;           
        }
        return ++slow;
    }
}
// @lc code=end

