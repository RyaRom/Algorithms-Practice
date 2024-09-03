package tinkoffAcademy2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution5 {

    private static final BufferedReader fastScanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line1 = fastScanner.readLine();
        int N = Integer.parseInt(line1.split(" ")[0]);
        int M = Integer.parseInt(line1.split(" ")[1]);
        int[][] pairs = new int[M][2];
        for (int i = 0; i < M; i++) {
            String line = fastScanner.readLine();
            int A = Integer.parseInt(line.split(" ")[0]);
            int B = Integer.parseInt(line.split(" ")[1]);
            pairs[i][0] = A;
            pairs[i][1] = B;
        }
        List<Integer> sequence = findSoldiersSequence(N, pairs);
        if (sequence == null) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            System.out.println(sequence.stream().map(Objects::toString).collect(Collectors.joining(" ")));
        }

    }

    public static List<Integer> findSoldiersSequence(int size, int[][] soldiers) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] ar = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pair : soldiers) {
            int a = pair[0];
            int b = pair[1];
            graph.get(a).add(b);
            ar[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            if (ar[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int nodeNeibor : graph.get(node)) {
                ar[nodeNeibor]--;
                if (ar[nodeNeibor] == 0) {
                    queue.add(nodeNeibor);
                }
            }
        }

        return result.size() == size ? result : null;
    }

}
