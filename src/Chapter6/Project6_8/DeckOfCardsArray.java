package Chapter6.Project6_8;

import Chapter4.Project4_6.Card;
import Chapter4.Project4_6.Card.Run;
import Chapter4.Project4_6.Card.Suit;

import java.util.Random;

public class DeckOfCardsArray
{
    private Card[] cards = new Card[52];

    public DeckOfCardsArray()
    {
        int pos = 0;
        for(int i = 0; i < Suit.values().length; i++)
            for(int j = 0; j < Run.values().length; j++)
            {
                cards[pos] = new Card(Suit.values()[i], Run.values()[j]);
                pos++;
            }
    }


    public void shuffle()
    {
        Random r = new Random();
        for(int i = 0; i < cards.length - 1; i++)
        {
            Card temp = cards[i];
            int rInt = r.nextInt(cards.length - i) + i;

            cards[i] = cards[rInt];
            cards[rInt] = temp;
        }
    }

    public Card[] dealCards(int n)
    {
        Card[] cardsToReturn = new Card[n];
        int cardsToDeal = Math.min(n, Math.max(0, cards.length - n));
        for(int i = 0; i < cardsToDeal; i++) cardsToReturn[i] = dealCard();
        return cardsToReturn;
    }

    public Card dealCard()
    {
        Card[] newCards = new Card[cards.length-1];
        //Random r = new Random();
        Card card = cards[0]; //[r.nextInt(cards.length-1)];
        if (newCards.length - 1 >= 0) for(int i = 1; i < newCards.length; i++) newCards[i-1] = cards[i];  //System.arraycopy(cards, 1, newCards, 0, newCards.length - 1);
        cards = newCards;
        return card;
    }

    public int getRemainingCardsInDeck() { return cards.length; }
}
