import java.util.*;

public class Foundation
{
    public static final String SUITS = "a234567891jqk_";
    private List<Card> pile;
    private final String suit;
    private int nextRank;
    public Foundation(String type) {
        pile = new ArrayList<Card>();
        this.suit = type;
        this.nextRank = 0;
    }
    public Card addCard(Card card) {
        if (card.getSuit() == suit &&
        SUITS.substring(nextRank,nextRank+1) != "_" &&
        card.getRank().substring(0,1) == SUITS.substring(nextRank,nextRank + 1)) {
            card.flip(true);
            card.setLocation("fn"+this.suit);
            pile.add(card);
            nextRank++;
            return null;
        }
        else return card;
    }
    public boolean isComplete() {
        if (SUITS.substring(nextRank,nextRank+1) == "_") return true;
        else return false;
    }
    public String getSuit() {
        return suit;
    }
    public int getRank() {
        return nextRank;
    }
    @Override
    public String toString() {
        if (nextRank > 0) return pile.get(pile.size()-1).toString();
        else return "["+suit+String.join("", Collections.nCopies(10-suit.length(), " "))+"]";
    }
}
