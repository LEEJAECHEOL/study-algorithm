package sort;

import java.util.Arrays;
import java.util.List;


/**
    가장 작은 또는 큰 값을 앞으로 보내는 정렬
    O(n^2)
 */
public class SelectionSort {

    public static void sortInteger(final List<Integer> arrays, final Sort sort) {
        final int arraySize = arrays.size();
        Integer compare, temp;
        int tempIndex = 0;

        for (int i = 0; i < arraySize; i++) {
            compare = sort == Sort.ASC ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            for (int j = i; j < arraySize; j++) {
                if (sort == Sort.ASC ? compare >
                        arrays.get(j) :
                        compare < arrays.get(j)
                ) {
                    compare = arrays.get(j);
                    tempIndex = j;
                }
            }
            temp = arrays.get(i);
            arrays.set(i, compare);
            arrays.set(tempIndex, temp);
        }
    }

    public static void main(String[] args) {
        final List<Integer> arrays = Arrays.asList(3, 8, 5, 6, 1, 10, 4, 7, 2, 9);
        SelectionSort.sortInteger(arrays, Sort.ASC);
        arrays.forEach(System.out::print);
        System.out.println();
        SelectionSort.sortInteger(arrays, Sort.DESC);
        arrays.forEach(System.out::print);
    }
}
