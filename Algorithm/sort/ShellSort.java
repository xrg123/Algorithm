package cn;

import java.util.Arrays;

/**
 * @Author:XRG
 * @Date:2019/3/23 11:32
 * @Desctiption:
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int increment = num.length;
        int j;
        do{
            increment = increment/3 +1;
            for(int i = increment; i < num.length; i++) {
                if(num[i] < num[i - increment]) {
                    int temp = num[i];
                    for(j = i - increment; j >= 0 && num[j] > temp; j -= increment) {
                        num[j + increment] = num[j];
                    }
                    num[j + increment] = temp;
                }
            }
        } while(increment > 1);
        System.out.println(Arrays.toString(num));
    }
}
