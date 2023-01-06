import fr.isep.game7WonderArch.domain.*;

import java.util.List;

public class Player {

    Wonder wonder;
    List<Card> deck;

    void setDeck(){
        List<CardDecks.CardTypeQuantity> cardTypeQuantity;
        switch (wonder){
            case Gizeh:
                cardTypeQuantity = CardDecks.deckCardQuantities_Gizeh;
                break;
            case Ephese:
                cardTypeQuantity = CardDecks.deckCardQuantities_Ephese;
                break;
            case Rhodes:
                cardTypeQuantity = CardDecks.deckCardQuantities_Rhodes;
                break;
            case Olympie:
                cardTypeQuantity = CardDecks.deckCardQuantities_Olympie;
                break;
            case Babylone:
                cardTypeQuantity = CardDecks.deckCardQuantities_Babylone;
                break;
            case Alexandrie:
                cardTypeQuantity = CardDecks.deckCardQuantities_Alexandrie;
                break;
            case Halicarnasse:
                cardTypeQuantity = CardDecks.deckCardQuantities_Halicarnasse;
        }
    }

    void SetWonder(){
        //TODO
    }

    public void ChooseCard() {
        //TODO
    }
}
