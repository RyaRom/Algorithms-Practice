package YandexHandbookAlg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Task6_3_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int billboards = s.nextInt();
        int k = s.nextInt();
        int weeks = s.nextInt();
        List<Advertiser> advertisers = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            advertisers.add(new Advertiser(s.nextInt(), s.nextInt()));
        }
        advertisers.sort(Comparator.comparingInt(Advertiser::getPriceForWeek).reversed());
        System.out.println(countMaxProfit(advertisers, weeks, billboards));
    }



    private static long countMaxProfit(List<Advertiser> advertisers, int weeks, int billboards){
        long profit = 0;
        List<Advertiser> advertisersOnBillboards = new ArrayList<>(billboards);
        for (int i = 0; i < weeks+1; i++) {

            //payment
            for (Advertiser advertiser: advertisersOnBillboards)profit+=advertiser.getPriceForWeek();

            //removeOld
            advertisersOnBillboards.removeIf(Advertiser::newWeek);

            //update
            int emptySlots = billboards- advertisersOnBillboards.size();
            for (int j = 0; j <emptySlots; j++) {
                if (advertisersOnBillboards.size()==billboards || advertisers.isEmpty()) break;
                advertisersOnBillboards.add(advertisers.get(0));
                advertisers.remove(0);
            }
        }
        return profit;
    }

    private static class Advertiser{
        private int priceForWeek;
        private int maxWeeks;

        public boolean newWeek(){
            maxWeeks--;
            return maxWeeks ==0;
        }

        public Advertiser(int priceForWeek, int maxWeeks) {
            this.priceForWeek = priceForWeek;
            this.maxWeeks = maxWeeks;
        }

        public int getPriceForWeek() {
            return priceForWeek;
        }

        public void setPriceForWeek(int priceForWeek) {
            this.priceForWeek = priceForWeek;
        }

        public int getMaxWeeks() {
            return maxWeeks;
        }

        public void setMaxWeeks(int maxWeeks) {
            this.maxWeeks = maxWeeks;
        }
    }
}
