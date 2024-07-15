package YandexHandbookAlg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task3_6_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        List<Integer> arr =new ArrayList<>(Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList())) ;
        lomuto(arr);
        System.out.println(arr.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
    private static void lomuto(List<Integer> list){
        int pivot = list.get(0);
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for (int a : list){
            if (a<=pivot)arr1.add(a);
            else if (a>pivot)arr2.add(a);
        }
        list.clear();
        int f = arr1.get(0);
        arr1.set(0, arr1.get(arr1.size()-1));
        arr1.set(arr1.size()-1, f);

        list.addAll(arr1);
        list.addAll(arr2);
    }
}
