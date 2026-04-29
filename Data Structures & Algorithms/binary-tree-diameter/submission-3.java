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
    int ans = 0;
    private int solve(TreeNode root, int [] ans){
        if(root == null ) return 0;
        int lh = solve(root.left, ans);
        int rh = solve(root.right, ans );
        ans[0] = Math.max(ans[0], lh + rh);
        return 1 + Math.max(lh, rh);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        int ret  = solve(root, res);
        return res[0];
    }
}
