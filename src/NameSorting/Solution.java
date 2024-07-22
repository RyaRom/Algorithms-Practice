package NameSorting;


class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        quickSort(names, heights, 0, names.length);
        return names;
    }
    private static void quickSort(String[] names, int[] arr, int start, int end){
        if (end <= start) return;
        int pivot = arr[end-1];
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