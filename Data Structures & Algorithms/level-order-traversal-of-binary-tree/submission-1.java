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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        

        if(root == null)
        return ans;

        q.add(root);
        while(!q.isEmpty()){
            List<Integer> t = new ArrayList<>();
            int size = q.size();
            System.out.println(size);
            for(int i = 0; i< size; i++){
                TreeNode nodeq = q.poll();

                if(nodeq == null)
                 continue;

                t.add(nodeq.val);

                q.add(nodeq.left);

                q.add(nodeq.right);
            }
            if(!t.isEmpty())
            ans.add(t);
        }
        return ans;
    }
}
