import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start 一次hash表
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int min = target-nums[i];
            //使用containsKey代替!= 判断
            if(map.containsKey(min)){
                return new int[]{map.get(min), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }           
}
// @lc code=end