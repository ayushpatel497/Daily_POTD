import java.util.*;

class Q008_GFG {
    // Function to count the number of possible triangles.
    static int countTriangles(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); // Sort the array
        int count = 0;

        // Iterate for each pair (i, j)
        for (int i = 0; i < n - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                // Find the maximum index k such that arr[i] + arr[j] > arr[k]
                while (k < n && arr[i] + arr[j] > arr[k]) {
                    k++;
                }
                if (k > j) {
                    count += k - j - 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline character
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int n = input.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            System.out.println(countTriangles(arr));
            System.out.println("~");
        }
        sc.close();
    }
}
