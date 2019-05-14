import java.util.*;

public class Table
{
    private Card[][] Table = new Card[7][20];
    public Table(Deck deck) {
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row <= col; row++) {
                Card newCard = deck.drawCard();
                newCard.setLocation("table");
                Table[col][row] = newCard;
            }
        }
    }

    public int size() {
        int index = 0;
        int elementLength = this.Table[0].length;
        for (int i = 0; i < this.Table.length; i++) {
            int count = 0;
            for (Object o : Table[i]) {
                if (o != null) count++;
            }
            if (count > elementLength) {
                index = i;
                elementLength = count;
            }
        }
        return elementLength;
    }
    public int cardSize() {
        int size = 0;
        for(Card[] col : this.Table) {
            for(Card card : col) {
                if(card != null) size++;
            }
        }
        return size;
    }
    public Card[][] getTable() {
        return Table;
    }
    public Card cardAt(int x, int y) {
        Card[] col = this.Table[y];
        Card card = col[x];
        return card;
    }
}
