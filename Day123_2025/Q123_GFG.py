class Node:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def findPrimes(self, n):
        primes = [True] * (n + 1)
        primes[0] = primes[1] = False
        for i in range(2, int(n**0.5) + 1):
            if primes[i]:
                for j in range(i * i, n + 1, i):
                    primes[j] = False
        return primes

    def primeList(self, head):
        max_num = 0
        temp = head
        while temp:
            max_num = max(max_num, temp.val)
            temp = temp.next

        primes = self.findPrimes(2 * max_num)

        temp = head
        while temp:
            num = temp.val
            if num == 1:
                temp.val = 2
            else:
                num1, num2 = num, num
                while not primes[num1]:
                    num1 -= 1
                while not primes[num2]:
                    num2 += 1
                temp.val = num2 if (num - num1 > num2 - num) else num1
            temp = temp.next

        return head
