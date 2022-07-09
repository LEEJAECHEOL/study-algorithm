package sort;

import java.util.Arrays;
import java.util.List;

/**
 * 퀵 정렬 : 분할 정복 알고리즘을 사용한 정렬 = O(NlogN)
 * 기준값 = 피벗 = 보통 가장 앞에 있는 값
 * 피벗을 기준으로 오른쪽은 피벗보다 큰값을 왼쪽에서는 피벗보다 작은 값을 선택 후 자리 변경
 * 엇갈릴 경우 작을 값과 피벗을 자리바꿈.
 * 항상 빠른 것은 아님
 * 최악(거의 정렬된 경우)에서는 시간 복잡도가 O(N^2)이다.
 */

public class QuickSort {


    public static void sortInteger(List<Integer> arrays, int start, int end, final Sort sort) {
        if (start >= end) {
            return;
        }

        int pivotKey = start;
        int i = start + 1, j = end, temp;

        while (i <= j) {
            // 피벗보다 큰 값을 찾음
            while (i <= end &&
                    (sort == Sort.ASC ?
                            arrays.get(i) <= arrays.get(pivotKey) :
                            arrays.get(i) >= arrays.get(pivotKey))
            ) {
                i++;
            }

            // 피벗보다 작은 값을 찾는다.
            while (j > start &&
                    (sort == Sort.ASC ?
                            arrays.get(j) >= arrays.get(pivotKey) :
                            arrays.get(j) <= arrays.get(pivotKey))
            ) {
                j--;
            }

            if (i > j) { // 엇갈릴 경우
                temp = arrays.get(j);
                arrays.set(j, arrays.get(pivotKey));
                arrays.set(pivotKey, temp);
            } else {
                temp = arrays.get(i);
                arrays.set(i, arrays.get(j));
                arrays.set(j, temp);
            }
        }

        sortInteger(arrays, start, j - 1, sort);
        sortInteger(arrays, j + 1, end, sort);
    }

    public static void main(String[] args) {
        final List<Integer> arrays = Arrays.asList(3, 8, 5, 6, 1, 4, 7, 2, 9);

        QuickSort.sortInteger(arrays, 0, arrays.size() - 1, Sort.DESC);
        arrays.forEach(System.out::print);
    }
}
