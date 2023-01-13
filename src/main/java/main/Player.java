package main;

import fr.isep.game7WonderArch.domain.card.Card;
import fr.isep.game7WonderArch.domain.card.CardBack;
import fr.isep.game7WonderArch.domain.card.CardDecks;
import fr.isep.game7WonderArch.domain.card.ScienceCategory;
import fr.isep.game7WonderArch.domain.wonder.Wonders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    Map<ScienceCategory, Integer> symbolsScience;
    Wonders wonders;
    List<Card> deck;
    private Boolean hasCat;
    private int victoryPoints;
    public Player(){
        SetWonder();
        SetDeck();this.symbolsScience = new HashMap<>();
        this.symbolsScience.put(ScienceCategory.Law, 0);
        this.symbolsScience.put(ScienceCategory.Architect, 0);
        this.symbolsScience.put(ScienceCategory.Mechanic, 0);
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
        Game.shuffle(this.deck);
    }

    void SetWonder(){
        //TODO GUI
    }

    public void makeMove() {
        //TODO ChooseCard GUI
        Card choosenCard = null;//GUI input
        choosenCard.apply(this);
    }

    public void takeCat(){
        this.hasCat = true;
    }

    public void giveCat() {
        this.hasCat = false;
    }
    public void addVictoryPoints(int vp){
        this.victoryPoints += vp;
    }

    public Boolean addSymbolScience(ScienceCategory scienceCategory) {
        this.symbolsScience.replace(scienceCategory, symbolsScience.get(scienceCategory));
        if(this.symbolsScience.containsValue(2)){
            this.symbolsScience.replace(scienceCategory, 0);
            return true;
            //TODO check:
        }else if(this.symbolsScience.values().stream().mapToInt(Integer::intValue).sum() == 3){
            this.symbolsScience.replaceAll((key, value) -> 0);
        }
        return false;
    }


    public void takeToken() {
        //TODO GUI
    }
    public boolean hasEnoughResources(){
        //TODO
        return false;
    }

}
