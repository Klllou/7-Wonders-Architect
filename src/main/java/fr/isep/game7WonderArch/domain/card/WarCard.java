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
        Game.conflictTokens.flipConflictTokens(this.hornsNumber);
        if(Game.conflictTokens.allConflictTokensFlipped()){
            //TODO start the war
        }
    }
}
