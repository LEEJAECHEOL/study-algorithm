package sort;

import java.util.Arrays;
import java.util.List;

/**
 *  옆 값과 비교해서 작은 or 큰 값을 반복적으로 앞으로 보냄 O(n^2)
 *  매번 교체를 하기 때문에 선택정렬보다 느림
 */

public class BubbleSort {

    public static void sortInteger(final List<Integer> arrays, final Sort sort) {
        final int arraySize = arrays.size();

        Integer temp;
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                if (sort == Sort.ASC ?
                        arrays.get(j) > arrays.get(j + 1) :
                        arrays.get(j) < arrays.get(j + 1)
                ) {
                    temp = arrays.get(j);
                    arrays.set(j, arrays.get(j + 1));
                    arrays.set(j + 1, temp);
                }
            }
        }
    }


    public static void main(String[] args) {
        final List<Integer> arrays = Arrays.asList(3, 8, 5, 6, 1, 4, 7, 2, 9);
        BubbleSort.sortInteger(arrays, Sort.ASC);
        arrays.forEach(System.out::print);
        System.out.println();
        BubbleSort.sortInteger(arrays, Sort.DESC);
        arrays.forEach(System.out::print);


    }
}
