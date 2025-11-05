import java.util.*;

class Pair implements Comparable<Pair> {
    int freq;
    int num;

    Pair(int freq, int num) {
        this.freq = freq;
        this.num = num;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.freq != other.freq) return this.freq - other.freq;
        return this.num - other.num;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return this.freq == p.freq && this.num == p.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(freq, num);
    }
}

class Helper {
    int x;
    long result;
    TreeSet<Pair> large = new TreeSet<>();
    TreeSet<Pair> small = new TreeSet<>();
    HashMap<Integer, Integer> occurrences = new HashMap<>();

    Helper(int x) {
        this.x = x;
        this.result = 0;
    }

    private void internalInsert(Pair p) {
        if (large.size() < x || p.compareTo(large.first()) > 0) {
            result += 1L * p.freq * p.num;
            large.add(p);
            if (large.size() > x) {
                Pair transfer = large.first();
                result -= 1L * transfer.freq * transfer.num;
                large.remove(transfer);
                small.add(transfer);
            }
        } else {
            small.add(p);
        }
    }

    private void internalRemove(Pair p) {
        if (!large.isEmpty() && p.compareTo(large.first()) >= 0) {
            result -= 1L * p.freq * p.num;
            large.remove(p);
            if (!small.isEmpty()) {
                Pair transfer = small.last();
                result += 1L * transfer.freq * transfer.num;
                small.remove(transfer);
                large.add(transfer);
            }
        } else {
            small.remove(p);
        }
    }

    void insert(int num) {
        if (occurrences.containsKey(num)) {
            internalRemove(new Pair(occurrences.get(num), num));
        }
        occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        internalInsert(new Pair(occurrences.get(num), num));
    }

    void remove(int num) {
        internalRemove(new Pair(occurrences.get(num), num));
        occurrences.put(num, occurrences.get(num) - 1);
        if (occurrences.get(num) > 0) {
            internalInsert(new Pair(occurrences.get(num), num));
        } else {
            occurrences.remove(num);
        }
    }

    long get() {
        return result;
    }
}

class Q309_Leetcode {
    public long[] findXSum(int[] nums, int k, int x) {
        Helper helper = new Helper(x);
        List<Long> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            helper.insert(nums[i]);
            if (i >= k) {
                helper.remove(nums[i - k]);
            }
            if (i >= k - 1) {
                res.add(helper.get());
            }
        }

        long[] ans = new long[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
