class Q045_GFG {
    Node first = null, middle = null, last = null, prev = null;
    private void getWrongNodes(Node root) {
        if (root == null) 
            return;

        getWrongNodes(root.left);

        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        
        prev = root;

        getWrongNodes(root.right);
    }

    public void correctBST(Node root) {
        
        getWrongNodes(root);

        if (first != null && last != null) {
            // Swap the data of the first and last nodes
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } 
        else if (first != null && middle != null) {
            // Swap the data of the first and middle nodes
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }
}
