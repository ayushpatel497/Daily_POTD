from typing import List

class Solution:
    def mostProfitablePath(self, edges: List[List[int]], bob: int, amount: List[int]) -> int:
        n = len(amount)
        # Build tree as an adjacency list.
        tree = [[] for _ in range(n)]
        for u, v in edges:
            tree[u].append(v)
            tree[v].append(u)
        
        distanceFromBob = [0] * n
        
        def findPaths(sourceNode: int, parentNode: int, time: int) -> int:
            nonlocal n, bob, amount, tree, distanceFromBob
            maxIncome = 0
            maxChild = float('-inf')
            
            # Initialize distanceFromBob for this node.
            if sourceNode == bob:
                distanceFromBob[sourceNode] = 0
            else:
                distanceFromBob[sourceNode] = n  # n is an upper bound.
            
            # Explore all children.
            for adjacentNode in tree[sourceNode]:
                if adjacentNode != parentNode:
                    maxChild = max(maxChild, findPaths(adjacentNode, sourceNode, time + 1))
                    distanceFromBob[sourceNode] = min(distanceFromBob[sourceNode], distanceFromBob[adjacentNode] + 1)
            
            # Determine income contribution from this node.
            if distanceFromBob[sourceNode] > time:
                maxIncome += amount[sourceNode]
            elif distanceFromBob[sourceNode] == time:
                maxIncome += amount[sourceNode] // 2
            
            # If no child exists, return current income.
            if maxChild == float('-inf'):
                return maxIncome
            else:
                return maxIncome + maxChild
        
        return findPaths(0, 0, 0)
