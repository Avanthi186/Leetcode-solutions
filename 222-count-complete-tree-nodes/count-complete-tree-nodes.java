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
    public int countNodes(TreeNode root) {
        if(root == null)
        return 0;

        int lefth = countlefth(root);
        int righth = countrighth(root);
        if(lefth == righth){
            return (int)Math.pow(2, lefth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int countlefth(TreeNode node){
        int h = 0;
        while(node != null){
            h++;
            node = node.left;
        }
        return h;
    }

    private int countrighth(TreeNode node){
        int h = 0;
        while(node != null){
            h++;
            node = node.right;
        }
        return h;
    }
}