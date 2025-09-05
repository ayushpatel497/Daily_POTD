class Solution:
    def segregate(self, head):
        if not head:
            return head

        cntZero = cntOne = cntTwo = 0
        curr = head

        # Count 0s, 1s, 2s
        while curr:
            if curr.data == 0:
                cntZero += 1
            elif curr.data == 1:
                cntOne += 1
            else:
                cntTwo += 1
            curr = curr.next

        # Rewrite values in sorted order
        curr = head
        while curr:
            if cntZero > 0:
                curr.data = 0
                cntZero -= 1
            elif cntOne > 0:
                curr.data = 1
                cntOne -= 1
            else:
                curr.data = 2
                cntTwo -= 1
            curr = curr.next

        return head
