import java.util.*;

class Q267_GFG {
    private Queue<Integer> q;
    private Deque<Integer> minQ, maxQ;

    public Q267_GFG() {
        q = new LinkedList<>();
        minQ = new LinkedList<>();
        maxQ = new LinkedList<>();
    }

    public void enqueue(int x) {
        q.add(x);

        while (!minQ.isEmpty() && minQ.peekLast() > x) {
            minQ.pollLast();
        }
        minQ.addLast(x);

        while (!maxQ.isEmpty() && maxQ.peekLast() < x) {
            maxQ.pollLast();
        }
        maxQ.addLast(x);
    }

    public void dequeue() {
        if (q.isEmpty()) return;
        int val = q.poll();
        if (!minQ.isEmpty() && minQ.peekFirst() == val) minQ.pollFirst();
        if (!maxQ.isEmpty() && maxQ.peekFirst() == val) maxQ.pollFirst();
    }

    public int getFront() {
        return q.peek();
    }

    public int getMin() {
        return minQ.peekFirst();
    }

    public int getMax() {
        return maxQ.peekFirst();
    }
}
