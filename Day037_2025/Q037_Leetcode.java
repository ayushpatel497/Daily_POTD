import java.util.HashMap;
import java.util.Map;

class Q037_Leetcode {
    public int tupleSameProduct(int[] nums) {
        int numsLength = nums.length;
        Map<Integer, Integer> pairProductsFrequency = new HashMap<>();
        int totalNumberOfTuples = 0;

        // Store the frequency of each product of pairs
        for (int firstIndex = 0; firstIndex < numsLength; ++firstIndex) {
            for (int secondIndex = firstIndex + 1; secondIndex < numsLength; ++secondIndex) {
                int product = nums[firstIndex] * nums[secondIndex];
                pairProductsFrequency.put(product, pairProductsFrequency.getOrDefault(product, 0) + 1);
            }
        }

        // Calculate the number of tuples based on product frequency
        for (int productFrequency : pairProductsFrequency.values()) {
            int pairsOfEqualProduct = (productFrequency * (productFrequency - 1)) / 2;
            totalNumberOfTuples += 8 * pairsOfEqualProduct;
        }

        return totalNumberOfTuples;
    }
}
