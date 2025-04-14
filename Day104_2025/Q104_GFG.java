import java.util.*;
class Q104_GFG {
    public String findOrder(String[] words) {
        int[] inDegree = new int[26];
        boolean[] exists = new boolean[26];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            graph.add(new ArrayList<>());
        }

        // Mark which characters exist in the words
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exists[ch - 'a'] = true;
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; ++i) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            int j = 0;
            while (j < len && w1.charAt(j) == w2.charAt(j)) j++;

            if (j < len) {
                int u = w1.charAt(j) - 'a';
                int v = w2.charAt(j) - 'a';
                graph.get(u).add(v);
                inDegree[v]++;
            } else if (w1.length() > w2.length()) {
                return "";
            }
        }

        // Topological sort using BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (exists[i] && inDegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            result.append((char)(u + 'a'));

            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // Validate all existing characters are in result
        for (int i = 0; i < 26; ++i) {
            if (exists[i] && inDegree[i] != 0) {
                return "";
            }
        }

        return result.toString();
    }
}
