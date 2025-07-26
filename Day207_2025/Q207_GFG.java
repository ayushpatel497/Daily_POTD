import java.util.*;

class Q207_GFG {
    public ArrayList<Integer> findMajority(int[] arr) {
        int count1 = 0, count2 = 0;
        int ele1 = 0, el2 = 0;

        for (int num : arr) {
            if (count1 == 0 && num != el2) {
                ele1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != ele1) {
                el2 = num;
                count2 = 1;
            } else if (num == ele1) {
                count1++;
            } else if (num == el2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == ele1) count1++;
            if (num == el2) count2++;
        }

        ArrayList<Integer> res = new ArrayList<>();
        int votes = arr.length;
        if (count1 > votes / 3) res.add(ele1);
        if (count2 > votes / 3 && el2 != ele1) res.add(el2);

        if (res.size() == 2 && res.get(0) > res.get(1)) {
            int temp = res.get(0);
            res.set(0, res.get(1));
            res.set(1, temp);
        }

        return res;
    }
}
