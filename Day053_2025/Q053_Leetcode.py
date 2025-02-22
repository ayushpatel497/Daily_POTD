from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def helper(self, traversal: str, index: list, depth: int) -> Optional['TreeNode']:
        if index[0] >= len(traversal):
            return None
        
        # Count the number of '-' characters.
        dash_count = 0
        while index[0] + dash_count < len(traversal) and traversal[index[0] + dash_count] == '-':
            dash_count += 1
        
        # If the count does not match the expected depth, return None.
        if dash_count != depth:
            return None
        
        # Skip the dashes.
        index[0] += dash_count
        
        # Parse the numeric value.
        value = 0
        while index[0] < len(traversal) and traversal[index[0]].isdigit():
            value = value * 10 + int(traversal[index[0]])
            index[0] += 1
        
        # Create a new TreeNode.
        node = TreeNode(value)
        
        # Recursively build the left and right subtrees.
        node.left = self.helper(traversal, index, depth + 1)
        node.right = self.helper(traversal, index, depth + 1)
        
        return node

    def recoverFromPreorder(self, traversal: str) -> Optional['TreeNode']:
        index = [0]  # Use a list to allow pass-by-reference for the index.
        return self.helper(traversal, index, 0)
