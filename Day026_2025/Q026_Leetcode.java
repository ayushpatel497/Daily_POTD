import java.util.*;

class Q026_Leetcode {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];
        for (int person = 0; person < n; person++) {
            inDegree[favorite[person]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int person = 0; person < n; person++) {
            if (inDegree[person] == 0) {
                queue.offer(person);
            }
        }

        int[] depth = new int[n];
        Arrays.fill(depth, 1);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int nextNode = favorite[currentNode];
            depth[nextNode] = Math.max(depth[nextNode], depth[currentNode] + 1);
            if (--inDegree[nextNode] == 0) {
                queue.offer(nextNode);
            }
        }

        int longestCycle = 0;
        int twoCycleInvitations = 0;

        for (int person = 0; person < n; person++) {
            if (inDegree[person] != 0) {
                int cycleLength = 0;
                int current = person;
                while (inDegree[current] != 0) {
                    inDegree[current] = 0;
                    cycleLength++;
                    current = favorite[current];
                }

                if (cycleLength == 2) {
                    twoCycleInvitations += depth[person] + depth[favorite[person]];
                } else {
                    longestCycle = Math.max(longestCycle, cycleLength);
                }
            }
        }

        return Math.max(longestCycle, twoCycleInvitations);
    }
}
