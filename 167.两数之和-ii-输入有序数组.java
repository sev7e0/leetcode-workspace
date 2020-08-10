/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length-1;
        while (head<tail) {
            int sum = numbers[head] + numbers[tail];
            if (sum == target) {
                return new int[]{head+1, tail+1};
            }else if (sum>target) {
                tail--;
            }else{
                head++;
            }
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

