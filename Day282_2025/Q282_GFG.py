class Solution:
    def postOrder(self, root):
        result = []

        def dfs(node):
            if not node:
                return
            dfs(node.left)
            dfs(node.right)
            result.append(node.data)

        dfs(root)
        return result
