package YandexHandbookAlg;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task3_6_2 {
    public static void main(String[] args) {

        while (true) {
            Random random= new Random();
            int n = random.nextInt(1, 100);
            int[] arr = IntStream.generate(random::nextInt).limit(n).toArray();
            int[] arr2 = Arrays.stream(arr).toArray();
            quickSortRandom(arr2, 0, n);
            String qs = Arrays.stream(arr2).boxed().map(Objects::toString).collect(Collectors.joining(" "));
            Arrays.sort(arr);
            String correct = Arrays.stream(arr).boxed().map(Objects::toString).collect(Collectors.joining(" "));
            if (!correct.equals(qs)){
                System.out.printf("%s\n\n is wrong      \n\n    %s\n\n is correct\n\n\n\n", qs, correct);
                break;
            }else {
                System.out.printf("%s\n\n is quickSort      \n\n    %s\n\n is correct\n\n\n\n", qs, correct);
            }
        }

    }
    private static void quickSortRandom(int[] arr, int start, int end){
        if (end-1 <= start) return;
        int random;
        do {
            random = (int) (Math.random() * end);
        }while (random < start || random >= end);
        int pivot = arr[random];
        arr[random] = arr[end-1];
        arr[end-1] = pivot;
        int pointer = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot){
                int a = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = a;
                pointer++;
            }
        }
        pointer--;
        quickSortRandom(arr, start, pointer);
        quickSortRandom(arr, pointer+1, end);
    }
}
