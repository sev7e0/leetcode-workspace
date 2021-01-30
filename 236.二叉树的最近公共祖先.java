/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

 // 前提是p q一定存在于root这棵树中
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果这棵树为空那么返回null
        if (root == null) {
            return null;
        }
        // 如果 p或者q等于root那么root就是他们的最近公共祖先
        if (root == p || root == q) {
            return root;
        }
        //分左右依次往下遍历
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        //
        if (leftNode != null && rightNode != null) {
            return root;
        }
        return leftNode == null ? rightNode : leftNode;

    }
}
// @lc code=end
