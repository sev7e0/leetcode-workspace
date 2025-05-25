/*
 * @lc app=leetcode.cn id=49 lang=java
 * @lcpr version=30201
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> reList = new ArrayList<>();
        if (strs.length == 0) {
            return reList;
        }
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            hashMap.computeIfAbsent(new String(charArray), m -> new ArrayList<>()).add(str);
        }
        reList.addAll(hashMap.values());
        return reList;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // ["eat", "tea", "tan", "ate", "nat", "bat"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [""]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["a"]\n
 * // @lcpr case=end
 * 
 */
