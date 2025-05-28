/*
 * @lc app=leetcode.cn id=239 lang=java
 * @lcpr version=30201
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.ArrayDeque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 维护队列单调性
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 入队
            deque.offerLast(i);

            // 出队：超过窗口
            if (i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            // 记录结果
            if (i >= k - 1) {
                // 放入i - k +1 的位置
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,3,-1,-3,5,3,6,7]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n1\n
 * // @lcpr case=end
 * 
 */
