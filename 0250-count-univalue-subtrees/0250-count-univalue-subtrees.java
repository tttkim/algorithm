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
    static int answer;
    public int countUnivalSubtrees(TreeNode root) {
        answer = 0;
        isUnivalue(root);
        return answer;
    }
    
    public boolean isUnivalue(TreeNode curr) {
        if (curr == null)
            return true;
        boolean leftValue = isUnivalue(curr.left);
        boolean rightValue = isUnivalue(curr.right);
        if (leftValue && rightValue) {
            if (curr.left != null && curr.left.val != curr.val)
                return false;
            if (curr.right != null && curr.right.val != curr.val)
                return false;
            // System.out.println("Node " + curr.val + " is Univalue");
            answer++;
            return true;
        }
        // System.out.println("Node " + curr.val + " is not Univalue");

        return false;
    } 
}