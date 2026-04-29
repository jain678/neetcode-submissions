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
    public boolean isSameTree(TreeNode p, TreeNode q) {
       Queue<TreeNode> q1 = new LinkedList<>();
       Queue<TreeNode> q2 = new LinkedList<>();       

       q1.add(p);
       q2.add(q);

       while(!q1.isEmpty() && !q2.isEmpty()){
        for(int i = q1.size(); i>=0; i--){
            TreeNode nodep = q1.poll();
            TreeNode nodeq = q2.poll();

            if(nodep == null && nodeq == null) continue;
            if(nodep == null || nodeq == null || nodep.val != nodeq.val) return false;

            q1.add(nodep.left);
            q1.add(nodep.right);
            q2.add(nodeq.left);
            q2.add(nodeq.right);

        }
       }
       return true;

    }
}
