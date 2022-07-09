package sort;


/**
 * 병합 정렬 - 분할 정복
 *           정확인 반으로 나눔 -> 피벗이 없음
 */

public class MergeSort {
    static int number = 8;
    static int[] sorted = new int[number];

    public static void main(String[] args) {
        int[] array = {7, 6, 5, 8, 3, 5, 9, 1};
        mergeSort(array, 0, number - 1);

        for (int i = 0; i < number; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static void merge(int[] array, int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int k = start;

        // 작은 순서대로 배열 삽입
        while (i <= middle && j <= end) {
            if (array[i] <= array[j]) {
                sorted[k] = array[i];
                i++;
            } else {
                sorted[k] = array[j];
                j++;
            }
            k++;
        }
        // 남은 데이터 삽입
        if (i > middle) {
            for (int t = j; t <= end; t++) {
                sorted[k] = array[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                sorted[k] = array[t];
                k++;
            }
        }
        // 정렬된 배열 삽입
        for (int t = start; t <= end; t++) {
            array[t] = sorted[t];
        }
    }

    static void mergeSort(int array[], int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }

    }
}
