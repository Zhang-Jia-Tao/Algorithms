package edu.princeton.cs.LeetCode.List;


import java.util.List;

//合并两个有序链表
public class zjt_21 {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();     //虚拟头节点
        if(list1.val > list2.val){
           head.next = list2;
           list1 = list1.next;
        } else {
            head.next = list1;
            list2 = list2.next;
        }

        ListNode ptr = head.next;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                ptr.next = list2;
                ptr = ptr.next;
                list2 = list2.next;
            } else {
                ptr.next = list1;
                ptr = ptr.next;
                list1 = list1.next;
            }
        }

        if(list1 == null){
            ptr.next = list2;
        } else {
            ptr.next = list1;
        }

        return head.next;
    }
}
