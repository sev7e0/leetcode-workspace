import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        LinkedList<Character> stack = new LinkedList<>();
        stack.add('?');
        for (int i = 0; i < s.length(); i++) {
            Character tmp = s.charAt(i);
            //判断栈顶元素是否与map中获取到的一致，一致出栈
            //不一致入栈
            if (stack.peek().equals(map.get(tmp))) {
                stack.pop();
                continue;
            }
            stack.push(tmp);
        }
        return stack.size() == 1;
    }
}
// @lc code=end

