package YandexHandbookAlg;

import java.util.*;
import java.util.stream.Collectors;

public class Task7_5_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] dots = new int[n][2];
        for (int i = 0; i < n; i++) {
            dots[i][0]=s.nextInt();
            dots[i][1]=s.nextInt();

        }
        Arrays.sort(dots, Comparator.comparingInt(d->d[0]));
        if (dots.length==2){
            System.out.println(dist(dots[0][0],dots[1][0],dots[0][1],dots[1][1]));
            return;
        }
        double d = minDistance(dots,0,n-1);
        System.out.println(Math.min(d, minMiddleScan(dots, n/2, d)));
    }

    private static double minMiddleScan(int[][] dots, int middleX, double d){
        double minDist=  0;
        List<List<Integer>> dts = new ArrayList<>();
        for (int[] dot : dots) {
            if (dist(dot[0], middleX, 0,0)<=d){
                dts.add(new ArrayList<>(Arrays.stream(dot).boxed().collect(Collectors.toList())));
            }
        }
        dts.sort(Comparator.comparingInt(e->e.get(1)));
        for (int i = 0; i < dts.size(); i++) {
            double minMinDist = 0;
            int size = Math.min(7, dts.size()-i);
            for (int j = i+1; j < i+size; j++) {
                minMinDist = Math.min(minMinDist, dist(dts.get(i).get(0), dts.get(i).get(1), dts.get(j).get(0),dts.get(j).get(1)));
            }
            minDist = Math.min(minMinDist, minDist);
        }
        return minDist;
    }

    private static double dist(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
    }

    private static double minDistance(int[][] dots, int start, int end){
        if (start+2==end){
            return Math.min(dist(dots[start][0],dots[start][1],dots[end][0],dots[end][1]), Math.min(dist(dots[start+1][0],dots[start+1][1],dots[end][0],dots[end][1]), dist(dots[start][0],dots[start][1],dots[start+1][0],dots[start+1][1])));
        }
        if (start == end) return Integer.MAX_VALUE;
        if (start + 1 == end) return dist(dots[start][0],dots[start][1],dots[end][0],dots[end][1]);
        double d1= minDistance(dots,start, end/2);
        double d2 = Integer.MAX_VALUE;
        if (d1!=Integer.MAX_VALUE) d2 = minDistance(dots,end-start>>1, end);
        return Math.min(d1, d2);
    }
}
