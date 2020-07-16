import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        if (intervals == null || intervals.length == 0) {
            return new int[][]{ newInterval };
        }
        int length = intervals.length;
        int[][] res = new int[length + 1][2];
        System.arraycopy(intervals, 0, res, 0, intervals.length);
        res[length] = newInterval;
        Arrays.sort(res, Comparator.comparing(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (res[i][1] >= res[i + 1][0]) {
                int[] a = { res[i][0], Math.max(res[i][1], res[i + 1][1]) };
                res[i + 1] = a;
            } else {
                result.add(res[i]);
            }
        }
        result.add(res[length]);
        return result.toArray(new int[result.size()][2]);
    }
}
// @lc code=end
