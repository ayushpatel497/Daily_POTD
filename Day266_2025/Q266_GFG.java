import java.util.*;

class Q266_GFG {
    public void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) return;

        int x = q.poll();   // remove front
        reverseQueue(q);    // recurse
        q.add(x);           // add back
    }
}
