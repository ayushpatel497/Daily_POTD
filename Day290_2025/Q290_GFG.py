class Solution:
    def solve(self, root, summ):
        if not root:
            return 0
        
        right = self.solve(root.right, summ)
        left = self.solve(root.left, root.data + right + summ)
        
        total = root.data + left + right
        root.data = right + summ
        
        return total

    def transformTree(self, root):
        self.solve(root, 0)
