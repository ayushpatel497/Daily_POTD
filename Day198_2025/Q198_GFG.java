import java.util.*;

class Q198_GFG {
    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactor = new HashMap<>();

        // Prime factorization of k
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                primeFactor.put(i, primeFactor.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            primeFactor.put(k, primeFactor.getOrDefault(k, 0) + 1);
        }

        int ans = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactor.entrySet()) {
            int p = entry.getKey();
            int lnk = entry.getValue();

            int powerInNFact = 0;
            int temp = n;

            while (temp > 0) {
                powerInNFact += temp / p;
                temp /= p;
            }

            ans = Math.min(ans, powerInNFact / lnk);
        }

        return ans;
    }
}
