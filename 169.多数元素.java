import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.compute(nums[i], (key, value)->{
                if (Objects.isNull(value)) {
                    value = 1;
                }else{
                    value++;
                }
                return value;
            });
        }
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue()>nums.length/2) {
                return i.getKey();
            }
        }
        return -1;
    }
}
// @lc code=end

