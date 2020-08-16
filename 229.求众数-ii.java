import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(final int[] nums) {
        final List<Integer> res = new ArrayList<>();
        final int target = nums.length / 3;
        int count = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i-1] == nums[i] ) {
                count++;
            }else{
                count = 1;
            }
            if (count>target) {
                if (!res.contains(nums[i])) {
                    res.add(nums[i]);
                }
            }
        }
        return res;
    }
}
// @lc code=end

