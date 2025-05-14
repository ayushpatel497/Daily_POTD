import java.util.*;

class Q134_Leetcode {
    static final int L = 26;
    static final int MOD = 1_000_000_007;

    static class Mat {
        int[][] a = new int[L][L];

        Mat() {
            for (int[] row : a) Arrays.fill(row, 0);
        }

        Mat multiply(Mat other) {
            Mat result = new Mat();
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    for (int k = 0; k < L; k++) {
                        result.a[i][j] = (int)((result.a[i][j] + (1L * this.a[i][k] * other.a[k][j]) % MOD) % MOD);
                    }
                }
            }
            return result;
        }
    }

    Mat identity() {
        Mat id = new Mat();
        for (int i = 0; i < L; i++) {
            id.a[i][i] = 1;
        }
        return id;
    }

    Mat quickMul(Mat base, int exp) {
        Mat result = identity();
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result.multiply(base);
            }
            base = base.multiply(base);
            exp >>= 1;
        }
        return result;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        Mat T = new Mat();

        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                T.a[(i + j) % 26][i] = 1;
            }
        }

        Mat res = quickMul(T, t);

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                ans = (int)((ans + (1L * res.a[i][j] * freq[j]) % MOD) % MOD);
            }
        }

        return ans;
    }
}
