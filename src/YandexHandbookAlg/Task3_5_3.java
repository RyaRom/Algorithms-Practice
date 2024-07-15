package YandexHandbookAlg;

import java.util.*;
import java.util.stream.Collectors;

public class Task3_5_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        List<Integer> arr =new ArrayList<>(Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList())) ;
        LinkedList<Integer> sorted = (LinkedList<Integer>) mergeSort(arr);
        System.out.println(sorted.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
    private static Queue<Integer> mergeSort(List<Integer> arr){
        if (arr.size()==1) return new LinkedList<>(arr);
        Queue<Integer> arr1 = mergeSort(new ArrayList<>(arr.subList(0, arr.size()/2)));
        Queue<Integer> arr2 = mergeSort(new ArrayList<>(arr.subList(arr.size()/2, arr.size())));
        List<Queue<Integer>> arrays = new ArrayList<>(){{
           add(arr1);
           add(arr2);
        }};
        int size = arr1.size() + arr2.size();
        Queue<Integer> merged = new LinkedList<>();
        merge(arrays, merged, size);
        return merged;
    }
    private static void merge(List<Queue<Integer>> arrays, Queue<Integer> merged, int size){
        while (merged.size() < size){
            int index = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arrays.size(); i++) {
                if (!arrays.get(i).isEmpty() && arrays.get(i).peek() < min ){
                    min = arrays.get(i).peek();
                    index = i;
                }
            }
            merged.add(arrays.get(index).poll());
        }
    }
}
