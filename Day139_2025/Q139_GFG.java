import java.util.ArrayList;

class Q139_GFG {
    Node pre = null;
    Node succ = null;
    int ele1 = Integer.MIN_VALUE;
    int ele2 = Integer.MAX_VALUE;

    void findPre(Node root, int key) {
        if (root == null) return;
        if (root.data < key) {
            if (ele1 < root.data) {
                ele1 = root.data;
                pre = root;
            }
            findPre(root.right, key);
        } else {
            findPre(root.left, key);
        }
    }

    void findSucc(Node root, int key) {
        if (root == null) return;
        if (root.data > key) {
            if (ele2 > root.data) {
                ele2 = root.data;
                succ = root;
            }
            findSucc(root.left, key);
        } else {
            findSucc(root.right, key);
        }
    }

    public ArrayList<Node> findPreSuc(Node root, int key) {
        findPre(root, key);
        findSucc(root, key);
        ArrayList<Node> res = new ArrayList<>();
        res.add(pre);
        res.add(succ);
        return res;
    }
}
