import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int length = nums.length;
        if (length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int start = 0;
        for (int i = 1; i <= length; i++) {
            if (i< length && nums[i] == nums[i - 1] + 1) {
                continue;
            } else {
                if (start == i - 1) {
                    res.add(String.valueOf(nums[start]));
                } else {
                    res.add(nums[start] + "->" + nums[i - 1]); 
                }
                start = i;
            }
        }
        return res;
    }
}
// @lc code=end
