package minimumOperationsArray;

class Solution {
    public int minOperations(int n) {
        int result=0;
        int average = n-1;
        while (average > 0){
            result += average;
            average-=2;
        }
        return result;
    }
}
