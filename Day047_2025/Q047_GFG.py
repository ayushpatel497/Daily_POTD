from collections import deque

class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

class Solution:
    # Function to serialize a tree and return a list containing nodes of tree.
    def serialize(self, root):
        if not root:
            return []
        
        serialized_list = []
        queue = deque([root])

        while queue:
            node = queue.popleft()
            if node:
                serialized_list.append(node.data)
                queue.append(node.left)
                queue.append(node.right)
            else:
                serialized_list.append(-1)
        
        return serialized_list

    # Function to deserialize a list and construct the tree.   
    def deSerialize(self, arr):
        if not arr or arr[0] == -1:
            return None
        
        root = Node(arr[0])
        queue = deque([root])
        i = 1

        while queue and i < len(arr):
            node = queue.popleft()

            # Left Child
            if arr[i] != -1:
                node.left = Node(arr[i])
                queue.append(node.left)
            i += 1

            # Right Child
            if i < len(arr) and arr[i] != -1:
                node.right = Node(arr[i])
                queue.append(node.right)
            i += 1

        return root
