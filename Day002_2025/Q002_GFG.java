import java.util.*;

class Q002_GFG {
    public int countSubarrays(int[] arr, int k) {
        // Q. Subarrays with sum K
        int ans = 0, currSum = 0;
        HashMap<Integer, Integer> um = new HashMap<>();
        um.put(0, 1);

        for (int num : arr) {
            currSum += num;
            if (um.containsKey(currSum - k)) {
                ans += um.get(currSum - k);
            }
            um.put(currSum, um.getOrDefault(currSum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int k = Integer.parseInt(sc.nextLine());
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Q002_GFG sol = new Q002_GFG();
            System.out.println(sol.countSubarrays(arr, k));
            System.out.println("~");
        }
        sc.close();
    }
}
