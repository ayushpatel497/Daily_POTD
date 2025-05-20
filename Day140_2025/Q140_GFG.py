class Solution:
    def minTime(self, root, target):
        self.ans = 0

        def findDepth(node):
            if not node:
                return 0
            return 1 + max(findDepth(node.left), findDepth(node.right))

        def findTarget(node):
            if not node:
                return -1

            if node.data == target:
                self.ans = max(self.ans, findDepth(node) - 1)
                return 1

            left = findTarget(node.left)
            if left != -1:
                depth = findDepth(node.right)
                self.ans = max(self.ans, left + depth)
                return left + 1

            right = findTarget(node.right)
            if right != -1:
                depth = findDepth(node.left)
                self.ans = max(self.ans, right + depth)
                return right + 1

            return -1

        findTarget(root)
        return self.ans
