from typing import List


class Solution:
    def validateCoupons(self, code: List[str], businessLine: List[str], isActive: List[bool]) -> List[str]:

        e, g, p, r = [], [], [], []

        for i in range(len(isActive)):
            if not isActive[i]:
                continue

            bl = businessLine[i]
            if bl not in ("electronics", "grocery", "pharmacy", "restaurant"):
                continue

            if not code[i]:
                continue

            ok = True
            for c in code[i]:
                if not (c.isalnum() or c == '_'):
                    ok = False
                    break
            if not ok:
                continue

            if bl[0] == 'e': e.append(code[i])
            if bl[0] == 'g': g.append(code[i])
            if bl[0] == 'p': p.append(code[i])
            if bl[0] == 'r': r.append(code[i])

        e.sort()
        g.sort()
        p.sort()
        r.sort()

        return e + g + p + r
