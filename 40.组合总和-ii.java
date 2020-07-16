import java.util.*;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    // 1,1,2,5,6,7,10
    List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //无序 首先要先排序
        Arrays.sort(candidates);
		ArrayList<Integer> supportList = new ArrayList<>();
		combine(0, candidates, supportList, target);
		return result;
	}
	private void combine(int index,int[] candidates, ArrayList<Integer> supportList, int target) {
        //剪枝操作
		if (target<0){
			return;
        }
        //剪枝操作
		if (target == 0){
			result.add(new ArrayList<>(supportList));
		}else {
			for (int i = index; i < candidates.length; i++) {
                //同样还是剪枝操作
                if (i > index && candidates[i] == candidates[i-1]) {
                    continue;
                }
                supportList.add(candidates[i]);
                //不同于39题，元素不可重复使用，下一次递归从
				combine(i+1, candidates,supportList,target-candidates[i]);
				supportList.remove(supportList.size()-1);
			}
		}
	}
}
// @lc code=end

