package main;

import fr.isep.game7WonderArch.domain.*;
import fr.isep.game7WonderArch.domain.card.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static fr.isep.game7WonderArch.domain.ProgressTokens.TOKENS;

public class Game {

    static int playersNumber;
    static public List<Player> players;
    List<Card> centralDeck;
    List<ProgressToken> progressTokens;
    Boolean gameIsGoing;

    public static ConflictTokens conflictTokens;

    public Game(int playersNumber){
        Game.playersNumber = playersNumber;
        players = new ArrayList<>();
        this.progressTokens = ProgressTokens.TOKENS;

        //shuffleProgressToken(TOKENS);TODO doesn't work

//        for(int i = 0; i < playersNumber; i++){
//            players.add(new Player(getPlayerName(), getPlayerAge()));
//        }

        //setCentralDeck();TODO doesn't work
        //shuffleDeck(this.centralDeck);TODO doesn't work

        conflictTokens = new ConflictTokens(playersNumber);
    }

    private int getPlayerAge() {
        //TODO GUI
        return 0;
    }

    private String getPlayerName() {
        //TODO GUI
        return "temporary name";
    }


    public static void addPlayer(Player newPlayer){
        players.add(newPlayer);
    }

    public static void doWar() {
        for(int i = 1; i < playersNumber; i++ ){

            if(players.get(i).getShields() > players.get(i-1).getShields()){
                players.get(i).takeVictoryToken();
            }
            else{
                players.get(i-1).takeVictoryToken();
            }

        }

        if(players.get(playersNumber-1).getShields() > players.get(0).getShields()){
            players.get(playersNumber-1).takeVictoryToken();
        }
        else{
            players.get(0).takeVictoryToken();
        }
    }

    public static void end() {
        Game.players = null;
        Game.playersNumber = 0;
        Game.conflictTokens = null;
    }


    void setCentralDeck(){
        for(CardDecks.CardTypeQuantity a: CardDecks.deckCardQuantities_Extra){
            for(int i = 0; i < a.quantity; i++){
                centralDeck.add(makeCard(a.cardType, CardBack.CentralDeck));
            }
        }
    }

    static public Card makeCard(CardType cardType, CardBack centralDeck) {
        return switch (cardType.cardCategory) {
            case MaterialCard -> new MaterialCard(cardType, centralDeck);
            case ProgressCard -> new ProgressCard(cardType, centralDeck);
            case WarCard -> new WarCard(cardType, centralDeck);
            case PoliticCard -> new PoliticCard(cardType, centralDeck);
        };
    }

    static public void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }
    static public void shuffleProgressToken(List<ProgressToken> tokens) {
        Collections.shuffle(tokens);
    }

    void Play(){
        while(gameIsGoing){
            for(int i = 0; i < playersNumber; i++)
            {
                players.get(i).makeMove();
            }
        }
    }


}
