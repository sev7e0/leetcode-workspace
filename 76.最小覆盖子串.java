/*
 * @lc app=leetcode.cn id=76 lang=java
 * @lcpr version=30201
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        // 使用 int[128] 是因为它可以无脑支持所有 ASCII 字符，不需要自己写复杂
        // 的字符映射逻辑，代码更安全、健壮。除非你非常确定字符种类有限，否则别用 52。
        int[] sArray = new int[128];
        int[] tArray = new int[128];
        int ansLeft = -1;
        int ansRIght = s.length();
        // 构造
        for (int i = 0; i < t.length(); i++) {
            tArray[t.charAt(i)]++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // 入
            sArray[s.charAt(right)]++;

            while (isCover(sArray, tArray)) {
                // 判定是否为最小
                if (right - left < ansRIght - ansLeft) {
                    ansLeft = left;
                    ansRIght = right;
                }
                // 出 找到最小的覆盖子串
                sArray[s.charAt(left)]--;
                left++;
            }
        }
        // 更新结果
        return ansLeft < 0 ? ans : s.substring(ansLeft, ansRIght + 1);
    }

    public boolean isCover(int[] sArray, int[] tArray) {
        // 可以直接循环 sArray的长度
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] < tArray[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "ADOBECODEBANC"\n"ABC"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a"\n"a"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a"\n"aa"\n
 * // @lcpr case=end
 * 
 */
