/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30201
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (hashMap.containsKey(s.charAt(right))) {
                hashMap.put(s.charAt(right), hashMap.get(s.charAt(right)) + 1);
            } else {
                hashMap.put(s.charAt(right), 1);
            }
            while (hashMap.get(s.charAt(right)) > 1) {
                hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "abcabcbb"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "bbbbb"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "pwwkew"\n
 * // @lcpr case=end
 * 
 */
