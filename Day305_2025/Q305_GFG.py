from collections import deque

class Solution:
    def findOrder(self, n, prerequisites):
        def make_graph(numTasks, prerequisites):
            graph = [[] for _ in range(numTasks)]
            for pre in prerequisites:
                graph[pre[1]].append(pre[0])
            return graph

        def compute_indegree(graph):
            indegree = [0] * len(graph)
            for neighbors in graph:
                for neigh in neighbors:
                    indegree[neigh] += 1
            return indegree

        graph = make_graph(n, prerequisites)
        indegree = compute_indegree(graph)

        zeros = deque([i for i in range(n) if indegree[i] == 0])
        toposort = []

        for _ in range(n):
            if not zeros:
                return []  # cycle detected
            zero = zeros.popleft()
            toposort.append(zero)
            for neigh in graph[zero]:
                indegree[neigh] -= 1
                if indegree[neigh] == 0:
                    zeros.append(neigh)

        return toposort
