import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list;

    public List<List<Integer>> permute(final int[] nums) {
        if (nums == null || (nums.length) == 0) {
            return res;
        }
        list = new ArrayList<>(nums.length);
        for (final int i : nums) {
            list.add(i);
        }
        backTracking(0, nums);
        return res;

    }

    private void backTracking(final int i, final int[] nums) {
        //判定完成条件
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            //交换位置
            Collections.swap(list, j, i);
            backTracking(i + 1, nums);
            Collections.swap(list, j, i);
        }

    }
}
// @lc code=end
