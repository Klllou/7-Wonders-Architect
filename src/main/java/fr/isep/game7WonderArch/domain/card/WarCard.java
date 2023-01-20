package fr.isep.game7WonderArch.domain.card;

import main.Game;
import main.Player;

public class WarCard extends Card{
    int hornsNumber;
    public WarCard(CardType type, CardBack back) {
        super(type, back);
        this.hornsNumber = type.hornCount;
    }

    @Override
    public void apply(Player player) {
        player.addShields(this.hornsNumber == 0);
        Game.conflictTokens.flipConflictTokens(this.hornsNumber);
        if(Game.conflictTokens.allConflictTokensFlipped()){
            Game.doWar();
        }
    }
}
