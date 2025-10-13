class Solution:
    def __init__(self):
        self.dp = {}

    def recursive(self, root):
        if not root:
            return 0
        if root in self.dp:
            return self.dp[root]

        skip1 = self.recursive(root.left)
        skip2 = self.recursive(root.right)

        a = b = c = d = 0
        if root.left:
            a = self.recursive(root.left.left)
            b = self.recursive(root.left.right)
        if root.right:
            c = self.recursive(root.right.left)
            d = self.recursive(root.right.right)

        include = root.data + a + b + c + d
        exclude = skip1 + skip2

        self.dp[root] = max(include, exclude)
        return self.dp[root]

    def getMaxSum(self, root):
        return self.recursive(root)
