import java.util.*;
public class Environment
{
    private Deck deck;
    private Table table;
    private Discard discard;
    private Foundation fnHeart;
    private Foundation fnDimnd;
    private Foundation fnSpade;
    private Foundation fnClubs;
    private int counter = 0;
    Scanner scan = new Scanner(System.in);
    public Environment()
    {
        this.deck = new Deck();
        this.table = new Table();
        this.discard = new Discard();
        this.fnHeart = new Foundation("Heart");
        this.fnDimnd = new Foundation("Diamond");
        this.fnSpade = new Foundation("Spade");
        this.fnClubs = new Foundation("Clubs");
        run();
    }
    public void run() {
        boolean stop = false;
        while (!stop) {
            System.out.println(counter);
            printScreen();
            if (deck.cards.size() > 0) System.out.print("\nDRAW another card, ");
            else System.out.print("SHUFFLE drawn cards back into the deck, ");
            System.out.println("or MOVE the existing ones.");
            String input = scan.nextLine().toLowerCase();
            if (input.equals("move")) ;//move();
            else if (input.equals("draw")) {
                discard.addCard(deck.drawCard());
            }
            else if (deck.cards.size() == 0 && input.equals("shuffle")) {
                discard.returnCards();
            }
            else if (input.equals("stop")) stop = true;
            counter++;
        }
    }
    public void printScreen() {
        System.out.print(String.join("", Collections.nCopies(20, "\n")));
        System.out.println(String.join("", Collections.nCopies(12*7, "_")));
        
        String returnDiscard = discard.toString();
        if (!returnDiscard.equals("")) returnDiscard = "Drawn: " + returnDiscard;
        if (deck.cards.size() > 0) System.out.print("[Draw Card ]");
        else System.out.print("[Deck Empty]");
        System.out.println(String.join("", Collections.nCopies(12*6 - returnDiscard.length(), " ")) +
        returnDiscard + "\n");
        
        ArrayList<ArrayList<Card>> printTable = table.getTable();
        int index = 0;
        int elementLength = printTable.get(0).size();
        for (ArrayList<Card> col : Table.Table) {
            if (col.size() > elementLength) {
                index = printTable.indexOf(col);
                elementLength = col.size();
            }
        }
        for (int row = 0; row < elementLength; row++) {
            for (int col = 0; col < 7; col++) {
                if (printTable.get(col).size() > row) {
                    Card card = printTable.get(col).get(row);
                    if (printTable.get(col).size() == row+1) card.flip(true);
                    System.out.print(card.toString());
                }
                else System.out.print(String.join("", Collections.nCopies(12, " ")));
            }
            System.out.print(" ");
            System.out.println(row + 1);
        }
        
        System.out.println(String.join("", Collections.nCopies(12*7, "_")));
        System.out.println(String.join("            ",fnHeart.toString(),
        fnDimnd.toString(),fnSpade.toString(),fnClubs.toString()));
    }
    public void move() {
        
    }
}
