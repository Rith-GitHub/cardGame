import java.util.*;
public class Discard
{
    private List<Card> discard;
    public Discard()
    {
        discard = new ArrayList<Card>();
    }
    public void addCard(Card card) {
        if (card != null) {
            card.flip(true);
            card.setLocation("discard");
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
    public void returnCards(Deck deck) {
        for (int i = 0; i < discard.size(); i++) {
            Card card = discard.get(i);
            card.flip(false);
            deck.addCard(card);
        }
        discard = new ArrayList<Card>();
        deck.shuffle();
    }
    public Card drawCard() {
        if (discard.size() > 0) {
            Card cardReturned = discard.remove(0);
            return cardReturned;
        }
        else return null;
    }
}
