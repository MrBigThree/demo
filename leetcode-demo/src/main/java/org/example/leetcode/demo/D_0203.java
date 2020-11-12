package org.example.leetcode.demo;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/11/11
 */
public class D_0203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null) {
            boolean remove = false;
            if (fast.val == val) {
                if (slow != null) {
                    slow.next = fast.next;
                }
                remove = true;
            }
            if (remove && slow == null) {
                head = fast.next;
            }
            if (!remove) {
                slow = fast;
            }
            fast = fast.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;


        ListNode listNode = new D_0203().removeElements(node1, 3);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
