package com.algorithm.sort;

/**
 * 冒泡排序 : 重复地走访过要排序的元素列，依次比较两个相邻的元素，如果顺序（如从小到大)错误就把他们交换过来。
 *
 * @author JiHC
 * @since 2020/8/24
 */
public class BubbleSort {

    // N个数字冒泡排序，总共要进行 N-1 轮比较，每轮的排序次数为 (N-i) 次比较
    public static void sort(int[] arr) {
        // 判断边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        boolean flag = false;// 判断是否发生交换
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            // 每轮需要比较的次数 N-i
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 开始进行比较，如果arr[j]比arr[j+1]的值大，那就交换位置
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;// 发生交换
                }
            }
            // flag为false,未发生交换,数组有序,退出冒泡排序
            if (!flag) {
                break;
            }
            flag = false;
        }
    }

}
