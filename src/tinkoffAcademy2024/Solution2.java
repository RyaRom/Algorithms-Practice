package tinkoffAcademy2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    private static final BufferedReader fastScanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line1 = fastScanner.readLine();
        String line2 = fastScanner.readLine();
        String line3 = fastScanner.readLine();
        String line4 = fastScanner.readLine();
        List<Integer> occupied = new ArrayList<>();
        for(String day : line1.split(" ")){
            if (day.equals("MON")) occupied.add(1);
            if (day.equals("TUE")) occupied.add(2);
            if (day.equals("WED")) occupied.add(3);
            if (day.equals("THU")) occupied.add(4);
            if (day.equals("FRI")) occupied.add(5);
            if (day.equals("SAT")) occupied.add(6);
            if (day.equals("SUN")) occupied.add(7);
        }
        for(String day : line2.split(" ")){
            if (day.equals("MON")) occupied.add(8);
            if (day.equals("TUE")) occupied.add(9);
            if (day.equals("WED")) occupied.add(10);
            if (day.equals("THU")) occupied.add(11);
            if (day.equals("FRI")) occupied.add(12);
            if (day.equals("SAT")) occupied.add(13);
            if (day.equals("SUN")) occupied.add(14);
        }
        for(String day : line3.split(" ")){
            if (day.equals("MON")) occupied.add(15);
            if (day.equals("TUE")) occupied.add(16);
            if (day.equals("WED")) occupied.add(17);
            if (day.equals("THU")) occupied.add(18);
            if (day.equals("FRI")) occupied.add(19);
            if (day.equals("SAT")) occupied.add(20);
            if (day.equals("SUN")) occupied.add(21);
        }
        for(String day : line4.split(" ")){
            if (day.equals("MON")) occupied.add(22);
            if (day.equals("TUE")) occupied.add(23);
            if (day.equals("WED")) occupied.add(24);
            if (day.equals("THU")) occupied.add(25);
            if (day.equals("FRI")) occupied.add(26);
            if (day.equals("SAT")) occupied.add(27);
            if (day.equals("SUN")) occupied.add(28);
        }
        Collections.sort(occupied);
        Collections.reverse(occupied);
        int lastFree = 28;
        int firstFree = 1;
        int maxSize = 1;
        occupied.add(0);
        occupied.add(0,29);
        for (int i = 0; i < occupied.size()-1; i++) {
            if (occupied.get(i) - occupied.get(i + 1) >= maxSize){
                lastFree = occupied.get(i);
                firstFree= occupied.get(i+1);
                maxSize = occupied.get(i) - occupied.get(i + 1);
            }
        }
        firstFree = firstFree+1;
        lastFree = lastFree-1;

        if (Math.abs(lastFree - firstFree) <=2) System.out.println("0 0");
        else System.out.println(firstFree + " " + lastFree);
    }
}
