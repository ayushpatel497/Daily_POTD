import java.util.*;

class Q006_GFG {
    public List<Integer> sumClosest(int[] arr, int target) {
        // Q. Sum Pair closest to target
        int n = arr.length;
        if (n <= 1) {
            return new ArrayList<>();
        }

        Arrays.sort(arr);
        int left = 0, right = 0;
        int i = 0, j = n - 1;
        int diff = Integer.MAX_VALUE;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (Math.abs(target - sum) < diff) {
                diff = Math.abs(target - sum);
                left = arr[i];
                right = arr[j];
            }

            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return Arrays.asList(left, right);
            }
        }

        return Arrays.asList(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Q006_GFG sol = new Q006_GFG();
            List<Integer> result = sol.sumClosest(arr, target);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int num : result) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
