import fr.isep.game7WonderArch.domain.card.Card;
import fr.isep.game7WonderArch.domain.card.CardBack;
import fr.isep.game7WonderArch.domain.card.CardDecks;
import fr.isep.game7WonderArch.domain.wonder.Wonders;

import java.util.List;

public class Player {

    Wonders wonders;
    List<Card> deck;

    Player(){
        SetWonder();
        SetDeck();
    }

    void SetDeck(){
        List<CardDecks.CardTypeQuantity> cardTypeQuantity = null;
        CardBack cardBack = null;
        switch (wonders){
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
                deck.add(Game.makeCard(a.cardType, cardBack));
            }
        }
        Game.shuffleCards(this.deck);
    }

    void SetWonder(){
        //TODO
    }

    public void ChooseCard() {
        //TODO ChooseCard
        Card choosenCard = null;//GUI input
        this.deck.add(choosenCard);
    }
}
