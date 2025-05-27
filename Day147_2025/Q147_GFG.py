class Solution:
    def leafNodes(self, preorder):
        stack = []
        leaves = []
        n = len(preorder)

        for i in range(n - 1):
            found = False
            if preorder[i] > preorder[i + 1]:
                stack.append(preorder[i])
            else:
                while stack and preorder[i + 1] > stack[-1]:
                    stack.pop()
                    found = True
            if found:
                leaves.append(preorder[i])

        leaves.append(preorder[-1])  # last node is always a leaf
        return leaves
