package org.example.leetcode.demo;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/11/16
 */
public class D_0234 {

    public boolean isPalindrome(ListNode head) {
        //用快慢指针找到中间节点
        ListNode middleNode = middleNode(head);
        //反转后半部分节点
        ListNode last = reverse(middleNode);
        //双指针遍历判断
        while (head != null && last != null) {
            if (head.val == last.val) {
                head = head.next;
                last = last.next;
            } else {
                return false;
            }
        }
        return true;

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node2 = new ListNode(0);
        head.next = node2;
        boolean palindrome = new D_0234().isPalindrome(head);
        System.out.println(palindrome);
    }
}
