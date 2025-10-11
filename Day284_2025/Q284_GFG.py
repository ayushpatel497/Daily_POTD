class Solution:
    def findMaxSum(self, root):
        self.maxSum = float('-inf')
        
        def solve(node):
            if not node:
                return 0
            left = max(0, solve(node.left))
            right = max(0, solve(node.right))
            
            currPathSum = node.data + left + right
            self.maxSum = max(self.maxSum, currPathSum)
            
            return node.data + max(left, right)
        
        solve(root)
        return self.maxSum
