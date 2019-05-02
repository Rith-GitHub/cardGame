import java.util.*;

public class Table
{
    public static ArrayList<ArrayList<Card>> Table = new ArrayList<ArrayList<Card>>(7);
    public Table() {
        for (int e = 0; e < 7; e++) {
            ArrayList<Card> col = new ArrayList<Card>();
            for (int a = 0; a <= e; a++) {
                Card newCard = Deck.drawCard();
                col.add(newCard);
            }
            Table.add(col);
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
    public ArrayList<ArrayList<Card>> getTable() {
        return Table;
    }
}
