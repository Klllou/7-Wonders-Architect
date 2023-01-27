package fr.isep.game7WonderArch.domain.card;

import main.*;
public class  PoliticCard extends Card {
    int victoryPoints;
    Player catOwner;
    Boolean hasCat;
    public PoliticCard(CardType type, CardBack back) {
        super(type, back);
        this.victoryPoints = type.laurelCount;
        this.hasCat = type.cat;
    }

    ////Fonction qui permet d'appliquer les effets des PoliticCard,
    // Ajoute des points de Victoire, ou lui permet de prendre le "chat" qui lui permet alors de voir
    // des cartes dans les pioches
    @Override
    public void apply(Player player) {
        if(this.hasCat){
            player.takeCat();
            if(this.catOwner != null){
                this.catOwner.giveCat();
            }
        }
        player.addVictoryPoints(this.victoryPoints);
    }

}
