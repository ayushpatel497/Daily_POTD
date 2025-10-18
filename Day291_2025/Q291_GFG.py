class Solution:
    def inorder(self, root, ans):
        if not root:
            return
        self.inorder(root.left, ans)
        ans.append(root.data)
        self.inorder(root.right, ans)
        
    def findMedian(self, root):
        ans = []
        self.inorder(root, ans)
        k = len(ans)
        if k % 2 == 0:
            med = ans[(k // 2) - 1]
        else:
            med = ans[((k + 1) // 2) - 1]
        return med
