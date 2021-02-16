package Chapter6.Project6_8;

import Chapter4.Project4_6.Card;

import java.util.ArrayList;
import java.util.Arrays;

public class CardDriver
{
    public static void main(String[] args) {

        DeckOfCardsArrayList docal = new DeckOfCardsArrayList();
        DeckOfCardsArray doca = new DeckOfCardsArray();

        doca.shuffle();
        ArrayList<Card> hand = new ArrayList<>(Arrays.asList(doca.dealCards(5)));
        System.out.println(hand);

        docal.shuffle();
        ArrayList<Card> alHand = new ArrayList<>(Arrays.asList(docal.dealCards(5)));
        System.out.println(alHand);
    }
}
