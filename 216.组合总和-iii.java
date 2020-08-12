import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 切记从1开始
        backTrack(new ArrayList<>(), 1, k, n);
        return result;
    }
    void backTrack(List<Integer> temp, int start, int size, int target) {
        //两个判定条件，1.要求k个数，也是不多不少正好k才会被录用。
        //2.要求和为n，也就是我们当前的target是否正好为0，不需要其他的数了，才会被录用
        if (size == 0 && 0 == target) {
            result.add(new ArrayList<>(temp));
            return;
        } else {
            //标准的回溯模板，for循环递归做选择，主意起始位置开始为上一次传递，终止为小于10
            for (int i = start; i < 10; i++) {
                //剪枝操作
                if (target - i < 0) {
                    break;
                }
                //加到路径中来
                temp.add(i);
                //继续探索，条件：
                //1、开始位置为当前i+1开始，因为不允许重复
                //2、当前容量，为size-1要求n个数组成
                //3、目标值为target-i，也就是组合剩余所需的数值
                backTrack(temp, i + 1, size - 1, target - i);
                //完成一次选择，回退一次，继续遍历
                temp.remove(temp.size() - 1);
            }
        }

    }

}
// @lc code=end
