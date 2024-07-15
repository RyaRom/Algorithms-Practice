package YandexHandbookAlg;

import java.util.*;
import java.util.stream.Collectors;

public class Task3_5_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int size = 0;
        List<Queue<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < n ;i++) {
            size += Integer.parseInt(s.nextLine());
            Queue<Integer> arr =new LinkedList<>(Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
            arrays.add(arr);
        }
        List<Integer> merged = new ArrayList<>(size);
        merge(arrays, merged, size);
        System.out.println(merged.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }

    private static void merge(List<Queue<Integer>> arrays, List<Integer> merged, int size){
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
