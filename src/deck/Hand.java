package deck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hand implements Serializable {

    private int length;
    private List<Card> cards = new ArrayList<>();

    public Hand(int length, List<Card> cards) {
        this.length = length;
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Cards: " + this.cards + " - Length: " + this.length;
    }
}
