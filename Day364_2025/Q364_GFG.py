class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Solution:
    def reverseList(self, head):
        prev = None
        curr = head

        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt

        return prev

    def addTwoLists(self, head1, head2):
        rNum1 = self.reverseList(head1)
        rNum2 = self.reverseList(head2)

        carry = 0
        dummy = Node(-1)
        tail = dummy

        while rNum1 or rNum2 or carry:
            op1 = rNum1.data if rNum1 else 0
            op2 = rNum2.data if rNum2 else 0

            total = op1 + op2 + carry
            carry = total // 10
            digit = total % 10

            tail.next = Node(digit)
            tail = tail.next

            if rNum1:
                rNum1 = rNum1.next
            if rNum2:
                rNum2 = rNum2.next

        head = self.reverseList(dummy.next)

        # remove leading zeros
        while head and head.data == 0:
            head = head.next

        return head
