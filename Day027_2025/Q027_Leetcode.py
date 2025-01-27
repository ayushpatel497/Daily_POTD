from typing import List
from collections import defaultdict, deque

class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        # Create adjacency list and indegree array
        adj_list = defaultdict(list)
        indegree = [0] * numCourses
        for u, v in prerequisites:
            adj_list[u].append(v)
            indegree[v] += 1

        # Initialize queue for topological sort
        queue = deque([i for i in range(numCourses) if indegree[i] == 0])

        # Map to store prerequisites for each course
        prereq_map = defaultdict(set)

        # Topological sort to build prerequisite map
        while queue:
            course = queue.popleft()
            for next_course in adj_list[course]:
                prereq_map[next_course].add(course)
                prereq_map[next_course].update(prereq_map[course])
                indegree[next_course] -= 1
                if indegree[next_course] == 0:
                    queue.append(next_course)

        # Answer queries
        return [query[0] in prereq_map[query[1]] for query in queries]
