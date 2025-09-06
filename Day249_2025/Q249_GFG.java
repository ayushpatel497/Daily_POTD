import java.util.HashMap;

class Q249_GFG {
    public int lengthOfLoop(Node head) {
        if (head == null || head.next == null) return 0;
        
        HashMap<Node, Integer> map = new HashMap<>();
        int i = 1;
        
        while (head != null) {
            if (map.containsKey(head)) {
                return i - map.get(head);
            }
            map.put(head, i);
            i++;
            head = head.next;
        }
        
        return 0;
    }
}
