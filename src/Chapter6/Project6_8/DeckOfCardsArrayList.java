package Chapter6.Project6_8;

import Chapter4.Project4_6.Card;
import Chapter4.Project4_6.Card.Run;
import Chapter4.Project4_6.Card.Suit;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCardsArrayList
{
    private ArrayList<Card> cards = new ArrayList<>();

    public DeckOfCardsArrayList()
    {
        for(int i = 0; i < Suit.values().length; i++) for(int j = 0; j < Run.values().length; j++) cards.add(new Card(Suit.values()[i], Run.values()[j]));
    }

    public void shuffle() { Collections.shuffle(cards); }

    public Card[] dealCards(int n)
    {
        Card[] cardsToReturn = new Card[n];
        int cardsToDeal = Math.min(n, Math.max(0, cards.size() - n));
        for(int i = 0; i < cardsToDeal; i++) cardsToReturn[i] = dealCard();
        return cardsToReturn;
    }

    public Card dealCard()
    {
        return cards.remove(0);
    }

    public int getRemainingCardsInDeck() { return cards.size(); }
}
