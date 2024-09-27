package math.josephus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findTheWinner(5,2));
    }
    public int findTheWinner(int n, int k) {
        List<Integer> people =new ArrayList<>(IntStream.range(1,n+1).boxed().toList());
        int currentHuman = 0;
        while (people.size()>1) {
            for (int i = 1; i < k; i++){
                currentHuman = currentHuman >= people.size()-1 ?0 : currentHuman + 1;
            }
            if (currentHuman == people.size()-1){
                people.remove(currentHuman);
                currentHuman = 0;
            }else people.remove(currentHuman);
        }
        return people.getFirst();
    }
}