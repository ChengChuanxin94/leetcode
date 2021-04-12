package com.qdu.leetcode;
import java.util.ArrayList;
import java.util.List;


/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/21
 */
public class YangHuiTriangle {
    public static void main(String[] args) {
        YangHuiTriangle yangHuiTriangle = new YangHuiTriangle();
        List<List<Integer>> generate = yangHuiTriangle.generate(30);

    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            for (int i1 = 0; i1 <= i; i1++) {
                int binomialCoefficient = getBinomialCoefficient(i, i1);
                currentRow.add(binomialCoefficient);
            }
            lists.add(currentRow);
        }
        return lists;
    }

    public int getBinomialCoefficient(int m, int n) {
        if (n == 0) {
            return 1;
        }
        int loop = n;
        long mResult = 1;
        long nResult = 1;

        if (loop > (m / 2)) {
            loop = m - n;
            n = m - n;
        }
        for (int i = 0; i < loop; i++) {
            mResult = mResult * m;
            m--;
            nResult = nResult * n;
            n--;
        }
        return (int) (mResult / nResult);

    }

}
