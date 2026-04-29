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
class IntWrapper{
    int value;
}
class Solution {
    private int solve(TreeNode root, IntWrapper ans){
        if(root == null ) return 0;
        int lh = solve(root.left, ans);
        int rh = solve(root.right, ans);
        ans.value = Math.max(ans.value, lh + rh);
        return 1 + Math.max(lh, rh);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        IntWrapper ans = new IntWrapper();
        ans.value = 0;
        int rees  = solve(root, ans);
        return ans.value;
    }
}
