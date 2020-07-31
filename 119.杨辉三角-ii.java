import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        if (rowIndex == 0) {
            res.add(1);
            return res;
        }
        for (int i = 1; i <= rowIndex; i++) {
            res = new ArrayList<>();
            res.add(1);
            for (int j = 1; j < i; j++) {
                res.add(pre.get(j) + pre.get(j - 1));
            }
            res.add(1);
            pre = res;
        }
        return res;

    }
}
// @lc code=end
