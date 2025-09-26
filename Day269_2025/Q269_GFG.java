import java.util.*;

class Q269_GFG {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        if (type == 1) { // rotate right
            for (int i = 0; i < k; i++) {
                int val = dq.removeLast();
                dq.addFirst(val);
            }
        } else if (type == 2) { // rotate left
            for (int i = 0; i < k; i++) {
                int val = dq.removeFirst();
                dq.addLast(val);
            }
        }
    }
}
