package AB7;

import AB6.TyrannosaurusRex;
import AB7.Interfaces.Card;

/**
 * Represents a playing card for the Blackjack game.
 * A card consists of a suit and a value. The suit can be hearts, diamonds, clubs, or spades, and the value
 * can range from the numbers two through ten, to face cards (jack, queen, king) and ace.
 * It also includes functionality to calculate the score based on the card's value.
 */
public class BJCard implements Card {
    // TODO: variable declarations (optional)
    private Suit suit;
    private Value value;
    /**
     * Constructs a new BJCard object representing a playing card in the game of Blackjack.
     *
     * @param suit  the suit of the card, such as HEARTS, DIAMONDS, CLUBS, or SPADES
     * @param value the value of the card, such as TWO, THREE, TEN, JACK, QUEEN, KING, or ACE
     */
    public BJCard(Suit suit, Value value) {
        // TODO: implementation
        this.suit = suit;
        this.value = value;
    }

    /**
     * Retrieves the suit of the card.
     *
     * @return the suit of the card, which is one of the four suits in a standard deck of
     * playing cards: HEARTS, DIAMONDS, CLUBS, or SPADES.
     */
    @Override
    public Suit getSuit() {
        // TODO: implementation
        return suit;
    }

    /**
     * Retrieves the value of the card.
     *
     * @return the value of the card, which represents its rank in a standard deck of playing cards.
     * This includes number values (TWO through TEN), face cards (JACK, QUEEN, KING), and ACE.
     */
    @Override
    public Value getValue() {
        // TODO: implementation
        return value;
    }

    /**
     * Calculates the score associated with the card based on its value.
     * For number cards (2-10), the score matches the card value.
     * For face cards (jack, queen, king), the score is 10.
     * For an ace, the score is 11.
     *
     * @return the score value of the card based on its value.
     */
    @Override
    public int getScore() {
        // TODO: implementation
        return switch (value) {
            case JACK, QUEEN, KING -> 10;
            case ACE -> 11;
            default -> value.ordinal() - Value.TWO.ordinal() + 2;
        };
    }

    /**
     * Returns a string representation of the card, combining its value and suit.
     *
     * <p>The string's format and content can be freely chosen, but should at least contain information on suit and value.</p>
     *
     * @return a string containing the card's value and suit.
     */
    @Override
    public String toString() {
        // TODO: implementation
        String value = switch (this.value) {
            case JACK -> "J";
            case QUEEN -> "Q";
            case KING -> "K";
            case ACE -> "A";
            default -> String.valueOf(this.value.ordinal() - Value.TWO.ordinal() + 2);
        };

        String ANSI_RED = "\u001B[31m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RESET = "\u001B[0m";
        String suit = switch (this.suit) {
            case HEARTS -> ANSI_RED + "\u2665" + ANSI_RESET;   // ♥ in rot
            case DIAMONDS -> ANSI_RED + "\u2666" + ANSI_RESET;   // ♦ in rot
            case SPADES -> ANSI_BLACK + "\u2660" + ANSI_RESET; // ♠ in schwarz/grau
            default -> ANSI_BLACK + "\u2663" + ANSI_RESET; // ♣ in schwarz/grau
        };

        return String.format("%s %s (%d)", value, suit, this.getScore());
    }

    /**
     * Compares this card to the specified object for equality. Two cards are considered equal
     * if they have the same suit and value.
     *
     * @param obj the object to be compared with this card for equality
     * @return true if the specified object is equal to this card; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        BJCard that = (BJCard) obj;
        return suit == that.getSuit() && value == that.getValue();
    }

    /*
    "Allerdings wäre es ein schwerer Fehler, wenn Sie nur equals überschreiben und hashCode unverändert lassen..."
    https://tuwel.tuwien.ac.at/mod/forum/discuss.php?d=499037
     */
    @Override
    public int hashCode() {
        return value.ordinal() + suit.ordinal() * 20;
    }

}
