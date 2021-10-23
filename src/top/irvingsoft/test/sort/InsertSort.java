package top.irvingsoft.test.sort;

import top.irvingsoft.code.sort.IArraySort;

import java.util.Arrays;

public class InsertSort implements IArraySort {
    public static void main(String[] args) {

        int[] arr = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        System.out.println(Arrays.toString(new InsertSort().sort(arr)));
    }

    @Override
    public int[] sort(int[] sourceArray) {
        return sourceArray;
    }
}
