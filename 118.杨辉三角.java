import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        // 第一行永远为1
        res.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            // 每行第一个元素也永远为1
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            // 每行最后一个元素也永远为1
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
// @lc code=end
