class Q045_Leetcode {
    vector<int> store;
    int size;
public:
    Q045_Leetcode() {
        // Q. Product of the Last K Numbers
        store.push_back(1);
        size = 0;
    }
    
    void add(int num) {
        if(num == 0){
            store = {1};
            size = 0;
        }
        else{
            store.push_back(num * store[size]);
            size += 1;
        }
    }
    
    int getProduct(int k) {
        if(k > size){
            return 0;
        }
        return store[size] / store[size - k];
    }
};

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers* obj = new ProductOfNumbers();
 * obj->add(num);
 * int param_2 = obj->getProduct(k);
 */