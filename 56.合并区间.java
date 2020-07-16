import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length==0) {
            return intervals;
        }
        int len = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                //根据每个数组0位置上排序，那么存在重叠的数组需要根据
                //两个数组右边界最大的，来决定新的数组的右边界
                int[] a = {intervals[i][0], Math.max(intervals[i + 1][1], intervals[i][1])};
                //并将新的数组放置到i+1的位置，也就是下一次遍历开始的位置
                intervals[i+1] = a;
            } else {
                res.add(intervals[i]);
            }
        }
        res.add(intervals[len-1]);
        return res.toArray(new int[res.size()][2]);
    }

}
// @lc code=end
