import java.util.*;

class Q027_Leetcode {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Create adjacency list and indegree array
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            adjList.computeIfAbsent(edge[0], _ -> new ArrayList<>()).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Initialize queue for topological sort
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Map to store prerequisites for each course
        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();

        // Topological sort to build prerequisite map
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int nextCourse : adjList.getOrDefault(course, new ArrayList<>())) {
                prereqMap.computeIfAbsent(nextCourse, _ -> new HashSet<>()).add(course);
                prereqMap.get(nextCourse).addAll(prereqMap.getOrDefault(course, new HashSet<>()));
                if (--indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        // Answer queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(prereqMap.getOrDefault(query[1], new HashSet<>()).contains(query[0]));
        }

        return result;
    }
}
