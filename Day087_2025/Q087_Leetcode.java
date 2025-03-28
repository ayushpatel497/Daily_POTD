import java.util.*;

class Cell {
    int row, col, value;
    Cell(int r, int c, int v) {
        this.row = r;
        this.col = c;
        this.value = v;
    }
}

class Query {
    int index, value;
    Query(int i, int v) {
        this.index = i;
        this.value = v;
    }
}

class UnionFind {
    private int[] parent, size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(size, 1);
    }

    public int find(int node) {
        if (parent[node] < 0) return node;
        return parent[node] = find(parent[node]);
    }

    public boolean union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);
        if (rootA == rootB) return false;
        
        if (size[rootA] > size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        return true;
    }

    public int getSize(int node) {
        return size[find(node)];
    }
}

class Q087_Leetcode {
    private static final int[] ROW_DIRECTIONS = {0, 0, 1, -1};
    private static final int[] COL_DIRECTIONS = {1, -1, 0, 0};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int rowCount = grid.length, colCount = grid[0].length;
        int totalCells = rowCount * colCount;

        List<Query> sortedQueries = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            sortedQueries.add(new Query(i, queries[i]));
        }
        sortedQueries.sort(Comparator.comparingInt(q -> q.value));

        List<Cell> sortedCells = new ArrayList<>();
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                sortedCells.add(new Cell(row, col, grid[row][col]));
            }
        }
        sortedCells.sort(Comparator.comparingInt(c -> c.value));

        UnionFind uf = new UnionFind(totalCells);
        int[] result = new int[queries.length];

        int cellIndex = 0;
        for (Query query : sortedQueries) {
            while (cellIndex < totalCells && sortedCells.get(cellIndex).value < query.value) {
                int row = sortedCells.get(cellIndex).row;
                int col = sortedCells.get(cellIndex).col;
                int cellId = row * colCount + col;

                for (int d = 0; d < 4; d++) {
                    int newRow = row + ROW_DIRECTIONS[d];
                    int newCol = col + COL_DIRECTIONS[d];
                    if (newRow >= 0 && newRow < rowCount && newCol >= 0 && newCol < colCount &&
                        grid[newRow][newCol] < query.value) {
                        uf.union(cellId, newRow * colCount + newCol);
                    }
                }
                cellIndex++;
            }
            result[query.index] = query.value > grid[0][0] ? uf.getSize(0) : 0;
        }

        return result;
    }

    public static void main(String[] args) {
        Q087_Leetcode sol = new Q087_Leetcode();
        int[][] grid = {{1, 2, 4}, {3, 4, 3}, {2, 1, 2}};
        int[] queries = {2, 3, 4};
        System.out.println(Arrays.toString(sol.maxPoints(grid, queries))); // Example Output
    }
}
