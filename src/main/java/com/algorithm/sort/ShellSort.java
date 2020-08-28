package com.algorithm.sort;

/**
 * 希尔排序 : 把数组按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的元素越来越多，当增量减至 1 时，整个数组恰被分成一组，算法便终止。
 *
 * @author JiHC
 * @since 2020/8/26
 */
public class ShellSort {

    public static void sort(int[] arr) {
        // 判断边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        int gap = 1;// 增量
        while (gap < arr.length) {
            gap = gap * 5 + 1;// 增量序列 : 1 , 4 , 13 , 40 , 121 , 364 , 1093...
        }
        // 进行分组
        while (gap > 0) {
            // 对各个分组进行 插入排序
            for (int i = gap; i < arr.length; i++) {
                insertValue (arr, gap, i);// 将arr[i]插入到所在分组的正确位置上
            }
            gap = gap / 5;// gap收缩，直至1
        }
    }

    /**
     * 将arr[i]插入到所在分组的正确位置上 ( 代码与插入排序几乎一致 )
     *
     * @param arr 数组
     * @param gap 增量
     * @param i   数组下标
     */
    private static void insertValue(int[] arr, int gap, int i) {
        int tmp = arr[i];
        int j = i - gap;
        // 按组进行插入(组内元素两两相隔gap)
        while (j >= 0 && arr[j] > tmp) {
            arr[j + gap] = arr[j];
            j -= gap;
            if (j + gap != i) {
                arr[j + gap] = tmp;
            }
        }
    }
}
