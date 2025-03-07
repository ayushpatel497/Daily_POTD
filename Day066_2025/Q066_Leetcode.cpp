class Solution {
    bool isPrime(int number) {
        if (number == 1) return false;
        for (int divisor = 2; divisor <= sqrt(number); divisor++) {
            if (number % divisor == 0) return false;
        }
        return true;
    }
public:
    vector<int> closestPrimes(int left, int right) {
        // Q. Closest Prime Numbers in Range
        vector<int> primeNumbers;
        for (int candidate = left; candidate <= right; candidate++) {
            if (candidate % 2 == 0 and candidate > 2) continue;
            if (isPrime(candidate)) {
                if (!primeNumbers.empty() &&
                    candidate <= primeNumbers.back() + 2) {
                    return {primeNumbers.back(), candidate};
                }
                primeNumbers.push_back(candidate);
            }
        }

        if (primeNumbers.size() < 2) return {-1, -1};
        vector<int> closestPair = {-1, -1};
        int minDifference = 1e6;

        for (int index = 1; index < primeNumbers.size(); index++) {
            int difference = primeNumbers[index] - primeNumbers[index - 1];
            if (difference < minDifference) {
                minDifference = difference;
                closestPair = {primeNumbers[index - 1], primeNumbers[index]};
            }
        }

        return closestPair;
    }
};