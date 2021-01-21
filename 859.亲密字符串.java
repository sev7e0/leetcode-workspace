import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    //拆成两个字符数组
    //挨个比较
    public boolean buddyStrings(final String A, final String B) {
        if (Objects.isNull(A) || Objects.isNull(B) || B.length() != A.length()) {
            return false;
        }
        //判断两个字符串是否相等
        if (A.equals(B)) {
            //相等只需要判定其是否为单一元素 如 aa这种
            final Set<Character> ch = new HashSet<>();
            for (int i = 0; i < B.length(); i++) {
                ch.add(A.charAt(i));
            }
            if (ch.size() < B.length()) {
                return true;
            }
        }else{
            //不想等就需要判定其是否存在正好两个 相同但位置互换的元素
            final List<Integer> qu = new LinkedList<>();
            for (int i = 0; i < B.length(); i++) {
                if (qu.size() > 2) {
                   return false;
                }
                if (B.charAt(i) != A.charAt(i)) {
                    qu.add(i);
                }
            }
            if (qu.size()<2) {
                return false;
            }
            //如果两个位置是互换的两个元素
            if (A.charAt(qu.get(0)) == B.charAt(qu.get(1)) 
            && A.charAt(qu.get(1)) == B.charAt(qu.get(0))) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

