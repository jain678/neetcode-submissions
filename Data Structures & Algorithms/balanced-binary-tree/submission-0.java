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
    private int solve(TreeNode root, boolean[] res){
        if(root == null) return 0;
        int lh = solve(root.left, res);
        int rh = solve(root.right, res);
        int heightDiff = Math.abs(rh - lh);
        if(heightDiff > 1){
            res[0] = false;
        }
        return 1 + Math.max(lh, rh);
    }
    public boolean isBalanced(TreeNode root) {
        boolean [] res = new boolean[1];
        res[0] = true;
        solve(root, res);
        return res[0];
    }
}
