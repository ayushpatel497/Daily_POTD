class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Solution:
    def getMiddle(self, head):
        if not head:
            return head
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow

    def merge(self, left, right):
        if not left:
            return right
        if not right:
            return left

        if left.data <= right.data:
            result = left
            result.next = self.merge(left.next, right)
        else:
            result = right
            result.next = self.merge(left, right.next)

        return result

    def mergeSort(self, head):
        if not head or not head.next:
            return head

        middle = self.getMiddle(head)
        nextToMiddle = middle.next
        middle.next = None

        left = self.mergeSort(head)
        right = self.mergeSort(nextToMiddle)

        return self.merge(left, right)
