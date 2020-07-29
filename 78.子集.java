import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<Integer> supportList = new ArrayList<>();
        if (Objects.isNull(nums) || nums.length == 0) {
            return result;
        }
        result.add(supportList);
        combin(nums, supportList, 0);
        return result;
    }

    private void combin(int[] nums, List<Integer> supportList, Integer index) {
        for (int i = index; i < nums.length; i++) {
            supportList.add(nums[i]);
            combin(nums, supportList, i + 1);
            result.add(new ArrayList<>(supportList));
            supportList.remove(supportList.size() - 1);
        }
    }
}
// @lc code=end
