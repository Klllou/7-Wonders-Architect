import fr.isep.game7WonderArch.domain.*;

import java.util.Collections;
import java.util.List;

public class Player {

    Wonder wonder;
    List<Card> deck;

    void setDeck(){
        List<CardDecks.CardTypeQuantity> cardTypeQuantity = null;
        CardBack cardBack = null;
        switch (wonder){
            case Gizeh:
                cardTypeQuantity = CardDecks.deckCardQuantities_Gizeh;
                cardBack = CardBack.Gizeh;
                break;
            case Ephese:
                cardTypeQuantity = CardDecks.deckCardQuantities_Ephese;
                cardBack = CardBack.Ephese;
                break;
            case Rhodes:
                cardTypeQuantity = CardDecks.deckCardQuantities_Rhodes;
                cardBack = CardBack.Rhodes;
                break;
            case Olympie:
                cardTypeQuantity = CardDecks.deckCardQuantities_Olympie;
                cardBack = CardBack.Olympie;
                break;
            case Babylone:
                cardTypeQuantity = CardDecks.deckCardQuantities_Babylone;
                cardBack = CardBack.Babylone;
                break;
            case Alexandrie:
                cardTypeQuantity = CardDecks.deckCardQuantities_Alexandrie;
                cardBack = CardBack.Alexandrie;
                break;
            case Halicarnasse:
                cardTypeQuantity = CardDecks.deckCardQuantities_Halicarnasse;
                cardBack = CardBack.Halicarnasse;
        }
        for(CardDecks.CardTypeQuantity a: cardTypeQuantity){
            for(int i = 0; i < a.quantity; i++){
                deck.add(new Card(a.cardType, cardBack));
            }
        }
        Game.shuffleCards(this.deck);
    }

    void SetWonder(){
        //TODO
    }

    public void ChooseCard() {
        //TODO
    }
}
