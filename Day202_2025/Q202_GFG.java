import java.util.Arrays;

class Q202_GFG {
    private void computeMobius(int n, int[] mu) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        mu[0] = 0;
        mu[1] = 1;

        for (int i = 2; i <= n; ++i) {
            if (isPrime[i]) {
                for (int j = i; j <= n; j += i) {
                    mu[j] *= -1;
                    isPrime[j] = false;
                }
                for (int j = i * i; j <= n; j += i * i) {
                    mu[j] = 0;
                }
            }
        }
    }

    private void buildFreq(int[] arr, int[] freq) {
        for (int x : arr) {
            freq[x]++;
        }
    }

    private void computeDivCnt(int maxVal, int[] freq, int[] d) {
        for (int k = 1; k <= maxVal; ++k) {
            for (int j = k; j <= maxVal; j += k) {
                d[k] += freq[j];
            }
        }
    }

    public int cntCoprime(int[] arr) {
        int maxVal = Arrays.stream(arr).max().getAsInt();
        int[] freq = new int[maxVal + 1];
        int[] d = new int[maxVal + 1];
        int[] mu = new int[maxVal + 1];
        Arrays.fill(mu, 1);

        buildFreq(arr, freq);
        computeDivCnt(maxVal, freq, d);
        computeMobius(maxVal, mu);

        int result = 0;
        for (int k = 1; k <= maxVal; ++k) {
            if (mu[k] == 0 || d[k] < 2)
                continue;

            int pairs = d[k] * (d[k] - 1) / 2;
            result += mu[k] * pairs;
        }

        return result;
    }
}
