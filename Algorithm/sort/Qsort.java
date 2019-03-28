package cn;

import java.util.Arrays;

/**
 * @Author:XRG
 * @Date:2019/3/23 16:29
 * @Desctiption:
 */
public class Qsort {
    public static void main(String[] args) {
        int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Qsort(num, 0, num.length -1);
        System.out.println(Arrays.toString(num));
    }

    public static void Qsort(int[] num, int low, int height) {
        if(low < height) {
            int povit = partition(num, low, height);
            Qsort(num, low, povit - 1);
            Qsort(num, povit + 1, height);
        }
    }

    public static int partition(int[] num, int low, int height){
        /*int m = low + (height - low)/2;
        if(num[low] > num[height]) {
            swap(num, low, height);
        }
        if(num[m] > num[height]) {
            swap(num, m, height);
        }
        if(num[m] > num[low]){
            swap(num, m, low);
        }*/
        int povit = num[low];
        while(low < height) {
            while(low < height && num[height] >= povit) {
                height--;
            }
            swap(num, low, height);
            while(low < height && num[low] <= povit) {
                low++;
            }
           swap(num, low, height);
        }
        return low;
    }

    public static void swap(int[] num,int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}
