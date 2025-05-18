class Solution:
    def findSpiral(self, root):
        if root is None:
            return []

        result = []
        s1 = [root]  # Right to left
        s2 = []      # Left to right

        while s1 or s2:
            while s1:
                temp = s1.pop()
                result.append(temp.data)
                if temp.right:
                    s2.append(temp.right)
                if temp.left:
                    s2.append(temp.left)
            while s2:
                temp = s2.pop()
                result.append(temp.data)
                if temp.left:
                    s1.append(temp.left)
                if temp.right:
                    s1.append(temp.right)

        return result
