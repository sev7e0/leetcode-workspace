import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<Integer> supportList = new ArrayList<>();
		combine(0, candidates, supportList, target);
		return result;
	}
	private void combine(int index,int[] candidates, ArrayList<Integer> supportList, int target) {
		if (target<0){
			return;
		}
		if (target == 0){
			result.add(new ArrayList<>(supportList));
		}else {
			for (int i = index; i < candidates.length; i++) {
				supportList.add(candidates[i]);
				combine(i, candidates,supportList,target-candidates[i]);
				supportList.remove(supportList.size()-1);
			}
		}
	}
}
// @lc code=end

