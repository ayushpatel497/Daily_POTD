from collections import deque

class Node:
    def __init__(self, value):
        self.left = None
        self.data = value
        self.right = None

class Solution:
    def levelOrder(self, root):
        if not root:
            return []
        
        levelOrderTraversal = []
        queue = deque([root])
        
        while queue:
            levelSize = len(queue)
            levelNodes = []
            
            for _ in range(levelSize):
                currentNode = queue.popleft()
                levelNodes.append(currentNode.data)
                
                if currentNode.left:
                    queue.append(currentNode.left)
                if currentNode.right:
                    queue.append(currentNode.right)
                    
            levelOrderTraversal.append(levelNodes)
        
        return levelOrderTraversal
