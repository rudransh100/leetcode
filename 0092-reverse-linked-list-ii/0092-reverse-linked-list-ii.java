/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)return head;
        ListNode dummyNode = new ListNode(-1,head);
        ListNode curr = dummyNode;
        int count = 0;
        while(count<left-1){
            curr = curr.next;
            count++;
        }
        count = 0;
        ListNode last = dummyNode;
        while(count<=right){
            last = last.next;
            count++;
        }
        ListNode temp = curr.next;
        count =1;
        while(count<=right-left+1&&temp!=null){
            ListNode x = temp;
            temp = temp.next;
            x.next = last;
            last = x;
            count++;
        }
        curr.next = last;
        return dummyNode.next;

    }
}