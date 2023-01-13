package fr.isep.game7WonderArch.domain.card;

import main.Player;

public class ProgressCard extends Card{
    ScienceCategory scienceCategory;
    public ProgressCard(CardType type, CardBack back) {
        super(type, back);
        scienceCategory = type.scienceCategory;
    }

    @Override
    public void apply(Player player) {
        if(player.addSymbolScience(this.scienceCategory)){
            player.takeToken();
        }
    }
}
