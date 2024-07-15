package YandexHandbookAlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task3_2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Line> list = new ArrayList<Line>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            list.add(new Line(s[0], s[1]));
        }
        list.sort(Comparator.comparingInt(Line::getEnd));
        Stack<Line> stack = new Stack<>();
        while (!list.isEmpty()){
            Line min = list.remove(0);
            stack.push(min);
            list.removeIf(l->l.start<= min.end);
        }
        if  (n==0) System.out.println(0);
        else System.out.print(stack.size());
    }
    private static class Line{
        private int start;

        private int end;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return start == line.start && end == line.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public Line(String start, String end) {
            this.start = Integer.parseInt(start);
            this.end = Integer.parseInt(end);
        }
    }
}
