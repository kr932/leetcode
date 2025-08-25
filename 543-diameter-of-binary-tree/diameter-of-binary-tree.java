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
    private int diameter = 0; // stores the maximum diameter found
    
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }
    
    // Helper function: returns the depth (height) of the tree
    private int depth(TreeNode node) {
        if (node == null) return 0;
        
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        
        // Update diameter: longest path through this node
        diameter = Math.max(diameter, leftDepth + rightDepth);
        
        // return height of the node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
