from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class FindElements:
    def __init__(self, root: Optional[TreeNode]):
        self.seen = set()
        self._bfs(root)
    
    def _bfs(self, root: Optional[TreeNode]) -> None:
        if not root:
            return
        root.val = 0
        queue = [root]
        while queue:
            current = queue.pop(0)
            self.seen.add(current.val)
            if current.left:
                current.left.val = current.val * 2 + 1
                queue.append(current.left)
            if current.right:
                current.right.val = current.val * 2 + 2
                queue.append(current.right)
    
    def find(self, target: int) -> bool:
        return target in self.seen

# Your FindElements object will be instantiated and called as such:
# obj = FindElements(root)
# param_1 = obj.find(target)
