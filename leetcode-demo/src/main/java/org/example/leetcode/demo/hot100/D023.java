package org.example.leetcode.demo.hot100;


import org.example.leetcode.demo.tool.LinkedListTool;
import org.example.leetcode.demo.tool.ListNode;

import java.util.List;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/8
 */
public class D023 {

    public static void main(String[] args) {

        ListNode head1 = LinkedListTool.generateLinkedList(new int[]{1, 4, 5});
        ListNode head2 = LinkedListTool.generateLinkedList(new int[]{1, 3, 4});
        ListNode head3 = LinkedListTool.generateLinkedList(new int[]{2, 6});
        ListNode[] listNodes = new ListNode[]{head1, head2, head3};
        ListNode head = new D023().mergeKLists(listNodes);
        LinkedListTool.printLinkedList(head);
    }

    /**
     * 合并k个链表，可以简化成合并两个链表，然后循环调用
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        for (int i = 0; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head.next;
    }

    private ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        ListNode head = null;
        ListNode tail = null;
        while (listNode1 != null || listNode2 != null) {
            int val1 = listNode1 == null ? Integer.MAX_VALUE : listNode1.val;
            int val2 = listNode2 == null ? Integer.MAX_VALUE : listNode2.val;
            ListNode currentNode;
            if (val1 < val2) {
                currentNode = listNode1;
                listNode1 = listNode1.next;
            } else {
                currentNode = listNode2;
                listNode2 = listNode2.next;
            }
            if (head == null) {
                head = tail = currentNode;
            } else {
                tail.next = currentNode;
                tail = currentNode;
            }
        }
        return head;
    }
}
