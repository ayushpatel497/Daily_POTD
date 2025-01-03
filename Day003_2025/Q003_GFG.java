import java.util.*;

class Q003_GFG {
    public long subarrayXor(int[] arr, int k) {
        // Q. Count Subarrays with given XOR
        HashMap<Integer, Integer> um = new HashMap<>();
        um.put(0, 1); // Initialize with XOR = 0
        int currXOR = 0;
        long ans = 0;

        for (int num : arr) {
            currXOR ^= num;

            if (um.containsKey(currXOR ^ k)) {
                ans += um.get(currXOR ^ k);
            }
            um.put(currXOR, um.getOrDefault(currXOR, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        sc.nextLine(); // Consume newline after number of test cases

        while (tc-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int k = sc.nextInt();
            sc.nextLine(); // Consume newline after k

            Q003_GFG sol = new Q003_GFG();
            System.out.println(sol.subarrayXor(arr, k));
            System.out.println("~");
        }

        sc.close();
    }
}
