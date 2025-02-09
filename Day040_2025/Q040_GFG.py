class Solution:
    # Helper function to compute the maximum path sum
    def height(self, root, ans):
        if root is None:
            return 0
        
        leftSum = max(0, self.height(root.left, ans))
        rightSum = max(0, self.height(root.right, ans))

        ans[0] = max(ans[0], leftSum + rightSum + root.data)
        
        return root.data + max(leftSum, rightSum)

    # Function to return maximum path sum from any node in a tree.
    def findMaxSum(self, root): 
        ans = [float('-inf')]
        self.height(root, ans)
        return ans[0]
