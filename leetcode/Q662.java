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
    int[] firstId = new int[3001];
    int answer = 0;
    int maxDepth = 0;

    public int widthOfBinaryTree(TreeNode root) {
        helper(root, 0, 0);
        return answer;
    }

    public void helper(TreeNode cur, int depth, int id)
    {
        if(cur == null)
            return;

        if(firstId[depth] == 0)
            firstId[depth] = id;
        
        answer = Math.max(answer, id - firstId[depth] + 1);

        helper(cur.left, depth+1, 2*id+1);
        helper(cur.right, depth+1, 2*id+2);
    }
}