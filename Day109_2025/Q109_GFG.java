class TrieNode {
    TrieNode[] child = new TrieNode[2];
}

class Q109_GFG {
    public int maxXor(int[] arr) {
        TrieNode root = new TrieNode();
        int maxResult = 0;

        insert(root, arr[0]);

        for (int i = 1; i < arr.length; i++) {
            maxResult = Math.max(maxResult, findMaxXor(root, arr[i]));
            insert(root, arr[i]);
        }

        return maxResult;
    }

    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 20; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }
            node = node.child[bit];
        }
    }

    private int findMaxXor(TrieNode root, int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 20; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;
            if (node.child[opposite] != null) {
                maxXor |= (1 << i);
                node = node.child[opposite];
            } else {
                node = node.child[bit];
            }
        }
        return maxXor;
    }
}
