package nameSorting;


import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
    }
    public String[] sortPeople(String[] names, int[] heights) {
        quickSort(names, heights, 0, names.length);
        return names;
    }
    private static void quickSort(String[] names, int[] arr, int start, int end){
        if (end-1 <= start) return;
        int random;
        do {
            random = (int) (Math.random() * end);
        }while (random < start || random >= end);
        int pivot = arr[random];
        arr[random] = arr[end-1];
        arr[end-1] = pivot;
        String t = names[random];
        names[random] = names[end-1];
        names[end-1] = t;
        int pointer = start;
        for (int i = start; i < end; i++) {
            if (arr[i] >= pivot){
                int a = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = a;

                String n = names[i];
                names[i] = names[pointer];
                names[pointer] = n;

                pointer++;
            }
        }
        pointer--;
        quickSort(names, arr, start, pointer);
        quickSort(names, arr, pointer+1, end);
    }
}