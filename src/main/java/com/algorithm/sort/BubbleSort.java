package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 冒泡排序
 * @author JiHC
 * @since 2020/8/24
 */
public class BubbleSort {
    private static Log log = LogFactory.getLog (BubbleSort.class);

    public static void main(String[] args) {
        int size = 10;// 数组长度(0 - 10)
        int value = 100;// 值大小(-100 - 100)
        //一维数组 : 数组中每个元素都只带有一个下标
        int[] arr = ArrayUtils.generateRandomArray (size, value);
        // 对象拷贝 : 一维数组：深克隆；（重新分配空间，并将元素复制过去） 二维数组：浅克隆。（只传递引用）
        int[] bubbleArr = arr.clone ();// 进行冒泡排序的数组
        int[] sortArr = arr.clone ();// 进行系统排序的数组

        StringBuilder arrStr = new StringBuilder ("原数组: ");
        for (int number : arr) {
            arrStr.append (number).append (" ");
        }
        log.info (arrStr);

        bubbleSort (bubbleArr);
        StringBuilder bubbleStr = new StringBuilder ("冒泡排序:");
        for (int bValue : bubbleArr) {
            bubbleStr.append (bValue).append (" ");
        }
        log.info (bubbleStr);

        // 绝对正确的方法,这个方法可以时间复杂度很差，但是要保证其准确性
        Arrays.sort (sortArr);// 调用系统的函数来进行验证
        StringBuilder sortStr = new StringBuilder ("系统函数排序: ");
        for (int sValue : sortArr) {
            sortStr.append (sValue).append (" ");
        }
        log.info (sortStr);

        log.info (ArrayUtils.isEqual (bubbleArr, sortArr) ? "成功" : "失败");
    }

    //N个数字冒泡排序，总共要进行N-1趟比较，每趟的排序次数为(N-i)次比较
    private static void bubbleSort(int[] arr) {
        //判断边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        log.info ("数组长度: " + arr.length + ", 预计执行" + (arr.length - 1) + "轮排序");
        boolean flag = false;// 判断是否发生交换
        for (int i = 0; i < arr.length - 1; i++) {
            log.info ("=========第" + (i+1) + "轮比较");
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 开始进行比较，如果arr[j]比arr[j+1]的值大，那就交换位置
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;// 发生交换
                }
                StringBuilder sb = new StringBuilder ();
                sb.append ("第").append (j+1).append ("次比较:");
                for (int number : arr) {
                    sb.append (number).append (" ");
                }
                log.info (sb);
            }
            if (!flag) {
                log.info ("flag为false,未发生交换,数组有序,退出冒泡排序");
                break;
            }
            flag = false;
        }
    }

}
