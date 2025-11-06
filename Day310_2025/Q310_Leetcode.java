import java.util.*;

class Vertex {
    int vertexId;
    boolean offline = false;
    int powerGridId = -1;

    Vertex() {}
    Vertex(int id) {
        this.vertexId = id;
    }
}

class Q310_Leetcode {
    private List<Vertex> vertices;

    private void traverse(Vertex u, int powerGridId, PriorityQueue<Integer> powerGrid, List<List<Integer>> graph) {
        u.powerGridId = powerGridId;
        powerGrid.add(u.vertexId);

        for (int vId : graph.get(u.vertexId)) {
            Vertex v = vertices.get(vId);
            if (v.powerGridId == -1) {
                traverse(v, powerGridId, powerGrid, graph);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        vertices = new ArrayList<>();

        for (int i = 0; i <= c; i++) {
            graph.add(new ArrayList<>());
            vertices.add(new Vertex(i));
        }

        for (int[] connection : connections) {
            int u = connection[0], v = connection[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<PriorityQueue<Integer>> powerGrids = new ArrayList<>();
        int powerGridId = 0;

        for (int i = 1; i <= c; i++) {
            Vertex v = vertices.get(i);
            if (v.powerGridId == -1) {
                PriorityQueue<Integer> powerGrid = new PriorityQueue<>();
                traverse(v, powerGridId, powerGrid, graph);
                powerGrids.add(powerGrid);
                powerGridId++;
            }
        }

        List<Integer> ansList = new ArrayList<>();

        for (int[] query : queries) {
            int operation = query[0], vertex = query[1];
            if (operation == 1) {
                Vertex v = vertices.get(vertex);
                if (!v.offline) {
                    ansList.add(vertex);
                } else {
                    PriorityQueue<Integer> pq = powerGrids.get(v.powerGridId);
                    while (!pq.isEmpty() && vertices.get(pq.peek()).offline) {
                        pq.poll();
                    }
                    ansList.add(pq.isEmpty() ? -1 : pq.peek());
                }
            } else if (operation == 2) {
                vertices.get(vertex).offline = true;
            }
        }

        // Convert list to array
        return ansList.stream().mapToInt(i -> i).toArray();
    }
}
