package com.algorithm.sort;

/**
 * 选择排序
 *
 * @author JiHC
 * @since 2020/8/25
 */
public class SelectionSort {

    // N个数字选择排序，总共要进行 N-1 轮比较，每轮的排序次数为 (N-i) 次比较
    public static void sort(int[] arr) {
        // 判断边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;// 用来记录最小值的索引位置，默认值为i
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;// 遍历 i+1~length 的值，找到其中最小值的位置
                }
            }
            // 交换当前索引 i 和最小值索引 min 的值
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
            // 执行完一次循环，当前索引 i 处的值为最小值，直到循环结束即可完成排序
        }
    }

}
