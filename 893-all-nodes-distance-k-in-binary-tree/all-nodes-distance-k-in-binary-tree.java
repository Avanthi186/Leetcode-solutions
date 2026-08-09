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
       Map<TreeNode, TreeNode> parent = new HashMap<>();
       makeparent(root, parent);

       Queue<TreeNode> q = new LinkedList<>();
       Set<TreeNode> v = new HashSet<>();
       q.offer(target);
       v.add(target);
       int d = 0;
       while(!q.isEmpty()){
        if(d == k){
            break;
        }

        int size = q.size();
        for(int i = 0; i < size; i++){
            TreeNode curr = q.poll();

            if(curr.left != null & !v.contains(curr.left)){
                q.offer(curr.left);
                v.add(curr.left);
            }
            if(curr.right != null && !v.contains(curr.right)){
                q.offer(curr.right);
                v.add(curr.right);
            }
            if(parent.containsKey(curr) && !v.contains(parent.get(curr))){
                q.offer(parent.get(curr));
                v.add(parent.get(curr));
            }
        }
        d++;
       }
       List<Integer> ans = new ArrayList<>();
       while(!q.isEmpty()){
        ans.add(q.poll().val);
       }
       return ans;
    }
    private void makeparent(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode cur = q.poll();

            if(cur.left != null){
                parent.put(cur.left, cur);
                q.offer(cur.left);
            }
            if(cur.right != null){
                parent.put(cur.right, cur);
                q.offer(cur.right);
            }
        }
    }
}