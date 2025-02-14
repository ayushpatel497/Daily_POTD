import java.util.*;

class ProductOfNumbers {
    private List<Integer> store;
    private int size;

    public ProductOfNumbers() {
        store = new ArrayList<>();
        store.add(1);
        size = 0;
    }
    
    public void add(int num) {
        if (num == 0) {
            store = new ArrayList<>();
            store.add(1);
            size = 0;
        } else {
            store.add(num * store.get(size));
            size++;
        }
    }
    
    public int getProduct(int k) {
        if (k > size) {
            return 0;
        }
        return store.get(size) / store.get(size - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
