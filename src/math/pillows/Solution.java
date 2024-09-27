package math.pillows;

class Solution {
    public int passThePillow(int n, int time) {
        n--;
        int mod = time % n;
        int side = (time / n) % 2;
        if (time <= n) return time + 1;
        if (side == 1) return mod == 0 ? n + 1 : (n + 1 - mod);
        else return mod == 0 ? 1 : mod;
    }
}
//1->2->3->4->5->6->7->8->7->6