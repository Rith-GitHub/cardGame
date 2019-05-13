import java.util.*;

public class Deck
{
    private List<Card> cards;
    public Deck()
    {
        cards = new ArrayList<Card>();
        for (int i=0; i < 52; i++) {
            String suit = "";
            String rank = "";
            if (i / 13 == 0) {suit = "hearts";}
            else if (i / 13 == 1) {suit = "diamonds";}
            else if (i / 13 == 2) {suit = "spades";}
            else if (i / 13 == 3) {suit = "clubs";}
            if (i % 13 == 0) {rank = "ace";}
            else if (i % 13 <= 9) {
                Integer d = new Integer(i % 13 + 1);
                rank = d.toString();
            }
            else if (i % 13 == 10) {rank = "jack";}
            else if (i % 13 == 11) {rank = "queen";}
            else if (i % 13 == 12) {rank = "king";}
            Card e = new Card(rank, suit, "deck");
            cards.add(e);
            Collections.shuffle(cards);
        }
    }
    public Card drawCard() {
        if (cards.size() > 0) {
            Card cardReturned = cards.remove(0);
            return cardReturned;
        }
        else return null;
    }
    public void addCard(Card card) {
        cards.add(card);
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }
}
