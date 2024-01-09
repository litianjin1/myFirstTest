package com.example.study.testDemo.sort;


/**
 * mergeSort 方法是归并排序的入口方法，它接受一个整数数组作为参数，并调用 mergeSort 方法进行递归排序。
 *
 * mergeSort 方法是归并排序的核心方法，它接受四个参数：待排序数组 arr、当前排序范围的左边界 left、右边界 right 和一个临时数组 temp。
 *
 * 在 mergeSort 方法中，首先判断左边界 left 是否小于右边界 right，如果是，则继续进行排序，否则不做任何操作。
 *
 * 在继续排序的情况下，首先计算出当前排序范围的中间位置 mid，然后分别对左半部分和右半部分进行递归排序，即调用 mergeSort 方法。
 *
 * 接下来，调用 merge 方法对已排序的左半部分和右半部分进行合并。
 *
 * merge 方法接受五个参数：待排序数组 arr、左边界 left、中间位置 mid、右边界 right 和临时数组 temp。
 *
 * 在 merge 方法中，定义三个指针 i、j 和 k，分别指向左半部分的起始位置、右半部分的起始位置和临时数组的起始位置。
 *
 * 使用两个指针 i 和 j 遍历左半部分和右半部分，比较两个指针所指的元素大小，将较小的元素放入临时数组 temp 中，并将对应指针后移。
 *
 * 当遍历完其中一个半部分后，将剩余的元素依次放入临时数组 temp 中。
 *
 * 最后，将临时数组 temp 中的元素复制回原数组 arr 的对应位置。
 *
 * 在 main 方法中，创建一个整数数组 arr，并调用 mergeSort 方法对其进行排序。
 *
 * 最后，使用循环遍历排序后的数组，并将每个元素输出到控制台。
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        //2、在 mergeSort 方法中，首先判断左边界 left 是否小于右边界 right，如果是，则继续进行排序，否则不做任何操作。
        if (left < right) {
            //3 在继续排序的情况下，首先计算出当前排序范围的中间位置 mid，然后分别对左半部分和右半部分进行递归排序，即调用 mergeSort 方法。
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            // 4 接下来，调用 merge 方法对已排序的左半部分和右半部分进行合并。
            merge(arr, left, mid, right, temp);
        }
    }

    //5 merge 方法接受五个参数：待排序数组 arr、左边界 left、中间位置 mid、右边界 right 和临时数组 temp。
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 6 在 merge 方法中，定义三个指针 i、j 和 k，分别指向左半部分的起始位置、右半部分的起始位置和临时数组的起始位置。
        int i = left;
        int j = mid + 1;
        int k = 0;
        //7 使用两个指针 i 和 j 遍历左半部分和右半部分，比较两个指针所指的元素大小，将较小的元素放入临时数组 temp 中，并将对应指针后移
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 8 当遍历完其中一个半部分后，将剩余的元素依次放入临时数组 temp 中
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 9 最后，将临时数组 temp 中的元素复制回原数组 arr 的对应位置。
        for (i = 0; i < k; i++) {
            arr[left + i] = temp[i];
        }
    }

     public  static void changeValue(int left){
         left++;
     }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7, 6, 3};
        mergeSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
//        int i= 6;
//        changeValue(i);
//        System.out.println(i);
    }
}
