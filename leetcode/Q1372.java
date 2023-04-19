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
    int answer = 0;
    public int longestZigZag(TreeNode root) {
        foo(root, true, 0);
        return answer;
    }

    public void foo(TreeNode cur, boolean isLeft, int depth)
    {
        if(cur == null)
            return;

        answer = Math.max(answer, depth);
        foo(cur.left, true, isLeft ? 1 : depth + 1);
        foo(cur.right, false, isLeft ? depth + 1 : 1);
    }
}