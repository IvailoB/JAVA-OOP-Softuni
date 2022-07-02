package WorkingWithAbstraction;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Card Suits:");
//        System.out.println("Ordinal value: " + CardSuit.CLUBS.ordinal() + "; Name value: " + CardSuit.CLUBS.name());
//        System.out.println("Ordinal value: " + CardSuit.DIAMONDS.ordinal() + "; Name value: " + CardSuit.DIAMONDS.name());
//        System.out.println("Ordinal value: " + CardSuit.HEARTS.ordinal() + "; Name value: " + CardSuit.HEARTS.name());
//        System.out.println("Ordinal value: " + CardSuit.SPADES.ordinal() + "; Name value: " + CardSuit.SPADES.name());

//        System.out.println("Card Ranks:");
//        for (CardRank value : CardRank.values()) {
//            System.out.println("Ordinal value: " + value.ordinal() + "; Name value: " + value.name());
//        }

        CardRanks cardRanks = CardRanks.valueOf(scanner.nextLine()); // CardRanks.TWO
        CardSuits cardSuits = CardSuits.valueOf(scanner.nextLine());

        Card card = new Card(cardSuits, cardRanks);

        System.out.printf("Card name: %s of %s; Card power: %d", card.getCardRanks(), card.getCardSuits(), card.getPower());
    }
}
