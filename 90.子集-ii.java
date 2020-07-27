import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(final int[] nums) {
        Arrays.sort(nums);
        final List<Integer> suportList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<>(suportList));
        combin(0, nums, suportList);
        return result;
    }

    private void combin(final int index, final int[] nums, final List<Integer> suportList) {
        for (int i = index; i < nums.length; i++) {
            //与上一个元素相同时进行剪枝
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            suportList.add(nums[i]);
            combin(i + 1, nums, suportList);
            result.add(new ArrayList<>(suportList));
            //回溯进行下一个元素
            suportList.remove(suportList.size() - 1);
        }
    }
}
// @lc code=end
