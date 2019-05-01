import java.util.*;

public class Deck
{
    static ArrayList<Card> cards = new ArrayList<Card>();
    public void Deck()
    {
        for (int i=0; i < 52; i++) {
            String suit = "";
            String rank = "";
            if (i % 4 == 0) {suit = "Heart  ";}
            else if (i % 4 == 1) {suit = "Diamond";}
            else if (i % 4 == 2) {suit = "Spade  ";}
            else if (i % 4 == 3) {suit = "Clover ";}
            if (i % 13 == 0) {rank = "A";}
            else if (i % 13 <= 9) {
                Integer d = new Integer(i+1);
                rank = d.toString();}
            else if (i % 13 == 10) {rank = "J";}
            else if (i % 13 == 11) {rank = "Q";}
            else if (i % 13 == 12) {rank = "K";}
            Card e = new Card(rank, suit);
            cards.add(e);
            Collections.shuffle(cards);
        }
    }
    static Card drawCard() {
        Card cardReturned = cards.remove(0);
        return cardReturned;
    }
}
