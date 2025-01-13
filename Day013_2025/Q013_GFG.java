import java.util.Scanner;

class Q013_GFG {
    public int maxWater(int[] arr) {
        // Q. Container With Most Water
        int left = 0;
        int right = arr.length - 1;
        int water = 0;

        while (left < right) {
            int tempWater = Math.min(arr[left], arr[right]) * (right - left);
            water = Math.max(water, tempWater);

            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = new int[input.length];

            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Q013_GFG sol = new Q013_GFG();
            System.out.println(sol.maxWater(arr) + "\n~");
        }

        sc.close();
    }
}
