class Solution:
    def __init__(self):
        self.pre = None
        self.succ = None
        self.ele1 = float('-inf')
        self.ele2 = float('inf')

    def findPre(self, root, key):
        if root is None:
            return
        if root.data < key:
            if self.ele1 < root.data:
                self.ele1 = root.data
                self.pre = root
            self.findPre(root.right, key)
        else:
            self.findPre(root.left, key)

    def findSucc(self, root, key):
        if root is None:
            return
        if root.data > key:
            if self.ele2 > root.data:
                self.ele2 = root.data
                self.succ = root
            self.findSucc(root.left, key)
        else:
            self.findSucc(root.right, key)

    def findPreSuc(self, root, key):
        self.findPre(root, key)
        self.findSucc(root, key)
        return [self.pre, self.succ]
