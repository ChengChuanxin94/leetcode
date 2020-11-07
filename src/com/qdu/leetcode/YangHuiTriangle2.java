package com.qdu.leetcode;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/22
 */
public class YangHuiTriangle2 {
    public static void main(String[] args) {
        YangHuiTriangle2 yangHuiTriangle2 = new YangHuiTriangle2();
        // List<Integer> row = yangHuiTriangle2.getRow(30);
        List<Integer> rowByYangHui = yangHuiTriangle2.getRowByYangHui(5);
    }

    public List<Integer> getRowByYangHui(int rowIndex) {
        ArrayList<Integer> lastLineList = new ArrayList<>();
        lastLineList.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> currentList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currentList.add(1);
                } else if (j > (i / 2)) {
                    currentList.add(currentList.get(i - j));
                } else {
                    currentList.add(lastLineList.get(j) + lastLineList.get(j - 1));
                }
            }
            lastLineList = currentList;
        }
        return lastLineList;
    }

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            Integer result;
            if (i > (rowIndex / 2)) {
                result = row.get(rowIndex - i);
            } else {
                result = getBinomialCoefficient(rowIndex, i);
            }
            row.add(result);
        }
        return row;
    }

    public Integer getBinomialCoefficient(int m, int n) {
        if (n == 0) {
            return 1;
        }
        int loop = n;
        if (loop > (m / 2)) {
            return getBinomialCoefficient(m, m - n);
        }
        BigInteger resultM = new BigInteger("1");
        BigInteger resultN = new BigInteger("1");
        for (int i = 0; i < loop; i++) {
            resultM = resultM.multiply(new BigInteger(String.valueOf(m)));
            m--;
            resultN = resultN.multiply(new BigInteger(String.valueOf(n)));
            n--;
        }
        return resultM.divide(resultN).intValue();
    }
}
