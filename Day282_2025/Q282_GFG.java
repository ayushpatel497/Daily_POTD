class Q282_GFG {
    ArrayList<Integer> postOrd = new ArrayList<>();

    public ArrayList<Integer> postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            postOrd.add(root.data);
        }
        return postOrd;
    }
}
