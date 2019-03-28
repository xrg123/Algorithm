package cn;

import java.util.Arrays;

/**
 * @Author:XRG
 * @Date:2019/3/21 21:28
 * @Desctiption:
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        for (int i = a.length / 2; i > 0; i--) {//构建成大顶锥
            heapAdjust(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapAdjust(a, 1, i);  //重新调整为大顶堆
        }
        System.out.println(Arrays.toString(a));
    }

    public static void heapAdjust(int[] a, int s, int m) {
        int temp, i, largest; //largest中存关键字较大的记录下标
        temp = a[s - 1]; //表示第s个节点
        for (i = 2 * s; i <= m; i *= 2) {
            if (i < m && a[i - 1] < a[i]) {
                largest = i;
            } else
                largest = i - 1;
            if (temp >= a[largest])
                break;
            a[s - 1] = a[largest];
            s = largest + 1;
        }
        a[s - 1] = temp;
    }
}
