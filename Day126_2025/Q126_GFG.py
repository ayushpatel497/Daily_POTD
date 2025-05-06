class Solution:
    def LeftView(self, root):
        result = []

        def leftViewUtil(node, level):
            if not node:
                return
            if len(result) == level:
                result.append(node.data)
            leftViewUtil(node.left, level + 1)
            leftViewUtil(node.right, level + 1)

        leftViewUtil(root, 0)
        return result
