package org.example.leetcode.demo;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/10/29
 */
public class D_0083 {

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(1);
        ListNode node_3 = new ListNode(2);
        ListNode node_4= new ListNode(3);
        ListNode node_5 = new ListNode(3);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        ListNode listNode = new D_0083().deleteDuplicates(node_1);
        System.out.println(listNode.val);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
