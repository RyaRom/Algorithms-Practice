package YandexHandbookAlg;

import java.util.*;
import java.util.stream.Collectors;

public class Task4_2_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        List<Integer> arr1 =new ArrayList<>(Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList())) ;
        int m = Integer.parseInt(s.nextLine());
        List<Integer> arr2 =new ArrayList<>(Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList())) ;
        List<Integer> sum = new ArrayList<>();
        polySum(arr1, arr2, sum);
        System.out.println(sum.size()-1);
        System.out.println(sum.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
    private static void polySum(List<Integer> arr1, List<Integer> arr2, List<Integer> sum){
        int size = Math.max(arr2.size(), arr1.size());
        fillWithZero(arr1, size);
        fillWithZero(arr2, size);
        for (int i = 0; i < size; i++) {
            sum.add(arr1.get(i) + arr2.get(i));
        }
    }
    private static void fillWithZero(List<Integer> arr, int initialCapacity){
        if (arr.size()<initialCapacity){
            List<Integer> zeroes = new ArrayList<>(Collections.nCopies(initialCapacity - arr.size(), 0));
            zeroes.addAll(arr);
            arr.clear();
            arr.addAll(zeroes);
        }
    }
}
