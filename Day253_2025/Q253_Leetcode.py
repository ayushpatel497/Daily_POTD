from typing import List

class Solution:
    def minimumTeachings(self, n: int, languages: List[List[int]], friendships: List[List[int]]) -> int:
        cncon = set()

        for friendship in friendships:
            mp = set()
            common = False

            for lan in languages[friendship[0] - 1]:
                mp.add(lan)

            for lan in languages[friendship[1] - 1]:
                if lan in mp:
                    common = True
                    break

            if not common:
                cncon.add(friendship[0] - 1)
                cncon.add(friendship[1] - 1)

        max_cnt = 0
        cnt = [0] * (n + 1)

        for user in cncon:
            for lan in languages[user]:
                cnt[lan] += 1
                max_cnt = max(max_cnt, cnt[lan])

        return len(cncon) - max_cnt
