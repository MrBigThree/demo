package org.example.leetcode.demo;

import java.util.Stack;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/11/18
 */
public class D_0112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        int num = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                num += root.val;
                stack.push(root);
                root = root.left;
            }
            if (num == sum) {
                return true;
            }
            root = stack.pop();
            if (root.right == null || root.right == temp) {
                num -= root.val;
                temp = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }
        return false;
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
//        node1.right = node3;
//
//        node2.left = node4;
//        node2.right = node5;
//
//        node3.left = node6;
//        node3.right = node7;
//
//        node4.left = node8;
//        node4.right = node9;

        new D_0112().hasPathSum(node1,1);
    }
}
