package cn;

import java.util.Arrays;

/**
 * @Author:XRG
 * @Date:2019/3/23 11:13
 * @Desctiption:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        boolean flag = true;
        for(int i = 0; i < num.length - 1; i++) {
            flag = false;
            for(int j = num.length - 1; j > i; j--) {
                if(num[j] < num[j - 1]) {
                    int temp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println(Arrays.toString(num));
    }
}
