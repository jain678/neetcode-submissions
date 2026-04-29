/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private boolean inorder(TreeNode root, int mn, int mx){
        if(root == null) return true;
        if(!(root.val > mn && root.val < mx)) 
            return false;
        return inorder(root.left, mn, root.val) && inorder(root.right, root.val, mx);
    }
    public boolean isValidBST(TreeNode root) {
        return inorder(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
