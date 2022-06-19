package sort;

import java.util.Arrays;
import java.util.List;

/**
 * 삽입 정렬 : 각 숫자를 적절한 위치에 삽입 = O(n^2)
 * 필요할때만 위치를 바꿔줌 (앞에 있는 값들은 정렬이 되어 있다고 가정한다.)
 * 거의 정렬된 상태에서 가장 효율적임
 */

public class InsertionSort {

    public static void sortInteger(final List<Integer> arrays, final Sort sort) {
        Integer temp;
        int j;
        for (int i = 0; i < arrays.size() - 1; i++) {
            j = i;
            while (j >= 0 && (sort == Sort.ASC ?
                    arrays.get(j) > arrays.get(j + 1) :
                    arrays.get(j) < arrays.get(j + 1))
            ) {
                temp = arrays.get(j);
                arrays.set(j, arrays.get(j + 1));
                arrays.set(j + 1, temp);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        final List<Integer> arrays = Arrays.asList(3, 8, 5, 6, 1, 4, 7, 2, 9);
        InsertionSort.sortInteger(arrays, Sort.ASC);
        arrays.forEach(System.out::print);
        System.out.println();
        InsertionSort.sortInteger(arrays, Sort.DESC);
        arrays.forEach(System.out::print);
    }
}
