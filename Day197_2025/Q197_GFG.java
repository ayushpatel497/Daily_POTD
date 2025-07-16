import java.util.*;

class Q197_GFG {
    static List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static int countNumbers(int n) {
        int count = 0;
        List<Integer> primes = sieve((int)Math.sqrt(n) + 1);

        for (int i = 0; i < primes.size(); i++) {
            long p8 = 1L;
            for (int j = 0; j < 8; j++) p8 *= primes.get(i);
            if (p8 <= n) {
                count++;
            } else {
                break;
            }
        }

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                long val = 1L * primes.get(i) * primes.get(i) * primes.get(j) * primes.get(j);
                if (val <= n) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
