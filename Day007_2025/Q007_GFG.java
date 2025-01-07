import java.util.*;

class Q007_GFG {
    public int countPairs(int[] arr, int target) {
        // Q. Pair with given sum in a sorted array
        int ans = 0;
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == target) {
                int countI = 0, countJ = 0;
                int valI = arr[i], valJ = arr[j];

                while (i <= j && arr[i] == valI) {
                    countI++;
                    i++;
                }
                while (i <= j && arr[j] == valJ) {
                    countJ++;
                    j--;
                }

                if (valI == valJ) {
                    ans += (countI * (countI - 1)) / 2;
                } else {
                    ans += countI * countJ;
                }
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String input = sc.nextLine();
            int[] arr = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int target = sc.nextInt();
            sc.nextLine();

            Q007_GFG obj = new Q007_GFG();
            System.out.println(obj.countPairs(arr, target));
            System.out.println("~");
        }

        sc.close();
    }
}
