import java.util.*;

public class Card
{
    private String rank;
    private String suit;
    private boolean faceUp;
    public Card(String r, String s)
    {
       this.rank = r;
       this.suit = s;
    }
    public Card(String r, String s, boolean b)
    {
       this.rank = r;
       this.suit = s;
       this.faceUp = b;
    }
    @Override
    public String toString() {
        if (this.faceUp) {
            String suitReturn = this.suit;
            suitReturn += String.join("", Collections.nCopies(7 - this.suit.length(), " "));
            String rankReturn = String.join("", Collections.nCopies(2 - this.rank.length(), " "));
            rankReturn += this.rank;
            return "["+suitReturn + "|" + rankReturn+"]";
        }
        else {
            return "["+String.join("", Collections.nCopies(10, "_"))+"]";
        }
    }
    public String getSuit() {return this.suit;}
    public String getRank() {return this.rank;}
    public void flip() {this.faceUp = !faceUp;}
    public void flip(boolean b) {this.faceUp = b;}
    public boolean getFace() {return this.faceUp;}
}
