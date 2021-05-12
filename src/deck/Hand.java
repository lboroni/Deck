package deck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hand implements Serializable {

    private List<Card> cards = new ArrayList<>();

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Cards: " + this.cards;
    }
}
