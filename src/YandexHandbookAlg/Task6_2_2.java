package YandexHandbookAlg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task6_2_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int S = s.nextInt();
        List<Integer> souvenirs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            souvenirs.add(s.nextInt());
        }
        int count=  0;
        Collections.sort(souvenirs);
        for (int i = 0; i < n; i++) {
            if (S==0 || souvenirs.isEmpty()) break;
            int suv = souvenirs.get(0);
            if (suv <= S){
                count++;
                S-=suv;
                souvenirs.remove(0);
            }
        }
        System.out.println(count);
    }
}
