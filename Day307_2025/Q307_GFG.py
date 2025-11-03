class Solution:
    def safeNodes(self, V, edges):
        from collections import deque, defaultdict

        reverseGraph = defaultdict(list)
        outDegree = [0] * V

        for u, v in edges:
            reverseGraph[v].append(u)
            outDegree[u] += 1

        q = deque([i for i in range(V) if outDegree[i] == 0])
        safeNodes = []

        while q:
            node = q.popleft()
            safeNodes.append(node)
            for parent in reverseGraph[node]:
                outDegree[parent] -= 1
                if outDegree[parent] == 0:
                    q.append(parent)

        return sorted(safeNodes)
