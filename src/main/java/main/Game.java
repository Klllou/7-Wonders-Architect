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
    public List<Card> centralDeck;
    List<ProgressToken> progressTokens;
    Boolean gameIsGoing;

    public static ConflictTokens conflictTokens;

    public Game(int playersNumber){
        Game.playersNumber = playersNumber;
        players = new ArrayList<>();
        this.progressTokens = ProgressTokens.TOKENS;

//        for(int i = 0; i < playersNumber; i++){
//            players.add(new Player(getPlayerName(), getPlayerAge()));
//        }

        setCentralDeck();
        shuffleDeck(this.centralDeck);

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

    //Lien entre Front-end et Back-end
    public static void addPlayer(Player newPlayer){
        players.add(newPlayer);
    }

    // fonction qui implémente la guerre, Vérifie le nombre de boucliers pour chaque joueur puis détermine le vainqueur
    // du combat et lui assigne des Points de victoire
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

    //Pour reset Toutes les variables à la fin d'une partie, afin de commencer la partie suivante correctement
    public static void end() {
        Game.players = null;
        Game.playersNumber = 0;
        Game.conflictTokens = null;
    }

// on définit le Deck central du jeu
    public void setCentralDeck(){
        this.centralDeck = new ArrayList<>();
        for(CardDecks.CardTypeQuantity a: CardDecks.deckCardQuantities_Extra){
            for(int i = 0; i < a.quantity; i++){
                centralDeck.add(makeCard(a.cardType, CardBack.CentralDeck));
            }
        }
    }

    //Création des cartes à mettre dans les différents decks
    static public Card makeCard(CardType cardType, CardBack centralDeck) {
        return switch (cardType.cardCategory) {
            case MaterialCard -> new MaterialCard(cardType, centralDeck);
            case ProgressCard -> new ProgressCard(cardType, centralDeck);
            case WarCard -> new WarCard(cardType, centralDeck);
            case PoliticCard -> new PoliticCard(cardType, centralDeck);
        };
    }

    //On crée les cartes à partir de la classe Enum, nous devons donc mélanger les cartes pour changer l'ordre des cartes
    static public void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }

    //Fonction qui lance le jeu
    public void play(){
        gameIsGoing = true;


        List t = players.subList(getIndexOfTheYoungest(), playersNumber);
        t.addAll(players.subList(0, getIndexOfTheYoungest()));                  //on définit l'ordre de jeu
        players = t;

        while(gameIsGoing){
            for(int i = 0; i < playersNumber; i++)                  //tant qu'aucune Merveille n'est entièrement construite le jeu continue
            {
                players.get(i).makeMove(this, i);
            }
            //TODO gameIsGoing = false
        }
        end();
    }

    //On à besoin de l'indice du joueur le plus jeune car c'est celui qui commence à jouer
    private int getIndexOfTheYoungest() {
        int min = 100;
        int res = -1;
        for(int i = 0; i < playersNumber; i++){
            if(players.get(i).age < min){
                min = players.get(i).age;
                res = i;
            }
        }
        return res;
    }

    //Lorsque un joueur pioche une carte, On retire cette carte du deck (il pioche forcément la première carte)
    public static Card getFirstCard(List<Card> deck){
        if (deck.size() == 0){
            return null;
        }
        return deck.remove(0);
    }
}
