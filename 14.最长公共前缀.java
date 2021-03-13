/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String r = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //根据两个字符串长度最小的进行循环
            int lenth = r.length() > strs[i].length() ? strs[i].length() : r.length();
            int posi = 0;
            for (; posi < lenth; posi++) {
                if (r.charAt(posi) != strs[i].charAt(posi)) {
                    break;
                }
            }
            // 每次根据新的position更新位置
            r = r.substring(0, posi);
            // 剪枝，避免不必要的循环
            if ("".equals(r)) {
                return r;
            }

        }
        return r;
    }
}
// @lc code=end
