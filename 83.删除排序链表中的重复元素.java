/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            if (p2.val == p2.next.val) {
                p2.next = p2.next.next;
            }else{
                p2 = p2.next;
            }
        }
        return head;
    }
}
// @lc code=end

