package netrunner.netrunnerplaymat;

import java.util.LinkedList;
import java.util.List;

public class Decklist {
    List<Card> cards;
    String name;

    public Decklist(String name, List<Card> cards) {
        this.cards = cards;
        this.name = name;
    }
}
