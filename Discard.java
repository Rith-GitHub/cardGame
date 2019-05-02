import java.util.*;
public class Discard
{
    public static ArrayList<Card> discard = new ArrayList<Card>();
    public Discard()
    {
        
    }
    static void addCard(Card card) {
        if (card != null) {
            card.flip(true);
            discard.add(0, card);
        }
    }
    @Override
    public String toString() {
        if (discard.size() > 0) {
            String returnString = discard.get(0).toString();
            if (discard.size() >= 3) returnString += " ] ]";
            else if (discard.size() == 2) returnString += " ]";
            return returnString;
        }
        else return "";
    }
    static void returnCards() {
        for (int i = 0; i < discard.size(); i++) {
            Card card = discard.get(i);
            card.flip(false);
            Deck.cards.add(card);
        }
        discard = new ArrayList<Card>();
        Collections.shuffle(Deck.cards);
    }
}
