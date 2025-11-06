import heapq
from typing import List

class Vertex:
    def __init__(self, vertexId: int):
        self.vertexId = vertexId
        self.offline = False
        self.powerGridId = -1

class Solution:
    def processQueries(self, c: int, connections: List[List[int]], queries: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(c + 1)]
        vertices = [Vertex(i) for i in range(c + 1)]

        for u, v in connections:
            graph[u].append(v)
            graph[v].append(u)

        def traverse(u: Vertex, grid_id: int, grid_heap: List[int]):
            u.powerGridId = grid_id
            heapq.heappush(grid_heap, u.vertexId)
            for vId in graph[u.vertexId]:
                v = vertices[vId]
                if v.powerGridId == -1:
                    traverse(v, grid_id, grid_heap)

        power_grids = []
        grid_id = 0
        for i in range(1, c + 1):
            if vertices[i].powerGridId == -1:
                grid_heap = []
                traverse(vertices[i], grid_id, grid_heap)
                power_grids.append(grid_heap)
                grid_id += 1

        answer = []
        for op, vertex in queries:
            v = vertices[vertex]
            if op == 1:
                if not v.offline:
                    answer.append(vertex)
                else:
                    pq = power_grids[v.powerGridId]
                    while pq and vertices[pq[0]].offline:
                        heapq.heappop(pq)
                    answer.append(pq[0] if pq else -1)
            elif op == 2:
                v.offline = True

        return answer
