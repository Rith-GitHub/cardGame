import java.util.*;
import java.lang.*;
public class Board
{
    private Deck deck;
    private Table table;
    private Discard discard;
    private Foundation fnHeart;
    private Foundation fnDimnd;
    private Foundation fnSpade;
    private Foundation fnClubs;
    Foundation[] foundations = new Foundation[] {fnHeart, fnDimnd, fnSpade, fnClubs};
    private int counter = 0;
    Scanner scan = new Scanner(System.in);

    public Board()
    {
        this.deck = new Deck();
        this.table = new Table(this.deck);
        this.discard = new Discard();
        this.fnHeart = new Foundation("hearts");
        this.fnDimnd = new Foundation("diamonds");
        this.fnSpade = new Foundation("spades");
        this.fnClubs = new Foundation("clubs");
    }
    public int size() {
        return this.table.size();
    }
    public int cardSize() {
        return this.table.cardSize();
    }
    public Card cardAt(int x, int y) {
        return this.table.carAt(x, y)
    }
}
    /*public void run() {
        boolean stop = false;
        while (!stop) {
            printScreen();
            System.out.println(counter);
            if (deck.cards.size() > 0) System.out.print("\nDRAW another card, ");
            else System.out.print("SHUFFLE drawn cards back into the deck, ");
            System.out.println("or MOVE the existing ones.");
            String input = scan.nextLine().toLowerCase();
            if (input.equals("move")) move();
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
        System.out.println(String.join("           ","1","2","3","4","5","6","7"));
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
        if (discard.discard.size() > 0) {
            System.out.println("Which card?\n-The DRAWN card");
        }
        else {
            System.out.println("Which card?");
        }
        System.out.println("-A card on the TABLE\n-CANCEL");
        String input = scan.nextLine().toLowerCase();
        ArrayList<Card> cardList = new ArrayList<Card>();
        if (input.equals("drawn") && discard.discard.size() > 0) {
            cardList.add(discard.drawCard());
        }
        else if (input.equals("table")) {
            System.out.println("Which column?\n-1\n-2\n-3\n-4\n-5\n-6\n-7");
            int col = 0;
            while(true) {
                input = scan.nextLine().toLowerCase();
                if (input.equals("cancel")) return;
                else {
                    try {
                        col = Integer.parseInt(input) - 1;
                        if (col >= 0 && col <= 6) break;
                        else throw new RuntimeException("uwa");
                    }
                    catch(Exception e) {
                        System.out.println("Which column?");
                        continue;
                    }
                }
            }
            int cardRow;
            ArrayList<Card> cards = table.getTable().get(col);
            System.out.println("Which card?");
            for (int i = 1; i <= cards.size(); i++) {
                System.out.println("-" + i + ":" + cards.get(i-1).toString());
            }
            while(true) {
                input = scan.nextLine().toLowerCase();
                if (input.equals("cancel")) return;
                else {
                    try {
                        cardRow = Integer.parseInt(input) - 1;
                        if (cardRow >= 0 && cardRow < cards.size()) {
                            cardList = new ArrayList(cards.subList(cardRow, cards.size()));
                            if (!cardList.get(0).getFace()) {
                                System.out.print("Card can't be moved. ");
                                throw new RuntimeException();
                            }
                            break;
                        }
                        else throw new RuntimeException();
                    }
                    catch(Exception e) {
                        System.out.println("Which card?");
                        continue;
                    }
                }
            }
            System.out.println("Where?");
            while(true) {
                if (cardList.get(0).getRank() == "A" && cardList.size() == 1) {
                    System.out.println("-Another column on the TABLE\n-Onto a FOUNDATION");
                    input = scan.nextLine().toLowerCase();
                    if (input.equals("cancel")) return;
                    else if (input.equals("foundation")) {
                        for (Foundation fn : foundations) {
                            if (fn.getSuit() == cardList.get(0).getSuit()) {
                                //Add here
                            }
                        }
                    }
                    else if (input.equals("table")) break;
                    else continue;
                }
            }
            input = scan.nextLine().toLowerCase();

        }
        else if (input.equals("cancel")) return;
        else {move(); return;}

    }
}*/
