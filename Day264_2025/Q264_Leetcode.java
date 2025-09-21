import java.util.*;

class Q264_Leetcode {
    private static class Node implements Comparable<Node> {
        int shop, movie, price;

        Node(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }

        @Override
        public int compareTo(Node other) {
            if (this.price != other.price) return this.price - other.price;
            if (this.shop != other.shop) return this.shop - other.shop;
            return this.movie - other.movie;
        }
    }

    private Map<Long, Node> byPair;
    private Map<Integer, TreeSet<Node>> availableByMovie;
    private TreeSet<Node> rentedSet;

    private long key(int shop, int movie) {
        return ((long) shop << 32) ^ movie;
    }

    public Q264_Leetcode(int n, int[][] entries) {
        byPair = new HashMap<>();
        availableByMovie = new HashMap<>();
        rentedSet = new TreeSet<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Node node = new Node(shop, movie, price);
            byPair.put(key(shop, movie), node);
            availableByMovie.computeIfAbsent(movie, k -> new TreeSet<>()).add(node);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!availableByMovie.containsKey(movie)) return res;

        TreeSet<Node> s = availableByMovie.get(movie);
        int count = 0;
        for (Node node : s) {
            if (count == 5) break;
            res.add(node.shop);
            count++;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        availableByMovie.get(movie).remove(node);
        rentedSet.add(node);
    }

    public void drop(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        rentedSet.remove(node);
        availableByMovie.get(movie).add(node);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (Node node : rentedSet) {
            if (count == 5) break;
            res.add(Arrays.asList(node.shop, node.movie));
            count++;
        }
        return res;
    }
}
