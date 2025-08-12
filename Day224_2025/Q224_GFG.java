import java.util.*;

class Q224_GFG {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(prices);
        
        int elementUsed = 0;
        int totalSum = 0;
        int start = 0;
        while (elementUsed < prices.length) {
            totalSum += prices[start];
            if (k == 0) {
                elementUsed += 1;
            } else {
                elementUsed = elementUsed + k + 1;
            }
            start++;
        }
        ans.add(totalSum);
        
        elementUsed = 0;
        int end = prices.length - 1;
        totalSum = 0;
        while (elementUsed < prices.length) {
            totalSum += prices[end];
            if (k == 0) {
                elementUsed += 1;
            } else {
                elementUsed = elementUsed + k + 1;
            }
            end--;
        }
        ans.add(totalSum);
        
        return ans;
    }
}
