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
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        ArrayList<int[]> arrayList = new ArrayList<>();
        int len = intervals.length;
        int[] cur = intervals[0]; // 初始化
        for (int right = 1; right < len; right++) {
            if (cur[1] >= intervals[right][0]) {
                // 判定前后两个的右边界哪个大
                cur[1] = Math.max(cur[1], intervals[right][1]);
            } else {
                /// 把 cur 加入结果列表，重新启动一段 cur
                arrayList.add(cur);
                cur = intervals[right];
            }
        }
        // 把cur加入结果
        arrayList.add(cur);
        return arrayList.toArray(new int[arrayList.size()][2]);
    }

}
// @lc code=end
