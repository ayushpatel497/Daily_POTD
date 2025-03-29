import java.util.*;

class Q088_Leetcode {
    private static final int MOD = 1_000_000_007;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] primeScores = new int[n];

        int maxElement = Collections.max(nums);
        List<Integer> primes = getPrimes(maxElement);

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            for (int prime : primes) {
                if (prime * prime > num) break;
                if (num % prime != 0) continue;

                primeScores[i]++;
                while (num % prime == 0) num /= prime;
            }

            if (num > 1) primeScores[i]++;
        }

        int[] nextDominant = new int[n];
        int[] prevDominant = new int[n];
        Arrays.fill(nextDominant, n);
        Arrays.fill(prevDominant, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && primeScores[stack.peek()] < primeScores[i]) {
                int top = stack.pop();
                nextDominant[top] = i;
            }
            if (!stack.isEmpty()) {
                prevDominant[i] = stack.peek();
            }
            stack.push(i);
        }

        long[] numOfSubarrays = new long[n];
        for (int i = 0; i < n; i++) {
            numOfSubarrays[i] = (long) (nextDominant[i] - i) * (i - prevDominant[i]);
        }

        List<int[]> sortedArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sortedArray.add(new int[]{nums.get(i), i});
        }

        sortedArray.sort((a, b) -> Integer.compare(b[0], a[0]));

        long score = 1;
        int processingIndex = 0;
        
        while (k > 0) {
            int[] numIndexPair = sortedArray.get(processingIndex++);
            int num = numIndexPair[0], index = numIndexPair[1];
            long operations = Math.min(k, numOfSubarrays[index]);
            score = (score * power(num, operations)) % MOD;
            k -= operations;
        }

        return (int) score;
    }

    private long power(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    private List<Integer> getPrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();
        
        for (int num = 2; num <= limit; num++) {
            if (!isPrime[num]) continue;
            primes.add(num);
            for (long multiple = (long) num * num; multiple <= limit; multiple += num) {
                isPrime[(int) multiple] = false;
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        Q088_Leetcode sol = new Q088_Leetcode();
        List<Integer> nums = Arrays.asList(2, 3, 7, 5);
        int k = 3;
        System.out.println(sol.maximumScore(nums, k)); // Example Output
    }
}
