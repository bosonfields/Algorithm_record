/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        int h = helper(root);
        return flag;
    }
    public int helper(TreeNode head){
        if(head == null) return 0;

        int left = helper(head.left);
        int right = helper(head.right);
        if(Math.abs(left-right)>1) flag = false;
        return Math.max(left, right) + 1;  
    }
}