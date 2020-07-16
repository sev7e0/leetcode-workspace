import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //先对数组进行排序，这样在能够保证双端队列能够根据和的大小决定左移还是右移
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            //定义两端指针
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //对求和求绝对值，如果小于之前的结果，那么更新新的结果
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                //开始根据结果移动指针，准备下一次求和
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    //此时相等，那么一定是距离最小的，直接返回
                    return result;
                }

            }
        }
        return result;

    }
}
// @lc code=end
