import java.util.Arrays;

class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
        next = null;
    }
}

class Q123_GFG {
    private boolean[] findPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }

    Node primeList(Node head) {
        int maxNum = 0;
        Node temp = head;
        while (temp != null) {
            maxNum = Math.max(maxNum, temp.val);
            temp = temp.next;
        }

        boolean[] primes = findPrimes(2 * maxNum);

        temp = head;
        while (temp != null) {
            int num = temp.val;
            if (num == 1) {
                temp.val = 2;
            } else {
                int num1 = num, num2 = num;
                while (!primes[num1]) num1--;
                while (!primes[num2]) num2++;

                temp.val = (num - num1 > num2 - num) ? num2 : num1;
            }
            temp = temp.next;
        }

        return head;
    }
}
