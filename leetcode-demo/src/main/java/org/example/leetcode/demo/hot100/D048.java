package org.example.leetcode.demo.hot100;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/18
 */
public class D048 {

    public void rotate(int[][] matrix) {

        /**
         * 额外的数组空间，
         * oldMatrix[i][j] = newMatrix[j][n-1-i]
         */
//        int length = matrix.length;
//        int[][] result = new int[length][length];
//        for (int i = 0; i < matrix.length; i++) {
//            int[] matrix1 = matrix[i];
//            for (int j = 0; j < matrix1.length; j++) {
//                result[j][length - 1 - i] = matrix1[j];
//            }
//        }
//        for (int i = 0; i < matrix.length; i++) {
//            int[] matrix1 = matrix[i];
//            for (int j = 0; j < matrix1.length; j++) {
//                matrix[i][j] = result[i][j];
//            }
//        }

        /**
         * 原地反转,遍历两次
         */
//        int n = matrix.length;
//        //先上下反转
//        for (int i = 0; i < n / 2; i++) {
//            for (int j = 0; j < n; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n - 1 - i][j];
//                matrix[n - 1 - i][j] = temp;
//            }
//        }
//        //然后坐上右下对角线反转
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i + 1; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }

        int n = matrix.length;
        for (int i = 0; i < (n - 1) / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];



            }
        }

    }
}
