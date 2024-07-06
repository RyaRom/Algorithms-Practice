package SuperPow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.superPow(78267,new int[]{2,0,0,2,9,4,8,4,2,8,5}));
    }

    public int superPow(int a, int[] b) {
        if (a==0||a==1) return a;
        a=a%1337;
        return (int) superPow2(a,new ArrayList<>( Arrays.stream(b).boxed().toList()));
    }

    public long superPow2(int a, List<Integer> b) {
        if (b.size() == 1 && b.getFirst() == 1) return a % 1337;
        if (b.getLast() % 2 == 0){
            divideBy2(b);
            return ((long) Math.pow(superPow2(a, b), 2))%1337;
        }
        else {
            b.set(b.size()-1, b.getLast() - 1);
            return (superPow2(a, b) * (a%1337))%1337;
        }
    }

    public void divideBy2(List<Integer> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            int temp = arr.get(i);
            if (temp % 2 == 0) arr.set(i, temp / 2);
            else {
                arr.set(i, Math.floorDiv(temp, 2));
                arr.set(i + 1, arr.get(i + 1) + 5);
            }
        }
        floor(arr);
    }

    public void floor(List<Integer> arr) {
        ArrayList<Integer> newArray = new ArrayList<>();
        int j = 0;
        while (arr.get(j)==0)j++;
        for (int i = j; i < arr.size(); i++) {
            int n = arr.get(i);
            if (n >= 10) {
                newArray.add(n / 10);
                newArray.add(n % 10);
            } else newArray.add(n);
        }
        arr.clear();
        arr.addAll(newArray);
    }

}