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
class Q053_Leetcode {
    // Helper function that builds the tree recursively.
    private TreeNode helper(String traversal, int[] index, int depth) {
        // If we've reached the end of the traversal string, return null.
        if (index[0] >= traversal.length()) 
            return null;
        
        // Count the number of dashes at the current position.
        int dashCount = 0;
        while (index[0] + dashCount < traversal.length() &&
               traversal.charAt(index[0] + dashCount) == '-') {
            dashCount++;
        }
        
        // If the number of dashes does not match the current depth, this node is not at this level.
        if (dashCount != depth) 
            return null;
        
        // Move the index past the dashes.
        index[0] += dashCount;
        
        // Parse the numeric value.
        int value = 0;
        while (index[0] < traversal.length() &&
               Character.isDigit(traversal.charAt(index[0]))) {
            value = value * 10 + (traversal.charAt(index[0]) - '0');
            index[0]++;
        }
        
        // Create a new TreeNode with the parsed value.
        TreeNode node = new TreeNode(value);
        
        // Recursively construct the left and right subtrees.
        node.left = helper(traversal, index, depth + 1);
        node.right = helper(traversal, index, depth + 1);
        
        return node;
    }
    
    public TreeNode recoverFromPreorder(String traversal) {
        int[] index = new int[]{0}; // Use an array to simulate pass-by-reference for the index.
        return helper(traversal, index, 0);
    }
}
