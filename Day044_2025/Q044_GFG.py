class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

class Solution:
    def findTarget(self, root, target):
        if not root:
            return False

        s1, s2 = [], []
        temp1, temp2 = root, root

        while True:
            while temp1:
                s1.append(temp1)
                temp1 = temp1.left
            while temp2:
                s2.append(temp2)
                temp2 = temp2.right

            if not s1 or not s2:
                break

            temp1 = s1[-1]
            temp2 = s2[-1]

            if temp1 == temp2:
                return False  # Prevent duplicate nodes

            pair_sum = temp1.data + temp2.data

            if pair_sum == target:
                return True
            elif pair_sum < target:
                s1.pop()
                temp1 = temp1.right
                temp2 = None  # Keep second stack unchanged
            else:
                s2.pop()
                temp2 = temp2.left
                temp1 = None  # Keep first stack unchanged

        return False
