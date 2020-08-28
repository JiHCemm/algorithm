package com.algorithm.sort;

/**
 * 插入排序 : 在待排序的元素中，假设前面n-1(其中n>=2)个数已经是排好顺序的，现将第n个数插到前面已经排好的序列中，然后找到合适自己的位置，使得插入第n个数的这个序列也是排好顺序的。
 * 插入排序的工作方式像许多人排序一手扑克牌。
 *
 * @author JiHC
 * @since 2020/8/26
 */
public class InsertionSort {
    public static void sort(int[] arr) {

        // 判断边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }
    }
}
