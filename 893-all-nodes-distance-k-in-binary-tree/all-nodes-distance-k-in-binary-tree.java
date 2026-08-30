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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> par = new HashMap<>();
        findpar(root, null, par);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> v = new HashSet<>();

        queue.offer(target);
        v.add(target);

        int dist = 0;
        while(!queue.isEmpty() && dist < k){
            int s = queue.size();
            for(int i = 0; i < s; i++){
                TreeNode node = queue.poll();

                if(node.right != null && v.add(node.right)){
                    queue.offer(node.right);
                }

                if(node.left != null && v.add(node.left)){
                    queue.offer(node.left);
                }

                TreeNode parnode = par.get(node);
                if(parnode != null && v.add(parnode)){
                    queue.offer(parnode);
                }
            }
            dist++;

        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
        res.add(queue.poll().val);
        }
        return res;

    }
    private void findpar(TreeNode node, TreeNode parnode, Map<TreeNode, TreeNode> par){
        if(node == null){
            return;

        }

        par.put(node, parnode);

        findpar(node.left, node, par);
        findpar(node.right, node, par);
    }
}