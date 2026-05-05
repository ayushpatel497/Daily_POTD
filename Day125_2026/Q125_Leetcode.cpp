/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        // Q. Rotate List
        if(!head || !head-> next){
            return head;
        }
        int n = 1;
        ListNode *prev = head;
        while(prev-> next){
            prev = prev-> next;
            n++;
        }
        k %= n;
        if(!k){
            return head;
        }
        n -= (k + 1);
        prev-> next = head;
        prev = head;
        while(n--){
            prev = prev-> next;
        }
        head = prev-> next;
        prev-> next = NULL;
        return head;
    }
};