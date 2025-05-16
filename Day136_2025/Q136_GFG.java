import java.util.*;

class Q136_GFG {
    class Node implements Comparable<Node> {
        int val, row, col;
        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Node other) {
            return this.val - other.val;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            pq.add(new Node(arr[i][0], i, 0));
            maxVal = Math.max(maxVal, arr[i][0]);
        }

        int minRange = Integer.MAX_VALUE;
        int minEl = -1, maxEl = -1;

        while (true) {
            Node curr = pq.poll();
            int minVal = curr.val;

            if (maxVal - minVal < minRange) {
                minRange = maxVal - minVal;
                minEl = minVal;
                maxEl = maxVal;
            }

            if (curr.col + 1 == n) break;

            int nextVal = arr[curr.row][curr.col + 1];
            pq.add(new Node(nextVal, curr.row, curr.col + 1));
            maxVal = Math.max(maxVal, nextVal);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minEl);
        result.add(maxEl);
        return result;
    }
}
