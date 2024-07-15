package YandexHandbookAlg;

import java.util.*;
import java.util.stream.Collectors;

public class Task3_5_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        List<Integer> arr =new ArrayList<>(Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList())) ;
        selectionSort(arr);
        System.out.println(arr.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }

    private static void selectionSort(List<Integer> arr){
        for (int i = 0; i < arr.size(); i++) {
            int min = Collections.min(arr.subList(i, arr.size()));
            arr.set(arr.indexOf(min), arr.get(i));
            arr.set(i, min);
        }
    }
}
