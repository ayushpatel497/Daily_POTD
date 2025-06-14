class Solution:
    def isSymmetric(self, root):
        if root is None:
            return True

        stack = [root.left, root.right]

        while stack:
            t1 = stack.pop()
            t2 = stack.pop()

            if t1 is None and t2 is None:
                continue
            if t1 is None or t2 is None:
                return False
            if t1.data != t2.data:
                return False

            stack.append(t1.left)
            stack.append(t2.right)

            stack.append(t1.right)
            stack.append(t2.left)

        return True
