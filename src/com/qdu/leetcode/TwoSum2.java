package com.qdu.leetcode;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/28
 */
public class TwoSum2 {
    public static void main(String[] args) {
        int[] ints = new TwoSum2().twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] indexArray = new int[2];
        int d;
        int minIndex;
        int maxIndex;
        Integer index;
        for (int i = 0; i < numbers.length; i++) {
            d = target - numbers[i];
            index = map.get(d);
            if (index != null && index != i) {
                if (index > i) {
                    minIndex = i + 1;
                    maxIndex = index + 1;
                } else {
                    minIndex = index + 1;
                    maxIndex = i + 1;
                }
                indexArray[0] = minIndex;
                indexArray[1] = maxIndex;
                return indexArray;
            }
            map.put(numbers[i], i);
        }
        return indexArray;
    }
}
