import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(final int[] nums) {
        if (nums == null || (nums.length) == 0) {
            return res;
        }
        backTracking(new ArrayList<>(), 0, nums);
        return res;
    }

    private void backTracking(ArrayList<Integer> arrayList, final int i, final int[] nums) {
        // 判定完成条件
        if (i == nums.length) {
            res.add(new ArrayList<>(arrayList));
            return;
        }
        final Set<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (set.contains(nums[j])) {
                continue;
            }
            set.add(nums[j]);
            // 交换位置
            swap(nums, j, i);
            arrayList.add(nums[i]);
            backTracking(arrayList, i + 1, nums);
            arrayList.remove(arrayList.size() - 1);
            swap(nums, j, i);
        }

    }

    private void swap(final int[] nums, final int j, final int i) {
        final int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
// @lc code=end

