import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {

            digits[i] = digits[i]+1;
            digits[i] = digits[i]%10;
            if (0!=digits[i]) {
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
// @lc code=end

