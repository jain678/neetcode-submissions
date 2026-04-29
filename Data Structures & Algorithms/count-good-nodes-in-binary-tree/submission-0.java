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
    int cnt = 0;
    private void solve(TreeNode root, int mx){
        if(root == null) return ;

        if(root.val >= mx){
            cnt++;
            mx = root.val;
        }
        solve(root.left, mx);
        solve(root.right, mx);
    }
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        solve(root, root.val);
        return cnt;
    }
}
