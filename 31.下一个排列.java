/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 * 
 * 
 * 现在我们的基本解题思路就有了，我们首先要找到两个数字进行交换，并且后面的数字要比前面的数字大，
 * 其次，我们需要变成为紧挨着当前数字的下一个数字，也就是上图当中的我们的顺序，可以这样来做:
 * 1.需要从后向前找到第一个升序对：如123465->123546中的123465，这样我们就可以确定4的位置i。
 * 2.接下来从后向前找到第一个比4大的数的位置，如123465->123546中的123465，这样我们可以确定5的位置j。
 * 3.再下来将i与j的数进行交换
 * 4.最后将i+1到最后的位置进行反转。
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        // 准备从右侧开始遍历
        int left = nums.length - 2;
        //找到一个升序数对 46 这种的
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }
        // 判断left是否越界，越界则说明当前数列为最大排序，无法找到下一个大的数列
        // 所以根据题意直接将其反转，按照升序排列
        if (left >= 0) {
            //从最后找到一个比i位置大得数，进行交换
            int right = nums.length - 1;
            while (right >= 0 && nums[right] <= nums[left]) {
                right--;
            }
            swap(nums, right, left);
        }
        //将i位置后的数列（64）进行全交换
        //此时他们已经是降序排列了，所以交换后（数列反转）为升序排列
        int l = left + 1;
        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l++, r--);
        }

    }

    private void swap(int[] nums, int right, int left) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
// @lc code=end
