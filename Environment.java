import java.util.*;

public class Environment
{
    private ArrayList<Card> pile;
    private String suit;
    private String currentRank;
    public Environment(Card ace) {
        if (ace.getRank() == "A") {
            this.pile.add(ace);
            this.suit = ace.getSuit();
            this.currentRank = "A";
        }
    }
}
