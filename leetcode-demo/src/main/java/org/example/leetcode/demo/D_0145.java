package org.example.leetcode.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/11/18
 */
public class D_0145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == temp) {
                list.add(root.val);
                temp = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }

        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        List<Integer> list = new D_0145().postorderTraversal(node1);
        list.forEach(System.out::println);

    }



}
