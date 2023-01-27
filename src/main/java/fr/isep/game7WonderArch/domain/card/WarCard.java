package fr.isep.game7WonderArch.domain.card;

import main.Game;
import main.Player;

public class WarCard extends Card{
    int hornsNumber;
    public WarCard(CardType type, CardBack back) {
        super(type, back);
        this.hornsNumber = type.hornCount;
    }

    //Le joueur obtient un bouclier, retourne un ConflictTokens. Si les trois conflictTokens sont retournés : doWar
    // Après le Combat, Les joueurs perdent leur boucliers s'il y avait une Corne de combat.
    @Override
    public void apply(Player player) {
        player.addShields(this.hornsNumber == 0);
        Game.conflictTokens.flipConflictTokens(this.hornsNumber);
        if(Game.conflictTokens.allConflictTokensFlipped()){
            Game.doWar();
        }
    }
}
