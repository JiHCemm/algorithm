package com.algorithm.util;

/**
 * @author JiHC
 * @since 2020/8/25
 */
public class ArrayUtils {

    public static boolean isEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //生成一个对数器。产生一个随机样本的数组，数组的长度和值都是随机的
    public static int[] generateRandomArray(int size, int value) {
        // 生成长度随机的数组，数组的最大长度是size的长度
        int[] arr = new int[(int) ((size + 1) * Math.random ())];
        for (int i = 0; i < arr.length; i++) {
            //针对数组中的每个值都可以随机一下，一个随机数减去另外一个随机数，可能产生正数，也可能产生负数
            arr[i] = (int) ((value + 1) * Math.random ()) - (int) (value * Math.random ());
        }
        return arr;
    }
}
