class Solution:
    def nodeSum(self, root, l, r):
        if not root:
            return 0

        res = 0
        if l <= root.data <= r:
            res += root.data

        if root.left:
            res += self.nodeSum(root.left, l, r)
        if root.right:
            res += self.nodeSum(root.right, l, r)

        return res
