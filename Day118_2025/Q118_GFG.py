class Solution:
    class Pair:
        def __init__(self, include, exclude):
            self.include = include
            self.exclude = exclude

    def solve(self, root):
        if not root:
            return self.Pair(0, 0)
        
        left = self.solve(root.left)
        right = self.solve(root.right)
        
        include = root.data + left.exclude + right.exclude
        exclude = max(left.include, left.exclude) + max(right.include, right.exclude)
        
        return self.Pair(include, exclude)

    def getMaxSum(self, root):
        ans = self.solve(root)
        return max(ans.include, ans.exclude)
