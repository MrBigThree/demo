package org.example.leetcode.demo.tool;

import java.util.List;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/8
 */
public class LinkedListTool {

    /**
     * 创建链表
     *
     * @param array
     * @return
     */
    public static ListNode generateLinkedList(int[] array) {
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < array.length; i++) {
            ListNode current = new ListNode(array[i]);
            if (i == 0) {
                tail = head = current;
            }
            tail.next = current;
            tail = current;
        }
        return head;
    }

    public static void printLinkedList(ListNode head){
        while (head != null){
            System.out.print(head.val);
            head = head.next;
            System.out.print(",");
        }
        System.out.println();
    }

}
