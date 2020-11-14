package array.p1122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-14 9:28
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int k = 0;
        for (int value : arr2) {
            for (int j = k; j < arr1.length; j++) {
                if (arr1[j] == value) {
                    int t = arr1[k];
                    arr1[k] = arr1[j];
                    arr1[j] = t;
                    k++;
                }
            }
        }
        Arrays.sort(arr1, k, arr1.length);
        return arr1;
    }

    public int[] relativeSortArrayCount(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] res = new int[arr1.length];

        for (int val: arr1) {
            bucket[val] ++;
        }
        int j = 0;
        for (int val: arr2) {
            while (bucket[val] -- > 0) {
                res[j ++] = val;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (bucket[i] -- > 0) {
                res[j ++] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.relativeSortArrayCount(arr1, arr2)));
    }
}
