class Solution:
    def getKthNode(self, head, k):
        k -= 1
        while head and head.next and k > 0:
            k -= 1
            head = head.next
        return head

    def reverseAList(self, head):
        prev, curr = None, head
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        return prev

    def reverseKGroup(self, head, k):
        temp = head
        prevLast = None

        while temp:
            kthNode = self.getKthNode(temp, k)
            if not kthNode:
                if prevLast:
                    prevLast.next = temp
                break

            nextNode = kthNode.next
            kthNode.next = None

            self.reverseAList(temp)

            if temp == head:
                head = kthNode
            else:
                prevLast.next = kthNode

            prevLast = temp
            temp = nextNode

        return head
