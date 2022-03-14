package edu.princeton.cs.LeetCode.List;

import java.util.HashSet;

//删除排序链表中的重复元素
//完全可以使用哈希表进行处理
public class zjt_83 {

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

    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> hashSet = new HashSet<>();
        while(head != null){
            hashSet.add(head.val);
            head = head.next;
        }
        ListNode reHead = new ListNode(-1);
        ListNode ptr = reHead;
        for(int val:hashSet){
            ListNode node = new ListNode(val);
            ptr.next = node;
            ptr = ptr.next;
        }
        ptr.next = null;
        return reHead.next;
    }
}
