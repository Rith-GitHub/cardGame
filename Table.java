import java.util.*;

public class Table
{
    public ArrayList<ArrayList<Card>> Table = new ArrayList<ArrayList<Card>>(7);
    public Table() {
        for (int col = 0; col < Table.size(); col++) {
            for (int e = col; e >= 0; e--) {
                Table.get(col).add(Deck.drawCard());
            }
        }
    }
    
    public void printTable() {
        ArrayList<Card> longestCol = Table.get(0);
        for (int col = 0; col < Table.size(); col++) {
            if (Table.get(col).size() > longestCol.size()) {
                longestCol = Table.get(col);
            }
        }
        int longestLen = longestCol.size();
        for (int row = 0; row < longestLen; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print(Table.get(col).get(row).toString() + " ");
            }
            System.out.println();
        }
    }
}
