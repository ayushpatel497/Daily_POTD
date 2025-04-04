from typing import Optional, Tuple

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def dfs(self, root: Optional[TreeNode]) -> Tuple[Optional[TreeNode], int]:
        if not root:
            return None, 0

        left_node, left_depth = self.dfs(root.left)
        right_node, right_depth = self.dfs(root.right)

        if left_depth > right_depth:
            return left_node, left_depth + 1
        elif left_depth < right_depth:
            return right_node, right_depth + 1
        else:
            return root, left_depth + 1

    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        return self.dfs(root)[0]
