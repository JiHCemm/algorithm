package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;

/**
 * 选择排序
 * @author JiHC
 * @since 2020/8/25
 */
public class SelectionSort {
    private static Log log = LogFactory.getLog (BubbleSort.class);
    public static void main(String[] args) {
        int size = 10;// 数组长度(0 - 10)
        int value = 100;// 值大小(-100 - 100)
        //一维数组 : 数组中每个元素都只带有一个下标
        int[] arr = ArrayUtils.generateRandomArray (size, value);
        // 对象拷贝 : 一维数组：深克隆；（重新分配空间，并将元素复制过去） 二维数组：浅克隆。（只传递引用）
        int[] selectArr = arr.clone ();// 进行选择排序的数组
        int[] sortArr = arr.clone ();// 进行系统排序的数组

        StringBuilder arrStr = new StringBuilder ("原数组: ");
        for (int number : arr) {
            arrStr.append (number).append (" ");
        }
        log.info (arrStr);

        selectSort (selectArr);
        StringBuilder selectStr = new StringBuilder ("选择排序:");
        for (int bValue : selectArr) {
            selectStr.append (bValue).append (" ");
        }
        log.info (selectStr);

        // 绝对正确的方法,这个方法可以时间复杂度很差，但是要保证其准确性
        Arrays.sort (sortArr);// 调用系统的函数来进行验证
        StringBuilder sortStr = new StringBuilder ("系统函数排序: ");
        for (int sValue : sortArr) {
            sortStr.append (sValue).append (" ");
        }
        log.info (sortStr);

        log.info (ArrayUtils.isEqual (selectArr, sortArr) ? "成功" : "失败");
    }

    private static void selectSort(int[] arr)  {

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

}
