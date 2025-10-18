class Q291_GFG {
    void inorder(Node root, ArrayList<Integer> ans) {
        if (root == null) return;
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }

    public int findMedian(Node root) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        int k = ans.size();
        int med = 0;
        if (k % 2 == 0) {
            med = ans.get((k / 2) - 1);
        } else {
            med = ans.get(((k + 1) / 2) - 1);
        }
        return med;
    }
}
