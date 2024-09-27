package simulation.waitingLineRestaurant;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}}));
    }
    public double averageWaitingTime(int[][] customers) {
        int startTime = 0;
        long average=0;
         for (int[] customer : customers) {
            startTime = Math.max(startTime, customer[0]);
            int finishTime = startTime + customer[1];
            average += (finishTime - customer[0]);
            startTime = finishTime;
        }
        return (double) average /customers.length;
    }
}