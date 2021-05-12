package deck;

import java.io.Serializable;

public class Card implements Serializable {

    private String suit; //naipe
    private String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Suit: " + this.suit + " - Value: " + this.value;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }
}
