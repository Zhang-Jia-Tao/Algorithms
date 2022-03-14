package edu.princeton.cs.LeetCode.List;

//分割链表
public class zjt_86 {
    public static void main(String[] args) {

    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1);  //小于x的头节点
        ListNode head2 = new ListNode(-1);  //大于x的头节点
        ListNode p1 = head1;
        ListNode p2 = head2;

        ListNode point = head;

        while(point != null){
            if(point.val < x){
                p1.next = point;
                point = point.next;
                p1 = p1.next;
            } else {
                p2.next = point;
                point = point.next;
                p2 = p2.next;
            }
        }
        p2.next = null;
        p1.next = head2.next;
        return head1.next;
    }
}
