import java.util.*;

public class Table
{
    public static ArrayList<ArrayList<Card>> Table = new ArrayList<ArrayList<Card>>(7);
    public Table(Deck deck) {
        for (int e = 0; e < 7; e++) {
            ArrayList<Card> col = new ArrayList<Card>();
            for (int a = 0; a <= e; a++) {
                Card newCard = deck.drawCard();
                newCard.setLocation("table");
                col.add(newCard);
            }
            Table.add(col);
        }
    }

    public int indexOfLongest() {
        int index = 0;
        int elementLength = this.Table.get(0).size();
        for (ArrayList<Card> col : this.Table) {
            if (col.size() > elementLength) {
                index = this.Table.indexOf(col);
                elementLength = col.size();
            }
        }
        return index;
    }
    public int size() {
        int colIndex = this.indexOfLongest();
        return this.Table.get(colIndex).size();
    }
    public int cardSize() {
        int size = 0;
        for(ArrayList<Card> col : this.table) {
            for(Card card : row) {
                size++;
            }
        }
        return size;
    }
    public ArrayList<ArrayList<Card>> getTable() {
        return Table;
    }
    public cardAt(int x, int y) {
        ArrayList<Card> col = this.Table.get(y);
        Card card = col.get(x);
        return card;
    }
}
