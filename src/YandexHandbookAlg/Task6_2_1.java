package YandexHandbookAlg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Task6_2_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int w = s.nextInt();
        List<Spice> spices = new ArrayList<Spice>();
        for (int i = 0; i < n; i++) {
            spices.add(new Spice(s.nextInt(), s.nextInt()));
        }
        spices.sort(Comparator.comparingDouble(Spice::getProfit).reversed());
        System.out.println(profitRec(spices, w));
    }

    private static double profitRec(List<Spice> spices, int w) {
        if (w==0 || spices.isEmpty()) return 0;
        Spice profitable = spices.get(0);
        int amount = Math.min(w, profitable.weight);
        double value = profitable.profit * amount;
        spices.remove(0);
        return value + profitRec(spices, w-amount);
    }

    private static class Spice{
        int weight;
        int price;
        double profit;

        public Spice(int price, int weight) {
            this.weight = weight;
            this.price = price;
            profit = 1.0*price / weight;
        }

        public double getProfit() {
            return profit;
        }
    }
}
