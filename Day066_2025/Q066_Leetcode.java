import java.util.*;

class Q066_Leetcode {
    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int divisor = 2; divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) return false;
        }
        return true;
    }

    public int[] closestPrimes(int left, int right) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int candidate = left; candidate <= right; candidate++) {
            if (candidate % 2 == 0 && candidate > 2) continue;
            if (isPrime(candidate)) {
                if (!primeNumbers.isEmpty() && candidate <= primeNumbers.get(primeNumbers.size() - 1) + 2) {
                    return new int[]{primeNumbers.get(primeNumbers.size() - 1), candidate};
                }
                primeNumbers.add(candidate);
            }
        }

        if (primeNumbers.size() < 2) return new int[]{-1, -1};

        int[] closestPair = {-1, -1};
        int minDifference = Integer.MAX_VALUE;

        for (int index = 1; index < primeNumbers.size(); index++) {
            int difference = primeNumbers.get(index) - primeNumbers.get(index - 1);
            if (difference < minDifference) {
                minDifference = difference;
                closestPair[0] = primeNumbers.get(index - 1);
                closestPair[1] = primeNumbers.get(index);
            }
        }

        return closestPair;
    }
}
