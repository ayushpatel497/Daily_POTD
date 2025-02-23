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
class Q054_Leetcode {
    private TreeNode constructTree(int[] preorder, int[] postorder, int[] preIndex, int[] postIndex) {
        TreeNode root = new TreeNode(preorder[preIndex[0]]);
        preIndex[0]++;  // Move to next in preorder
        
        // If the current root's value is not equal to the current postorder element,
        // it means that the left subtree exists, so recursively construct the left subtree.
        if (root.val != postorder[postIndex[0]]) {
            root.left = constructTree(preorder, postorder, preIndex, postIndex);
        }
        
        // If after processing left subtree, the current root's value is still not equal
        // to the current postorder element, then the right subtree exists.
        if (root.val != postorder[postIndex[0]]) {
            root.right = constructTree(preorder, postorder, preIndex, postIndex);
        }
        
        // After constructing left and right subtrees, move postorder index.
        postIndex[0]++;
        return root;
    }
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int[] preIndex = new int[]{0};
        int[] postIndex = new int[]{0};
        return constructTree(preorder, postorder, preIndex, postIndex);
    }
}
