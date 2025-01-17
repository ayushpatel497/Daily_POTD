import java.util.*;

class Q017_GFG {
    public static int[] productExceptSelf(int[] arr) {
        // Q. Product array puzzle
        int n = arr.length;
        int[] products = new int[n];
        Arrays.fill(products, 1);

        int preProduct = 1;
        for (int i = 0; i < n; i++) {
            products[i] *= preProduct;
            preProduct *= arr[i];
        }

        int postProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            products[i] *= postProduct;
            postProduct *= arr[i];
        }

        return products;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of test cases:");
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline character

        while (t-- > 0) {
            System.out.println("Enter the array elements separated by space:");
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            int[] result = productExceptSelf(arr);

            System.out.println("Result:");
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println("\n~");
        }

        sc.close();
    }
}
