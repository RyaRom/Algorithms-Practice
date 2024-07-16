package Tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution5 {
    private static final BufferedReader fastScanner = new BufferedReader(new InputStreamReader(System.in));

//    private static class Node{
//        @Override
//        public String toString() {
//            return id + "";
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Node node = (Node) o;
//            return id == node.id && Objects.equals(next, node.next);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(id, next);
//        }
//
//        private final int id;
//        private List<Node> next = new ArrayList<>();
//
//        public Node(int id, List<Node> next) {
//            this.id = id;
//            this.next = next;
//        }
//
//        public Node(int id) {
//            this.id = id;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public List<Node> getNext() {
//            return next;
//        }
//
//        public void setNext(List<Node> next) {
//            this.next = next;
//        }
//    }
//    private static HashMap<Integer, Node> nodes = new HashMap();
    public static void main(String[] args) throws IOException {
        String line1= fastScanner.readLine();
        int N = Integer.parseInt(line1.split(" ")[0]);
        int M = Integer.parseInt(line1.split(" ")[1]);
        int[][] pairs= new int[M][2];
        for (int i = 0; i < M; i++) {
            String line = fastScanner.readLine();
            int A = Integer.parseInt(line.split(" ")[0]);
            int B = Integer.parseInt(line.split(" ")[1]);
            pairs[i][0] =A;
            pairs[i][1] =B;
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

        return result.size() == size? result:null;
    }

}
