import fr.isep.game7WonderArch.domain.*;

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
        players = new ArrayList<Player>();
        this.progressTokens =new ProgressTokens();

        for(int i = 0; i < playersNumber; i++){
            Player player = new Player();
            player.SetWonder();
            players.add(player);
        }
//        shuffleCards();
    }


//    public void shuffleCards() {
//        Collections.shuffle(CardDecks.deckCardQuantities_Extra);
//        Collections.shuffle(CardDecks.deckCardQuantities_Alexandrie);
//        Collections.shuffle(CardDecks.deckCardQuantities_Halicarnasse);
//        Collections.shuffle(CardDecks.deckCardQuantities_Babylone);
//        Collections.shuffle(CardDecks.deckCardQuantities_Ephese);
//        Collections.shuffle(CardDecks.deckCardQuantities_Olympie);
//        Collections.shuffle(CardDecks.deckCardQuantities_Rhodes);
//        Collections.shuffle(CardDecks.deckCardQuantities_Gizeh);
//    }

    void Play(){
        while(gameIsGoing){
            for(int i = 0; i < this.playersNumber; i++)
            {
                players.get(i).ChooseCard();
            }
        }
    }
}
