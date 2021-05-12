package deck;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deck implements Serializable {

    private static final long serialVersionUID = -1668438030829165132L;

    private final String path = "/tmp/deck/";
    private final List<String> suits = Arrays.asList("HEARTS", "CLUBS", "DIAMONDS", "SPADES");
    private final List<String> values = Arrays.asList("ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
            "JACK", "QUEEN", "KING", "ACE");
    private List<Card> cards = new ArrayList<>();

    public Deck(String fileName) {
        Deck deck = readFromFile(fileName);
        this.cards = deck.getCards();
    }

    public Deck() {
        suits.forEach(suit -> {
            values.forEach(value -> {
                cards.add(new Card(suit, value));
            });
        });
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Hand deal(int i) {
        List<Card> cardsHand = cards.stream().limit(i).collect(Collectors.toList());
        cardsHand.forEach(cards::remove);

        return new Hand(cardsHand);
    }

    public void save(String fileName) {
        try {
            File file = new File(path);
            file.mkdirs();

            FileOutputStream fileOutputStream = new FileOutputStream(path + fileName);
            ObjectOutputStream write = new ObjectOutputStream(fileOutputStream);
            write.writeObject(this);
            write.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("Error on save Deck: " + e.getMessage());
        }
    }

    public Deck readFromFile(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path + fileName);
            ObjectInputStream write = new ObjectInputStream(fileInputStream);

            Deck deck = (Deck) write.readObject();

            write.close();
            fileInputStream.close();
            return deck;
        } catch (Exception e) {
            System.out.println("Error on read Deck from file: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "Cards: " + this.cards;
    }

    public List<String> getSuits() {
        return suits;
    }

    public List<String> getValues() {
        return values;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getPath() {
        return path;
    }
}
