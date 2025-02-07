import java.util.*;

class Q038_GFG {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        fillInorder(root, inorderList);
        return inorderList;
    }
    
    // Helper function to perform inorder traversal
    private void fillInorder(Node root, ArrayList<Integer> inorderList) {
        if (root == null) {
            return;
        }
        
        fillInorder(root.left, inorderList);  // Traverse left subtree
        inorderList.add(root.data);           // Visit root
        fillInorder(root.right, inorderList); // Traverse right subtree
    }
}
