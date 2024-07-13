package PascalTrinagle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> PT = new ArrayList<>();
        PT.add(new ArrayList<>(){{add(1);}});
        if (numRows == 1){
            return PT;
        }
        PT.add(new ArrayList<>(){{add(1);add(1);}});
        for (int i = 3; i <= numRows; i++) {
            List<Integer> currentLine = new ArrayList<>();
            List<Integer> previousLine = PT.get(i-1-1);
            currentLine.add(1);
            for (int j = 1; j < previousLine.size(); j++) {
                currentLine.add(previousLine.get(j) + previousLine.get(j-1));
            }
            currentLine.add(1);
            PT.add(currentLine);
        }
        return PT;
    }
}
