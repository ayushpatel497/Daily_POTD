import java.util.*;

class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void unite(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    void reset(int x) {
        parent[x] = x;
        rank[x] = 0;
    }
}

class Q353_Leetcode {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

        Map<Integer, List<int[]>> sameTimeMeetings = new HashMap<>();
        for (int[] m : meetings) {
            sameTimeMeetings
                .computeIfAbsent(m[2], k -> new ArrayList<>())
                .add(new int[]{m[0], m[1]});
        }

        UnionFind uf = new UnionFind(n);
        uf.unite(0, firstPerson);

        for (int time : sameTimeMeetings.keySet()) {
            List<int[]> list = sameTimeMeetings.get(time);

            for (int[] m : list) {
                uf.unite(m[0], m[1]);
            }

            for (int[] m : list) {
                if (!uf.connected(m[0], 0)) {
                    uf.reset(m[0]);
                    uf.reset(m[1]);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uf.connected(i, 0)) ans.add(i);
        }

        return ans;
    }
}
