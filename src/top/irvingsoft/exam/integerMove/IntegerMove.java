package top.irvingsoft.exam.integerMove;

public class IntegerMove {

    private static final Integer[] ints = new Integer[]{6, 4, -3, 5, -2, -1, 0, 1, -9};

    public static void main(String[] args) {

        Integer[] integers = new Integer[200];
        int index = 0;

        for (Integer anInt : ints) {
            if (anInt > 0) {
                integers[index++] = anInt;
            }
        }

        for (Integer anInt : ints) {
            if (anInt == 0) {
                integers[index++] = anInt;
            }
        }

        for (Integer anInt : ints) {
            if (anInt < 0) {
                integers[index++] = anInt;
            }
        }

        for (int i = 0; i < index - 1; i++) {
            System.out.printf("%s ", integers[i]);
        }
        System.out.println(integers[index - 1]);
    }
}

/**
 * 正数左移，负数右移
 * 要求时间复杂度 O(n)，空间复杂度 O(1)
 */