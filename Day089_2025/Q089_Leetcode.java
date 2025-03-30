import java.util.*;

class Q089_Leetcode {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitionSizes = new ArrayList<>();
        int[] lastOccurrence = new int[26];

        // Step 1: Store last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Partition the string
        int partitionStart = 0, partitionEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            partitionEnd = Math.max(partitionEnd, lastOccurrence[s.charAt(i) - 'a']);
            
            // If we reach the end of a partition
            if (i == partitionEnd) {
                partitionSizes.add(partitionEnd - partitionStart + 1);
                partitionStart = i + 1;
            }
        }

        return partitionSizes;
    }

    public static void main(String[] args) {
        Q089_Leetcode sol = new Q089_Leetcode();
        System.out.println(sol.partitionLabels("ababcbacadefegdehijhklij")); // Example Output: [9,7,8]
    }
}
