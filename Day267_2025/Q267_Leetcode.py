class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0:
            return "0"

        ans = []

        # sign handling
        if (numerator > 0) ^ (denominator > 0):
            ans.append("-")

        num, den = abs(numerator), abs(denominator)

        q, r = divmod(num, den)
        ans.append(str(q))

        if r == 0:
            return "".join(ans)

        ans.append(".")
        mp = {}

        while r != 0:
            if r in mp:
                ans.insert(mp[r], "(")
                ans.append(")")
                break
            mp[r] = len(ans)
            r *= 10
            q, r = divmod(r, den)
            ans.append(str(q))

        return "".join(ans)
