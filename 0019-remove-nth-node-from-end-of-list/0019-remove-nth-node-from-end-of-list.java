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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        if(temp==null||temp.next == null)return null;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        if(count == n)return head.next;
        temp = head;
        for(int i =1;i<=count;i++){
            if(i==count-n){
                temp.next = temp.next.next;
                break;
            }
            temp= temp.next;
        }
        return head;
    }
}