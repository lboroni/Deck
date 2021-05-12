package deck;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Deck myDeck = new Deck();

        System.out.println("Deck inicial -------------------------------------------");
        System.out.println(myDeck);

        myDeck.shuffle(); // Embaralha deck

        System.out.println("Deck embaralhado ---------------------------------------");
        System.out.println(myDeck);

        Hand hand = myDeck.deal(5); // Retorna uma "mão" com as n cartas solicitadas e remove as cartas do deck
        System.out.println("Mão entregue--------------------------------------------");
        System.out.println(hand);

        System.out.println("Deck restante ------------------------------------------");
        System.out.println(myDeck);

        String fileName = "deckSalvo.txt";
        myDeck.save(fileName); // Salva Deck em arquivo

        Deck myNewDeck = new Deck(fileName); // Cria novo Deck a partir de um arquivo

        System.out.println("Novo Deck criado a partir de um arquivo ----------------");
        System.out.println(myNewDeck);
    }
}
