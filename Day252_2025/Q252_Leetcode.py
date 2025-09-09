from collections import deque

class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        mod = 10**9 + 7
        know = deque()
        share = deque()
        know.append((1, 1))
        know_cnt = 1
        share_cnt = 0

        for day in range(2, n + 1):
            if know and know[0][0] == day - delay:
                know_cnt = (know_cnt - know[0][1] + mod) % mod
                share_cnt = (share_cnt + know[0][1]) % mod
                share.append(know.popleft())

            if share and share[0][0] == day - forget:
                share_cnt = (share_cnt - share[0][1] + mod) % mod
                share.popleft()

            if share:
                know_cnt = (know_cnt + share_cnt) % mod
                know.append((day, share_cnt))

        return (know_cnt + share_cnt) % mod
