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
    if(root == null){
        return 0;
    }
        int lefth = getlefth(root);
        int righth = getrighth(root);

        if(lefth == righth){
            return (1 << lefth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getlefth(TreeNode root){
        int h = 0;

        while(root != null){
            h++;
            root =root.left;
        }
        return h;
    }
    private int getrighth(TreeNode root){
        int h = 0;
        while(root != null){
            h++;
            root = root.right;
        }
        return h;
    }
}