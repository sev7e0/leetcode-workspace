/*
 * @lc app=leetcode.cn id=438 lang=java
 * @lcpr version=30201
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] charArray = p.toCharArray();
        int[] cnt = new int[26];
        for (char charArray2 : charArray) {
            cnt[charArray2 - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // 进入窗口
            int c = s.charAt(right) - 'a';
            // 对应位置-1
            cnt[c]--;
            // 只要小于零就一直左移
            while (cnt[c] < 0) {
                // 当前位置 ++
                cnt[s.charAt(left) - 'a']++;
                // left 左移
                left++;
            }
            // 如果长度相等，那就是满足字母异位词
            if (right + 1 - left == p.length()) {
                res.add(left);
            }
        }
        return res;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "cbaebabacd"\n"abc"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "abab"\n"ab"\n
 * // @lcpr case=end
 * 
 */
