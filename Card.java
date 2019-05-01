import java.util.*;

public class Card
{
    // instance variables - replace the example below with your own
    private String rank;
    private String suit;
    /**
     * Constructor for objects of class Card
     */
    public Card(String r, String s)
    {
       this.rank = r;
       this.suit = s;
    }
    @Override
    public String toString() {
        return this.suit + "|" + this.rank;
    }
    public String getSuit() {return this.suit;}
    public String getRank() {return this.rank;}
}
