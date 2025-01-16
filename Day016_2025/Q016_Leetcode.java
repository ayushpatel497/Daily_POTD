import java.util.Scanner;

class Q016_Leetcode {
    public int xorAllNums(int[] nums1, int[] nums2) {
        // Q. Bitwise XOR of All Pairings
        int nums1Size = nums1.length;
        int nums2Size = nums2.length;
        int xorAll = 0;

        if (nums1Size % 2 != 0) {
            for (int num : nums2) {
                xorAll ^= num;
            }
        }

        if (nums2Size % 2 != 0) {
            for (int num : nums1) {
                xorAll ^= num;
            }
        }

        return xorAll;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input nums1 array
        System.out.println("Enter nums1 size and elements:");
        int nums1Size = sc.nextInt();
        int[] nums1 = new int[nums1Size];
        for (int i = 0; i < nums1Size; i++) {
            nums1[i] = sc.nextInt();
        }

        // Input nums2 array
        System.out.println("Enter nums2 size and elements:");
        int nums2Size = sc.nextInt();
        int[] nums2 = new int[nums2Size];
        for (int i = 0; i < nums2Size; i++) {
            nums2[i] = sc.nextInt();
        }

        Q016_Leetcode sol = new Q016_Leetcode();
        System.out.println("XOR of All Pairings: " + sol.xorAllNums(nums1, nums2));

        sc.close();
    }
}
