/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int v = x;
        int res = 0;
        //反转
        while (x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res == v;
    }
}
// @lc code=end

