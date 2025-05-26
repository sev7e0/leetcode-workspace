/*
 * @lc app=leetcode.cn id=1456 lang=java
 * @lcpr version=30201
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        char[] charArray = s.toCharArray();
        int maxVowels = 0;
        int res = 0;
        for (int i = 0; i < charArray.length; i++) {
            // 窗口增加
            if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o'
                    || charArray[i] == 'u') {
                maxVowels++;
            }
            // 不到定长持续增加
            if (i < k - 1) {
                continue;
            }
            // 更新最大值
            res = Math.max(maxVowels, res);
            // 移除前更新
            if (charArray[i + 1 - k] == 'a' || charArray[i + 1 - k] == 'e' || charArray[i + 1 - k] == 'i'
                    || charArray[i + 1 - k] == 'o' || charArray[i + 1 - k] == 'u') {
                maxVowels--;
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "abciiidef"\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "aeiou"\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "leetcode"\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "rhythms"\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "tryhard"\n4\n
 * // @lcpr case=end
 * 
 */
