import fr.isep.game7WonderArch.domain.*;
import fr.isep.game7WonderArch.domain.card.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    int playersNumber;
    List<Player> players;
    List<Card> centralDeck;
    ProgressTokens progressTokens;
    Boolean gameIsGoing;

    Game(int playersNumber){
        this.playersNumber = playersNumber;
        this.players = new ArrayList<>();
        this.progressTokens = new ProgressTokens();

        for(int i = 0; i < playersNumber; i++){
            players.add(new Player());
        }
        setCentralDeck();
        shuffleCards(this.centralDeck);
    }

    void setCentralDeck(){
        for(CardDecks.CardTypeQuantity a: CardDecks.deckCardQuantities_Extra){
            for(int i = 0; i < a.quantity; i++){
                centralDeck.add(makeCard(a.cardType, CardBack.CentralDeck));
            }
        }
    }

    static Card makeCard(CardType cardType, CardBack centralDeck) {
        return switch (cardType.cardCategory) {
            case MaterialCard -> new MaterialCard(cardType, centralDeck);
            case ProgressCard -> new ProgressCard(cardType, centralDeck);
            case WarCard -> new WarCard(cardType, centralDeck);
            case PoliticCard -> new PoliticCard(cardType, centralDeck);
        };
    }

    static void shuffleCards(List<Card> deck) {
        Collections.shuffle(deck);
    }

    void Play(){
        while(gameIsGoing){
            for(int i = 0; i < this.playersNumber; i++)
            {
                players.get(i).ChooseCard();
            }
        }
    }
}
