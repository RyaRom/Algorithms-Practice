package YandexHandbookAlg;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task7_3_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        quickSortRandom(arr, 0, n);
        System.out.println(Arrays.stream(arr).boxed().map(Objects::toString).collect(Collectors.joining(" ")));
    }

    private static void quickSortRandom(int[] arr, int start, int end){
        if (end <= start) return;
        int random;
        do {
            random = (int) (Math.random() * end);
        }while (random < start || random >= end);
        int pivot = arr[random];
        arr[random] = arr[end-1];
        arr[end-1] = pivot;
        int pointer = start;
        int rp = end-1;
        int i = start;
        while (i<=rp) {
            if (arr[i] < pivot){
                int a = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = a;
                pointer++;
                i++;
            }
            else if (arr[i]==pivot){
                i++;
            }
            else {
                int a = arr[i];
                arr[i] = arr[rp];
                arr[rp] = a;
                rp--;
            }
        }

        pointer--;
        quickSortRandom(arr, start, pointer);
        quickSortRandom(arr, rp+1, end);
    }
}
